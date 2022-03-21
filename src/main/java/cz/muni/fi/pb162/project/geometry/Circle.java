package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Circle implements Measurable, Circular {
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

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return String.format("Circle: center=%s, radius=%s",
                center,
                radius);
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }
}
