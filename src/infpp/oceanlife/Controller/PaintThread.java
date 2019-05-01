package infpp.oceanlife.Controller;

/**
 * The paint thread takes care of repainting a given gui with a frame rate of 30. It calls the draw() method of all Ocean Objects. Paint-Thread
 * synchronizes the ocean and the jListObjects to make sure to read the correct data
 * 
 * @author Baris Simonjan, Etienne Violet
 *
 */
public class PaintThread extends Thread {

	/**
	 * Frame-Rate
	 */
	private static long FPS = 30;

	/**
	 * flag for terminating the run() method
	 */
	private boolean running;

	/**
	 * Create a Thread
	 */
	public PaintThread() {
		running = true;
	}

	/**
	 * when a thread is started than repaint the objects once per frame
	 */
	@Override
	public void run() {
		while (true) {

			long startTime = System.currentTimeMillis();

			synchronized (OceanLifeController.getOcean()) {
				synchronized (OceanLifeController.getGui().getjListObjects()) {

					// reapint the gui synchronized
					OceanLifeController.getGui().repaint();
				}
			}
			// if the terminate method was called quit the run() method
			// (terminate)
			if (!running) {
				return;
			}

			// Set the thread to sleep until the stated FPS (30) is reached
			long endTime = System.currentTimeMillis();

			// calculate the time-difference to say, how much time it will take
			// to reach 30 frames -> sleep-time
			long sleepTime = 1000 / FPS - (endTime - startTime);
			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException ex) {
				}
			}
		}
	}

	/**
	 * Terminate the thread after next loop
	 */
	void terminate() {
		running = false;
	}
}
