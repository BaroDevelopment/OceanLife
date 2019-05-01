package infpp.oceanlife.Model;

import infpp.oceanlife.View.OceanGraphic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * the class for a bubble
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */

@SuppressWarnings("serial")
public class Bubble extends OceanObject {

	/**
	 * number of created Bubbles in total
	 */
	private static int counter = 0;

	/**
	 * Create A Bubble with a specific position. Generates a random start direction. Increases the static counter for bubbles and sets the unique
	 * name.
	 * 
	 * @param x
	 *            x-position of the Bubble
	 * @param y
	 *            y-position of the Bubble
	 */
	public Bubble(int x, int y) {
		Bubble.counter++;
		this.name = "Bubble " + Bubble.counter;
		this.position[0] = x;
		this.position[1] = y;
		// random direction from 20° to 160°
		this.direction = rndDirection();
	}

	/**
	 * Return the name and the position as a String. Calls the superclass' toString method to get the position as a string. Overriding the default
	 * toString method.
	 * 
	 * @return string containing name and position
	 */
	@Override
	public String toString() {
		// the toString method of OceanObjects returns the position
		return this.getName() + ": " + super.toString();
	}

	/**
	 * Get the height of a Bubble
	 * 
	 * @return height of a Bubble
	 */
	@Override
	public int getHeight() {
		return OceanGraphic.getBubbleImage().getHeight();
	}

	/**
	 * Get the width of a Bubble
	 * 
	 * @return width of a Bubble
	 */
	@Override
	public int getWidth() {
		return OceanGraphic.getBubbleImage().getWidth();
	}

	/**
	 * Draw a Bubble into the ocean
	 * 
	 * @param g
	 *            Graphic for the Bubble
	 */
	@Override
	public void draw(Graphics g) {
		// draw the image (bubble) in the ocean
		g.drawImage(OceanGraphic.getBubbleImage(), this.getPosition()[0], this.getPosition()[1], null);

		// Draw the Border if selected
		if (border == true) {
			g.setColor(Color.red);
			g.drawRect(this.getPosition()[0], this.getPosition()[1], getWidth(), getHeight());
		}
	}

	/**
	 * Sets all parameters for the next step with given speed and FPS. Bubble ignores width of an ocean, so it might go out the screen, but it will
	 * reappear again on the oceans ground
	 * 
	 * @param PPS
	 *            speed in pixel per second
	 * @param FPS
	 *            frame-rate in frames per second
	 * @param oceanWidth
	 *            width of the ocean
	 * @param oceanDepth
	 *            depth of the ocean
	 */
	@Override
	public void calc(int PPS, long FPS, int oceanWidth, int oceanDepth) {

		// 5% per frame chance to change direction
		if (Math.random() * 1000 < 50) {
			this.setDirection(rndDirection());
		}

		/*
		 * if the y-coordinate <= 0 then set the y-coordinate to the maximum (ocean-depth),and set the x-coordinate randomly
		 */
		if (getPosition()[1] <= 0) {
			float[] pos = { (int) (Math.random() * 1000) % oceanWidth, oceanDepth - getHeight() };
			this.setPosition(pos);
		}
		// otherwise calculate and set the next position
		else {
			this.setPosition(this.calcNextPos(PPS, FPS));
		}
	}

	/**
	 * Generate a new random direction for a Bubble. (in degree) The return value is an integer from 20 to 159 and should be interpreted as an angle
	 * 
	 * @return random direction for a Bubble
	 */
	// 0° = right
	// < 90° = up
	// < 180° = left
	// < 270° = down
	// < 360° = right
	private int rndDirection() {
		return ((int) (Math.random() * 10000)) % 140 + 20;
	}

	/**
	 * Computes the exact next Position according to Speed and FPS
	 * 
	 * @param PPS
	 *            speed in pixel per frame
	 * @param FPS
	 *            frame-rate in frames per second
	 * @return exact position for next step
	 */
	private float[] calcNextPos(int PPS, long FPS) {

		float newPos[] = new float[2];

		/*
		 * Calculate new x-position new x-pos = x + cos(dir * pi / 180) * PPS / FPS ==> maximum: x + 5 dir * pi / 180 converts the angle from degree
		 * to radial norm multiplication with (PPS / FPS) sets the direction in relation with the speed and frame-rate
		 */
		newPos[0] = this.getExactPosition()[0] + ((float) Math.cos(this.getDirection() * Math.PI / 180.0) * ((float) PPS / (float) FPS));

		/*
		 * Calculate new y-position new y-pos = x + sin(dir * pi / 180) * PPS / FPS ==> maximum: x - 5 dir * pi / 180 converts the angle from degree
		 * to radial norm multiplication with (PPS / FPS) sets the direction in relation with the speed and frame-rate
		 */
		newPos[1] = this.getExactPosition()[1] - ((float) Math.sin(this.getDirection() * Math.PI / 180.0) * ((float) PPS / (float) FPS));

		return newPos;
	}
}
