package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {
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
        super(center, Integer.MAX_VALUE, radius);
        setColor(Color.RED);
    }

    @Override
    public String toString() {
        return String.format("Circle: center=%s, radius=%s",
                super.getCenter(),
                super.getRadius());
    }

    @Override
    public double getEdgeLength() {
        return 0;
    }
}
