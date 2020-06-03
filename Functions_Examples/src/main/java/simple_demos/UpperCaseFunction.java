package simple_demos;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class UpperCaseFunction implements Function<String, String> {

	@Override
	public String process(String input, Context context) {
		return String.format("%s", input.trim().toUpperCase());
	}
}
