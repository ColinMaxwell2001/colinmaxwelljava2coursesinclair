/* Colin Maxwell
 * Java II 
 * Adding & Removing Skillsets
 * 3/23/21
 */

package edu.institution.actions.asn7;

import java.util.Scanner;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoInfo;
import edu.institution.asn2.LinkedInUser;

public class AddSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		
		String skillInput = "";
		
		System.out.println("Enter skillset: ");
		skillInput = scanner.nextLine();
			
		loggedInUser.addSkillset(skillInput);
		ApplicationHelper.incrementSkillsetCount(skillInput);
		UndoInfo uI = new UndoInfo("Add Skillset", skillInput);
		UndoAction.history.push(uI);

		System.out.println(skillInput + " has been added to your skillsets.");
		
		
		
		return true;
	}

}
