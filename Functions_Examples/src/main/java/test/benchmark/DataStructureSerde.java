package test.benchmark;

import java.util.regex.Pattern;

public class DataStructureSerde {
	static public DataStructure deserialize(String sentence) {
		DataStructure inputDataStructure = new DataStructure(sentence);
		return inputDataStructure;
	}
	
	static public DataStructure deserialize(byte[] input) {
		String inputString = new String(input);
		String[] fields = inputString.split(Pattern.quote("|"));
		DataStructure dataStructure = new DataStructure(fields[0], Long.parseLong(fields[1]), 
				Long.parseLong(fields[2]), Long.parseLong(fields[3]));
		return dataStructure;
	}
	
	static public byte[] serialize(DataStructure input) {
		String resultString = String.format("%s|%d|%d|%d", input.getSentence(), input.getStartTime(), 
				input.getEndTime(), input.getMsgLength());
		
		return resultString.getBytes();
	}
}
