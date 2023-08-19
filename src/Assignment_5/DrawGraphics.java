package Assignment_5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class DrawGraphics {
    ArrayList<BouncingBox> boxes = new ArrayList<BouncingBox>();
    private Image image;
    
    //Initializes this class for drawing. 
    public DrawGraphics() {
        boxes.add(new BouncingBox(200, 50, Color.RED));
        boxes.add(new BouncingBox(200, 50, Color.RED));
        boxes.add(new BouncingBox(200, 50, Color.RED));
        
        boxes.get(0).setMovementVector(-2, 0);
        boxes.get(1).setMovementVector(0, 2);
        boxes.get(2).setMovementVector(2, 2);
        
        try {
            // Load the image from a file
        	image = ImageIO.read(getClass().getResource("bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
    	surface.drawImage(image, 0, 0, 300, 300, null);
        surface.drawLine(50, 50, 250, 250);
        surface.drawArc(50, 50, 200, 200, 90, 275);
        surface.drawArc(25, 25, 250, 250, 275, 275);
        surface.drawPolygon(new int[] {75, 125, 175, 225, 225, 175, 125, 75}, new int[] {125, 75, 75, 125, 175, 225, 225, 175}, 8);
        
        for(BouncingBox box: boxes)
        	box.draw(surface);
    }
} 