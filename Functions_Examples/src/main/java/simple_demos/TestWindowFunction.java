package simple_demos;

import java.util.Collection;

import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.functions.api.WindowContext;
import org.apache.pulsar.functions.api.WindowFunction;

public class TestWindowFunction implements WindowFunction<Integer, Integer>{
	
	@Override
	public Integer process(Collection<Record<Integer>> inputs, WindowContext context) {
		
		Integer result = 0;
		for (Record<Integer> record : inputs) {
			result += record.getValue();
		}
		
		return result;
	}
}
