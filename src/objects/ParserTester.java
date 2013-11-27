package objects;

import java.util.ArrayList;
import java.util.List;

public class ParserTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser parser=new Parser();
		List<String> inputs=new ArrayList<String>();
		inputs.add("because(rule_desc('direct network access', 1.0), hacl(internet,'172.19.8.7',tcp ,'3389'), [attackerLocated(internet)])");
		
		List<TraceStep> ts=parser.inputparser(inputs);
		for (TraceStep t : ts){
			System.out.println(t.toString());
		}

	}

}
