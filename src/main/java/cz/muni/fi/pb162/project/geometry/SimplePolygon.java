package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * @author Michael Skor
 */
public abstract class SimplePolygon implements Polygon {
    /**
     * Constructor of SimplePolygon
     * @param vertices vertices
     */
    public SimplePolygon(Vertex2D[] vertices) {
        if (vertices == null || vertices.length == 0) {
            throw new IllegalArgumentException("vertices is null or is empty");
        }
        for (Vertex2D vertex : vertices) {
            if (vertex == null) {
                throw new IllegalArgumentException("vertices contain null");
            }
        }
    }

    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public abstract int getNumVertices();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < this.getNumVertices(); i++) {
            stringBuilder.append(" ").append(this.getVertex(i));
        }
        return stringBuilder.toString();
    }
}
