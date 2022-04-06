package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * @author Michael Skor
 */
public class SimpleMath {
    /**
     * Returns the minimum X coordinate
     * @param polygon: polygon to inspect
     * @return minimum X coordinate
     */
    public static double minX(Polygon polygon) {
        double min = polygon.getVertex(0).getX();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            min = Math.min(min, polygon.getVertex(i).getX());
        }
        return min;
    }

    /**
     * Returns the minimum Y coordinate
     * @param polygon: polygon to inspect
     * @return minimum Y coordinate
     */
    public static double minY(Polygon polygon) {
        double min = polygon.getVertex(0).getY();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            min = Math.min(min, polygon.getVertex(i).getY());
        }
        return min;
    }

    /**
     * Returns the maximum X coordinate
     * @param polygon: polygon to inspect
     * @return maximum X coordinate
     */
    public static double maxX(Polygon polygon) {
        double max = polygon.getVertex(0).getX();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            max = Math.max(max, polygon.getVertex(i).getX());
        }
        return max;
    }

    /**
     * Returns the maximum Y coordinate
     * @param polygon: polygon to inspect
     * @return maximum Y coordinate
     */
    public static double maxY(Polygon polygon) {
        double max = polygon.getVertex(0).getY();
        for (int i = 1; i < polygon.getNumVertices(); i++) {
            max = Math.max(max, polygon.getVertex(i).getY());
        }
        return max;
    }
}
