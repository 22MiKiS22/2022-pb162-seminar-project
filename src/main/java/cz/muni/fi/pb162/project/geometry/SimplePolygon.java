package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * @author Michael Skor
 */
public abstract class SimplePolygon implements Polygon {
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public abstract int getNumVertices();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < this.getNumVertices(); i++) {
            stringBuilder.append(" ").append(this.getVertex(i));
        }
        return stringBuilder.toString();
    }
}
