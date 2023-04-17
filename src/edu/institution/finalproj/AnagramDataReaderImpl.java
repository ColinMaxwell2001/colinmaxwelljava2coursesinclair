/* Colin Maxwell
 * Java II
 * Final Project
 * 5/3/2021
 */

package edu.institution.finalproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class AnagramDataReaderImpl implements AnagramDataReader{
	
	private static String PATH = System.getProperty("user.home") + File.separator + "Java2" + File.separator;
	private static String FILE_NAME = "anagram_data.txt";
	
	
	String namesFile = PATH + FILE_NAME;
	Set<String> hash_Set = new HashSet<String>();
	@Override
	public Set<String> readData() {
//	 	System.out.println(namesFile);
		try {
			Scanner textFile = new Scanner(new File(namesFile));
			 
			while(textFile.hasNext()) {
				hash_Set.add(textFile.next().trim());
			}
			
			textFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		
		return hash_Set;
	}
	
}
