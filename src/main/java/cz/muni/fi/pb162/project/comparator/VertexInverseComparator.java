package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * @author Michael Skor
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    @Override
    public int compare(Vertex2D o1, Vertex2D o2) {
        if (o1.getX() == o2.getX()) {
            return Double.compare(o2.getY(), o1.getY());
        }
        return Double.compare(o2.getX(), o1.getX());
    }
}
