package infpp.oceanlife.Controller;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Listener class for jTextFields
 * 
 * @author Baris Simonjan, Etienne Violet
 *
 */
class FocusListenerEx extends FocusAdapter {

	/**
	 * Handle jTextfields when focus is lost to keep the value in the allowed range a value greater than the ocean width will be reset to the
	 * maxOceanwidth a value less than zero will be reset to 0
	 * 
	 * @param e
	 *            Event
	 */
	@Override
	public void focusLost(FocusEvent e) {
		Object source = e.getSource();
		if (source == OceanLifeController.getGui().getjTextFieldX()) {
			// get the text of the jTextField-X
			String input = OceanLifeController.getGui().getjTextFieldX().getText();
			try {
				int i = Integer.parseInt(input);
				if (i > OceanLifeController.getOcean().getWidth()) {
					OceanLifeController.getGui().getjTextFieldX().setText(String.valueOf(OceanLifeController.getOcean().getWidth()));
				} else if (i < 0) {
					OceanLifeController.getGui().getjTextFieldX().setText("0");
				}
			} catch (NumberFormatException numberFormatException) {
				// if string entered in the jTextField, than set Value to 0
				OceanLifeController.getGui().getjTextFieldX().setText("0");
			}
			OceanLifeController.getGui().getjSliderX().setValue(Integer.parseInt(OceanLifeController.getGui().getjTextFieldX().getText()));
		} else if (source == OceanLifeController.getGui().getjTextFieldY()) {
			// get the text of the jTextField-Y
			String input = OceanLifeController.getGui().getjTextFieldY().getText();
			try {
				int i = Integer.parseInt(input);
				if (i > OceanLifeController.getOcean().getDepth()) {
					OceanLifeController.getGui().getjTextFieldY().setText(String.valueOf(OceanLifeController.getOcean().getDepth()));
				} else if (i < 0) {
					OceanLifeController.getGui().getjTextFieldX().setText("0");
				}
			} catch (NumberFormatException numberFormatException) {
				// if string entered in the jTextField, than set Value to 0
				OceanLifeController.getGui().getjTextFieldY().setText("0");
			}
			OceanLifeController.getGui().getjSliderY().setValue(Integer.parseInt(OceanLifeController.getGui().getjTextFieldY().getText()));
		}
	}
}