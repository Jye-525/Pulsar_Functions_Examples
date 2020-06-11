package test.clients;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

import test.benchmark.DataStructure;
import test.benchmark.DataStructureSerde;

public class TestConsumer {
	
	public static void main(String[] args) {
		
		try {
			
			PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
			System.out.println(client.toString());
			
			Consumer<byte[]> consumer = client.newConsumer().topic("persistent://test/test-namespace/uppercase-result").
					subscriptionName("my-scr").subscribe();
				
			while (true) {
				try {
		            Message<byte[]> msg = consumer.receive();
		            DataStructure dataStructure = DataStructureSerde.deserialize(msg.getValue());
		            consumer.acknowledge(msg);
		            System.out.println("message info (sentence: " + dataStructure.getSentence() 
		            + ", startTime: " + dataStructure.getStartTime()
		            + ", endTime: " + dataStructure.getEndTime()
		            + ", msgLength: " + dataStructure.getMsgLength());
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		            break;
		        }
			}
			client.close();
			
		} catch ( PulsarClientException e) {
			e.printStackTrace();
		}
	}
}
