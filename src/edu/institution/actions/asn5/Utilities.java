/* Colin Maxwell
 * Java II Assignment 5 - Utility Methods
 * 2/21/21
 */

package edu.institution.actions.asn5;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
	
	public <T> void removeDuplicates(List<T> items) {
		
		if(items == null)
		{
			return;
		}
		
		// create new arraylist object
		List<T> newList = new ArrayList<>();
		
		//Check for duplicates
		for (T emp: items) {
			if(!newList.contains(emp))
			{
				newList.add(emp);
			}
		}
		
		items.clear();
		items.addAll(newList);
		
	}
	
	
	public <E> E linearSearch(List<E> list, E key) {
		
		//Case for null
		if (list == null || key == null)
			return null;
		
		for(E i: list)
		{
			if(i == null)
				continue;
			
			if(i.equals(key))
			{
				return i;
			}
		}
		
		//If key not found
		return null;
	}
	

}
