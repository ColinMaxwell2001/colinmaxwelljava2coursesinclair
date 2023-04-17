/* Colin Maxwell
 * Java 2
 * Undoing Actions
 * 4/11/2021
 */
package edu.institution.actions.asn10;

import edu.institution.asn2.LinkedInUser;

public class UndoInfo {
	
	//Variable that holds method / menu action
	private String undoType = "";
	
	//Variable that holds who/what
	private String undoWhat = "";
	
	private LinkedInUser undoUser = null;


	//Over loaded constructor
	public UndoInfo(String undoType, String undoWhat) {
		//Sets Variables
		setUndoType(undoType);
		setUndoWhat(undoWhat);
	}
	
	//Over loaded constructor for LinkedInUser 
	public UndoInfo(String undoType, String undoWhat, LinkedInUser user) {
		//Sets Variables
		setUndoType(undoType);
		setUndoWhat(undoWhat);
		this.undoUser = user;
	}


	

	/*Getters & Setters*/
	public String getUndoType() {
		return undoType;
	}

	public void setUndoType(String undoType) {
		this.undoType = undoType;
	}

	public String getUndoWhat() {
		return undoWhat;
	}

	public void setUndoWhat(String undoWhat) {
		this.undoWhat = undoWhat;
	}
	
	public LinkedInUser getUndoUser() {
		return undoUser;
	}

	public void setUndoUser(LinkedInUser undoUser) {
		this.undoUser = undoUser;
	}
	
	@Override
	public String toString() {
		return "UndoInfo [undoType=" + undoType + ", undoWhat=" + undoWhat + "]";
	}
	
}

	
	