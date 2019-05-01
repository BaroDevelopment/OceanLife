package infpp.oceanlife.Model;

import infpp.oceanlife.View.OceanGraphic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * the class for a plant
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
@SuppressWarnings("serial")
public class Plant extends OceanObject {

	/**
	 * number of created Plants in total
	 */
	private static int counter = 0;

	/**
	 * Counter for the Plant state
	 */
	private int pic;

	/**
	 * Constructor expects two integers for the position
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 */
	public Plant(int x, int y) {
		Plant.counter++;
		name = "Plant " + Plant.counter;
		position[0] = x;
		position[1] = y;
		// plants don't move
		direction = 0;
		pic = 0;
	}

	/**
	 * Overriding the default toString method.
	 * 
	 * @return String containing name and position
	 */
	@Override
	public String toString() {
		return this.getName() + ": " + super.toString();
	}

	/**
	 * return pixel height of a plant
	 * 
	 * @return pixel height of plant
	 */
	@Override
	public int getHeight() {
		return OceanGraphic.getPlantImage().getHeight();
	}

	/**
	 * return pixel height of a plant
	 * 
	 * @return pixel height of plant
	 */
	@Override
	public int getWidth() {
		return OceanGraphic.getPlantImage().getWidth();
	}

	/**
	 * We check the Plant state (pic) and draw the corresponding graphic
	 * 
	 * @param g
	 *            Graphic to paint on
	 */
	@Override
	public void draw(Graphics g) {
		// decide which picture to take
		if (pic < 20) {
			g.drawImage(OceanGraphic.getPlantImage(), getPosition()[0], getPosition()[1], null);
		} else if (pic < 40) {
			g.drawImage(OceanGraphic.getPlantImage1(), getPosition()[0], getPosition()[1], null);
		} else if (pic < 60) {
			g.drawImage(OceanGraphic.getPlantImage2(), getPosition()[0], getPosition()[1], null);
		} else if (pic < 80) {
			g.drawImage(OceanGraphic.getPlantImage3(), getPosition()[0], getPosition()[1], null);
		} else {
			g.drawImage(OceanGraphic.getPlantImage4(), getPosition()[0], getPosition()[1], null);
		}
		// draw border if necessary
		if (border == true) {
			g.setColor(Color.red);
			g.drawRect(getPosition()[0], getPosition()[1], getWidth(), getHeight());
		}
	}

	/**
	 * on calculating plant only need to increase counter for animation
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
		pic = (pic + 3) % 100;
	}
}
