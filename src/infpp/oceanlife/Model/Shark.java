package infpp.oceanlife.Model;

import infpp.oceanlife.View.OceanGraphic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class for ocan Object shark
 * 
 * @author Baris Simonjan, Etienne Violet
 */
@SuppressWarnings("serial")
public class Shark extends OceanObject {
	/**
	 * counter of instances
	 */
	private static int counter = 0;

	/**
	 * Constructor expects two ints for the position.
	 * 
	 * @param x
	 *            x-position
	 * @param y
	 *            y-position
	 */
	public Shark(int x, int y) {
		Shark.counter++;
		name = "Shark " + Shark.counter;
		position[0] = x;
		position[1] = y;
		direction = ((int) (Math.random() * 10000)) % 360;
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
	 * draw an shark to a graphic object
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	public void draw(Graphics g) {
		// check direction and paint according to it
		if (getDirection() < 271 && getDirection() > 90) {
			g.drawImage(OceanGraphic.getSharkImage(), getPosition()[0], getPosition()[1], null);
		} else {
			g.drawImage(OceanGraphic.getSharkImage(), getPosition()[0], getPosition()[1], getPosition()[0] + OceanGraphic.getSharkImage().getWidth(),
					getPosition()[1] + OceanGraphic.getSharkImage().getHeight(), OceanGraphic.getSharkImage().getWidth(), 0, 0, OceanGraphic
							.getSharkImage().getHeight(), null);
		}
		// paint the border if necassary
		if (border == true) {
			g.setColor(Color.red);
			g.drawRect(getPosition()[0], getPosition()[1], getWidth(), getHeight());
		}
	}

	/**
	 * get the pixel height of an shark
	 * 
	 * @return pixel height
	 */
	@Override
	public int getHeight() {
		return OceanGraphic.getSharkImage().getHeight();
	}

	/**
	 * get the pixel width of an shark
	 * 
	 * @return the width of the shark
	 */
	@Override
	public int getWidth() {
		return OceanGraphic.getSharkImage().getWidth();
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
		 *  Calc methode von mir und Etienne
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
//			float[] pos = { getPosition()[0], oceanDepth - 20 };
//			this.setPosition(pos);
//		}
//		// otherwise calculate and set the next position
//		else {
//			this.setPosition(this.calcNextPos(PPS, FPS));
//		}
		
        //1% chance to change direction
        if(Math.random()*1000<10){
            setDirection(rndDirection());
        }
        while(!directionIsOK(oceanWidth,oceanDepth)){
            setDirection(rndDirection());
        } 
        setPosition(calcNextPos(PPS,FPS));
	}

	/**
	 * generate a random direction for a shark should be interpreted as a angle from 0° to 359°
	 * 
	 * @return random Direction from 0° to 359° (int)
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
     * check if the curretn direction is ok
     * its not ok if the next step it out of the oceans bounds
     * @param oceanWidth
     * @param oceanDepth
     * @return is the next step ok?
     */
    private boolean directionIsOK(int oceanWidth,int oceanDepth) {
        float newPos[] = new float[2];
        float currentPos[] = getExactPosition();

        newPos[0] = ((float)Math.cos(getDirection()*Math.PI/180) * 10)
                + currentPos[0];

        newPos[1] =  currentPos[1]-((float)Math.sin(getDirection()*Math.PI/180) * 10);
        
        //check boundries
        if(newPos[0]<0 || newPos[0]>oceanWidth-getWidth()
                ||newPos[1]<0 || newPos[1]>oceanDepth-getHeight()){
            return false;
        }else{
            return true;            
        }        
    }
}
