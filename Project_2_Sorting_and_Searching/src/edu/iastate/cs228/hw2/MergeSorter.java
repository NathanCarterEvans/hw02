package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

public class MergeSorter extends AbstractSorter
{
	private Point[] temp;  // Temporary array for the merge process

	public MergeSorter(Point[] pts) 
	{
		super(pts);
		algorithm = Algorithm.MergeSort;  // Set the algorithm type
		temp = new Point[pts.length];
	}

	@Override 
	public void sort()
	{
		mergeSortRec(points);
	}

	private void mergeSortRec(Point[] pts)
	{
		if (pts.length <= 1) return;

		// Split the array into two halves
		int mid = pts.length / 2;
		Point[] left = new Point[mid];
		Point[] right = new Point[pts.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = pts[i];
		}
		for (int i = mid; i < pts.length; i++) {
			right[i - mid] = pts[i];
		}

		// Recursively sort the two halves
		mergeSortRec(left);
		mergeSortRec(right);

		// Merge the sorted halves
		merge(pts, left, right);
	}

	private void merge(Point[] pts, Point[] left, Point[] right)
	{
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (pointComparator.compare(left[i], right[j]) <= 0) {
				pts[k++] = left[i++];
			} else {
				pts[k++] = right[j++];
			}
		}

		while (i < left.length) {
			pts[k++] = left[i++];
		}

		while (j < right.length) {
			pts[k++] = right[j++];
		}
	}
}
