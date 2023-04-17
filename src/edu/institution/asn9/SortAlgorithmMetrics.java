package edu.institution.asn9;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortAlgorithmMetrics {
	
	
	
	@SuppressWarnings("resource")
	public List<MetricData> retrieveMetrics(String filePath) {
				
		List<MetricData> newList = new ArrayList<MetricData>();

		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
		//	System.out.println(e.getMessage());
			return null;
		}
		
		List<Integer> intList = new ArrayList<Integer>();
		
		// 1. Read the integeres into ArrayList
		while(scanner.hasNextInt())
		{
		    intList.add(scanner.nextInt()); 
		}
		
		// System.out.println("what is size: " + intList.size());
		
		// 1. Shuffles integers in ArrayList
		Collections.shuffle(intList);
		Integer[] temp = {};
		// Converts the ArrayList into an array
		Integer[] list = intList.toArray(temp);
		// Array Declaration
		Integer[] list2 = new Integer[list.length];
		Integer[] list3 = new Integer[list.length];
		Integer[] list4 = new Integer[list.length];
		Integer[] list5 = new Integer[list.length];

		// Copies all elements of list into 5 identical lists
		System.arraycopy(list, 0, list2, 0, list.length);
		System.arraycopy(list, 0, list3, 0, list.length);
		System.arraycopy(list, 0, list4, 0, list.length);
		System.arraycopy(list, 0, list5, 0, list.length);

		
		/*Bubble Sort*/
		MetricData mc = new MetricData(SortAlgorithm.BUBBLE_SORT); // Set Algorithm = Bubble Sort
		mc.setTimeComplexity(TimeComplexity.QUADRATIC); // Set TimeComplexity = Quadratic
		//Time Bubble Sort
		LocalTime start = LocalTime.now();
		BubbleSort.bubbleSort(list); 
		LocalTime end = LocalTime.now();
		// Set Execution Time
		mc.setExecutionTime(Duration.between(start, end).toMillis());
		//Add Bubble Sort to List
		newList.add(mc); 
		
		/*Merge Sort*/
		MetricData mc2 = new MetricData(SortAlgorithm.MERGE_SORT); //Set Algorithm = Merge Sort
		mc2.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		//Time Merge Sort
		LocalTime start2 = LocalTime.now();
		MergeSort.mergeSort(list2);
		LocalTime end2 = LocalTime.now();
		// Set Execution Time
		mc2.setExecutionTime(Duration.between(start2, end2).toMillis());
		// Add Merge Sort to List
		newList.add(mc2);
		
		/*Quick Sort*/
		MetricData mc3 = new MetricData(SortAlgorithm.QUICK_SORT);
		mc3.setTimeComplexity(TimeComplexity.QUADRATIC);
		//Time Quick Sort
		LocalTime start3 = LocalTime.now();
		QuickSort.quickSort(list3);
		LocalTime end3 = LocalTime.now();
		// Set Execution Time
		mc3.setExecutionTime(Duration.between(start3, end3).toMillis());
		// Add Quick Sort to List
		newList.add(mc3); 
		
		
		/*Heap Sort*/
		MetricData mc4 = new MetricData(SortAlgorithm.HEAP_SORT);
		mc4.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		// Time Heap Sort
		LocalTime start4 = LocalTime.now();
		HeapSort.heapSort(list4);
		LocalTime end4 = LocalTime.now();
		// Set Execution Time
		mc4.setExecutionTime(Duration.between(start4, end4).toMillis());
		// Add Heap Sort to List
		newList.add(mc4);
		
		/*Insertion Sort*/
		MetricData mc5 = new MetricData(SortAlgorithm.INSERTION_SORT);
		mc5.setTimeComplexity(TimeComplexity.QUADRATIC);
		// Time Insertion Sort
		LocalTime start5 = LocalTime.now();
		InsertionSort.insertionSort(list5);
		LocalTime end5 = LocalTime.now();
		// Set Execution Time
		mc5.setExecutionTime(Duration.between(start5, end5).toMillis());
		// Add Insertion Sort to List
		newList.add(mc5);
		
		Collections.sort(newList);
		//Do same thing for all others
		return newList;
	
	} // End RetrieveMetrics()
	
	

} // End Class
