package edu.institution.actions.asn4;

import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoInfo;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class AddConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		System.out.println("Enter Username: ");
		String userName = scanner.nextLine();
				
		
		if(userRepository.retrieve(userName) == null)
		{
			System.out.println("There is no user with that user name");
			return true;
		}
		
		try {
				loggedInUser.addConnection(userRepository.retrieve(userName));
				System.out.println("Connection " + userName + " is added!");
				UndoInfo uI = new UndoInfo("Add Connection", userName);
				UndoAction.history.push(uI);
				
			//	System.out.println("Record Undo Event for Add Connection");
			//	System.out.println("Record the user name");
				
			} catch (LinkedInException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	
		
		return true;
	}

}
