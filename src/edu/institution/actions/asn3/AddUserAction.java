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
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class AddUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		try {
			System.out.println("Enter a username: ");
			String username = scanner.nextLine();
			
			System.out.println("Enter a password: ");
			String password = scanner.nextLine();
			
			System.out.println("Enter a Type (P/S): " );
			String type = scanner.nextLine();

			//Sets supplied username, password
			LinkedInUser user = new LinkedInUser(username,password);
			//Sets supplied type
			user.setType(type);
			//Adds user to user Repository
			userRepository.add(user);
			
			UndoInfo uI = new UndoInfo("Sign Up", username);
			UndoAction.history.push(uI);
			
		} catch (LinkedInException e) {
			//System.out.println(e.getMessage()); //displays error message
		}
		
		return true; //Keep user signed in
	} //end process

} //end AddUserAction
