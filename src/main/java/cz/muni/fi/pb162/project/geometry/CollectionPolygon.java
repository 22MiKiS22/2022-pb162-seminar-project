package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michael Skor
 */
public class CollectionPolygon extends SimplePolygon {
    private final List<Vertex2D> vertices;

    /**
     * Constructor which converts list of Vertex2D vertices to List
     * @param vertices Vertex2D list
     */
    public CollectionPolygon(List<Vertex2D> vertices) {
        super(vertices.toArray(new Vertex2D[0]));
        this.vertices = new ArrayList<>(vertices);
    }

    /**
     * Constructor of CollectionPolygon
     * @param vertices Vertex2D list
     */
    public CollectionPolygon(Vertex2D[] vertices) {
        super(vertices);
        this.vertices = new ArrayList<>(Arrays.asList(vertices));
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index");
        }
        return vertices.get(index % vertices.size());
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        return this.vertices.equals(((CollectionPolygon) object).getVertices());
    }

    @Override
    public int hashCode() {
        return vertices != null ? vertices.hashCode() : 0;
    }

    /**
     * Getter for vertices
     * @return copy of vertices
     */
    public List<Vertex2D> getVertices() {
        return new ArrayList<>(vertices);
    }

    /**
     * Method removes the most left polygons
     * @return polygons without most left vertices
     */
    public CollectionPolygon withoutLeftmostVertices() {
        List<Vertex2D> newVertices = new ArrayList<>();

        for (Vertex2D vertex : vertices) {
            if (vertex.getX() != SimpleMath.minX(this)) {
                newVertices.add(vertex);
            }
        }
        if (newVertices.size() > 0) {
            return new CollectionPolygon(newVertices);
        }
        return null;
    }
}
