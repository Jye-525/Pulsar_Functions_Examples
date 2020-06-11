package test.benchmark;

public class DataStructure {
	private String sentenceString;
	private long   startTimeStamp;
	private long   endTimeStamp;
	private long   messageLength;
	
	public DataStructure(String sentence) {
		sentenceString = sentence;
		startTimeStamp = System.currentTimeMillis();
		endTimeStamp   = System.currentTimeMillis();
		messageLength  = sentence.length();
	}
	
	public DataStructure(String sentence, long startTimeStamp, long endTimeStamp, long msgLength) {
		sentenceString = sentence;
		this.startTimeStamp = startTimeStamp;
		this.endTimeStamp   = endTimeStamp;
		messageLength  = msgLength;
	}
	
	public void setEndTime(long endTimesStamp) {
		this.endTimeStamp = endTimesStamp;
	}
	
	public void UppercaseSentence() {
		sentenceString = sentenceString.toUpperCase();
	}
	
	public String getSentence() {
		return sentenceString;
	}
	
	public long getStartTime() {
		return startTimeStamp;
	}
	
	public long getEndTime() {
		return endTimeStamp;
	}
	
	public long getMsgLength() {
		return messageLength;
	}
}
