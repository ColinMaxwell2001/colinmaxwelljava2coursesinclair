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

public class ListUserByConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		//Retrieves all LinkedInUsers
		List<LinkedInUser> users = userRepository.retrieveAll();
		Collections.sort(users, new MyComparator());

		for (LinkedInUser i : users)
			//If LinkedInUser is not null and username is not null
			if(i!= null && i.getUsername() != null) 
				System.out.println(i.getUsername() + "; Connection Size = " + i.getConnections().size());
			
		return true;
	} //End Process
	 
	
	//Implements the comparator for linkedInUsers, interface requires compare method
	private static class MyComparator implements Comparator<LinkedInUser>  {
		
		@Override
		public int compare (LinkedInUser o1, LinkedInUser o2) {
			
			//Checks for null
			//Throws LinkedInException
			if(o1 == null || o2 == null)
			{
				try {
					throw new LinkedInException("LinkedInUser cannot be null");
				} catch (LinkedInException e) { 
					System.out.println(e.getMessage());
					return -1;
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
			
			
			// .size() retrieves the size of the users connection list
			int user1Connections = o1.getConnections().size();
			int user2Connections = o2.getConnections().size();
			
			int sizeCheck = user2Connections - user1Connections;
			
			if(sizeCheck != 0) 
			{
				//Returns -1 or +1
				return sizeCheck;
			}
			
			//If sizes are the same, compare by names
			String user1Name = o1.getUsername();
			String user2Name = o2.getUsername();
			
			int nameCheck =  user1Name.compareToIgnoreCase(user2Name);
			return nameCheck;
			
						
		} // End compare
		
		
	} // End MyComparator Class

} //End Class
