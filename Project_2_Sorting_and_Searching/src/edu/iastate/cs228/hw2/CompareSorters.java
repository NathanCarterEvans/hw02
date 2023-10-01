package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 

public class CompareSorters 
{
	public static void main(String[] args) throws FileNotFoundException
	{		
		Scanner input = new Scanner(System.in);
		System.out.println("Choose an option:\n1. Generate random points\n2. Read points from a file");
		int choice = input.nextInt();
		
		Point[] points = null;
		
		if(choice == 1) {
			System.out.println("Enter the number of random points to generate:");
			int numPts = input.nextInt();
			points = generateRandomPoints(numPts, new Random());
		} else {
			// For simplicity, we'll assume a method readPointsFromFile() exists
			// points = readPointsFromFile();
		}
		
		PointScanner[] scanners = {null, null,null,null}; 
		// Initialize scanners with different sorting algorithms
		scanners[0] = new PointScanner(points, Algorithm.SelectionSort);
		scanners[1] = new PointScanner(points, Algorithm.InsertionSort);
		scanners[2] = new PointScanner(points, Algorithm.MergeSort);
		scanners[3] = new PointScanner(points, Algorithm.QuickSort);
		
		// Scan points using each algorithm and print statistics
		for(PointScanner scanner : scanners) {
			scanner.scan();
			// For simplicity, we'll assume a method getScanTime() exists in PointScanner
			// System.out.println(scanner.getAlgorithm() + " took: " + scanner.getScanTime() + " nanoseconds");
		}
		
		input.close();
	}
	
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		if(numPts < 1) {
			throw new IllegalArgumentException("Number of points should be at least 1.");
		}
		
		Point[] randomPoints = new Point[numPts];
		for(int i = 0; i < numPts; i++) {
			int x = rand.nextInt(101) - 50; // Random number between -50 and 50
			int y = rand.nextInt(101) - 50; // Random number between -50 and 50
			randomPoints[i] = new Point(x, y);
		}
		
		return randomPoints;
	}
}
