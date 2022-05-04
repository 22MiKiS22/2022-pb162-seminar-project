package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.comparator.VertexInverseComparator;

import java.util.Comparator;

/**
 * @author Michael Skor
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private final double x;
    private final double y;

    /**
     * Constructor of Vertex2D
     * @param x: x coordinate
     * @param y: y coordinate
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * This method returns string representing vertex
     * @return string
     */
    public String toString() {
        return String.format("[%s, %s]", x, y);
    }

    /**
     * This method calculate middle vertex of given two vertices
     * @param vertex: given vertex
     * @return new vertex representing middle vertex
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        return new Vertex2D((this.x + vertex.x)/2.0, (this.y + vertex.y)/2.0);
    }

    /**
     * Method calculates distance of points
     * @param point: given point
     * @return distance of points
     */
    public double distance(Vertex2D point) {
        if (point == null) {
            return -1.0;
        }
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        return x == ((Vertex2D) object).getX() && y == ((Vertex2D) object).getY();
    }

    @Override
    public int hashCode() {
        return 31 * (int) x + (int) y;
    }

    @Override
    public int compareTo(Vertex2D vertex) {
        if (x == vertex.getX()) {
            return (int) (y - vertex.getY());
        }
        return (int) (x - vertex.getX());
    }
}
