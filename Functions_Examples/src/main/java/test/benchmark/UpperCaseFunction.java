package test.benchmark;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class UpperCaseFunction implements Function<String, byte[]> {

	@Override
	public byte[] process(String input, Context context) {
		DataStructure inputData = DataStructureSerde.deserialize(input);
		inputData.UppercaseSentence();
		inputData.setEndTime(System.currentTimeMillis());
		return DataStructureSerde.serialize(inputData);
	}
}
