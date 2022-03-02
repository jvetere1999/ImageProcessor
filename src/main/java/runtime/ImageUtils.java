package runtime;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {

    public static byte[] toByteArray(BufferedImage img, String format) throws IOException {
        ByteArrayOutputStream imgArr = new ByteArrayOutputStream();
        ImageIO.write(img, format, imgArr);
        byte[] bytes = imgArr.toByteArray();
        return bytes;
    }
}
