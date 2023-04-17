/* Colin Maxwell
 * Java 2
 * Undoing Actions
 * 4/11/2021
 */

package edu.institution.actions.asn10;

// import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class UndoAction implements MenuAction {
	
	// publicly available to all actions
	public static Stack<UndoInfo> history = new Stack<>();
	
	
	
	
	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
	/*	
		Iterator value = history.iterator();
		while (value.hasNext()) {
			System.out.println(value.next());
		} 
	*/
		
		if (history.isEmpty())
		{
			System.out.println("There is no action to undo");
			return true;
		}
		
		
		//Display Warning Message
		System.out.println("The last menu option selected was " + history.peek().getUndoType() + " involving " + history.peek().getUndoWhat());
		System.out.println("Undo?(Y/N)");
		String yesNo = scanner.nextLine();
		
		if(!yesNo.toUpperCase().equals("Y")) {
			return true;
		}


		
		/*Add Connection*/
		if(history.peek().getUndoType() == "Add Connection")
		{
			try {
				loggedInUser.removeConnection(userRepository.retrieve(history.peek().getUndoWhat()));
				System.out.println("From Undo, removed " + history.peek().getUndoWhat() + " back");
				history.pop();//removed from the stack
			} catch (LinkedInException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} //End Add Connection
			
	
		/*Remove Connection*/
		else if(history.peek().getUndoType() == "Remove Connection")
		{
			try {
				loggedInUser.addConnection(userRepository.retrieve(history.peek().getUndoWhat()));
				System.out.println("From Undo, added " + history.peek().getUndoWhat() + " back");
				history.pop(); //Removed from the stack
			} catch (LinkedInException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// End Remove Connection
		
		
		/** EXTRA CREDIT*/
		
		/*Add Skillset*/
		else if(history.peek().getUndoType() == "Add Skillset")
		{
			loggedInUser.removeSkillset(history.peek().getUndoWhat());
			ApplicationHelper.decrementSkillsetCount
			
			(history.peek().getUndoWhat());

			System.out.println("From Undo, removed " + history.peek().getUndoWhat() + " skillset back");
			history.pop();
		} //End Add Skillset
		
		/*Remove Skillset*/
		else if(history.peek().getUndoType() == "Remove Skillset")
		{
			loggedInUser.addSkillset(history.peek().getUndoWhat());
			ApplicationHelper.incrementSkillsetCount(history.peek().getUndoWhat());
			System.out.println("From Undo, added " + history.peek().getUndoWhat() + " skillset back");
			history.pop();
		}
		
		/*Sign up a new User*/
		else if(history.peek().getUndoType() == "Sign Up")
		{
			LinkedInUser user = null;
			
			user = userRepository.retrieve(history.peek().getUndoWhat());
			userRepository.delete(user);
			System.out.println("From Undo, deleted " + history.peek().getUndoWhat() + " user back from repository");
			history.pop();
		}
		
		/*Delete a new User*/
		else if(history.peek().getUndoType() == "Delete User")
		{
			LinkedInUser user1 = null;
			
			user1 = history.peek().getUndoUser();
			
			try {
				userRepository.add(user1);
				System.out.println("From Undo, added " + history.peek().getUndoWhat() + " user back from repository");
				history.pop();
			} catch (LinkedInException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return true;
	}

}
