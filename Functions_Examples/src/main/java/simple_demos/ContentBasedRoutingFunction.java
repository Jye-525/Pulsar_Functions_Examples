package simple_demos;


import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class ContentBasedRoutingFunction implements Function<String, String> {
	
	@Override
	public String process(String input, Context context) {
		String matchedTopic = "persistent://my-tenant/my-namespace/matched_topic";
		String unmatchedTopic = "persistent://my-tenant/my-namespace/unmatched_topic";
		
		boolean bMatched = input.contains("music");
		if (bMatched) {
			context.publish(matchedTopic, input);
		}else {
			context.publish(unmatchedTopic, input);
		}
		
		return null;
	}
}
