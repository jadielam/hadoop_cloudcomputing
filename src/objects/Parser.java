package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Parser {
	
	
	public static List<TraceStep> inputparser(List<String> inputs)
	{	 
		
		List<TraceStep> tracesteplist=new ArrayList<TraceStep>();
		for(String input:inputs)
		 {
			TraceStep t=scan(input);
			System.out.println(input);
			tracesteplist.add(t);
		}	
		return tracesteplist;
	}
	public static TraceStep scan(String s)
	{
		
	Pattern p0 = Pattern.compile("\\((.*)\\)");
        Matcher m = p0.matcher(s);
        m.find();
       
        Pattern p1=Pattern.compile("\\((.*?)\\),\\s");
        m = p1.matcher(s);
        m.find();
        String interactionrule = m.group(1);
        String last=interactionrule.substring(interactionrule.length() - 1);
		if(!last.equals(")"))
		{
			interactionrule=interactionrule+")";
		}
        
        Pattern p2=Pattern.compile("\\),\\s(.*?),\\s\\[");
        m = p2.matcher(s);
        m.find();
        String fact = m.group(1);
        Fact f=  buildfact(fact);
        
        Pattern p3=Pattern.compile("\\[(.*)\\]");
        m = p3.matcher(s);
        m.find();
        String conjunct = m.group(1); 
        Conjunct c=  buildconjunct(conjunct);
        InteractionRule i=new InteractionRule(interactionrule);
        TraceStep tracestep=new TraceStep(i,f,c);
        
       // System.out.println(Arrays.toString(result));
        System.out.println(text);
        System.out.println(interactionrule);
        System.out.println(fact);
        System.out.println(conjunct);
        //System.out.println(predicate);
       // System.out.println(constantlist);
        //System.out.println(fc);
        //System.out.println(fact21);
        return tracestep;
      
	}
	
	public static Conjunct buildconjunct(String conjunct)
	{
		Pattern pattern = Pattern.compile("\\), ");
        String[] facts = pattern.split(conjunct);
        List<Fact> factlist=new ArrayList<Fact>();
        for(String fact:facts)
        {
        	Fact fact1=buildfact(fact);
        	factlist.add(fact1);
        }
        
		return new Conjunct(factlist);
		
	}
	
	public static Fact buildfact(String fact)
	{
		//fact//
		String last=fact.substring(fact.length() - 1);
		if(!last.equals(")"))
		{
			fact=fact+")";
		}
		Pattern p1 = Pattern.compile("\\((.*)\\)");
        String predicate=StringUtils.substringBefore(fact, "(");
        Matcher  m=p1.matcher(fact);
        m.find();
    	String constantlist=m.group(1);
    	String[] constants=constantlist.split(", ");
    	
    	List<Constant> constantlist1=new ArrayList<Constant>();
    
    	for (String constant:constants)
    	{
    		
    		/*Pattern p0=Pattern.compile("\\[(.*)\\]");
    		m = p0.matcher(constant);
            m.find();
            constant = m.group(1);*/
            System.out.println(constant);
            Constant c=new Constant(1,constant);
            constantlist1.add(c);	
    	}
    	Fact fact1=new Fact(predicate,constantlist1);
    	
    	return fact1;
	}
	
	public static void main(String args[])
	{
	String fileName="/hadoop_cloudcomputing/src/testing";
	        Path path = Path.get(fileName);
	        Scanner scanner = new Scanner(path);
	        List<String> inputs=new ArrayList<String>(); 
	        //read file line by line
	        scanner.useDelimiter(System.getProperty("line.separator"));
	        while(scanner.hasNext()){
	        	inputs.add(scanner.next());
	        }
	        inputparser(inputs);
	        scanner.close();
	}
}
