package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements insertion sort.   
 *
 */
public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points. It invokes the superclass constructor, and also 
	 * sets the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);  // Assuming the superclass AbstractSorter has a constructor that takes an array of points.
		algorithm = Algorithm.InsertionSort;  // Assuming algorithm is a protected variable in AbstractSorter.
	}	

	
	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	public void sort()
	{
		int n = points.length;  // Assuming points[] is a protected array in AbstractSorter.
		for (int i = 1; i < n; ++i) 
		{
			Point key = points[i];
			int j = i - 1;

			// Move elements of points[0..i-1] that are greater than key
			// to one position ahead of their current position
			while (j >= 0 && points[j].compareTo(key) > 0) 
			{
				points[j + 1] = points[j];
				j = j - 1;
			}
			points[j + 1] = key;
		}
	}		
}
