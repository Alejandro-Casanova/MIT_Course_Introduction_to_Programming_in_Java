package Assignment_6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval implements Sprite {
	private Color color;
	private int width;
    private int height;
	
	public Oval(int width, int height, Color color) {
		this.color = color;
		this.width = width;
        this.height = height;
	}

	@Override
	public void draw(Graphics surface, int x, int y) {
		// Draw the object
        surface.setColor(color);
        surface.fillOval(x, y, width, height);
        surface.setColor(Color.BLACK);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, width, height);

	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

}
