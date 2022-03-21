package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Michael Skor
 */
public class SimpleMath {
    /**
     * Returns the minimum X coordinate
     * @param triangle: triangle to inspect
     * @return minimum X coordinate
     */
    public static double minX(Triangle triangle) {
        double min = triangle.getVertex(0).getX();
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, triangle.getVertex(i).getX());
        }
        return min;
    }

    /**
     * Returns the minimum Y coordinate
     * @param triangle: triangle to inspect
     * @return minimum Y coordinate
     */
    public static double minY(Triangle triangle) {
        double min = triangle.getVertex(0).getY();
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, triangle.getVertex(i).getY());
        }
        return min;
    }

    /**
     * Returns the maximum X coordinate
     * @param triangle: triangle to inspect
     * @return maximum X coordinate
     */
    public static double maxX(Triangle triangle) {
        double max = triangle.getVertex(0).getX();
        for (int i = 1; i < 3; i++) {
            max = Math.max(max, triangle.getVertex(i).getX());
        }
        return max;
    }

    /**
     * Returns the maximum Y coordinate
     * @param triangle: triangle to inspect
     * @return maximum Y coordinate
     */
    public static double maxY(Triangle triangle) {
        double max = triangle.getVertex(0).getY();
        for (int i = 1; i < 3; i++) {
            max = Math.max(max, triangle.getVertex(i).getY());
        }
        return max;
    }
}
