package component;

import image.ColorStorage;
import image.FavoriteColor;

import java.util.HashMap;

public class Component {
    public          ColorStorage                    rootColor;
    private final   int                             DISTANCE = 15;
    public          HashMap<int[], ColorStorage>    component; // int {x, y}

    public Component(int[] cord, ColorStorage point) {
        rootColor = point;
        component = new HashMap<>();
        component.put(cord, point);
    }
    public Component() {
        component = new HashMap<>();
    }

    public Component(ColorStorage _rootColor) {
        rootColor = _rootColor;
        component = new HashMap<>();
    }

    public void componentAdd(int[] cord, ColorStorage point) {
        component.put(cord, point);
        //updateAverage();
    }

    public void union (Component toAdd) {
        component.putAll(toAdd.component);
    }



//    private void updateAverage () {
//        double[] newAvg = new double[] {0, 0, 0};
//        for (ColorStorage com: component.values()) {
//            newAvg[0] += com.red;
//            newAvg[1] += com.green;
//            newAvg[2] += com.blue;
//        }
//        newAvg[0] = newAvg[0]/component.size();
//        newAvg[1] = newAvg[1]/component.size();
//        newAvg[2] = newAvg[2]/component.size();
//        averageColor = newAvg;
//    }

    public boolean contains(int[] check) {
        return component.containsKey(check);
    }
    public int size(){
        return component.size();
    }
    public boolean match(ColorStorage outside) {
        int outRed      = outside.red;
        int outGreen    = outside.green;
        int outBlue     = outside.blue;
        boolean dominant;
        boolean red     = isDominant(FavoriteColor.RED) ? (rootColor.red   - DISTANCE/2) < outRed
                && outRed   < (rootColor.red   + DISTANCE/2) : (rootColor.red   - DISTANCE) < outRed
                && outRed   < (rootColor.red   + DISTANCE);
        boolean green   = isDominant(FavoriteColor.GREEN) ? (rootColor.green   - DISTANCE/2) < outGreen
                && outGreen   < (rootColor.green   + DISTANCE/2) : (rootColor.green   - DISTANCE) < outGreen
                && outGreen   < (rootColor.green   + DISTANCE);
        boolean blue    = isDominant(FavoriteColor.BLUE)? (rootColor.blue  - DISTANCE/2) < outBlue  && outBlue  < (rootColor.blue  + DISTANCE/2) :
                (rootColor.blue  - DISTANCE) < outBlue  && outBlue  < (rootColor.blue  + DISTANCE);;

        return red && green && blue;
    }
    public boolean isDominant(FavoriteColor color) {
        return rootColor.favoriteColor == color;
    }
    public int getColor() {
        return rootColor.color.getRGB();
    }

}
