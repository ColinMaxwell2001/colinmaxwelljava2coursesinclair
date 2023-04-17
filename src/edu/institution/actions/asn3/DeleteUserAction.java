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
import edu.institution.actions.asn10.UndoInfo;
import edu.institution.asn2.LinkedInUser;

public class DeleteUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {

		LinkedInUser user = null;
		
		System.out.println("Enter a username: ");
		String username = scanner.nextLine();
			
		user = userRepository.retrieve(username);
		//Checks if user exists
		if (user == null) {
			System.out.println("User: " + username + " does not exist");
			return true;
		} 
		    	
		System.out.println("Enter a password: ");
	    String password = scanner.nextLine();	
			
	    //Test Password Correct
		if (!user.isPasswordCorrect(password))
			System.out.println("Password was not correct.");
		else {
			//Delete user
			userRepository.delete(user);
			UndoInfo uI = new UndoInfo("Delete User", username, user);
			UndoAction.history.push(uI);
			
			if (loggedInUser == user)
				return false;
		}
			
		return true;
	} //End process
	
} //End DeleteUserAction
