package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Triangle extends ArrayPolygon implements Measurable {
    private final Triangle[] triangles = {null, null, null};
    private static final double DEVIATION = 0.001;

    /**
     * Constructor of Triangle
     * @param a: first vertex
     * @param b: second vertex
     * @param c: third vertex
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(new Vertex2D[] {a, b ,c});
    }

    /**
     * Constructor of Triangle with depth
     * @param a: first vertex
     * @param b: second vertex
     * @param c: third vertex
     * @param depth: division depth
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth) {
        this(a, b, c);
        divide(depth);
    }

    /**
     * This method controls if number is in range [0..2]
     * @param index: controlled number
     * @return true or false
     */
    private boolean inRange(int index) {
        return index >= 0 && index <= 2;
    }

    @Override
    public String toString() {
        return String.format("Triangle: vertices=%s %s %s",
                getVertex(0),
                getVertex(1),
                getVertex(2));
    }

    /**
     * Method divides triangles to smaller triangles
     * @return if the operation is done successfully
     */
    public boolean divide() {
        if (isDivided()) {
            return false;
        }
        Vertex2D middleA = getVertex(0).createMiddle(getVertex(1));
        Vertex2D middleB = getVertex(0).createMiddle(getVertex(2));
        Vertex2D middleC = getVertex(2).createMiddle(getVertex(1));
        triangles[0] = new Triangle(getVertex(0), middleA, middleB);
        triangles[1] = new Triangle(getVertex(1), middleA, middleC);
        triangles[2] = new Triangle(getVertex(2), middleC, middleB);

        return true;
    }

    /**
     * Method divides triangles to smaller triangles until depth > 0
     */
    public void divide(int depth) {
        if (depth > 0) {
            divide();
            for (int i = 0; i < 3; i++) {
                triangles[i].divide(depth - 1);
            }
        }
    }

    /**
     * This method checks if the triangle is already divided
     * @return true: divided, or false
     */
    public boolean isDivided() {
        return getSubTriangle(0) != null && getSubTriangle(1) != null && getSubTriangle(2) != null;
    }

    /**
     * This method returns desired sub-triangle
     * @param index: index of desired sub-triangle
     * @return pointer to desired sub-triangle or null when error occurs
     */
    public Triangle getSubTriangle(int index) {
        if (inRange(index)) {
            return triangles[index];
        }
        return null;
    }

    /**
     * This method controls if the triangle is equilateral
     * @return true if triangle is equilateral, else false
     */
    public boolean isEquilateral() {
        double sideA = getVertex(0).distance(getVertex(1));
        double sideB = getVertex(0).distance(getVertex(2));
        double sideC = getVertex(2).distance(getVertex(1));
        return  Math.abs(sideA - sideB) <= DEVIATION &&
                Math.abs(sideA - sideC) <= DEVIATION &&
                Math.abs(sideB - sideC) <= DEVIATION;
    }
}
