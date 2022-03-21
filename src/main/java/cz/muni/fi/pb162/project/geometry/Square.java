package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Square implements Circular {
    private final Vertex2D center;
    private final double diameter;
    private final Vertex2D[] vertices = {null, null, null, null};

    /**
     * Constructor of square
     * @param center: center of square
     * @param diameter: diameter of square
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
        this.initializeVertices();
    }

    /**
     * Constructor of square
     * @param object: circular base object
     */
    public Square(Circular object) {
        this(object.getCenter(), object.getRadius() * 2.0);
    }

    /**
     * Getter for vertex
     * @param index: index of vertex
     * @return desired vertex
     */
    public Vertex2D getVertex(int index) {
        if (0 > index || index > 3) {
            return null;
        }
        return vertices[index];
    }

    /**
     * This private method initializes vertices
     */
    private void initializeVertices() {
        for(int i = 0; i < 4; i++) {
            vertices[i] = new Vertex2D(
                    center.getX() + (i - 1) * ((i + 1) % 2) * (diameter / 2),
                    center.getY() + (i - 2) * (i % 2) * (diameter / 2));
        }
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return diameter / 2.0;
    }

    @Override
    public String toString() {
        return String.format("Square: vertices=%s %s %s %s",
                vertices[0],
                vertices[1],
                vertices[2],
                vertices[3]);
    }
}
