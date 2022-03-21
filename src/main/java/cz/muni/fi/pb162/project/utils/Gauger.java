package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Michael Skor
 */
public class Gauger {
    /**
     * This method prints measurement of Measurable object
     * @param object: measurable object
     */
    public static void printMeasurement(Measurable object) {
        System.out.printf("Width: %s%n", object.getWidth());
        System.out.printf("Height: %s%n", object.getHeight());
    }

    /**
     * This method prints measurement of Triangle object
     * @param triangle: triangle
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle);
        printMeasurement((Measurable) triangle);
    }
}
