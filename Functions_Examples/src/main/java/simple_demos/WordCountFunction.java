package simple_demos;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class WordCountFunction implements Function<String, String> {
	@Override
	public String process(String input, Context context) {
		HashMap<String, Long> result = new HashMap<String, Long>();
		
		Arrays.asList(input.split(" ")).forEach(word->{
			String contentKey = word.toLowerCase();
			context.incrCounter(contentKey, 1);
			result.put(contentKey, context.getCounter(contentKey));
		});
		
		return String.format("%s", result.toString());
	}
}
