package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 * @author Michael Skor
 */
public class ArrayPolygon extends SimplePolygon {
    private final Vertex2D[] vertices;

    /**
     * Constructor of ArrayPolygon
     * @param vertices: array of vertices
     */
    public ArrayPolygon(Vertex2D[] vertices) {
        if (vertices == null || vertices.length < 3) {
            throw new IllegalArgumentException("vertices is null or have less than 3 vertices");
        }
        for (Vertex2D vertex : vertices) {
            if (vertex == null) {
                throw new IllegalArgumentException("vertices contain null");
            }
        }
        this.vertices = Arrays.copyOf(vertices, vertices.length);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index");
        }
        return vertices[index % vertices.length];
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass() ||
                vertices.length != ((ArrayPolygon) object).vertices.length) {
            return false;
        }
        for (int i = 0; i < vertices.length; i++) {
            if (!vertices[i].equals(((ArrayPolygon) object).vertices[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertices);
    }

    @Override
    public int getNumVertices() {
        return vertices.length;
    }
}
