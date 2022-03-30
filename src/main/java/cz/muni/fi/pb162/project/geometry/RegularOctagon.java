package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class RegularOctagon extends GeneralRegularPolygon {
    /**
     * Constructor of RegularOctagon
     * @param center: center of octagon
     * @param radius: radius of octagon
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
