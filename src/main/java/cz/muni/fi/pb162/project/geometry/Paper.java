package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Michael Skor
 */
public class Paper implements Drawable {
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
    public void drawPolygon(Polygon polygon) {
        if (color != Color.WHITE) {
            ColoredPolygon polygonToDraw = new ColoredPolygon(polygon, color);
            polygons.add(polygonToDraw);
        }
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
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
}
