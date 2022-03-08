package component;

import image.ColorStorage;
import image.Image;

import java.awt.*;
import java.util.ArrayList;


public class FillComponent {
    Component       com1, com2;
    int             xMin, xMax;
    int             yMin, yMax;
    int[][]         display;

    public FillComponent(Component _com1) {
        com1 = _com1;
        com2 = new Component(new ColorStorage(Color.BLUE));
        xMax = 0;
        yMax = 0;
        xMin = 10000;
        yMin = 10000;
        for (int[] cord: com1.component.keySet()) {
            xMax = xMax < cord[0] ? cord[0] : xMax;
            yMax = yMax < cord[1] ? cord[1] : yMax;
            xMin = xMin > cord[0] ? cord[0] : xMin;
            yMin = yMin > cord[1] ? cord[1] : yMin;
        }
        int normalizedXMax = xMax - xMin;
        int normalizedYMax = yMax - yMin;
        display = new int[normalizedXMax+1][ normalizedYMax+1];
        for (int[] cord: com1.component.keySet()) {
            display [cord[0]-xMin][cord[1] -yMin] = 1;if ( !isAdjacent(cord[0]-xMin, cord[1] -yMin))
                com2.componentAdd(new int[] { cord[0]-xMin, cord[1] -yMin }, new ColorStorage(Color.BLUE));


        }


        ArrayList<Component> c = new ArrayList<>();
        c.add(com2);

        Image img = new Image("src/main/images/component.png",c , normalizedXMax+1, normalizedYMax+1);
    }
    public boolean isAdjacent(int x, int y){
        int adjacency = 0;
        if (display[x][y] == 1){
            if (x-1 >= 0 && display[x-1][y] == 1 )
                adjacency++;
            if (x+1 < display.length && display[x+1][y] == 1)
                adjacency++;
            if (y-1 >= 0 && display[x][y-1] == 1)
                adjacency++;
            if (y+1 < display[0].length && display[x][y+1] == 1)
                adjacency++;
        }
        if (adjacency >= 2  )
            System.out.println(adjacency);
        if (adjacency == 2 || adjacency == 3)
            return true;
        return false;
    }


    @Override
    public String toString(){
        return "MAX X: " + xMax + " MAX Y: " + yMax +"\n" +
                "MIN X: "+ xMin + " MIN Y: " + yMin;
    }
}
