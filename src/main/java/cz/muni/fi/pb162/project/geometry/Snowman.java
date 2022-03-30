package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Snowman {
    public static final int SPHERES_COUNT = 3;
    private static final double REDUCTION_FACTOR = 0.8;
    private final RegularPolygon[] spheres = new RegularPolygon[SPHERES_COUNT];

    /**
     * Constructor of snowman
     * @param lowerSphere: lower sphere
     * @param reductionFactor: reduction factor
     */
    public Snowman(RegularPolygon lowerSphere, double reductionFactor) {
        spheres[0] = lowerSphere;
        if (0 < reductionFactor && reductionFactor <= 1) {
            this.makeSpheres(reductionFactor);
        } else {
            this.makeSpheres(REDUCTION_FACTOR);
        }
    }

    /**
     * Returns copy of snowman's spheres
     * @return array of spheres
     */
    public RegularPolygon[] getBalls() {
        return spheres.clone();
    }

    /**
     * This method creates spheres for snowman
     * @param reductionFactor: reduction factor of smaller spheres
     */
    private void makeSpheres(double reductionFactor) {
        int numEdges = spheres[0].getNumEdges();
        for (int i = 1; i < SPHERES_COUNT; i++) {
            double tempRadius = spheres[i - 1].getRadius();
            spheres[i] = new GeneralRegularPolygon(
                    new Vertex2D(spheres[i - 1].getCenter().getX(),
                            spheres[i - 1].getCenter().getY() + tempRadius + tempRadius * reductionFactor),
                    numEdges,
                    tempRadius * reductionFactor) {
            };
        }
    }
}
