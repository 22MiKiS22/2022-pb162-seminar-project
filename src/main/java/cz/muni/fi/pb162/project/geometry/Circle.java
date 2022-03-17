package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Circle {
    private final double radius;
    private final Vertex2D center;

    /**
     * Parameterless constructor
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    /**
     * Constructor
     * @param center: center of circle
     * @param radius: radius of circle
     */
    public Circle(Vertex2D center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return String.format("Circle: center=%s, radius=%s",
                center.toString(),
                radius);
    }
}
