package cz.muni.fi.pb162.project.geometry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Michael Skor
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable, PolygonWritable {
    private final Map<String, Vertex2D> vertices;

    private LabeledPolygon(Map<String, Vertex2D> vertices) {
        super(vertices.keySet().stream().map(vertices::get).toArray(Vertex2D[]::new));
        this.vertices = vertices;
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("negative index");
        }
        return vertices.get((String) vertices.keySet().toArray()[index % vertices.size()]);
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
        return Collections.unmodifiableSet(vertices.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        return vertices.keySet().stream()
                .filter(key -> vertices.get(key).equals(vertex))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<>(this.vertices.values());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        Set<Vertex2D> v = new TreeSet<>(comparator);
        v.addAll(vertices.values());
        return v;
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

    @Override
    public void write(OutputStream os) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writeVertices(writer);
        } catch (Exception e) {
            throw new IOException("write error");
        }
    }

    @Override
    public void write(File file) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writeVertices(writer);
        } catch (Exception e) {
            throw new IOException("write error");
        }
    }

    private void writeVertices(BufferedWriter writer) throws IOException {
        for (String label : vertices.keySet()) {
            writer.write(String.valueOf(vertices.get(label).getX()));
            writer.write(String.valueOf(vertices.get(label).getY()));
            writer.write(String.format("%f %f %s%s",
                    vertices.get(label).getX(),
                    vertices.get(label).getY(),
                    label,
                    System.lineSeparator()));
        }
    }

    /**
     * Method creates and writes json to given output stream
     * @param os os
     */
    public void writeJson(OutputStream os) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
        writer.write(gson.toJson(vertices));
        writer.flush();
    }

    /**
     * @author Michael Skor
     */
    public static class Builder implements Buildable<LabeledPolygon>, PolygonReadable {
        private final Map<String, Vertex2D> vertices;

        /**
         * Builder constructor
         */
        public Builder() {
            vertices = new TreeMap<>();
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

        @Override
        public Builder read(InputStream is) throws IOException {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                readVertices(reader);
            } catch (Exception e) {
                throw new IOException("bad input format");
            }
            return this;
        }

        @Override
        public Builder read(File file) throws IOException {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                readVertices(reader);
            } catch (Exception e) {
                throw new IOException("bad input format");
            }
            return this;
        }

        private void readVertices(BufferedReader reader) throws IOException {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(" ", 3);
                vertices.put(items[2], new Vertex2D(Double.parseDouble(items[0]),
                        Double.parseDouble(items[1])));
            }
        }
    }
}
