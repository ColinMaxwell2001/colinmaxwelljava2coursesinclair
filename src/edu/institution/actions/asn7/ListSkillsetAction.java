/* Colin Maxwell
 * Java II 
 * Adding & Removing Skillsets
 * 3/23/21
 */

package edu.institution.actions.asn7;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
	/*
		for(HashMap.Entry<String, Integer> entry : ApplicationHelper.hMap.entrySet())
		{
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	*/
		
		Set <String> setS = loggedInUser.getSkillsets();
		
		if(setS!= null)
		{
			for(String s: setS)
			{
				int value = ApplicationHelper.retrieveSkillsetCount(s);
				
				System.out.println(s + "  (" + value + " users)");
			}
		}
		else
			System.out.println("You have not entered any skillsets.");
		
		
		return true;
	}

}
