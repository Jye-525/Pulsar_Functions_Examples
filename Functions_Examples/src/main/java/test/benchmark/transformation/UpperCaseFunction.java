package test.benchmark.transformation;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;


public class UpperCaseFunction implements Function<byte[], byte[]> {
	
	@Override
	public byte[] process(byte[] input, Context context) {
		TransforDataStructure dataStructure = TransformDataStructureSerd.Deserializer(input);
		dataStructure.UppercaseContent();
		return TransformDataStructureSerd.Serializer(dataStructure);
	}

}
