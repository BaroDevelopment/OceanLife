package infpp.oceanlife.Controller;

import infpp.oceanlife.Model.OceanObject;

import java.util.LinkedList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * class for the jListObject if an Object in the jList was clicked.
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
public class ListSelectionListenerEx implements ListSelectionListener {

	/**
	 * Set a border to the selected Object of the jList
	 * 
	 * @param e
	 *            Event
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {
				// get the selected OceanObject
				OceanObject object = (OceanObject) OceanLifeController.getGui().getjListObjects().getSelectedValue();
				// reset all border flags (to false)
				OceanLifeController.getHandler().resetBorders();
				// find the selected object in the ocean and set its border flag
				LinkedList<OceanObject> objects = OceanLifeController.getOcean().getOceanObjects();
				for (int i = 0; i < objects.size(); i++) {
					if (objects.get(i) == object) {
						objects.get(i).setBorder(true);
						break;
					}
				}
			}
		}
	}
}
