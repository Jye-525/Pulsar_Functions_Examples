package test.clients;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

public class TestProducer {
	public static void main(String[] args){
		try {
			PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
			System.out.println(client.toString());
			
			Producer<String> producer = client.newProducer(Schema.STRING).topic("persistent://test/test-namespace/normal-sentence").create();
			
			while (true){
				try {
		            producer.newMessage().value("hello, this is the first sentence").send();
		            Thread.sleep(500);
		            continue;

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
