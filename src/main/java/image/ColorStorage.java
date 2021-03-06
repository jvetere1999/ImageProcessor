package image;

import java.awt.*;

import static image.FavoriteColor.*;

public class ColorStorage {
    public int              red;
    public int              green;
    public int              blue;
    public FavoriteColor    favoriteColor;
    public Color            color;

    public ColorStorage(Color _color) {
        color   = _color;
        red     = _color.getRed();
        green   = _color.getGreen();
        blue    = _color.getBlue();

        if (red > blue && red > green)
            favoriteColor = RED;
        else if (green > red && green > blue)
            favoriteColor = GREEN;
        else
            favoriteColor = BLUE;

    }

    @Override
    public boolean equals(Object o) {
        ColorStorage other = null;
        if (o instanceof ColorStorage) {
            other = (ColorStorage) o;
        }

        return red == other.red && green == other.green && blue == other.blue;
    }
    @Override
    public String toString() {
        return red + " " + green + " " + blue;
    }

}
