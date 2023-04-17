/* 
 * Colin Maxwell
 * Java 2
 * Midterm 
 * 3/7/2021
 * 
 */

package edu.institution.midterm;

import java.util.List;

public interface PartManager{

	//Imports the part store from an external file
	//Accepts the file path to the file which contains the parts to import
	//Returns the number of parts imported
	public int importPartStore(String filePath);
	
	public Part costPart(String partNumber);
	
	public Part retrievePart(String partNumber);
	
	public List<Part> getFinalAssemblies();
	
	public List<Part> getPurchasePartsByPrice();
	
} //End PartManager
