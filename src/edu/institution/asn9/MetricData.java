/*
 * Colin Maxwell
 * Java 2
 * Sorting
 * 4/4/2021
 */

package edu.institution.asn9;

public class MetricData implements Comparable<MetricData>{
	
	// the sort algorithm used to sort the data
	private SortAlgorithm sortAlgorithm;
	
	// the time complexity for the sort algorithm
	private TimeComplexity timeComplexity;
	
	// the time (in milliseconds) that it took to sort the data
	private long executionTime;

	//Constructor
	public MetricData(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	
	


	/*Getters and Setters*/
	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public TimeComplexity getTimeComplexity() {
		return timeComplexity;
	}

	public void setTimeComplexity(TimeComplexity timeComplexity) {
		this.timeComplexity = timeComplexity;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	
	
	/*toString*/
	@Override
	public String toString() {
		return "MetricData [sortAlgorithm=" + sortAlgorithm + ", timeComplexity=" + timeComplexity + ", executionTime="
				+ executionTime + "]";
	}
	
	/*Hash Code / Equals */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sortAlgorithm == null) ? 0 : sortAlgorithm.hashCode());
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
		MetricData other = (MetricData) obj;
		if (sortAlgorithm != other.sortAlgorithm)
			return false;
		return true;
	}




	@Override
	public int compareTo(MetricData o) {
			
		if (this.executionTime == o.getExecutionTime()) {
            return 0;
        } else if (this.executionTime > o.getExecutionTime()) {
            return 1;
        } else {
            return -1;
        }			
	}
	




	
	
	
	
	
} // End Class






