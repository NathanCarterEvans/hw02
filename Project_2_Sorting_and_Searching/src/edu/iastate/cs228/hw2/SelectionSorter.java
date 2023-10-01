package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author Your Name
 *
 */

/**
 * 
 * This class implements selection sort.   
 *
 */
public class SelectionSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points. It invokes the superclass constructor, and also 
	 * sets the instance variables algorithm in the superclass.
	 *  
	 * @param pts  
	 */
	public SelectionSorter(Point[] pts)  
	{
		super(pts);  // Assuming the superclass AbstractSorter has a constructor that takes an array of points
		algorithm = Algorithm.SelectionSort;  // Assuming algorithm is a protected variable in AbstractSorter
	}	

	
	/** 
	 * Apply selection sort on the array points[] of the parent class AbstractSorter.  
	 * 
	 */
	@Override 
	public void sort()
	{
		for (int i = 0; i < points.length - 1; i++) 
		{
			int minIndex = i;
			for (int j = i + 1; j < points.length; j++) 
			{
				if (pointComparator.compare(points[j], points[minIndex]) < 0) 
				{
					minIndex = j;
				}
			}
			
			// Swap points[i] and points[minIndex]
			Point temp = points[i];
			points[i] = points[minIndex];
			points[minIndex] = temp;
		}
	}	
}
