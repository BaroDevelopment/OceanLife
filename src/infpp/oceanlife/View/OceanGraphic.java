package infpp.oceanlife.View;

import infpp.oceanlife.Controller.OceanLifeController;
import infpp.oceanlife.Model.OceanObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Class to load all images
 * 
 * @author Baris Simonjan, Etienne Violet
 */

@SuppressWarnings("serial")
public class OceanGraphic extends JPanel {

	// /////////////////////////////////////////////////////////
	// /// Declaration / Initialization of attributes //////////
	// ////////////////////////////////////////////////////////

	/**
	 * Declaration of all fish images
	 */
	private static BufferedImage Nemo, blueFishImage, yellowFishImage, greenFishImage, fishBlueImage, fishGreenImage, fishRedImage, fishfatImage;

	/**
	 * Declaration of all plant images
	 */
	private static BufferedImage plantImage, plantImage1, plantImage2, plantImage3, plantImage4;

	/**
	 * Declaration of the bubble image
	 */
	private static BufferedImage bubbleImage;

	/**
	 * Declaration of the stone image
	 */
	private static BufferedImage stoneImage;

	/**
	 * Declaration of the background picture
	 */
	private static BufferedImage background;

	/**
	 * Declaration of the shark image
	 */
	private static BufferedImage sharkImage;

	// /////////////////////////////////////////////////////////
	// ////////////////// Getter and Setter ///////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Getter for NemoImage
	 * 
	 * @return the nemo
	 */
	public static BufferedImage getNemo() {
		return Nemo;
	}

	/**
	 * Getter for blueFishImage
	 * 
	 * @return the blueFishImage
	 */
	public static BufferedImage getBlueFishImage() {
		return blueFishImage;
	}

	/**
	 * Getter for yellowFishImage
	 * 
	 * @return the yellowFishImage
	 */
	public static BufferedImage getYellowFishImage() {
		return yellowFishImage;
	}

	/**
	 * Getter for greenFishImage
	 * 
	 * @return the greenFishImage
	 */
	public static BufferedImage getGreenFishImage() {
		return greenFishImage;
	}

	/**
	 * Getter for fishBlueImage
	 * 
	 * @return the fishBlueImage
	 */
	public static BufferedImage getFishBlueImage() {
		return fishBlueImage;
	}

	/**
	 * Getter for fishGreenImage
	 * 
	 * @return the fishGreenImage
	 */
	public static BufferedImage getFishGreenImage() {
		return fishGreenImage;
	}

	/**
	 * Getter for fishRedImage
	 * 
	 * @return the fishRedImage
	 */
	public static BufferedImage getFishRedImage() {
		return fishRedImage;
	}

	/**
	 * Getter for fishfatImage
	 * 
	 * @return the fishfatImage
	 */
	public static BufferedImage getFishfatImage() {
		return fishfatImage;
	}

	/**
	 * Getter for plantImage
	 * 
	 * @return the plantImage
	 */
	public static BufferedImage getPlantImage() {
		return plantImage;
	}

	/**
	 * Getter for plantImage1
	 * 
	 * @return the plantImage1
	 */
	public static BufferedImage getPlantImage1() {
		return plantImage1;
	}

	/**
	 * Getter for plantImage2
	 * 
	 * @return the plantImage2
	 */
	public static BufferedImage getPlantImage2() {
		return plantImage2;
	}

	/**
	 * Getter for plantImage3
	 * 
	 * @return the plantImage3
	 */
	public static BufferedImage getPlantImage3() {
		return plantImage3;
	}

	/**
	 * Getter for plantImage4
	 * 
	 * @return the plantImage4
	 */
	public static BufferedImage getPlantImage4() {
		return plantImage4;
	}

	/**
	 * Getter for bubbleImage
	 * 
	 * @return the bubbleImage
	 */
	public static BufferedImage getBubbleImage() {
		return bubbleImage;
	}

	/**
	 * Getter for stoneImage
	 * 
	 * @return the stoneImage
	 */
	public static BufferedImage getStoneImage() {
		return stoneImage;
	}

	/**
	 * Getter for sharkImage
	 * 
	 * @return the sharkImage
	 */
	public static BufferedImage getSharkImage() {
		return sharkImage;
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Constructor ///////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * create a OceanGraphic and load all images
	 */
	public OceanGraphic() {
		loadImages();
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Methods//// ///////////////////////////
	// /////////////////////////////////////////////////////////
	/**
	 * Do the Painting of the ocean when paint() is called
	 * 
	 * @param g
	 *            Graphics to paint on
	 */
	@Override
	public void paint(Graphics g) {
		// draw the background
		g.drawImage(background, 0, 0, null);

		// draw all the oceanObjects
		LinkedList<OceanObject> oceanObjects = OceanLifeController.getOcean().getOceanObjects();
		for (int i = 0; i < oceanObjects.size(); i++) {
			oceanObjects.get(i).draw(g);
		}
	}

	/**
	 * when creating an oceanGraphic load all the images
	 */
	private void loadImages() {
		// load the images
		try {
			URL url;

			url = OceanGraphic.class.getResource("../pictures/Nemo.png");
			Nemo = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fishgreen.png");
			greenFishImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fishyellow.png");
			yellowFishImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fishblue.png");
			blueFishImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/plant.png");
			plantImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/plant1.png");
			plantImage1 = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/plant2.png");
			plantImage2 = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/plant3.png");
			plantImage3 = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/plant4.png");
			plantImage4 = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/bubble.png");
			bubbleImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fish_red.png");
			fishRedImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fish_blue.png");
			fishBlueImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fish_green.png");
			fishGreenImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/fishfat.png");
			fishfatImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/stone.png");
			stoneImage = ImageIO.read(url);

			url = OceanGraphic.class.getResource("../pictures/shark.png");
			sharkImage = ImageIO.read(url);

			background = ImageIO.read(getClass().getResourceAsStream("../pictures/background.png"));

		} catch (Exception e) {
			// if the pictures couldn't be loaded then open a popup and exit the
			// program
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "Unable to load all pictures.\nProgramm will be closed now.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}