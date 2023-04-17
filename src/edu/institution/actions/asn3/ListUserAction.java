/* Colin Maxwell
 * Java II R01
 * Assignment 3 - LinkedInUser CLI
 * 2/7/21
 */
package edu.institution.actions.asn3;

import java.util.Scanner;
import java.util.List;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		List<LinkedInUser>users = userRepository.retrieveAll();
		for (LinkedInUser i : users) 
			System.out.println(i.getUsername()); 
		
		return true;
	}

}
