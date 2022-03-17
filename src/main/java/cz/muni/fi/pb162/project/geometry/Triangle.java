package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Triangle {
    private final Vertex2D[] vertices;
    private final Triangle[] triangles = {null, null, null};
    private static final double DEVIATION = 0.001;

    /**
     * Constructor of Triangle
     * @param a: first vertex
     * @param b: second vertex
     * @param c: third vertex
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        this.vertices = new Vertex2D[]{a, b, c};
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
     * Method returns desired vertex
     * @param index: index of desired vertex
     * @return Vertex2D: desired vertex
     */
    public Vertex2D getVertex(int index) {
        if (inRange(index)) {
            return vertices[index];
        }
        return null;
    }

    /**
     * Method replaces vertex with desired index with given vertex
     * @param index: index of vertex to replace
     * @param vertex: new vertex
     */
    public void setVertex(int index, Vertex2D vertex) {
        if (inRange(index)) {
            vertices[index] = vertex;
        }
    }

    private boolean inRange(int index) {
        return index >= 0 && index <= 2;
    }

    @Override
    public String toString() {
        return String.format("Triangle: vertices=%s %s %s",
                vertices[0],
                vertices[1],
                vertices[2]);
    }

    /**
     * Method divides triangles to smaller triangles
     * @return if the operation is done successfully
     */
    public boolean divide() {
        if (isDivided()) {
            return false;
        }
        Vertex2D middleA = vertices[0].createMiddle(vertices[1]);
        Vertex2D middleB = vertices[0].createMiddle(vertices[2]);
        Vertex2D middleC = vertices[2].createMiddle(vertices[1]);
        triangles[0] = new Triangle(vertices[0], middleA, middleB);
        triangles[1] = new Triangle(vertices[1], middleA, middleC);
        triangles[2] = new Triangle(vertices[2], middleC, middleB);

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
        double sideA = vertices[0].distance(vertices[1]);
        double sideB = vertices[0].distance(vertices[2]);
        double sideC = vertices[2].distance(vertices[1]);
        return  Math.abs(sideA - sideB) <= DEVIATION &&
                Math.abs(sideA - sideC) <= DEVIATION &&
                Math.abs(sideB - sideC) <= DEVIATION;
    }
}
