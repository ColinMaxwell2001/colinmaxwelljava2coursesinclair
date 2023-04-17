package edu.institution.actions.asn4;

import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListConnectionAction implements MenuAction {

	public ListConnectionAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		
		List<LinkedInUser> users = loggedInUser.getConnections();
		
		for(LinkedInUser i: users)
		{
			System.out.println(i.getUsername());
		}
		
		
		 
		return true;
	}

}
