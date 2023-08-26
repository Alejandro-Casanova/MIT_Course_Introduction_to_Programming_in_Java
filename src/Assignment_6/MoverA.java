package Assignment_6;

import java.awt.Graphics;

public class MoverA implements Mover {
	protected int x;
	protected int y;
	protected int xDirection;
	protected int yDirection;
	protected Sprite sprite;
    
	public MoverA(int startX, int startY, Sprite sprite) {
		x = startX;
        y = startY;
        this.sprite = sprite; 
	}

	@Override
	public void setMovementVector(int xIncrement, int yIncrement) {
		xDirection = xIncrement;
        yDirection = yIncrement;

	}

	@Override
	public void draw(Graphics surface) {
		sprite.draw(surface, x, y);
        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;
	}

}
