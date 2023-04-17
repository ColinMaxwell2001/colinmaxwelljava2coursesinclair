package edu.institution.actions.asn4;

import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoInfo;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class RemoveConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		System.out.println("Enter user name to remove: ");
		String userName = scanner.nextLine();
		
		if (userRepository.retrieve(userName) == null)
		{
			System.out.println("There is no user with that user name");
		}
		
		try {
			loggedInUser.removeConnection(userRepository.retrieve(userName));
			System.out.println("Connection " + userName + " is removed!");
			UndoInfo uI = new UndoInfo("Remove Connection", userName);
			UndoAction.history.push(uI);
			
		} catch (LinkedInException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return true;
	}

}
