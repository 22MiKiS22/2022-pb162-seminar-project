package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Vertex2D {
    private double x = 0;
    private double y = 0;

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

    /**
     * Method prints info about vertex
     * @return String: vertex coordinates
     */
    public String getInfo() {
        return "[" + x + ", " + y + "]";
    }

    /**
     * Method sums coordinates
     * @return double: Sum of coordinates
     */
    public double sumCoordinates() {
        return x + y;
    }

    /**
     * Method moves one vertex by given vertex
     * @param vertex: moving vertex
     */
    public void move(Vertex2D vertex) {
        x += vertex.x;
        y += vertex.y;
    }
}
