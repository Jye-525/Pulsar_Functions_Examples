package test.benchmark.transformation;

public class TransformDataStructureSerd {
	private static String separatorString = "#";
	
	public static TransforDataStructure Deserializer(byte[] input) {
		return new TransforDataStructure(input);
	}
	
	public static byte[] Serializer(TransforDataStructure dataStructure) {
		StringBuilder sb = new StringBuilder();
		sb.append(dataStructure.getContent());
		sb.append(separatorString);
		sb.append(dataStructure.getStartTime());
		sb.append(separatorString);
		dataStructure.setEndTime();
		sb.append(dataStructure.getEndTime());
		sb.append(separatorString);
		sb.append(dataStructure.getLatency());
		sb.append(separatorString);
		sb.append(dataStructure.getRecordLength());
		
		return sb.toString().getBytes();
	}
}
