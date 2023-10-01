package edu.iastate.cs228.hw2;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    // Static variable to determine if comparison is based on x or y coordinate
    public static boolean xORy; 

    // Default constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Parameterized constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Set the value of the static variable xORy
    public static void setXorY(boolean xORy) {
        Point.xORy = xORy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(Point q) {
        if (xORy) { // Compare based on x-coordinate
            if (this.x < q.x || (this.x == q.x && this.y < q.y)) {
                return -1;
            } else if (this.x == q.x && this.y == q.y) {
                return 0;
            } else {
                return 1;
            }
        } else { // Compare based on y-coordinate
            if (this.y < q.y || (this.y == q.y && this.x < q.x)) {
                return -1;
            } else if (this.y == q.y && this.x == q.x) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
