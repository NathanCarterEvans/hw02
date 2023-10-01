package edu.iastate.cs228.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PointScanner {
    private Point[] points;
    private Point medianCoordinatePoint;
    private Algorithm sortingAlgorithm;
    protected long scanTime;

    public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException {
        if (pts == null || pts.length == 0) {
            throw new IllegalArgumentException("Invalid points array.");
        }
        this.points = pts.clone();
        this.sortingAlgorithm = algo;
    }

    protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException {
        Scanner scanner = new Scanner(new File(inputFileName));
        int count = 0;
        while (scanner.hasNextInt()) {
            scanner.nextInt();
            count++;
        }
        if (count % 2 != 0) {
            throw new InputMismatchException("Odd number of integers in the file.");
        }
        scanner.close();

        this.points = new Point[count / 2];
        scanner = new Scanner(new File(inputFileName));
        for (int i = 0; i < this.points.length; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            this.points[i] = new Point(x, y);
        }
        scanner.close();
        this.sortingAlgorithm = algo;
    }

    public void scan() {
        AbstractSorter sorter = null;
        switch (sortingAlgorithm) {
            case SelectionSort:
                sorter = new SelectionSorter(points);
                break;
            case InsertionSort:
                sorter = new InsertionSorter(points);
                break;
            case MergeSort:
                sorter = new MergeSorter(points);
                break;
            case QuickSort:
                sorter = new QuickSorter(points);
                break;
        }

        sorter.setComparator(0);
        sorter.sort();
        int medianX = sorter.getMedian().getX();

        sorter.setComparator(1);
        sorter.sort();
        int medianY = sorter.getMedian().getY();

        medianCoordinatePoint = new Point(medianX, medianY);
    }

    public String stats() {
        return sortingAlgorithm + " " + points.length + " " + scanTime;
    }

    @Override
    public String toString() {
        return "MCP: (" + medianCoordinatePoint.getX() + ", " + medianCoordinatePoint.getY() + ")";
    }

    public void writeMCPToFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(toString());
        writer.close();
    }
}
