package Assignment_6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class DrawGraphics {
	
	ArrayList<Mover> sprites = new ArrayList<Mover>();
	private Image image;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Oval oval = new Oval(15, 20, Color.RED);
        
        sprites.add(new Bouncer(100, 170, box));
        sprites.add(new Bouncer(90, 60, oval));
        sprites.add(new StraightMover(10, 60, box));
        sprites.add(new StraightMover(120, 10, oval));
        
        sprites.get(0).setMovementVector(3, 1);
        sprites.get(1).setMovementVector(2, -1);
        sprites.get(2).setMovementVector(2, 0);
        sprites.get(3).setMovementVector(-2, 0);
        
        try {
            // Load the image from a file
        	image = ImageIO.read(getClass().getResource("bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
    	
    	surface.drawImage(image, 0, 0, 300, 300, null);
        surface.drawLine(50, 50, 250, 250);
        surface.drawArc(50, 50, 200, 200, 90, 275);
        surface.drawArc(25, 25, 250, 250, 275, 275);
        surface.drawPolygon(new int[] {75, 125, 175, 225, 225, 175, 125, 75}, new int[] {125, 75, 75, 125, 175, 225, 225, 175}, 8);
        
        for(Mover sprite: sprites)
        	sprite.draw(surface);
    }
}
