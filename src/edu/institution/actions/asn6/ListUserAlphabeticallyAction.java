/* Colin Maxwell
 * Java II R01
 * Assignment 6 - Ordering Elements in a List
 * 2/27/21
 */

package edu.institution.actions.asn6;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserAlphabeticallyAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		//Retrieves all the users within the database
		List<LinkedInUser> users = userRepository.retrieveAll();
		
		//Sorts the users alphabetically
		Collections.sort(users);
		for (LinkedInUser i : users) 
			System.out.println(i.getUsername()); 
		 
		return true;
	} //End process

} //End Class
