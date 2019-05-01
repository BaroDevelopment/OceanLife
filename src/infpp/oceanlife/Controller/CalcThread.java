package infpp.oceanlife.Controller;

import infpp.oceanlife.Model.Fish;
import infpp.oceanlife.Model.OceanObject;

import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Thread to control the movement and collision of OceanObjects in an given OceanInterFace. Also updates a given JList.
 * 
 * @author Baris Simonjan, Etienne Violet
 */
public final class CalcThread extends Thread {

	/**
	 * flag to indicate whether to terminate the Thread or not
	 */
	private boolean running;

	/**
	 * desired frames per second
	 */
	private static long FPS = 25;

	/**
	 * speed for OceanObjects in pixel per second
	 */
	private static int PPS;

	/**
	 * @param pps
	 *            the PPS to set
	 */
	public static void setPPS(int pps) {
		PPS = pps;
	}

	/**
	 * Create a Thread
	 */
	public CalcThread() {
		running = true;
		PPS = OceanLifeController.getGui().getjSliderSpeed().getValue();
	}

	/**
	 * Calculate and change Object data in a while loop until the running flag is set to false. Synchronizing with OceanInterface and the jListObjects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		while (true) {

			// Set the starting time to have a orientation for the sleep-time
			long startTime = System.currentTimeMillis();

			// make sure to do everything synchronized: only one thread can use the objects
			synchronized (OceanLifeController.getOcean()) {
				synchronized (OceanLifeController.getGui().getjListObjects()) {

					// Let every OceanObject in the OceanInterface calculate its next position
					LinkedList<OceanObject> oceanObjects = OceanLifeController.getOcean().getOceanObjects();
					// calculate all new positions of the objects in the oceanObjects List
					for (int i = 0; i < oceanObjects.size(); i++) {
						oceanObjects.get(i).calc(PPS, FPS, OceanLifeController.getOcean().getWidth(), OceanLifeController.getOcean().getDepth());
					}
					// calculate collisions and add Objects to deleteList
					LinkedList<OceanObject> deleteList = getDeleteList(oceanObjects);

					// delete Objects and update list if necessary
					if (deleteList.size() > 0) {
						// Update Ocean
						oceanObjects.removeAll(deleteList);
						// save selected object in the jListObjects before removing
						OceanObject object = (OceanObject) OceanLifeController.getGui().getjListObjects().getSelectedValue();
						// update the JList with the references of the oceanObjects (LinkedList)
						OceanLifeController.getGui().getjListObjects().setListData(oceanObjects.toArray());
						// if the previous selected item is still in the list set it selected again
						if (oceanObjects.contains(object)) {
							OceanLifeController.getGui().getjListObjects().setSelectedValue(object, true);
						} else {
							// if the selected Object was removed than select nothing
							OceanLifeController.getGui().getjListObjects().clearSelection();
						}
					}
				} // End of synchronization of JList
			} // End of synchronization of ocean

			// quit if terminate() was called
			if (!running)
				return;

			// Set the thread to sleep until the stated FPS (25) is reached
			long endTime = System.currentTimeMillis();

			// calculate the time-difference to say, how much time it will take to reach 25 frames -> sleep-time
			long sleepTime = 1000 / FPS - (endTime - startTime);

			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException ex) {
					// do nothing
				}
			}
		}
	}

	/**
	 * Check if a Shark and a Fish collide
	 * 
	 * @param shark
	 *            Shark to check
	 * @param fish
	 *            Fish to check
	 * @return is there a collision?
	 */
	private boolean collide(OceanObject shark, OceanObject fish) {

		// Make sure only to let a shark not eat Nemo Fish
		if (((Fish) fish).getColor() == 0) {
			return false;
		}

		// set up two Rectangles
		Rectangle sharkRect = new Rectangle(shark.getPosition()[0], shark.getPosition()[1], shark.getWidth(), shark.getHeight());

		Rectangle fishRect = new Rectangle(fish.getPosition()[0], fish.getPosition()[1], fish.getWidth(), fish.getHeight());

		// Check for collision and return value
		return sharkRect.intersects(fishRect);
	}

	/**
	 * Tell the thread to terminate at end of the next loop
	 */
	public void terminate() {
		this.running = false;
	}

	/**
	 * Calculate Objects to be deleted
	 * 
	 * @param oceanObjects
	 *            List of Objects to check for collisions
	 * @return List of Objects that should be deleted
	 */
	private LinkedList<OceanObject> getDeleteList(LinkedList<OceanObject> oceanObjects) {

		// List with objects to be deleted
		LinkedList<OceanObject> deleteList = new LinkedList<OceanObject>();

		// Search for sharks
		for (int i = 0; i < oceanObjects.size(); i++) {
			if (oceanObjects.get(i).getName().startsWith("Shark")) {

				// If found a shark check all fish for collision
				for (int j = 0; j < oceanObjects.size(); j++) {
					if (oceanObjects.get(j).getName().startsWith("Fish")) {

						// if they collide add them to the deleteList
						if (this.collide(oceanObjects.get(i), oceanObjects.get(j))) {
							deleteList.add(oceanObjects.get(j));
						}
					}
				}
			}
		}
		// return the deleteList which only can contain Fish
		return deleteList;
	}
}
