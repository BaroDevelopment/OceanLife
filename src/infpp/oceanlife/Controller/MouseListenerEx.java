package infpp.oceanlife.Controller;

import infpp.oceanlife.Model.Bubble;
import infpp.oceanlife.Model.Fish;
import infpp.oceanlife.Model.Ocean;
import infpp.oceanlife.Model.OceanObject;
import infpp.oceanlife.Model.Plant;
import infpp.oceanlife.Model.Shark;
import infpp.oceanlife.Model.Stone;
import infpp.oceanlife.View.OceanGraphic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.Random;

/**
 * MouseListener Class for all button events in the OceanGui mainly to handle clicked buttons.
 * 
 * @author Baris Simonjan, Etienne Violet
 *
 */
public class MouseListenerEx extends MouseAdapter {

	/**
	 * Random variable to get random number for the JCheckBoxes
	 */
	private Random random;

	/**
	 * FileFilter for .ocean data
	 */
	OceanFileFilter fileFilter = new OceanFileFilter();

	/**
	 * Constructor of the MouseListener. Initialize the random instance
	 */
	MouseListenerEx() {
		random = new Random();
	}

	/**
	 * Handle mouse events
	 * 
	 * @param e
	 *            event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		Object source = e.getSource();

		// Quit Button
		if (source == OceanLifeController.getGui().getjButtonQuit()) {
			this.handleQuitButton();
		}

		// Add Button
		else if (source == OceanLifeController.getGui().getjButtonAdd()) {
			// get the counter for the objects
			// if String is typed in the Spinner than the Value will be set to 1
			// by default
			int counter = (Integer) OceanLifeController.getGui().getJSpinnerCount().getValue();

			if (counter <= 0 || counter > 100) {
				// Generate Error Message when typed not allowed number
				final JOptionPane optionPane = new JOptionPane();
				JOptionPane.showMessageDialog(optionPane, "Allowed numbers are 1 - 100", "Warning", JOptionPane.WARNING_MESSAGE);
				// set the value to 1
				OceanLifeController.getGui().getJSpinnerCount().setValue(1);
				return;
			}

			while (counter != 0) {
				this.handleAddButton();
				counter = counter - 1;
			}
			// reset the counter back to 1 after added all objects
			OceanLifeController.getGui().getJSpinnerCount().setValue(1);
		}

		// Remove Button
		else if (source == OceanLifeController.getGui().getjButtonRemove()) {
			this.handleRemoveButton();
		}
		// Step Button
		else if (source == OceanLifeController.getGui().getjButtonStep()) {
			this.handleStepButton();
		}
		// Information Button
		else if (source == OceanLifeController.getGui().getjButtonInfo()) {
			this.handleInfoButton();
		}
		// Save Button
		else if (source == OceanLifeController.getGui().getjButtonSave()) {
			this.handleSaveButton();
		}
		// Load Button
		else if (source == OceanLifeController.getGui().getjButtonLoad()) {
			this.handleLoadButton();
		}
		// Clear Button
		else if (source == OceanLifeController.getGui().getjButtonClear()) {
			this.handleClearButton();
		}
		// Deselect Button
		else if (source == OceanLifeController.getGui().getjButtonDeselect()) {
			this.handleDeselectButton();
		}
		// Clicked on the OceanGraphic
		else if (source == OceanLifeController.getOceanGraphic()) {
			this.handleOceanGraphic(e.getX(), e.getY());
		}
		// Start Button
		else if (source == OceanLifeController.getGui().getjButtonStart()) {
			this.handleStartButton();
		}
		// Stop Button
		else if (source == OceanLifeController.getGui().getjButtonStop()) {
			this.handleStopButton();
		}
	}

	/**
	 * Terminate the Thread
	 */
	private void handleStopButton() {
		if (OceanLifeController.getCalcThread().getState() != Thread.State.TERMINATED) {
			OceanLifeController.getCalcThread().terminate();
			System.out.println("Stopping Threads .....");
		} else {
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "Ocean is not running .....", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Start Threads if "Start" Button was pressed
	 */
	private void handleStartButton() {
		if (OceanLifeController.getCalcThread().getState() == Thread.State.TERMINATED) {
			OceanLifeController.setCalcThread(new CalcThread());
			OceanLifeController.getCalcThread().start();
			System.out.println("Starting Threads .....");
		} else {
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "Ocean is already running .....", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Things to do when the add button was pressed. Tries to add a new Object (synchronized)
	 */
	@SuppressWarnings("unchecked")
	private void handleAddButton() {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {
				/**
				 * initializing an OceanObject with null
				 */
				OceanObject object = null;
				/**
				 * x-Coordinate (random)
				 */
				int x;

				/**
				 * y-Coordinate (random)
				 */
				int y;

				// check if CheckBox for random coordinations is selected
				if (OceanLifeController.getGui().getCheckboxRandCoord().isSelected()) {
					x = random.nextInt(OceanLifeController.getOcean().getWidth());
					y = random.nextInt(OceanLifeController.getOcean().getDepth());
				} else {
					// otherwise take the jTextField inputs as coordinations
					x = Integer.parseInt(OceanLifeController.getGui().getjTextFieldX().getText());
					y = Integer.parseInt(OceanLifeController.getGui().getjTextFieldY().getText());
				}
				// check if CheckBox for random Objects is selected
				if (OceanLifeController.getGui().getCheckboxRandObj().isSelected()) {
					// make random number for objects which is inserted
					int psyeudorandom = (int) ((Math.random() * 100000) % 100);

					/*
					 * 50% Fish, 40% Bubble, 5% Stone, 4% Plant and 1% Shark
					 */
					if (psyeudorandom < 50) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getNemo().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getNemo().getWidth();
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getNemo().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getNemo().getHeight();
						}
						object = new Fish(x, y);
					} else if (psyeudorandom < 90) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getBubbleImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getBubbleImage().getWidth();
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getBubbleImage().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getBubbleImage().getHeight();
						}
						object = new Bubble(x, y);
					} else if (psyeudorandom < 95) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getStoneImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getStoneImage().getWidth();
						}
						y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getStoneImage().getHeight();
						object = new Stone(x, y);
					} else if (psyeudorandom < 99) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getPlantImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getPlantImage().getWidth();
						}
						y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getPlantImage().getHeight() - 5;
						object = new Plant(x, y);
					} else if (psyeudorandom < 100) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getSharkImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getSharkImage().getWidth();
							;
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getSharkImage().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getSharkImage().getHeight();
						}
						object = new Shark(x, y);
					}
				}
				// if the CheckBox for random Objects was not selected than add object from combo-box
				else {
					/*
					 * create object with corrected position if the position would paint the object outside the ocean it sets the x and y
					 * coordinations to the max possible position
					 */

					// get input from gui
					String selection = (String) OceanLifeController.getGui().getjComboBoxAdd().getSelectedItem();

					if ("Fish".equals(selection)) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getNemo().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getNemo().getWidth();
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getNemo().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getNemo().getHeight();
						}
						object = new Fish(x, y);
					} else if ("Bubble".equals(selection)) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getBubbleImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getBubbleImage().getWidth();
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getBubbleImage().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getBubbleImage().getHeight();
						}
						object = new Bubble(x, y);
					} else if ("Stone".equals(selection)) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getStoneImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getStoneImage().getWidth();
						}
						y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getStoneImage().getHeight();
						object = new Stone(x, y);
					} else if ("Plant".equals(selection)) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getPlantImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getPlantImage().getWidth();
						}
						y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getPlantImage().getHeight() - 5;
						object = new Plant(x, y);
					} else if ("Shark".equals(selection)) {
						if (x > OceanLifeController.getOcean().getWidth() - OceanGraphic.getSharkImage().getWidth()) {
							x = OceanLifeController.getOcean().getWidth() - OceanGraphic.getSharkImage().getWidth();
							;
						}
						if (y > OceanLifeController.getOcean().getDepth() - OceanGraphic.getSharkImage().getHeight()) {
							y = OceanLifeController.getOcean().getDepth() - OceanGraphic.getSharkImage().getHeight();
						}
						object = new Shark(x, y);
					}
				}

				// try to insert created object and update List
				try {
					// add the selected object to oceanObjects (LinkedList)
					OceanLifeController.getOcean().addOceanObject(object);
					int i = OceanLifeController.getGui().getjListObjects().getSelectedIndex();
					// set the jList to the reference of the oceanObjects (LinkedList)
					OceanLifeController.getGui().getjListObjects().setListData(OceanLifeController.getOcean().getOceanObjects().toArray());
					OceanLifeController.getGui().getjListObjects().setSelectedIndex(i);
					System.out.println("Added " + object);
				} catch (Exception ex) {
					// Generate Error Message when failed
					final JOptionPane optionPane = new JOptionPane();
					JOptionPane.showMessageDialog(optionPane, "Could not add Object!", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	/**
	 * things to do when removeButton was pressed changes the ocean and the removeList synchronized
	 */
	@SuppressWarnings("unchecked")
	private void handleRemoveButton() {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {

				// If nothing is selected warn the user and leave this method
				if (-1 == OceanLifeController.getGui().getjListObjects().getSelectedIndex()) {
					final JOptionPane optionPane = new JOptionPane();
					JOptionPane.showMessageDialog(optionPane, "Please select an object in order to delete!", "Selection error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Find the selected object index and cast it to an OceanObject
				Object selection = (OceanObject) OceanLifeController.getGui().getjListObjects().getSelectedValue();
				// run through the oceanObjects List
				for (int i = 0; i < OceanLifeController.getOcean().getOceanObjects().size(); i++) {
					// get the selected Object
					if (selection == OceanLifeController.getOcean().getOceanObjects().get(i)) {
						// try to delete it
						try {
							OceanLifeController.getOcean().removeOceanObject(i);
							int index = OceanLifeController.getGui().getjListObjects().getSelectedIndex();
							// synchronize the whole jListObjects with the oceanObjectsList
							OceanLifeController.getGui().getjListObjects().setListData(OceanLifeController.getOcean().getOceanObjects().toArray());

							if (index >= OceanLifeController.getOcean().getOceanObjects().size()) {
								// change the selected index of the jListObject to -1 (one up)
								index = OceanLifeController.getOcean().getOceanObjects().size() - 1;
							}
							OceanLifeController.getGui().getjListObjects().setSelectedIndex(index);
							System.out.println("Removed " + selection);
						} catch (Exception ex) {
							// Warn user that Object does not exists
							final JOptionPane optionPane = new JOptionPane();
							JOptionPane.showMessageDialog(optionPane, "Object not found", "ERROR", JOptionPane.WARNING_MESSAGE);
						}
						// object was found, so we can leave the for loop
						break;
					}
				}
			}
		}
	}

	/**
	 * handle the pressed clearButton doing computing synchronized
	 */
	@SuppressWarnings("unchecked")
	private void handleClearButton() {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {
				if (OceanLifeController.getOcean().getOceanObjects().size() == 0) {
					final JOptionPane optionPane = new JOptionPane();
					JOptionPane.showMessageDialog(optionPane, "There is no Object in the Ocean to clear", "Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// reset the LinkedList oceanObjects
					OceanLifeController.getOcean().getOceanObjects().clear();
					// reset the jListObjects
					OceanLifeController.getGui().getjListObjects().setListData(new Object[0]);
					System.out.println("Ocean was cleaned .....");
				}
			}
		}
	}

	/**
	 * handle pressed deselectButton (synchronized)
	 */
	private void handleDeselectButton() {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {
				// call function to set all border flags to false
				OceanLifeController.getHandler().resetBorders();
				// reset lists selection
				OceanLifeController.getGui().getjListObjects().clearSelection();
			}
		}
	}

	/**
	 * handle clicks on the oceanGraphic (synchronized) Set the Border for an OceanObject which was clicked
	 * 
	 * @param x
	 *            x-position of mouse click
	 * @param y
	 *            y-position of mouse click
	 */
	private void handleOceanGraphic(int x, int y) {
		synchronized (OceanLifeController.getOcean()) {
			synchronized (OceanLifeController.getGui().getjListObjects()) {
				// get closest oceanObject
				int index = OceanLifeController.getOcean().getClosestIndex(x, y);
				// if computing closest index was successful
				if (index >= 0) {
					// first clear all border flags
					OceanLifeController.getHandler().resetBorders();
					// and set the border flag of the closest object
					OceanLifeController.getOcean().getOceanObjects().get(index).setBorder(true);
					// and select the according value in the jListObjects list
					OceanLifeController.getGui().getjListObjects()
							.setSelectedValue(OceanLifeController.getOcean().getOceanObjects().get(index), true);
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked" })
	/**
	 * handle pressed loadButton
	 * tries to load another ocean and set everything according
	 * (synchronized)
	 */
	private void handleLoadButton() {
		// bring up a file chooser
		final JFileChooser chooser = new JFileChooser();
		// allow only .ocean files
		chooser.setFileFilter(fileFilter);
		// set opening path to directory where this application runs
		chooser.setCurrentDirectory(new File("."));
		// get the state of selection
		int selection = chooser.showOpenDialog(OceanLifeController.getGui());
		// if users approves his selection
		if (selection == JFileChooser.APPROVE_OPTION) {
			try {
				// open new FIle stream from the selected file
				FileInputStream is = new FileInputStream(chooser.getSelectedFile());
				// create new object stream with this stream
				ObjectInputStream ois = new ObjectInputStream(is);

				// read the new Ocean
				Ocean newOcean = (Ocean) ois.readObject();
				synchronized (OceanLifeController.getOcean()) {
					synchronized (OceanLifeController.getGui().getjListObjects()) {
						// change the current ocean
						OceanLifeController.setOcean(newOcean);

						// set up the new jListObjects
						LinkedList<OceanObject> objects = OceanLifeController.getOcean().getOceanObjects();
						OceanLifeController.getGui().getjListObjects().setListData(objects.toArray());
						// set the correct selected object if there is any
						for (int i = 0; i < objects.size(); i++) {
							if (objects.get(i).getBorder()) {
								OceanLifeController.getGui().getjListObjects().setSelectedValue(objects.get(i), true);
								break;
							}
						}
					}
				}
				// close the stream
				ois.close();

				System.out.println("Succesfully loaded .....");
				// Inform user about success
				final JOptionPane optionPane = new JOptionPane();
				JOptionPane.showMessageDialog(optionPane, "Successfully loaded ocean.", "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				// inform user if there was a error reading form the file
				final JOptionPane optionPane = new JOptionPane();
				JOptionPane.showMessageDialog(optionPane, "Could not deserialize selection.\n" + "Please choose a correct File!\n", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * handle pressed SaveButton saves the current state of the ocean in .ocean file (synchronized)
	 */
	private void handleSaveButton() {

		// Create FileChooser
		final JFileChooser chooser = new JFileChooser();
		// set opening path to directory where this application runs
		chooser.setCurrentDirectory(new File("."));
		// get the state of selection
		int selection = chooser.showSaveDialog(OceanLifeController.getGui());
		if (selection == JFileChooser.APPROVE_OPTION) {
			try {
				// make sure the File ends with .ocean
				File selectedFile = chooser.getSelectedFile();
				if (!selectedFile.getAbsolutePath().endsWith(".ocean")) {
					selectedFile = new File(selectedFile.getAbsolutePath() + ".ocean");
				}
				// open File Stream
				FileOutputStream os = new FileOutputStream(selectedFile);

				// open Object Stream
				ObjectOutputStream oos = new ObjectOutputStream(os);

				// write ocean into file
				oos.writeObject(OceanLifeController.getOcean());

				// Close the Stream
				oos.close();

				System.out.println("Successfully saved .....");
				// inform the user about success
				final JOptionPane op = new JOptionPane();
				JOptionPane.showMessageDialog(op, "Successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// save was not successful
				final JOptionPane op = new JOptionPane();
				JOptionPane.showMessageDialog(op, "Could not be saved!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Opens a Message Dialog which gives informations about the Ocean
	 */
	private void handleInfoButton() {
		String info = "                                 <<< OceanLife Rules >>>\n\n" + "The Input in the X-Textfield has to be between 0 - 1610\n"
				+ "The Input in the Y-Textfield has to be between 0 - 1020\n" + "Too small values will be set to 0\n"
				+ "Too big values will be set to the corresponding maximum value\n" + "Otherwise the values will be set automaticlly to 0\n\n"
				+ "In the Spinner there are only number between 1 and 15 allowed\n"
				+ "After adding Objects into the Ocean the value of the Spinner will be set to 1\n\n"
				+ "There 8 Fish species. The shark eats all fishes expect a specie\n\n" + "\nOceanLife Project by \nYINGYANG CODING\n";
		final JOptionPane optionPane = new JOptionPane();
		JOptionPane.showMessageDialog(optionPane, info, "Rules of the Ocean", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Things to do when the quit button was pressed
	 **/
	private void handleQuitButton() {
		int result = JOptionPane.showConfirmDialog(null, "Close the OceanLife?", "Exit", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			System.out.println("Programm closed successfully");
			System.exit(0);
		}
	}

	/**
	 * If the calcThread is running we stop it otherwise we just perform a single move of all objects
	 */
	private void handleStepButton() {
		if (OceanLifeController.getOcean().getOceanObjects().isEmpty()) {
			// check if the Ocean is empty
			System.out.println("Failed to Step because Ocean is empty .....");
			final JOptionPane optionPane = new JOptionPane();
			JOptionPane.showMessageDialog(optionPane, "There is no Object in the Ocean to move.", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// terminate the Thread for stepping
		if (OceanLifeController.getCalcThread().getState() != Thread.State.TERMINATED) {
			OceanLifeController.getCalcThread().terminate();
			System.out.println("Thread terminated to Step.");
			OceanLifeController.getCalcThread().run();
		} else {
			OceanLifeController.getCalcThread().run();
			System.out.println("Stepping ....");
		}
	}
}
