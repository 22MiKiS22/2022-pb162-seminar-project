package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public class Triangle {
    private final Vertex2D[] vertices;
    private final Triangle[] triangles = {null, null, null};

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
     * Method returns desired vertex
     * @param index: index of desired vertex
     * @return Vertex2D: desired vertex
     */
    public Vertex2D getVertex(int index) {
        if (myRange(index)) {
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
        if (myRange(index)) {
            vertices[index] = vertex;
        }
    }

    private boolean myRange(int index) {
        return index >= 0 && index <= 2;
    }

    @Override
    public String toString() {
        return String.format("Triangle: vertices=%s %s %s", vertices[0].toString(),
                vertices[1].toString(),
                vertices[2].toString());
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
        if (myRange(index)) {
            return triangles[index];
        }
        return null;
    }
}
