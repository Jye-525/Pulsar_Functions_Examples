package test.benchmark.transformation;

public class TransforDataStructure {
	private String contentString;
	private long   startTimeMs;
	private long   startNanos;
	private long   endTimeMs;
	private long   endNanos;
	private long   latency;
	private long   recordLength;
	
	public TransforDataStructure(byte[] input) {
		contentString = new String(input);
		startTimeMs = System.currentTimeMillis();
		startNanos = System.nanoTime();
		endTimeMs = System.currentTimeMillis();
		endNanos = System.nanoTime();
		latency = 0;
		recordLength = contentString.length();
	}
	
	public void UppercaseContent() {
		contentString = contentString.toUpperCase();
	}
	
	public void setEndTime() {
		endNanos = System.nanoTime();
		endTimeMs = System.currentTimeMillis();
		latency = endNanos - startNanos;
	}
	
	public String getContent() {
		return contentString;
	}
	
	public long getStartTime() {
		return startTimeMs;
	}
	
	public long getEndTime() {
		return endTimeMs;
	}
	
	public long getLatency() {
		return latency;
	}
	
	public long getRecordLength() {
		return recordLength;
	}
}
