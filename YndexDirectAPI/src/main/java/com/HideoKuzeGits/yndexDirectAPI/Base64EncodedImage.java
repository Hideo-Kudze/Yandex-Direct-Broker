package com.HideoKuzeGits.yndexDirectAPI;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by root on 09.07.14.
 */
public class Base64EncodedImage {

    private String type;
    private BufferedImage bufferedImage;
    private String name;

    public Base64EncodedImage(String name, BufferedImage bufferedImage, String type) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        if (Math.max(width,height)!=150)
            throw new IncorrectImageExeption("The shorter side of image is not equal to 150 pixel.");

        if (Math.min(width,height)<150)
            throw new IncorrectImageExeption("The longest side of image is shorter than 150 pix.");

        if (Math.min(width,height)>200)
            throw new IncorrectImageExeption("The longest side of image is longer then 200 pixels.");

        this.bufferedImage = bufferedImage;
        this.type = type;
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getBase64EncodedString(){
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(bufferedImage, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (imageString.length()>200000)
            throw new IncorrectImageExeption("Length of base64 encoded string longer than 20 000 characters.");
        return imageString;
    }
}
