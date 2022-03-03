package structs;


import enums.ProcessType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;


public class Image {

    protected String                format;
    protected String                fileName;
    protected int                   height;
    protected int                   width;

    protected BufferedImage         img;
    protected ColorStorage[][]      imgArr;


    public Image(String _fileName) {
        fileName    = _fileName;
        format      = fileName.substring(fileName.lastIndexOf("."));
        inputImg();
        getPixels();
    }

    public Image(String _fileName, ColorStorage[][] _imgArr, ProcessType type) {
        fileName    = _fileName;
        width       = _imgArr.length;
        height      = _imgArr[0].length;
        img         = new BufferedImage(width, height, TYPE_INT_ARGB);
        imgArr      = _imgArr.clone();

        switch (type) {
            case DOMINATE_COLOR -> DOMINATE_COLOR();
            case COLOR_MIX_UP    -> COLOR_MIX_UP();
        }

        saveImg();
    }

    /**
     * Rebuils image with eveyr pixel set to the formers "Favorite" or dominant image
     */
    protected void DOMINATE_COLOR () {
        int rgb = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                switch ( imgArr[x][y].favoriteColor){
                    case RED    -> rgb = Color.RED.getRGB();
                    case BLUE   -> rgb = Color.BLUE.getRGB();
                    case GREEN  -> rgb = Color.GREEN.getRGB();
                }
                img.setRGB(x, y, rgb);
            }
        }
    }
    protected void COLOR_MIX_UP() {
        int rgb;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ColorStorage temp = imgArr[x][y];
                rgb = new Color(temp.green, temp.blue, temp.red).getRGB();
                img.setRGB(x, y, rgb);
            }
        }
    }

    /**
     * Gets array of color values
     *
     * @return imgArr[][]
     */
    public ColorStorage[][] getColorStorage() {
        return imgArr;
    }
    /**
     * Creates buffered read and sets value of img to the
     * ARGB byte array of the image given in File Name
     */
    protected void inputImg() {
        try {
            File input = new File(fileName);
            img = ImageIO.read(input);
            height = img.getHeight();
            width = img.getWidth();
        }
        catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves img to new file
     *
     * @throws IOException in case of failure to save image (?)
     */
    public void saveImg() {
        try {
            File outputFile = new File(fileName);
            ImageIO.write(img, "png", outputFile);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convertes buffered read to pixleArray
     *
     * @throws IOException
     */
    public void getPixels() {
        ColorStorage[][] colorArray = new ColorStorage[width ][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);
                colorArray[x] [y] = new ColorStorage(color);
            }
        }
        imgArr = colorArray;
    }

    /**
     * Takes byte array of image and turns it into an string
     * @return byte array represented as stringΩ
     */

    public void output() {
        for (int y = 0; y < height; y++) {
            System.out.print("| ");
            for (int x = 0; x < width; x++) {
                System.out.print(", " + imgArr[x] [y]);
            }
            System.out.println(" |");
        }
    }

}
