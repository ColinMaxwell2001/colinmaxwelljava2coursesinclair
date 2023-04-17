/* Colin Maxwell
 * Java II 
 * Adding & Removing Skillsets
 * 3/23/21
 */

package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.Set;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoInfo;
import edu.institution.asn2.LinkedInUser;

public class RemoveSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		String removeSkill = "";
		
		System.out.println("Enter skillset to remove: ");
		removeSkill = scanner.nextLine();
		
		Set <String> skillSetInput = loggedInUser.getSkillsets();

		
		if(!skillSetInput.contains(removeSkill) || removeSkill == null)
		{
			System.out.println("Skill not in skillset!");
			return true;
		}
		
		loggedInUser.removeSkillset(removeSkill);
		ApplicationHelper.decrementSkillsetCount(removeSkill);
		UndoInfo uI = new UndoInfo("Remove Skillset", removeSkill);
		UndoAction.history.push(uI);
		
		System.out.println(removeSkill + " has been removed from your skillset!");
		
			
		return true;
	}

}
