package cz.muni.fi.pb162.project.geometry;

import static cz.muni.fi.pb162.project.geometry.Color.BLACK;

/**
 * @author Michael Skor
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private final Vertex2D center;
    private final int edgesCount;
    private final double radius;
    private Color color;

    /**
     * Constructor of GeneralRegularPolygon
     * @param center: center of polygon
     * @param edgesCount: edges count of polygon
     * @param radius: radius of polygon
     */
    public GeneralRegularPolygon(Vertex2D center, int edgesCount, double radius) {
        this.center = center;
        this.edgesCount = edgesCount;
        this.radius = radius;
        this.color = BLACK;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getNumEdges() {
        return edgesCount;
    }

    @Override
    public double getEdgeLength() {
        return 2.0 * radius * Math.sin(Math.PI / edgesCount);
    }

    @Override
    public Vertex2D getVertex(int index) {
        return new Vertex2D(center.getX() - radius * Math.cos(index * 2.0 * Math.PI / edgesCount),
                center.getY() - radius * Math.sin(index * 2.0 * Math.PI / edgesCount));
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getWidth() {
        return radius * 2.0;
    }

    @Override
    public double getHeight() {
        return radius * 2.0;
    }

    @Override
    public String toString() {
        return String.format("%s-gon: center=%s, radius=%s, color=%s",
                edgesCount, center, radius, color);
    }
}
