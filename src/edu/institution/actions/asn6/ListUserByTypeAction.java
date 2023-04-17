/* Colin Maxwell
 * Java II R01
 * Assignment 6 - Ordering Elements in a List
 * 2/27/21
 */

package edu.institution.actions.asn6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class ListUserByTypeAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		//Retrieves all the users within the database
		List<LinkedInUser> users = userRepository.retrieveAll();	
		Collections.sort(users, new MyComparator());
		
		for (LinkedInUser i : users) 
			//If not null
			if(i!= null && i.getUsername() != null)
				System.out.println(i.getUsername() + "; type = " + i.getType()); 

		return true; 
		
		
	} //End process
	
	//Implements comparator for linkedInUses, interface requires compare method
	private static class MyComparator implements Comparator<LinkedInUser> {
	
		@Override
		public int compare(LinkedInUser o1, LinkedInUser o2) {
			
			//Check for null here
			//Throw linkedInuser exception
			if(o1 == null || o2 == null)
			{
				try {
					throw new LinkedInException("LinkedInUser cannot be null");
				} catch (LinkedInException e) {
					System.out.println(e.getMessage());
					return -1; //Gets out of method
				}
			}
			
			//Checks for null username
			if(o1.getUsername() == null || o2.getUsername() == null)
			{
				try {
					throw new LinkedInException("Username cannot be null");
				} catch (LinkedInException e) {
					System.out.println(e.getMessage());
					return -1;
				}
			}
			
			String user1Type = o1.getType();
			String user2Type = o2.getType();
		
			int typeCheck = user1Type.compareTo(user2Type);
			
			//If the types do not equal 0, then they are different
			if(typeCheck != 0)
			{
				return typeCheck;
			}
			
			//The types were the same, begin checking names
			String user1Name = o1.getUsername();
			String user2Name = o2.getUsername();
			
			int nameCheck =  user1Name.compareToIgnoreCase(user2Name);
			return nameCheck;
			
		} //End compare method
		
} //End MyComparator
	
} //End Class

