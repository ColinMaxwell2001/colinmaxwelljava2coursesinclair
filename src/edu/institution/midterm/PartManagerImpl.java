/* 
 * Colin Maxwell
 * Java 2
 * Midterm 
 * 3/7/2021
 * 
 */

package edu.institution.midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;



public class PartManagerImpl implements PartManager {

	float nextPartPrice = 0;
	float additionalPartPrice = 0;
	
	// https://www.w3schools.com/java/java_hashmap.asp
	// Hash Map Collection for Extra Credit
	HashMap<String, Part> partsMap = new HashMap<String, Part>();
	
	@Override
	public int importPartStore(String filePath) {
		String jsonData = "";
		
		File file = new File(filePath);
		if(!file.exists()) 
			return 0;//
		 
		Scanner input;
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				jsonData+= input.next();
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		Gson gson = new Gson();
		Part[] parts = gson.fromJson(jsonData, Part[].class);
		
		List<Part> partsFound = new ArrayList<>();
		
		for(Part i: parts)
		{
			if (partsFound.contains(i))
			{
				continue;
			}
			else
			{
				partsFound.add(i);
				partsMap.put(i.getPartNumber(), i);
			}
		}
		
		return partsMap.size();
		
	} //End importPartStore()
	
	
	@Override
	public Part costPart(String partNumber) {
		
		Part costP = retrievePart(partNumber);
		
		float totalPrice = recursiveMethod(costP);
		costP.setPrice(totalPrice);
		
		return costP;
		
	} //End costPart

	public float recursiveMethod(Part currentPart) {

		List<BomEntry> currentBom = currentPart.getBillOfMaterial();
		//Set to 0 at the beginning of each recursive call
		float finalPrice = 0;

		//Base Case      
		if (currentBom == null)
			return currentPart.getPrice(); //purchased
		
		
		for(BomEntry i : currentBom)
		{
			//Retrieve Part Number
			currentPart = retrievePart(i.getPartNumber());
			
			//Calls recursive Method
			nextPartPrice = recursiveMethod(currentPart);
			
			//Sets additional price to (nextPartPrice * that part's quantity)
			additionalPartPrice = nextPartPrice * i.getQuantity(); 
			
			//Final Price = additionalPartPrice
			finalPrice = finalPrice + additionalPartPrice;
		}
		
		return roundForMoney(finalPrice);

	} //End recursiveMethod
	 
	private float roundForMoney(float value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}
	
	@Override
	public Part retrievePart(String partNumber) {
	
		Part returnPart = partsMap.get(partNumber);
		if (returnPart == null)
		{
			return null;
		}
		
		return returnPart;
		
	}// End retrievePart()

	
	
	@Override
	public List<Part> getFinalAssemblies() {
		//Create new arrayList to hold all assembly parts
		List<Part> assemblyList = new ArrayList<>();
		
		//for each part within the parts array list
		for(Part i: partsMap.values())
		{
			if(i.getPartType().equals("ASSEMBLY"))
				assemblyList.add(i);
			
		}
		
		/*Sort in ascending order*/
		Collections.sort(assemblyList, new MyComparator());
		for(Part i: assemblyList)
		{
			System.out.println(i.getPartNumber() + " " + i.getPartType());
		}
		
		return assemblyList;
	} //End getFinalAssemblies() 

	
	
	@Override
	public List<Part> getPurchasePartsByPrice() {
		
		//Create a new arrayList to hold all purchased parts 
		List<Part> purchasedList = new ArrayList<>();
		
		//for each part within the parts array list
		for(Part i: partsMap.values())
		{
			if(i.getPartType().equals("PURCHASE"))
				purchasedList.add(i);
			
		}
		
		//Sort in descending order
		Collections.sort(purchasedList, new MyComparator2());
		for(Part i: purchasedList)
		{
			System.out.println(i.getPrice() + " " + i.getPartType());
		}
		
		return purchasedList;
	}//End getPurchasePartsByPrice()
	
 private static class MyComparator implements Comparator<Part>  {
		
		@Override
		public int compare (Part o1, Part o2) {
			
			//Checks for null
			//Throws LinkedInException
			if(o1 == null || o2 == null)
			{
				try {
					throw new Exception("Part cannot be null");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return -1;
				}
			}

			//Checks for null username
			if(o1.getPartNumber() == null || o2.getPartNumber() == null)
			{
				try {
					throw new Exception("Part number cannot be null");
				} catch (Exception e) {
					//Prints Exception
					System.out.println(e.getMessage());
					return -1;
				}
			}
		
			//If sizes are the same, compare by names
			String part1 = o1.getPartNumber();
			String part2 = o2.getPartNumber();
			
			int partCheck =  part1.compareToIgnoreCase(part2);
			return partCheck;
					
		} // End compare
		
	} // End MyComparator Class
		
		
 private static class MyComparator2 implements Comparator<Part>  {
		
		@Override
		public int compare (Part o1, Part o2) {
			//Checks for null
			//Throws LinkedInException
			if(o1 == null || o2 == null)
			{
				try {
					throw new Exception("Part cannot be null");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return -1;
				}
			}
			
			//If sizes are the same, compare by names
			float part1 = o1.getPrice();
			float part2 = o2.getPrice();
						
			if(part1 > part2)
				return -1;
			else if (part1 < part2)
				return 1;
			else
				return 0;
						
		} // End compare
		
	} // End MyComparator Class

} //End Class
	
	
	
	
	


