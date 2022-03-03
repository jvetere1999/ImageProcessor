package runtime;

import application.GUI;
import structs.Image;
import structs.Processor;

import java.io.IOException;
import java.util.ArrayList;

import static enums.ProcessType.COLOR_MIX_UP;

public class ImageUtils {
    public static ArrayList<Image> images = new ArrayList<>();
    public static void main (String[] args) {
        GUI.main(args);
    }

    public static void createImage(String fn) {
       try {
           Image img;
           img = new Image(fn);
           images.add(img);
       } catch (Exception e) {
           System.out.println("File not found");
       }
    }
    public static void createImages(ArrayList<String> files) {
        try {
            for (String fn: files) {
                Image img;
                img = new Image(fn);
                images.add(img);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    public static void testMain (String[] args) {
//        String      fn,  fnNew;
//        String      fn1, fn1New;
//        String      fn2, fn2New;
//        Image img, img2;
//
//        fn          = "src/main/images/airplane.png";
//        fnNew       = "src/main/images/airplane2.png";
//        fn1         = "src/main/images/calibration.jpeg";
//        fn1New      = "src/main/images/calibration2.jpeg";
//        fn2          = "src/main/images/graphImage.png";
//        fn2New       = "src/main/images/graphImage2.png";
//
//        Processor process1 = new Processor(fn, fnNew, COLOR_MIX_UP);
//        Thread thread = new Thread(process1);
//        Processor process2 = new Processor(fn1, fn1New, COLOR_MIX_UP);
//        Thread thread2 = new Thread(process2);
//        Processor process3 = new Processor(fn2, fn2New, COLOR_MIX_UP);
//        Thread thread3 = new Thread(process3);
//        thread.start();
//        thread2.start();
//        thread3.start();
//    }
}
