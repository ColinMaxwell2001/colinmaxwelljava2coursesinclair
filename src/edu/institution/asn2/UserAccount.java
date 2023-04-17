/* Colin Maxwell
 * Java II R01
 * Assignment 2 - The LinkedInUser Class
 *  1/29/21
 */

package edu.institution.asn2;

import java.io.Serializable;

public abstract class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 135688228421516010L;
	//Private Fields
	private String username;
	private String password;
	
	
	/*Constructor*/
	public UserAccount(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	
	/* New Abstract Method */
	public abstract void setType(String type);

	public String getUsername()
	{
		return this.username;
	}
	
	public boolean isPasswordCorrect(String password)
	{	//Testing for null password within this.object
		if(this.password == null)
		{
			return false;
		}
		
		else if (this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	@Override
	 public String toString() {
		 
		 return this.getUsername();
		 
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	 
	 
	
} //End Class
