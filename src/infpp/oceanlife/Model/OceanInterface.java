package infpp.oceanlife.Model;

import java.util.LinkedList;

/**
 * the interface for our Ocean. The class that implements this interface has to implement all the methods which are given here.
 * 
 * @author Etienne Violet, Baris Simonjan
 *
 */
public interface OceanInterface {

	/**
	 * get the width of the ocean
	 * 
	 * @return returns the width of the ocean
	 */
	public int getWidth();

	/**
	 * get the depth of the ocean
	 * 
	 * @return returns the depth of the ocean
	 */
	public int getDepth();

	/**
	 * get the LinkedList of OceanObjects of the ocean
	 * 
	 * @return returns the linkedList of OceanObjects
	 */
	public LinkedList<OceanObject> getOceanObjects();

	/**
	 * set the LinkedList of OceanObjects of the ocean
	 * 
	 * @param oceanObjects
	 *            a linkedList of OceanObjects
	 * @throws Exception
	 *             Exception
	 */
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) throws Exception;

	/**
	 * method to create a string with information about the objects contained in the ocean
	 * 
	 * @return returns the information as a string
	 */
	@Override
	public String toString();

	/**
	 * Add an OceanObject to the oceans list
	 * 
	 * @param object
	 *            The object to be added
	 * @throws Exception
	 *             Exception
	 */
	public void addOceanObject(OceanObject object) throws Exception;

	/**
	 * Remove an selected OceanObject from the oceans list
	 * 
	 * @param i
	 *            index of the OceanObject in the list
	 * @throws Exception
	 *             Exception
	 */
	public void removeOceanObject(int i) throws Exception;

	/**
	 * Get the Index of the closest OceanObject to a coordinate (x/y)
	 * 
	 * @param x
	 *            x-coordinate
	 * @param y
	 *            y-coordinate
	 * @return Index of closest OceanObject
	 */
	public int getClosestIndex(int x, int y);
}
