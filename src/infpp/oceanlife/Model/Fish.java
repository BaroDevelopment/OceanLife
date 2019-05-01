package infpp.oceanlife.Model;

import infpp.oceanlife.View.OceanGraphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * the class for a fish
 * 
 * @author Etienne Violet, Baris Simonjan
 */

@SuppressWarnings("serial")
public class Fish extends OceanObject {
	/**
	 * ID of the fish color
	 */
	private int color;

	/**
	 * number of created Fish in total
	 */
	private static int counter = 0;

	/**
	 * Getter for the Color
	 * 
	 * @return the color of a Fish
	 */
	public int getColor() {
		return this.color;
	}

	/**
	 * Create A Fish with a specific position. Generates color and random start direction.
	 * 
	 * @param x
	 *            x-position of the Fish
	 * @param y
	 *            y-position of the Fish
	 */
	public Fish(int x, int y) {
		Fish.counter++;
		this.name = "Fish " + Fish.counter;
		this.position[0] = x;
		this.position[1] = y;

		// set a random start direction in degree between 0° - 359°
		this.direction = ((int) (Math.random() * 10000)) % 360;

		// randomly set color of the fish
		int rnd = (int) (Math.random() * 100000) % 100;

		// All fish spawn with the same probability (14%) except Nemo (color = 0, 2%)
		// The Shark doesn't eat Nemo
		if (rnd < 2) {
			// Nemo
			this.color = 0;
		} else if (rnd < 16) {
			this.color = 1;
		} else if (rnd < 30) {
			this.color = 2;
		} else if (rnd < 44) {
			this.color = 3;
		} else if (rnd < 58) {
			this.color = 4;
		} else if (rnd < 72) {
			this.color = 5;
		} else if (rnd < 86) {
			this.color = 6;
		}
		// fatfish
		else
			this.color = 7;
	}

	/**
	 * Return the name and the position as a String. Overriding the default toString method.
	 * 
	 * @return String containing name and position
	 */
	@Override
	public String toString() {
		// the toString method of OceanObjects returns the position
		return this.getName() + ": " + super.toString();
	}

	/**
	 * Get the height of a Fish
	 * 
	 * @return Heigth of a Fish
	 */
	@Override
	public int getHeight() {
		return OceanGraphic.getNemo().getHeight();
	}

	/**
	 * Get the width of a Fish
	 * 
	 * @return width of a Fish
	 */
	@Override
	public int getWidth() {
		return OceanGraphic.getNemo().getWidth();
	}

	/**
	 * Draw this Fish to a given Graphics
	 * 
	 * @param g
	 *            the Graphics to print the Fish on
	 */
	@Override
	public void draw(Graphics g) {
		// Choose the image with the correct color
		BufferedImage temp = null;
		if (this.color == 0) {
			temp = OceanGraphic.getNemo();
		} else if (this.color == 1) {
			temp = OceanGraphic.getYellowFishImage();
		} else if (this.color == 2) {
			temp = OceanGraphic.getBlueFishImage();
		} else if (this.color == 3) {
			temp = OceanGraphic.getGreenFishImage();
		} else if (this.color == 4) {
			temp = OceanGraphic.getFishGreenImage();
		} else if (this.color == 5) {
			temp = OceanGraphic.getFishRedImage();
		} else if (this.color == 6) {
			temp = OceanGraphic.getFishBlueImage();
		} else {
			temp = OceanGraphic.getFishfatImage();
			;
		}

		// decide which side the fish is looking at and print it
		/*
		 * call the drawImage Method with the arguments: image, x and y coordinate
		 */
		if (this.getDirection() < 271 && this.getDirection() > 90) {
			g.drawImage(temp, this.getPosition()[0], this.getPosition()[1], null);
		} else {
			// reflect the image horizontally
			g.drawImage(temp, this.getPosition()[0], this.getPosition()[1], this.getPosition()[0] + this.getWidth(),
					this.getPosition()[1] + this.getHeight(), this.getWidth(), 0, 0, this.getHeight(), null);
		}
		// Draw the Border if selected
		if (border == true) {
			g.setColor(Color.red);
			g.drawRect(this.getPosition()[0], this.getPosition()[1], this.getWidth(), this.getHeight());
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

		/*
		 * Calc Methode von mir und Etienne
		 */
//		// 1% per chance to change direction
//		if (Math.random() * 1000 < 10) {
//			this.setDirection(rndDirection());
//		}
//		// if the shark leaves on the left hand side it reappears on the right
//		if (getPosition()[0] < 0) {
//			float[] pos = { oceanWidth, getPosition()[1] };
//			this.setPosition(pos);
//		}
//		// if the shark leaves on the right hand side it reappears on the left
//		if (getPosition()[0] > oceanWidth) {
//			float[] pos = { 0, getPosition()[1] };
//			this.setPosition(pos);
//		}
//		// if the shark leaves at the top it we reset the y- Position to 1
//		if (getPosition()[1] < 0) {
//			float[] pos = { getPosition()[0], 1 };
//			this.setPosition(pos);
//		}
//		// if the fish leaves at the bottom it we reset the y - Position to ocean-depth - 20
//		// so we make sure that the shark doesn't leave the ocean
//		if (getPosition()[1] > oceanDepth) {
//			float[] pos = { getPosition()[0], oceanDepth - 3 };
//			this.setPosition(pos);
//		}
//		// otherwise calculate and set the next position
//		else {
//			this.setPosition(this.calcNextPos(PPS, FPS));
//		}
		
        //1% chance to change direction
        if(Math.random()*1000<10){
            this.setDirection(this.rndDirection());
        }
        
        //If the direction needs to be changed try a new one until its ok
        while(!this.directionIsOK(PPS,FPS,oceanWidth,oceanDepth)){
            this.setDirection(this.rndDirection());
        }
        
        //Since the direction is ok now we can update the position
        setPosition(this.calcNextPos(PPS,FPS));
	}

	/**
	 * Generate a new random direction. The return value is an integer from 0 to 359 and should be interpreted as an angle where 0Â° = right and 90Â°
	 * = up
	 * 
	 * @return random direction for a Fish
	 */
	private int rndDirection() {
		return (int) (Math.random() * 1000) % 360;
	}

	/**
	 * Calculates the exact Position according to Speed and FPS
	 * 
	 * @param PPS
	 *            Speed of the Fish
	 * @param FPS
	 *            Frames per second
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
	
    /**
     * Check if the next step in the current direction is still inside
     * the oceans boundries
     * @param PPS speed in pixel per second
     * @param FPS framrate in frames per second
     * @param oceanWidth widht of the ocean this fish is in
     * @param oceanDepth depth of the ocean this fish is in
     * @return is the next still in the oceans boundries?
     */
    private boolean directionIsOK(int PPS,long FPS,int oceanWidth,int oceanDepth) {
        
        float newPos[] = new float[2];

        //Calculate x-position
        newPos[0] = this.getExactPosition()[0] 
                +((float)Math.cos(this.getDirection()*Math.PI/180) *  
                ((float)PPS
                /(float)FPS));

        //Calculate y-position
        newPos[1] =  this.getExactPosition()[1]-
                ((float)Math.sin(this.getDirection()*Math.PI/180) * 
                ((float)PPS
                /(float)FPS));
        
        //check if the position is still in the oceans boundries
        if(newPos[0]<0 || newPos[0]>oceanWidth-getWidth()
                ||newPos[1]<0 || newPos[1]>oceanDepth-getHeight()){
            return false;
        }else{
            return true;            
        }
    }
}
