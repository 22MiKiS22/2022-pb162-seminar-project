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
        super(vertices);
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
