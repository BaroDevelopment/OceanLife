package infpp.oceanlife;

import infpp.oceanlife.Controller.OceanLifeController;

/**
 * The Main class for this Project
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
public class OceanApplication {

	/**
	 * Controller we start
	 */
	private static OceanLifeController controller;

	/**
	 * Creates a new Controller object and runs the start method of the controller
	 * 
	 * @param args
	 *            Argument type is: name.ocean file
	 */
	public static void main(String[] args) {
		controller = new OceanLifeController();
		controller.start();
	}
}
