package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michael Skor
 */
public enum Color {
    WHITE,
    RED,
    GREEN,
    YELLOW,
    BLACK,
    ORANGE,
    BLUE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
