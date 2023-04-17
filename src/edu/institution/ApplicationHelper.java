/*
 Copyright (C) 2020. Doug Estep -- All Rights Reserved.
 Copyright Registration Number: TXU002159309.

 This file is part of the Tag My Code application.

 This application is protected under copyright laws and cannot be used, distributed, or copied without prior written
 consent from Doug Estep.  Unauthorized distribution or use is strictly prohibited and punishable by domestic and
 international law.

 Proprietary and confidential.
 */
package edu.institution;

import java.util.HashMap;
import java.util.List;

import edu.institution.asn2.LinkedInUser;

/**
 * Contains static helper methods to aid with the command line user interface.
 */
public class ApplicationHelper {
	
	/*----HashMap----*/
	public static HashMap<String, Integer> hMap = new HashMap<String, Integer>();

	/**
	 * Displays the supplied message to the console.
	 * 
	 * @param message the message.
	 */
	public static void showMessage(String message) {
		System.out.println("\n" + message);
	}
	
	
	
	/**Increments number of users associated with the supplied skillset.
	 * If this is the first occurence ofthe supplied skillset, then add
	 * the skillset to your collection and default the count to one.
	 * 
	 * @param skillset the skillset to increment
	 */
	public static void incrementSkillsetCount(String skillset) {
		
		if(hMap.containsKey(skillset))
		{
			
			hMap.put(skillset, hMap.get(skillset) + 1);
		}
		else
			hMap.put(skillset, 1);
		
	}
	
	
	/** Decrements the number of useres associated with the suppleid skillset.
	 *  If the number of users associated with the supplied skillset is zero
	 *  then remove the skillset from your collection
	 *  
	 *  @param skillset the skillset to decrement
	 */
	 public static void decrementSkillsetCount(String skillset) {
		 
		 if(hMap.containsKey(skillset))
			{
			
			 	if(hMap.get(skillset) == 1)
				{
					hMap.remove(skillset);
				}
			 	else
			 		hMap.put(skillset, hMap.get(skillset) - 1);
				
				
			/*
				for(HashMap.Entry<String, Integer> entry : ApplicationHelper.hMap.entrySet())
				{
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				}
			*/
			
			}
			
	 } //End decrementSkillsetCount
	 
	 
	 /** Retrieve the number of users associated with the supplied skillset.
	  *  If the skillset is not in the collection, return -1
	  * 
	  */
	  public static int retrieveSkillsetCount(String skillset) {
		  
		  if (!hMap.containsKey(skillset))
		  {
			   return -1;
		  }
		 
		  return hMap.get(skillset);
	  }
	  
	  
	  
	  /** Loops through each user and incremnts the global skillset usage count for
	   *  each skillset associated with the user
	   *  
	   *  @param users the list of users.
	   */
	  	public static void initSkillsetUsages(List<LinkedInUser> users) {
	  		
	  		for(LinkedInUser u: users)
	  		{
	  			//u.getSkillsets();
	  			if(u.getSkillsets() == null)
	  				continue;
	  			
	  			
	  			for(String s: u.getSkillsets())
	  			{
	  				incrementSkillsetCount(s);
	  			}
	  			
	  		}
	  		
	  	}
	  	
	  
}
