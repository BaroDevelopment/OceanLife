package infpp.oceanlife.Controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener class for the Sliders
 * 
 * @author Baris Simonjan, Etienne Violet
 */
public class SliderListener implements ChangeListener {

	/**
	 * handle a changes selected value to keep the jTextFields and the Slider synchronized
	 * 
	 * @param e
	 *            Event
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if (source == OceanLifeController.getGui().getjSliderX()) {
			OceanLifeController.getGui().getjTextFieldX().setText(String.valueOf(OceanLifeController.getGui().getjSliderX().getValue()));
		} else if (source == OceanLifeController.getGui().getjSliderY()) {
			OceanLifeController.getGui().getjTextFieldY().setText(String.valueOf(OceanLifeController.getGui().getjSliderY().getValue()));
		} else if (source == OceanLifeController.getGui().getjSliderSpeed()) {
			int speed = OceanLifeController.getGui().getjSliderSpeed().getValue();
			OceanLifeController.getCalcThread();
			CalcThread.setPPS(speed);
		}
	}
}
