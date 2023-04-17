/* Colin Maxwell
 * Java II R01
 * Assignment 2 - The LinkedInUser Class
 *  1/29/21
 */

package edu.institution.asn2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LinkedInUser extends UserAccount implements Comparable<LinkedInUser>, Serializable{
	/*
	 * 
	 */
	private static final long serialVersionUID = -5323380888033456568L;
	
	
	private Set<String> skillsets = new TreeSet<String>();
	
	/** Returns the skillsets.*/
	public Set<String> getSkillsets() {
		return skillsets;
		
	}
	
	/** Adds the supplied skillset to this user. */
	public void addSkillset(String skillset) {
		
		if(skillsets == null)
			skillsets = new TreeSet<String>();
		
		skillsets.add(skillset);
	}
	
	
	/** Removes the supplied skillset from this user. */
	public void removeSkillset(String skillset) {
		skillsets.remove(skillset);
	}
	




	public LinkedInUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	private String type;
	private List<LinkedInUser> connections = new ArrayList<>();
	
	
	
	
	/* Methods */
	public String getType()
	{
		return this.type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	    //Adds the supplied connection to the list of connections for this user
		//@Throws LinkedInException if the supplied user is alread connected to this user.
	public void addConnection(LinkedInUser user) throws LinkedInException {
		
		if(this.connections.contains(user))
		{
			throw new LinkedInException("You are already connected with this user");
		}
		else
		{ 
			//Adds User into arrayList
			this.connections.add(user);
		//	System.out.println("Connection " + user.getUsername() + " is added!");
		}
	}  
	
	  
	// Remove the supplied user from the list of connections for this user.
	// @Throws LinkedInException if the supplied user is not connected to this user. 
	public void removeConnection(LinkedInUser user) throws LinkedInException {
		if(!this.connections.contains(user))
		{	
			//Throws exception if the inputted user is not located in the user's connections list
			throw new LinkedInException("You are NOT connected with this user");
		}
		else
		{	//removes user
			this.connections.remove(user);
		//	System.out.println("Connection " + user.getUsername() + " is removed!");
		}
		
	}
	
	public List<LinkedInUser> getConnections() {
		
		return new ArrayList<>(this.connections);
		
	}
	
	@Override
	public int compareTo(LinkedInUser user) {
		/*
		String myName = this.getUsername();
		String yourName = user.getUsername();
		return myName.compareToIgnoreCase(yourName);
		*/
		
		if(this==null || user == null)
		{
			return 1;
		}
		if(this.getUsername() == null || user.getUsername() == null)
		{
			return -1;
		}
		
		
		int x = this.getUsername().compareToIgnoreCase(user.getUsername());
		return x;
		
	}
	
	
	
	
} // End Class
