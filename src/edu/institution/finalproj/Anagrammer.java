/* Colin Maxwell
 * Java II
 * Final Project
 * 5/3/2021
 */

package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class Anagrammer {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creates Options object
		Options options = new Options();
		//adds an option
		options.addOption("a", "anagram", true, "supplies the anagram to evaluate");
		options.addOption("h", "help", false, "displays this help textdisplays the help for this program");
		options.addOption("nf", "no-filter", false, "output all anagram values with no filter");
		options.addOption("words", "filter-words", false, "output only values that are known words");
		
		//Creates a parser
		CommandLineParser parser = new DefaultParser();
		
		//parse the options passed as command line arguments
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return; 
		}
		
		String anagramValue = "";
		String optionValue = null;
		boolean doesNotHaveA = false;
		if(cmd.hasOption("a"))
		{
			anagramValue = cmd.getOptionValue("a");
	        //System.out.println("Value passed: " + anagramValue);
		} else { //If -a is not supplied
			System.out.println("Missing Required Option: -a");
			doesNotHaveA = true;
		}
		
		if(cmd.hasOption("nf"))
		{ 
			//System.out.println("Has nf");
			optionValue = "nf";
		}
		if(cmd.hasOption("h"))
		{
			HelpFormatter formatter = new HelpFormatter();
		    formatter.printHelp("anagrammer", options);		
		}
		if(cmd.hasOption("words"))
		{
			//System.out.println("Has words");
			optionValue = "words";
		} 
		//Default optionValue to "words"
		if(optionValue == null)
			optionValue = "words";
		
		AnagramEvaluatorImpl anagramEvaluate = new AnagramEvaluatorImpl();
		List<String> answerList = new ArrayList<String>();		 
		
		answerList =anagramEvaluate.evaluate(anagramValue, optionValue);
		//System.out.println(anagramEvaluate.evaluate(anagramValue, optionValue) + "This is evaluating the strings");
		
		int count = 0;
		if(doesNotHaveA == false)
		{
			//Prints all of the words in the answer list
			for(String s : answerList)
			{
				System.out.println(s);
				count++;
			
				if (count == answerList.size())
				{
					System.out.println("\n-- " + count + " value(s) found");
				}
			}
		}
		
		
	} //End Main

} //End Class
