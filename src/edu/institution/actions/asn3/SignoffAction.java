/* Colin Maxwell
 * Java II R01
 * Assignment 3 - LinkedInUser CLI
 * 2/7/21
 */
package edu.institution.actions.asn3;

import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.asn2.LinkedInUser;

public class SignoffAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		UndoAction.history.clear();
		
		return false;
	}

}
