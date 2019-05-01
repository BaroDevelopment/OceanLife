package infpp.oceanlife.Model;

import java.awt.Graphics;
import java.io.Serializable;

/**
 * this is the superclass for all the objects in our ocean
 * 
 * @author Etienne Violet, Baris Simonjan
 */
@SuppressWarnings("serial")
public abstract class OceanObject implements Serializable {

	/**
	 * Pair of floats to store the position
	 */
	float[] position = new float[2];

	/**
	 * Does the Object have a border?
	 */
	boolean border;

	/**
	 * Direction of the Ocean Object
	 */
	int direction;

	/**
	 * String containing the name
	 */
	String name;

	/**
	 * Check if this object is in the boundaries in an ocean This method is used in Ocean class in the method setOceanObjects
	 * 
	 * @param ocean
	 *            the ocean to check boundaries
	 * @throws Exception
	 *             if out of boundaries
	 */
	public void checkPosition(OceanInterface ocean) throws Exception {
		if (position[0] > ocean.getWidth() - getWidth()) {
			throw new Exception("RIGHT");
		} else if (position[1] > ocean.getDepth() - getHeight()) {
			throw new Exception("DOWN");
		} else if (position[0] < 0) {
			throw new Exception("LEFT");
		} else if (position[1] < 0) {
			throw new Exception("UP");
		}
	}

	/**
	 * Getter method for position
	 * 
	 * @return position rounded values as integer[2]
	 */
	public int[] getPosition() {
		int[] pos = new int[2];
		pos[0] = Math.round(position[0]);
		pos[1] = Math.round(position[1]);
		return pos;
	}

	/**
	 * Setter method for position
	 * 
	 * @param pos
	 *            position in int[2] format
	 */
	public void setPosition(float[] pos) {
		position[0] = pos[0];
		position[1] = pos[1];
	}

	/**
	 * Set the direction of an OceanObject
	 * 
	 * @param direction
	 *            new direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Get the direction of an OceanObject
	 * 
	 * @return direction of the object
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * All oceanObjects need to be able to draw themselves on a Graphics object
	 * 
	 * @param g
	 *            Graphics to be draw
	 */
	public abstract void draw(Graphics g);

	/**
	 * All oceanObjects need to have a method that computes their next position with given speed and frame rate in given ocean boundaries
	 * 
	 * @param PixelPerSecond
	 *            speed in pixel per second
	 * @param maxFPS
	 *            frame rate in frames per second (FPS)
	 * @param oceanWidth
	 *            width of the ocean
	 * @param oceanDepth
	 *            depth of the ocean
	 */
	public abstract void calc(int PixelPerSecond, long maxFPS, int oceanWidth, int oceanDepth);

	/**
	 * Getter method for the name
	 * 
	 * @return String containing the unique name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Overrides the default toString method.
	 * 
	 * @return String containing the position
	 */
	@Override
	public String toString() {
		return "position: x: " + this.position[0] + " y: " + this.position[1];
	}

	/**
	 * getter method for the exact position (floats)
	 * 
	 * @return exact position (floats)
	 */
	public float[] getExactPosition() {
		return position;
	}

	/**
	 * setter method for the border flag
	 * 
	 * @param b
	 *            new flag
	 */
	public void setBorder(boolean b) {
		border = b;
	}

	/**
	 * getter method for border flag
	 * 
	 * @return border flag
	 */
	public boolean getBorder() {
		return border;
	}

	/**
	 * Every Ocean object needs to be able to return their width in pixel
	 * 
	 * @return pixel width
	 */
	public abstract int getWidth();

	/**
	 * Every Ocean object needs to be able to return their height in pixel
	 * 
	 * @return pixel height
	 */
	public abstract int getHeight();
}
