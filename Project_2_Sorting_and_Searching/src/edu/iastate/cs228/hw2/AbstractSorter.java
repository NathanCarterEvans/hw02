package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

public abstract class AbstractSorter
{
	protected Point[] points;
	protected Algorithm algorithm = null;
	protected Comparator<Point> pointComparator = null;

	protected AbstractSorter()
	{
		// Default constructor
	}

	protected AbstractSorter(Point[] pts) throws IllegalArgumentException
	{
		if (pts == null || pts.length == 0)
		{
			throw new IllegalArgumentException("Input array of points cannot be null or empty.");
		}
		this.points = pts.clone(); // Deep copy to ensure encapsulation
	}

	public void setComparator(int order) throws IllegalArgumentException
	{
		if (order < 0 || order > 1)
		{
			throw new IllegalArgumentException("Order must be either 0 (for x-coordinate) or 1 (for y-coordinate).");
		}
		pointComparator = (Point p1, Point p2) -> {
			if (order == 0) // Compare by x-coordinate
			{
				return Integer.compare(p1.getX(), p2.getX());
			}
			else // Compare by y-coordinate
			{
				return Integer.compare(p1.getY(), p2.getY());
			}
		};
	}

	public abstract void sort();

	public Point getMedian()
	{
		return points[points.length / 2];
	}

	public void getPoints(Point[] pts)
	{
		System.arraycopy(points, 0, pts, 0, points.length); // Copy points[] to pts[]
	}

	protected void swap(int i, int j)
	{
		Point temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
}
   