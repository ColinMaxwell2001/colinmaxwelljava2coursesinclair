/* Colin Maxwell
 * Java II R01
 * Assignment 3 - LinkedInUser CLI
 * 2/7/21
 */
package edu.institution.actions.asn3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class SerializedUserRepository implements UserRepository {
	
	/*Data Fields*/
	private String filePath;
	private String fileName;
	private List<LinkedInUser>users;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init(String filePath, String fileName) {
		
		/* 
		 * Deserialize the data stored at the nameOfPath
		 * location into a list of LinkedIn users
		 */
		this.filePath = filePath;
		this.fileName = fileName;
		String nameOfPath = filePath + fileName;
		
		/* If no previously saved data*/
		File file = new File(nameOfPath); 
        if (!file.exists()) {
        	//Initialize new array list of LinkedInUsers
        	this.users = new ArrayList<>();
            return;
        }
		
        //Snippet from PowerPoint Reading Objects Example      
        try (
        	 FileInputStream fis = new FileInputStream(nameOfPath);
        	 ObjectInputStream ois = new ObjectInputStream(fis);
        	 ) { 
        	this.users = (List<LinkedInUser>) ois.readObject();
        } catch (Exception e) { 
        	e.printStackTrace();
        }
        
        /**Initiate the skillset usage counts after the application starts up */
		ApplicationHelper.initSkillsetUsages(users);
	}

	@Override
	public void add(LinkedInUser user) throws LinkedInException {
		/* Test if user supplies no username and no type */
		if (user.getUsername().equals("") || user.getType().equals(""))
		{
			throw new LinkedInException("The user name and type are required to add a new user."); 
		}
		
		/* Test if user supplies null username and null type */
		else if (user.getUsername() == null || user.getType() == null) 
		{	
			throw new LinkedInException("The user name and type are required to add a new user."); 
		}
		
		/* Test if user supplies type that isn't 'P' or 'S' */
		else if (!user.getType().equals("P") && !user.getType().equals("S"))
		{
			throw new LinkedInException("Invalid user type. Valid types are P or S.");
		}
		
		/* Test if supplied user already exists */
		else if (this.users.contains(user))
		{
			throw new LinkedInException("A user already exists with that user name.");	
		}
		//supplied user passes all error checks, add user to list
		this.users.add(user);
		saveAll();
		
	} //End add()
	

	@Override
	public void saveAll() {		
		String nameOfFilePath = this.filePath + this.fileName;
		
		File file = new File(nameOfFilePath);
	
		if(file.exists()) { 
		    file.delete();
		}
	
		
		try (
			 FileOutputStream fout = new FileOutputStream(nameOfFilePath);
			 ObjectOutputStream oos = new ObjectOutputStream(fout);
			) {	
			//Overwrites the list of LinkedIn users to file system.
			 oos.writeObject(this.users);
			} catch (Exception ex) {
			  ex.printStackTrace();
			}
	} //End saveAll()

	@Override
	public void delete(LinkedInUser user) {
		/* Removes the supplied LinkedIn User from the list of LinkedIn
		 * users that was established in init method */
		this.users.remove(user);
		saveAll(); 
	} //End delete()
	

	@Override
	public LinkedInUser retrieve(String username) {
		/* Returns the LinkedIn users associated with supplied name or null*/
		LinkedInUser selectedUser = null;
		for (LinkedInUser i: this.users) {
			/* Checks if username is not null and equals supplied username */
			if (i.getUsername() !=null) {
				if (i.getUsername().equals(username))
					selectedUser = i;
			}
		}
		//Returns null if null or user associated with supplied user
		return selectedUser;
	} // End retrieve()

	@Override
	public List<LinkedInUser> retrieveAll() {		
		return new ArrayList<>(this.users);
	} // End retrieveAll()

	
	@Override
	public String toString() {
		String message="";
		
		for (LinkedInUser i : this.users) 
            System.out.println("UserName: (" + i.getUsername() + ") Type=(" + i.getType() +")"); 
		
		message += this.filePath;
		message += this.fileName;
		message += "\n";
		return message; 
	} //End toString
	
}
