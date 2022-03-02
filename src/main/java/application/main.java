package application;


import structs.Image;

public class main {
    public static void main (String args[]) {
        String      fn, fn2;
        Image       img, img2;

        fn          = "src/main/images/airplane.png";
        fn2         = "src/main/images/airplane2.png";
        img         = new Image(fn);

        img2        = new Image(fn2, img.getColorStorage());
        img.output();
    }
}
