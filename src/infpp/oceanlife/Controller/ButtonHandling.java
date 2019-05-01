package infpp.oceanlife.Controller;

import java.util.LinkedList;

import infpp.oceanlife.Model.OceanObject;

/**
 * Class to handle button events
 * 
 * @author Baris Simonjan, Etienne Violet
 */

/**
 * Class for all button events in the OceanGUI mainly to handle clicked buttons.
 */
public class ButtonHandling {

	// /////////////////////////////////////////////////////////
	// ///////////// Declaration of attributes ///////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Mouselistener for all Buttons
	 */
	private MouseListenerEx mouseListener;

	/**
	 * Focuslistener for the jTextFields
	 */
	private FocusListenerEx focusListener;

	/**
	 * Sliderlistener for the Sliders
	 */
	private SliderListener slideListener;

	/**
	 * ListselectionListener for the border to set of an Object in the jList was clicked
	 */
	private ListSelectionListenerEx listSelectionListener;

	// /////////////////////////////////////////////////////////
	// ////////////////// Getter and Setter ///////////////////
	// ////////////////////////////////////////////////////////
	/**
	 * Getter for the ListselectionListener
	 * 
	 * @return the listSelectionListener
	 */
	public ListSelectionListenerEx getListSelectionListener() {
		return listSelectionListener;
	}

	/**
	 * Getter for the MouseListener
	 * 
	 * @return the mouseListener
	 */
	public MouseListenerEx getMouseListener() {
		return mouseListener;
	}

	/**
	 * Setter for the MouseListener
	 * 
	 * @param mouseListener
	 *            the mouseListener to set
	 */
	public void setMouseListener(MouseListenerEx mouseListener) {
		this.mouseListener = mouseListener;
	}

	/**
	 * Getter for the FocusListener
	 * 
	 * @return the focusListener
	 */
	public FocusListenerEx getFocusListener() {
		return focusListener;
	}

	/**
	 * Setter for the FocusListener
	 * 
	 * @param focusListener
	 *            the focusListener to set
	 */
	public void setFocusListener(FocusListenerEx focusListener) {
		this.focusListener = focusListener;
	}

	/**
	 * Getter for the SlideListener
	 * 
	 * @return the slideListener
	 */
	public SliderListener getSlideListener() {
		return slideListener;
	}

	/**
	 * Setter for the SlideListener
	 * 
	 * @param slideListener
	 *            the slideListener to set
	 */
	public void setSlideListener(SliderListener slideListener) {
		this.slideListener = slideListener;
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Constructor ///////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Initialization of all Listeners
	 */
	public ButtonHandling() {

		this.mouseListener = new MouseListenerEx();
		this.focusListener = new FocusListenerEx();
		this.slideListener = new SliderListener();
		this.listSelectionListener = new ListSelectionListenerEx();
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Methods ///////////////////////////////
	// /////////////////////////////////////////////////////////

	/**
	 * resets the flag for borders at every object in the current ocean is used in the MouseListener class in the method handleDeselectButton
	 */
	void resetBorders() {
		LinkedList<OceanObject> oceanObjects = OceanLifeController.getOcean().getOceanObjects();
		for (int i = 0; i < oceanObjects.size(); i++) {
			oceanObjects.get(i).setBorder(false);
		}
	}
}
