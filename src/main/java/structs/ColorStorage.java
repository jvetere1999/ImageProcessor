package structs;

import enums.FavoriteColor;

import java.awt.*;

import static enums.FavoriteColor.*;

public class ColorStorage {
    public int              red;
    public int              green;
    public int              blue;
    public FavoriteColor favoriteColor;
    public Color            color;

    public ColorStorage(Color _color) {
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
    public String toString() {
        return red + " " + green + " " + blue;
    }

}
