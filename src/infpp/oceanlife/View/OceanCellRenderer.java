package infpp.oceanlife.View;

import infpp.oceanlife.Model.OceanObject;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Custom CellRenderer for OceanObject containing JLists. Calls the toName() method and not the toString method on rendering.
 * 
 * @author Baris Simonjan, Etienne Violet
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class OceanCellRenderer extends JLabel implements ListCellRenderer {

	/**
	 * Create a new OceanCellRender and set opaque to true so you can select an item in the JList
	 */
	public OceanCellRenderer() {
		setOpaque(true);
	}

	/**
	 * Override the method that is called when a cell needs to be rendered
	 * 
	 * @param list
	 *            JList (we don't need it)
	 * @param value
	 *            Object (OceanObject)
	 * @param index
	 *            index parameter, but we don't need it
	 * @param isSelected
	 *            is an Ocean Object in the JList selected?
	 * @param cellHasFocus
	 *            we don't need it
	 * @return the CellRenderer
	 */
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

		OceanObject object = (OceanObject) value;

		// changed this function from toString to getName()
		// so the name of the object is filled in in the JList-cell
		setText(object.getName());
		// set the colors: background and font of the JList
		setBackground(isSelected ? Color.LIGHT_GRAY : Color.white);
		setForeground(Color.black);

		return this;
	}
}
