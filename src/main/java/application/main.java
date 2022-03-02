package application;


import structs.Image;

public class main {
    public static void main (String args[]) {
        String      fn;
        Image img;
        fn      = "src/main/images/airplane.png";
        img     = new Image(fn);
        System.out.println(img.toString());
    }
}
