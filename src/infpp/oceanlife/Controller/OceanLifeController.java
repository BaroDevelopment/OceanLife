package infpp.oceanlife.Controller;

import infpp.oceanlife.Model.*;
import infpp.oceanlife.View.*;

import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * Controller
 * 
 * @author Baris Simonjan, Etienne Violet
 *
 */
public class OceanLifeController {

	// /////////////////////////////////////////////////////////
	// /// Declaration/ Initialization of attributes //////////
	// ////////////////////////////////////////////////////////

	/**
	 * create empty interface
	 */
	private static OceanInterface ocean;

	/**
	 * handler we need for the clicked gui components
	 */
	private static ButtonHandling handler;

	/**
	 * gui we are working with
	 */
	private static OceanLifeGui gui;

	/**
	 * thread for painting
	 */
	private static PaintThread paintThread;

	/**
	 * thread for calculating
	 */
	private static CalcThread calcThread;

	/**
	 * Graphics
	 */
	private static OceanGraphic oceanGraphic;

	// ////////////////////////////////////////////////////////
	// /////////// Getter and Setter //////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Getter for the graphic
	 * 
	 * @return the oceanGraphic
	 */
	public static OceanGraphic getOceanGraphic() {
		return oceanGraphic;
	}

	/**
	 * Setter for the graphic
	 * 
	 * @param oceanGraphic
	 *            the OceeanGraphic we set
	 */
	public static void setOceanGraphic(OceanGraphic oceanGraphic) {
		OceanLifeController.oceanGraphic = oceanGraphic;
	}

	/**
	 * Getter for our ButtonHandler
	 * 
	 * @return the handler
	 */
	public static ButtonHandling getHandler() {
		return handler;
	}

	/**
	 * Setter for our ButtonHandler
	 * 
	 * @param handler
	 *            the handler to set
	 */
	public static void setHandler(ButtonHandling handler) {
		OceanLifeController.handler = handler;
	}

	/**
	 * Getter for the paintThread
	 * 
	 * @return the paintThread
	 */
	public static PaintThread getPaintThread() {
		return paintThread;
	}

	/**
	 * Setter for the paintThread
	 * 
	 * @param paintThread
	 *            the paintThread to set
	 */
	public static void setPaintThread(PaintThread paintThread) {
		OceanLifeController.paintThread = paintThread;
	}

	/**
	 * Getter for the CalcThread
	 * 
	 * @return the calcThread
	 */
	public static CalcThread getCalcThread() {
		return calcThread;
	}

	/**
	 * Setter for the CalcThread
	 * 
	 * @param calcThread
	 *            the calcThread to set
	 */
	public static void setCalcThread(CalcThread calcThread) {
		OceanLifeController.calcThread = calcThread;
	}

	/**
	 * Getter for our Ocean
	 * 
	 * @return the ocean
	 */
	public static OceanInterface getOcean() {
		return ocean;
	}

	/**
	 * Setter for our Ocean
	 * 
	 * @param ocean
	 *            the ocean to set
	 */
	public static void setOcean(OceanInterface ocean) {
		OceanLifeController.ocean = ocean;
	}

	/**
	 * Getter for the Gui
	 * 
	 * @return the gui
	 */
	public static OceanLifeGui getGui() {
		return gui;
	}

	/**
	 * Setter for the Gui
	 * 
	 * @param gui
	 *            the gui to set
	 */
	public static void setGui(OceanLifeGui gui) {
		OceanLifeController.gui = gui;
	}

	// /////////////////////////////////////////////////////////
	// //////////////////////// Methods ///////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * starts the controller
	 */
	public void start() {
		// Create empty List for the ocean objects
		LinkedList<OceanObject> oceanObjects;

		// create a new and empty ocean
		oceanObjects = new LinkedList<OceanObject>();
		try {
			/*
			 * initializing the interface with the Ocean this is allowed because the Ocean implements the OceanInterface (ocean)
			 */
			ocean = new Ocean();
		} catch (Exception ex) {
			// Open a Popup to inform user about error
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "Could not create ocean!\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			// Quit the application
			System.exit(0);
		}
		// handler initialize all Listeners
		handler = new ButtonHandling();

		oceanGraphic = new OceanGraphic();
		// Create an OceanGUI
		gui = new OceanLifeGui();
		// make the frame visible
		gui.setVisible(true);

		// start threads
		paintThread = new PaintThread();
		calcThread = new CalcThread();
		paintThread.start();
		calcThread.start();
	}
}
