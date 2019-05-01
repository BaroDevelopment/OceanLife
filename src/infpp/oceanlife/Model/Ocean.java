package infpp.oceanlife.Model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * the ocean holds a number of OceanObjects
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
@SuppressWarnings("serial")
public class Ocean implements OceanInterface, Serializable {

	// /////////////////////////////////////////////////////////
	// /// Declaration/ Initialization of attributes //////////
	// ////////////////////////////////////////////////////////

	/**
	 * Width of the ocean
	 */
	private final int width = 1610;
	/**
	 * Depth of the ocean
	 */
	private final int depth = 1020;

	/**
	 * LinkedList containing all of the OceanObjects
	 */
	private LinkedList<OceanObject> oceanObjects;

	// ////////////////////////////////////////////////////////
	// /////////// Getter and Setter //////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Get the width of the Ocean
	 * 
	 * @return width of the Ocean
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Get the depth of the Ocean
	 * 
	 * @return Depth of Ocean
	 */
	@Override
	public int getDepth() {
		return this.depth;
	}

	/**
	 * Get the list with OceanObjects
	 * 
	 * @return LinkedList of OceanObjects
	 */
	@Override
	public LinkedList<OceanObject> getOceanObjects() {
		return oceanObjects;
	}

	/**
	 * Set the list with OceanObjects
	 * 
	 * @param oceanObjects
	 *            LinkedList of OceanObjects
	 * @throws Exception
	 *             if an object is not in the boundaries of the ocean
	 */
	@Override
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) throws Exception {
		// if the oceanObjects (LinkedList) is empty, than do nothing !
		if (oceanObjects != null) {
			// Check if this object is in the boundaries in an ocean
			for (int i = 0; i < oceanObjects.size(); i++) {
				try {
					// check if the OceanObject in the List is outside of the ocean boundaries
					oceanObjects.get(i).checkPosition(this);
				} catch (Exception e) {
					throw new Exception("Tried to set a list " + "of OceanObjects with an " + "Object that is out of this bound:\n\"" + e.getMessage() + "\"");
				}
			}
			// Clear Old List add add all other elements
			oceanObjects.clear();
			oceanObjects.addAll(oceanObjects);
		}
	}

	// ////////////////////////////////////////////////////////
	// ////////////// Constructor /////////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * set the attributes width, depth and oceanObjects(LinkedList) to given parameters
	 * 
	 * @param oceanObjects
	 *            List of oceanObjects
	 * @throws Exception
	 *             If width or depth is less than zero
	 */

	public Ocean() throws Exception {
		// initialize the LinkedList of oceanObjects
		this.oceanObjects = new LinkedList<OceanObject>();
	}

	// /////////////////////////////////////////////////////////
	// //////////////////////// Methods ///////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Return the width, depth and a list of all Ocean Objects with their name and position
	 * 
	 * @return String containing width, depth and list of OceanObjects
	 */
	@Override
	public String toString() {
		String value;
		// Add the depth and width
		value = "Ocean: width: " + width + " depth: " + depth + "\nObjects:\n";

		// Add the OceanObjects
		for (int i = 0; i < oceanObjects.size(); i++) {
			value = value + oceanObjects.get(i).toString() + "\n";
		}

		return value;
	}

	/**
	 * Add an OceanObject to the LinkedList oceanObjects
	 * 
	 * @param object
	 *            The object to be added
	 * @throws Exception
	 *             if the object is out of boundaries
	 */
	@Override
	public void addOceanObject(OceanObject object) throws Exception {
		try {
			// Check if is out of boundaries
			object.checkPosition(this);
		} catch (Exception exception) {
			throw new Exception("Object out of oceans boundaries:" + exception.getMessage());
		}
		oceanObjects.add(object);
	}

	/**
	 * Delete an object on given index
	 * 
	 * @param i
	 *            Index of the Object to delete
	 * 
	 * @throws Exception
	 *             if the index is out of the lists bounds
	 */
	@Override
	public void removeOceanObject(int i) throws Exception {
		if (i >= oceanObjects.size()) {
			throw new Exception("Index out of bounds");
		} else {
			oceanObjects.remove(i);
		}
	}

	/**
	 * Get the index of the closest OceanObject to a coordinate (x/y) Is needed to set the Border of an OceanObject. Is used by the Method handleOceanGraphic in MouseListener
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * 
	 * @return Index of closest OceanObject
	 */
	@Override
	public int getClosestIndex(int x, int y) {
		// if the list is empty
		if (oceanObjects.size() == 0) {
			return -1;
		}
		// Iterate through the list and remember the shortest distance with the
		// index
		int index = 0;
		double shortestDistance = getDistance(oceanObjects.get(0).getPosition(), x, y);
		double temp = 0.0;
		for (int i = 1; i < oceanObjects.size(); i++) {
			temp = getDistance(oceanObjects.get(i).getPosition(), x, y);
			if (temp < shortestDistance) {
				index = i;
				shortestDistance = temp;
			}
		}
		// Return the index of the closest object
		return index;
	}

	/**
	 * Calculate the Distance of two positions
	 * 
	 * @param pos
	 *            x- and y-position of first object
	 * @param x
	 *            x-position of second object
	 * @param y
	 *            y-position of second object
	 * @return the distance
	 */
	private double getDistance(int[] pos, int x, int y) {
		// Euklidische Norm
		return Math.sqrt((pos[0] - x) * (pos[0] - x) + (pos[1] - y) * (pos[1] - y));
	}
}