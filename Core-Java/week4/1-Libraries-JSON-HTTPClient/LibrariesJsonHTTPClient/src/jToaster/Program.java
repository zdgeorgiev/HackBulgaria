package jToaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.nitido.utils.toaster.Toaster;

public class Program {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Wait 45 minutes
        // Thread.sleep(2700000);

        // Wait 5 seconds
        Thread.sleep(5000);

        Toaster toaster = new Toaster();

        Image image = new ImageIcon("background.jpg").getImage();
        toaster.setBackgroundImage(image);

        BufferedImage bimg = ImageIO.read(new File("background.jpg"));
        toaster.setToasterHeight(bimg.getHeight());
        toaster.setToasterWidth(bimg.getWidth());
        toaster.setDisplayTime(5000);
        toaster.setToasterMessageFont(new Font("Consolas", Font.BOLD, 70));
        toaster.setBorderColor(new Color(1, 1, 1, 100));
        toaster.setMargin(200);
        toaster.setMessageColor(new Color(255, 0, 0, 250));

        toaster.showToaster("Pleace get a little break you're already addicted.");
    }
}