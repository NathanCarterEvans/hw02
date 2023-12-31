package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

public class QuickSorter extends AbstractSorter
{
	/**
	 * Constructor takes an array of points. It invokes the superclass constructor, and also 
	 * sets the instance variables algorithm in the superclass.
	 * 
	 * @param pts input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		super(pts);
		algorithm = Algorithm.QuickSort; // Assuming Algorithm is an enum in the superclass or accessible scope
	}

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.
	 */
	@Override 
	public void sort()
	{
		quickSortRec(0, points.length - 1);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first starting index of the subarray
	 * @param last ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		if (first < last)
		{
			int pivotIndex = partition(first, last);
			quickSortRec(first, pivotIndex - 1);
			quickSortRec(pivotIndex + 1, last);
		}
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return pivot index after partition
	 */
	private int partition(int first, int last)
	{
		Point pivot = points[last];
		int i = first - 1;

		for (int j = first; j < last; j++)
		{
			if (pointComparator.compare(points[j], pivot) <= 0)
			{
				i++;
				Point temp = points[i];
				points[i] = points[j];
				points[j] = temp;
			}
		}

		Point temp = points[i + 1];
		points[i + 1] = points[last];
		points[last] = temp;

		return i + 1;
	}
}
