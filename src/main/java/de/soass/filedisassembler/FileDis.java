package de.soass.filedisassembler;



import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class FileDis {
    public File video;
    public List<BufferedImage> frames;

    public FileDis(File video) {
        this.video = video;
    }

    public void disassemble() throws FrameGrabber.Exception {

        Java2DFrameConverter converter = new Java2DFrameConverter();
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(video);
        frameGrabber.start();
        Frame frame;
        double frameRate=frameGrabber.getFrameRate();
        int imgNum=0;
        System.out.println("Video has "+frameGrabber.getLengthInFrames()+" frames and has frame rate of "+frameRate);
        try {
            for(int ii=1;ii<=frameGrabber.getLengthInFrames();ii++){
                imgNum++;
                frameGrabber.setFrameNumber(ii);
                frame = frameGrabber.grab();
                BufferedImage bi = converter.convert(frame);
                frames.add(bi);
                ii+=1;
            }
            frameGrabber.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
