package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.comparator.VertexInverseComparator;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michael Skor
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable {
    private final Map<String, Vertex2D> vertices;

    /**
     * Constructor of LabeledPolygon
     * @param vertices vertices
     */
    public LabeledPolygon(List<Vertex2D> vertices) {
        super(vertices.toArray(new Vertex2D[0]));
        this.vertices = new LinkedHashMap<>();
        String currentLetter = "A";
        for (Vertex2D vertex : vertices) {
            this.vertices.put(currentLetter, vertex);
            currentLetter = getNextLetter(currentLetter);
        }
    }

    private LabeledPolygon(Map<String, Vertex2D> vertices) {
        super(vertices.keySet().stream().map(vertices::get).toArray(Vertex2D[]::new));
        this.vertices = vertices;
    }

    private String getNextLetter(String current) {
        if (current.charAt(current.length() - 1) == 'Z' &&
                current.charAt(current.length() - 1) == current.charAt(current.length() - 2)) {
            current += 'A';
        } else {
            char lastChar = current.charAt(current.length() - 1);
            current = current.substring(current.length() - 1).replace(lastChar, ++lastChar);
        }
        return current;
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index");
        }
        Iterator<Map.Entry<String, Vertex2D>> iterator = vertices.entrySet().iterator();
        Vertex2D returnVertex = null;
        for (int i = 0; i < index % vertices.size() + 1; i++) {
            returnVertex = iterator.next().getValue();
        }
        return returnVertex;
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    @Override
    public Vertex2D getVertex(String label) {
        if (!vertices.containsKey(label)) {
            throw new NullPointerException("vertex doesn't exist");
        }
        return vertices.get(label);
    }

    @Override
    public Collection<String> getLabels() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        return vertices.keySet().stream()
                .filter(key -> vertices.get(key).equals(vertex))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        Comparator<Vertex2D> c = new VertexInverseComparator();
        Set<Vertex2D> sortedVertices = new HashSet<>(this.vertices.values());
        return sortedVertices.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        Set<Vertex2D> sortedVertices = new LinkedHashSet<>(this.vertices.values());
        return sortedVertices.stream().sorted(comparator).collect(Collectors.toList());
    }

    /**
     * This method return duplicate vertices
     * @return vertices
     */
    public Collection<Vertex2D> duplicateVertices() {
        return vertices.values().stream()
                .filter(vertex -> Collections.frequency(vertices.values(), vertex) > 1)
                .collect(Collectors.toSet());
    }

    /**
     * @author Michael Skor
     */
    public static class Builder implements Buildable<LabeledPolygon> {
        private final Map<String, Vertex2D> vertices;

        /**
         * Builder constructor
         */
        public Builder() {
            vertices = new LinkedHashMap<>();
        }

        /**
         * Method adds vertex
         * @param label label of vertex
         * @param vert vertex
         * @return builder
         */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null || vert == null) {
                throw new IllegalArgumentException("null vertex or label");
            }
            vertices.put(label, vert);
            return this;
        }

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(vertices);
        }
    }
}
