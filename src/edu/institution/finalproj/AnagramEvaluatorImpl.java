/* Colin Maxwell
 * Java II
 * Final Project
 * 5/3/2021
 */

package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class AnagramEvaluatorImpl implements AnagramEvaluator {

	
	private List<String> permutationsList = new ArrayList<String>();
	private Set<String> words_Set = new HashSet<String>();
	@Override
	public List<String> evaluate(String anagram, String option) {
		
		List<String> finalPermutationsList = new ArrayList<String>();

		//Returns null if anagram is null
		if(anagram == null) return null;
		
		AnagramDataReaderImpl anagramDataReader = new AnagramDataReaderImpl();
		
		permutationsList.clear();
		combinations(anagram, ""); 
		
		/*No-filter*/
		if(option == "nf")
		{
			//Sorts list
			Collections.sort(permutationsList, new MyComparator());
			return permutationsList; //Returns list of words with no-filter
		}
		
		finalPermutationsList.clear();
		/*Words*/
		if(option == "words")
		{
			words_Set = anagramDataReader.readData();
		 
			//For Each String in the permutations List
			for(String i: permutationsList)
			{
				//For Each String in the wordset
				for(String j: words_Set)
				{
					//If any of the strings in either set/list match
					if(i.equalsIgnoreCase(j))
					{
						//add that string onto the final list
						finalPermutationsList.add(i);
					}
				}
			}
			//Sorts list
			Collections.sort(finalPermutationsList, new MyComparator());
			return finalPermutationsList;
		}
		
		//Returns null if option doesn't equal nf or words
		return null;
	}//End evaluate()
	
	//Implements comparator to compare elements in list
	private static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			
			//Check fro null here
			if(o1 == null || o2 == null)
			{
				System.out.println("Cannot be null");
				return -1;
			}
			
			return o1.compareToIgnoreCase(o2);
			
		}
		
	}
	
	//Recursive Method to Add all permutations into a 
	@Override
	public void combinations(String anagram, String ans){
		
		//Base Case
		if (anagram.length() == 0) 
		{
			permutationsList.add(ans);//Adds ans onto the List
			return;
		}
		
		//For the length of the anagram
		for(int i = 0; i < anagram.length(); i++)
		{
			//ith character of anagram
			char ch = anagram.charAt(i);
			
			//Rest of String
			String ros = anagram.substring(0, i) + anagram.substring(i + 1);
			
			// Recursive call
			combinations(ros, ans + ch);
		}
		
		/* This is where I recieved help for this method
		 * https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
		 * 
		 * I chose this implementation because it was the easiest to follow along with.
		 * The way it works is by going through all of the letters of the anagram in the
		 * for loop, and re-arranging them (the Recursive Call) until the anagram's length is equal to 0 (the Base Case),
		 * meaning the method has recursively iterated until all possible combinations were met. 
		 */
		
		
	}
	
} //End Class
