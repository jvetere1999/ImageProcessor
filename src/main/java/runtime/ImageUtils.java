package runtime;

import component.Component;
import component.ConnectedComponents;
import component.FillComponent;
import image.Image;

import java.util.ArrayList;

public class ImageUtils {
    public static ArrayList<Image> images = new ArrayList<>();
    public static void main (String[] args) {
       // GUI.main(args);
        testConnectedComponents();
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
    public static void testConnectedComponents() {
        String fn          = "src/main/images/airplane.png";
        Image img = new Image(fn);
        ConnectedComponents components = new ConnectedComponents(img);

        components.componentPrune(750, 15000);
        ArrayList<Component> images = new ArrayList<>();
        Component temp = components.asList().get(2);
        images.add(temp);
        String  fileName    = fn.substring(0, fn.indexOf("."));
        Image   img2        = new Image(fileName +"pruned.png", images, img.width, img.height);
//        ArrayList<Component> pruned = components.prunedAsList();
//        String  fileName    = fn.substring(0, fn.indexOf("."));
//        Image   img2        = new Image(fileName +"pruned.png",
//                images,
//                img.width,
//                img.height);
//        Image   img3        = new Image(fileName +"unpruned.png",
//                pruned,
//                img.width,
//                img.height);
        FillComponent fill = new FillComponent(temp);

        System.out.println(fill);



    }
    //img2        = new Image(fileNameNew, img.getColorStorage(), type);


//    public static void testMain (String[] args) {
//        String      fn,  fnNew;
//        String      fn1, fn1New;
//        String      fn2, fn2New;
//        Image       img, img2;
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
