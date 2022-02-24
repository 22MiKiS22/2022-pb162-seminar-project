package cz.muni.fi.pb162.project;


import cz.muni.fi.pb162.project.geometry.Vertex2D;

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
    public static void main(String[] args) {

        Vertex2D vertex1 = new Vertex2D();
        Vertex2D vertex2 = new Vertex2D();

        vertex1.setX(2);
        vertex1.setY(3);

        vertex2.setX(1);
        vertex2.setY(1);

        vertex1.move(vertex2);
        System.out.println(vertex1.getInfo());
        System.out.println(vertex2.getInfo());
    }
}
