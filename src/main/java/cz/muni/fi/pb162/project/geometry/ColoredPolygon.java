package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class ColoredPolygon {
    private final Polygon polygon;
    private final Color color;

    /**
     * Constructor of ColoredPolygon
     * @param polygon polygon to color
     * @param color color of polygon
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }

    /**
     * Getter for polygon
     * @return polygon
     */
    public Polygon getPolygon() {
        return polygon;
    }

    /**
     *Getter for color
     * @return color
     */
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (polygon.equals(((ColoredPolygon) object).getPolygon())) {
            return true;
        }
        return ((ColoredPolygon) object).getColor() == color;
    }

    @Override
    public int hashCode() {
        int result = getPolygon() != null ? getPolygon().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        return result;
    }
}
