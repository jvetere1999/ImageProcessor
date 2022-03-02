package structs;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class Image {

    protected String            fileName;
    protected int               height;
    protected int               width;
    protected BufferedImage     img;
    protected byte[]            imgArr;
    protected String            format;

    public Image(String _fileName) {
        fileName = _fileName;
        format = fileName.substring(fileName.lastIndexOf("."));
        inputImg();
        System.out.println("here");
        toByteArray();
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
     * @param _fileName - Name of new image file
     * @throws IOException
     */
    public void saveImg(String _fileName) throws IOException {
        File outputFile = new File(_fileName);
        ImageIO.write(img, "png", outputFile);
    }

    /**
     * Convertes buffered read to byte array using format found in main
     *
     * @throws IOException
     */
    public void toByteArray() {
        try {
            ByteArrayOutputStream tempImgArr = new ByteArrayOutputStream();
            ImageIO.write(img, format, tempImgArr);
            imgArr = tempImgArr.toByteArray();
        }
        catch (IOException e){
            System.out.println("here");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Takes byte array of image and turns it into an string
     * @return byte array represented as stringΩ
     */
    @Override
    public String toString() {
        String rtr = Base64.encodeBase64String(imgArr);
        return rtr;
    }

}
