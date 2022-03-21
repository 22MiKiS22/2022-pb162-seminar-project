package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Snowman {
    public static final int SPHERES_COUNT = 4;
    private static final double REDUCTION_FACTOR = 0.8;
    private final Circular[] spheres = new Circular[SPHERES_COUNT];

    /**
     * Constructor of snowman
     * @param lowerSphere: lower sphere
     * @param reductionFactor: reduction factor
     */
    public Snowman(Circular lowerSphere, double reductionFactor) {
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
    public Circular[] getBalls() {
        return spheres.clone();
    }

    /**
     * This method creates spheres for snowman
     * @param reductionFactor: reduction factor of smaller spheres
     */
    private void makeSpheres(double reductionFactor) {
        for (int i = 1; i < SPHERES_COUNT; i++) {
            double tempRadius = spheres[i - 1].getRadius();
            spheres[i] = new Circle(
                    new Vertex2D(spheres[i - 1].getCenter().getX(),
                            spheres[i - 1].getCenter().getY() + tempRadius + tempRadius * reductionFactor),
                    tempRadius * reductionFactor);
        }
    }
}
