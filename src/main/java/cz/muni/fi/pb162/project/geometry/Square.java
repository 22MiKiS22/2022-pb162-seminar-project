package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Square extends GeneralRegularPolygon implements Circular {
    /**
     * Constructor of square
     * @param center: center of square
     * @param diameter: diameter of square
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2.0);
    }

    /**
     * Constructor of square
     * @param object: circular base object
     */
    public Square(Circular object) {
        this(object.getCenter(), object.getRadius() * 2.0);
    }

    @Override
    public String toString() {
        return String.format("Square: vertices=%s %s %s %s",
                getVertex(0),
                getVertex(1),
                getVertex(2),
                getVertex(3)
                );
    }
}
