package infpp.oceanlife.Model;

import infpp.oceanlife.View.OceanGraphic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * the class for a stone
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
@SuppressWarnings("serial")
public class Stone extends OceanObject {

	/**
	 * static counter for instances of stones
	 */
	private static int counter = 0;

	/**
	 * Create a Stone with position
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 */
	public Stone(int x, int y) {
		Stone.counter++;
		name = "Stone " + Stone.counter;
		position[0] = x;
		position[1] = y;
		direction = 0;
	}

	/**
	 * Overriding the default toString method
	 * 
	 * @return String containing name and position
	 */
	@Override
	public String toString() {
		return this.getName() + ": " + super.toString();
	}

	/**
	 * get the pixel height of a stone
	 * 
	 * @return pixel height of a stone
	 */
	@Override
	public int getHeight() {
		return OceanGraphic.getStoneImage().getHeight();
	}

	/**
	 * get the pixel width of a stone
	 * 
	 * @return pixel width of a stone
	 */
	@Override
	public int getWidth() {
		return OceanGraphic.getStoneImage().getWidth();
	}

	/**
	 * draw the stone to a graphic object
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(OceanGraphic.getStoneImage(), getPosition()[0], getPosition()[1], null);
		if (border == true) {
			g.setColor(Color.red);
			g.drawRect(getPosition()[0], getPosition()[1], getWidth(), getHeight());
		}
	}

	/**
	 * Do nothing on calculation method, because the stone don't move
	 * 
	 * @param PixelPerSecond
	 *            pixel per second
	 * @param maxFPS
	 *            fps
	 * @param oceanWidth
	 *            width of the ocean
	 * @param oceanDepth
	 *            depth of the ocean
	 */
	@Override
	public void calc(int PixelPerSecond, long maxFPS, int oceanWidth, int oceanDepth) {
		// the stone don't move !
	}
}
