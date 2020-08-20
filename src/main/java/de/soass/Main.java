package de.soass;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.Java2DFrameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("C:/Users/Rares/Desktop/tst.mp4");
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(f);
        try {
            frameGrabber.setFrameNumber(1);
          BufferedImage bf =   Java2DFrameUtils.toBufferedImage(frameGrabber.grabImage());
          ImageIO.write(bf, "jpeg", new File("./abc.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /*public static void main(String[] args) throws FileNotFoundException {
	if(args.length == 1){
	    String videoPath = args[0];
	    File f = new File(videoPath);
	    if (f.exists()){

        }else {
	        throw new FileNotFoundException("The video file cant be found");
        }
    }else {
	    System.out.println("Syntax: java -jar [JAR-NAME] [VIDEO-PATH]");
    }

    }*/
}
