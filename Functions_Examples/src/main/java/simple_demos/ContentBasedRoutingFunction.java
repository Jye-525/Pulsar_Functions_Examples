package simple_demos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.functions.LocalRunner;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class ContentBasedRoutingFunction implements Function<String, String> {
	
	@Override
	public String process(String input, Context context) {
		String regex = context.getUserConfigValue("regex").get().toString();
		String matchedTopic = context.getUserConfigValue("matched-topic").get().toString();
		String unmatchedTopic = context.getUserConfigValue("unmatched-topic").get().toString();
		
		
		// check if the input contains "hello" in it.
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			context.publish(matchedTopic, input);
		}else {
			context.publish(unmatchedTopic, input);
		}
		
		return null;
	}
	
	public static void main(String[] args) throws Exception {
	    FunctionConfig functionConfig = new FunctionConfig();
	    functionConfig.setTenant("test");
	    functionConfig.setNamespace("test-namespace");
	    functionConfig.setName("example-function");
	    functionConfig.setInputs(Collections.singleton("persistence://test/test-namespace/matched-topic"));
	    functionConfig.setClassName(ContentBasedRoutingFunction.class.getName());
	    functionConfig.setRuntime(FunctionConfig.Runtime.JAVA);
	    functionConfig.setOutput("persistence://test/test-namespace/test-topic");
	    Map<String, Object> userConfig = new HashMap<String, Object>();
	    userConfig.put("regex", ".*hello.*");
	    userConfig.put("matched-topic", "persistent://test/test-namespace/matched-topic");
	    userConfig.put("unmatched-topic", "persistent://test/test-namespace/unmatched-topic");
	    functionConfig.setUserConfig(userConfig);

	    LocalRunner localRunner = LocalRunner.builder().functionConfig(functionConfig).build();
	    localRunner.start(false);
	}
}
