package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.File;
import java.io.IOException;

/**
 * Class for running main method.
 *
 * @author Michael Skor
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) throws IOException {
        LabeledPolygon.Builder builder = new LabeledPolygon.Builder();
        builder.read(new File("polygon-ok.txt"));
        builder.addVertex("vrchol x", new Vertex2D(123, 456));
        LabeledPolygon polygon = builder.build();
        polygon.writeJson(System.out);
        System.out.printf("Hello World!%s", System.lineSeparator());
    }
}
