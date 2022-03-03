package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Vertex2D {
    private double x;
    private double y;

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

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * This method calculate middle vertex of given two vertices
     * @param vertex: given vertex
     * @return new vertex representing middle vertex
     */
    public Vertex2D createMiddle(Vertex2D vertex) {
        return new Vertex2D((this.x + vertex.x)/2.0, (this.y + vertex.y)/2.0);
    }
}
