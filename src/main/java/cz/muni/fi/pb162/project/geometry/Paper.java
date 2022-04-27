package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michael Skor
 */
public class Paper implements Drawable, PolygonFactory {
    private final Set<ColoredPolygon> polygons;
    private Color color = Color.BLACK;

    /**
     * Parameterless constructor of Paper
     */
    public Paper() {
        polygons = new LinkedHashSet<>();
    }

    /**
     * Constructor of Paper from object
     * @param object given object
     */
    public Paper(Drawable object) {
        polygons = new LinkedHashSet<>(object.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (color == Color.WHITE) {
            throw new TransparentColorException("color is white");
        }
        ColoredPolygon polygonToDraw = new ColoredPolygon(polygon, color);
        polygons.add(polygonToDraw);
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (polygons.isEmpty()) {
            throw new EmptyDrawableException("paper is empty");
        }
        polygons.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(polygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> uniqueVertices = new HashSet<>();
        polygons.stream().map(coloredPolygon -> getVertices(coloredPolygon.getPolygon()))
                        .forEach(uniqueVertices::addAll);
        return uniqueVertices.size();
    }

    private Set<Vertex2D> getVertices(Polygon polygon) {
        Set<Vertex2D> vertices = new HashSet<>();
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            vertices.add(polygon.getVertex(i));
        }
        return vertices;
    }

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException {
        if (vertices == null) {
            throw new NullPointerException("argument is null");
        }
        if (vertices.size() == 0){
            throw new MissingVerticesException("no vertices");
        }
        List<Vertex2D> tempVertices = new ArrayList<>(vertices);
        CollectionPolygon newCollection;
        try {
            newCollection = new CollectionPolygon(tempVertices);
        } catch (IllegalArgumentException e) {
            tempVertices.removeAll(Collections.singletonList(null));
            return tryToCreatePolygon(tempVertices);
        }
        return newCollection;
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        boolean paperEmpty = true;
        for (List<Vertex2D> vertices : collectionPolygons) {
            try {
                drawPolygon(tryToCreatePolygon(vertices));
                paperEmpty = false;
            } catch (TransparentColorException tce) {
                changeColor(Color.BLACK);
            } catch (MissingVerticesException | NullPointerException ignored) { }
        }
        if (paperEmpty) {
            throw new EmptyDrawableException("no polygon to draw", new MissingVerticesException("missing vertices"));
        }
    }

    /**
     * Method returns all polygons with color
     * @param color color
     * @return polygons
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        return polygons.stream().filter(polygon -> polygon.getColor() == color)
                .map(ColoredPolygon::getPolygon).collect(Collectors.toSet());
    }
}
