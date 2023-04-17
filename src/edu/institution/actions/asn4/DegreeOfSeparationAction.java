/* Colin Maxwell
 * Java II R01
 * Assignment 4 - LinkedIn Connections
 * 2/15/21
 */
package edu.institution.actions.asn4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;


public class DegreeOfSeparationAction implements MenuAction {

	/* Data Fields */
	List<LinkedInUser> answer = new ArrayList<>(); //Holds the users within the final result
	int count = 0; // counts how many times the recursive function has called itself
	boolean userFound = false;
	 
	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		//Array List that holds every user that has been seaerched
		List<LinkedInUser> searched = new ArrayList<>(); 

		System.out.println("Enter username: ");
		String userName = scanner.nextLine();
		
		// Calls recusive method, passing count at 0, the searched arrayList, the LoggedInUser, and the specified userName
		separation(0, searched, loggedInUser, userName);
		
		if(userFound) //If userFound is true, print the size of the array containing all of the linkedInUser's
		{
			System.out.println("There is " + answer.size() + " degrees of separation between you and " + userName );
			System.out.print(loggedInUser.getUsername());
			
			//For Each linkedInUser in the answer ArrayList, print their name
			for (LinkedInUser i: answer) 
			{
				System.out.print(" -> " + i.getUsername());
			}
			//Print name of specified user
			System.out.println(" -> " + userName); 
		}
		//Null test
		else if(userRepository.retrieve(userName) == null)
		{
			System.out.println("There is no user with that user name");
		}
		//If there is no connection with the logged in user and specified user.
		else
		{
			System.out.println("Connection not found");
		}
		
		return true;
	}
	
	
	public int separation(int count, List<LinkedInUser> searched, LinkedInUser currentLinkedInUser, String username)
	{
		if (currentLinkedInUser.getUsername().equals(username) && count == 0) //Test for searching self
			return 0;
		
		/*Base Case*/ //If the user is found, return count
		if(userFound)
		{
			return count;
		}

		//Searches through the current user's connections list
		for(LinkedInUser user : currentLinkedInUser.getConnections())
		{
			
			if(searched.contains(user))
			{
				continue; // iterates back into the for-loop
			}
			
			//Base Case
			if(user.getUsername().equals(username))
			{
				userFound = true;
				return count;
			}
			
			count++;
			searched.add(user); //Adds the user into the searched ArrayList to avoid reoccuring users.
			answer.add(user); //Adds the user into the answer ArrayList containing the correct users
			separation(count, searched, user, username); //Calls itself again
		}
		if(!userFound)
		{
			answer.clear(); //ArrayList cleared
		}
		
		//returns count, (number of times method has been called)
		return count;
	}
	
	
}
