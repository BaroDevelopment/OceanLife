package infpp.oceanlife.View;

import infpp.oceanlife.Controller.OceanLifeController;

import java.awt.*;
import java.util.Hashtable;
import javax.swing.*;

/**
 * GUI of the OceanLife
 *
 * @author Baris Simonjan, Etienne Violet
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class OceanLifeGui extends JFrame {

	// /////////////////////////////////////////////////////////
	// /// Declaration / Initialization of attributes //////////
	// ////////////////////////////////////////////////////////

	/**
	 * CellRenderer for the jListObjects
	 */
	private OceanCellRenderer cellRenderer = new OceanCellRenderer();

	/**
	 * jSpinner for the count of objects
	 */
	private JSpinner jSpinnerCount;

	/**
	 * CheckBox to add random coordinates
	 */
	private JCheckBox checkboxRandCoord;

	/**
	 * CheckBox to add random Object
	 */
	private JCheckBox checkboxRandObj;

	/**
	 * Add Button
	 */
	private JButton jButtonAdd;

	/**
	 * Clear Button
	 */
	private JButton jButtonClear;

	/**
	 * Deselect Button
	 */
	private JButton jButtonDeselect;

	/**
	 * Information Button
	 */
	private JButton jButtonInfo;

	/**
	 * Load Button
	 */
	private JButton jButtonLoad;

	/**
	 * Quit Button
	 */
	private JButton jButtonQuit;

	/**
	 * Remove Button
	 */
	private JButton jButtonRemove;

	/**
	 * Save Button
	 */
	private JButton jButtonSave;

	/**
	 * Start Button
	 */
	private JButton jButtonStart;

	/**
	 * Step Button
	 */
	private JButton jButtonStep;

	/**
	 * Stop Button
	 */
	private JButton jButtonStop;

	/**
	 * ComboBox to add objects into the ocean
	 */
	private JComboBox jComboBoxAdd;

	/**
	 * "ADD" Label
	 */
	private JLabel jLabelAdd;

	/**
	 * "Objects in the Ocean" Label
	 */
	private JLabel jLabelList;

	/**
	 * "Menu Panel" Label
	 */
	private JLabel jLabelMenuPanel;

	/**
	 * "Option Panel" Label
	 */
	private JLabel jLabelOceanControl;

	/**
	 * "Remove Options" Label
	 */
	private JLabel jLabelRemove;

	/**
	 * "X" Label for the TextField
	 */
	private JLabel jLabelX;

	/**
	 * "Y" Label for the TextField
	 */
	private JLabel jLabelY;

	/**
	 * JList where the Objects are in
	 */
	private JList jListObjects;

	/**
	 * Panel of the Ocean
	 */
	private JPanel jPanelOcean;

	/**
	 * ScrollPane for the jListObjects
	 */
	private JScrollPane jScrollPane1;

	/**
	 * Slider for the X Textfield
	 */
	private JSlider jSliderX;

	/**
	 * Slider for the X Textfield
	 */
	private JSlider jSliderY;

	/**
	 * Textfield for the x-coordinate
	 */
	private JTextField jTextFieldX;

	/**
	 * Textfield for the y-coordination
	 */
	private JTextField jTextFieldY;

	/**
	 * SpeedSlider
	 */
	private JSlider jSliderSpeed;

	/**
	 * Label for the jSpeedSlider with the text: "Speed"
	 */
	private JLabel jLabelSpeed;

	// /////////////////////////////////////////////////////////
	// ////////////////// Getter and Setter ///////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Getter for jSpinnerCount
	 * 
	 * @return jSpinnerCount
	 */
	public JSpinner getJSpinnerCount() {
		return jSpinnerCount;
	}

	/**
	 * Getter for checkboxRandCoord
	 * 
	 * @return the checkboxRandCoord
	 */
	public JCheckBox getCheckboxRandCoord() {
		return checkboxRandCoord;
	}

	/**
	 * Getter for checkboxRandObj
	 * 
	 * @return the checkboxRandObj
	 */
	public JCheckBox getCheckboxRandObj() {
		return checkboxRandObj;
	}

	/**
	 * Getter for the jSliderSpeed
	 * 
	 * @return the jSliderSpeed
	 */
	public JSlider getjSliderSpeed() {
		return jSliderSpeed;
	}

	/**
	 * Getter for jListObjects
	 * 
	 * @return the jListObjects
	 */
	public JList getjListObjects() {
		return jListObjects;
	}

	/**
	 * Setter for jListObjects
	 * 
	 * @param jListObjects
	 *            the removelist (JList)
	 */
	public void setjListObjects(JList jListObjects) {
		this.jListObjects = jListObjects;
	}

	/**
	 * Getter for jButtonAdd
	 * 
	 * @return the jButtonAdd
	 */
	public JButton getjButtonAdd() {
		return jButtonAdd;
	}

	/**
	 * Getter for jButtonClear
	 * 
	 * @return the jButtonClear
	 */
	public JButton getjButtonClear() {
		return jButtonClear;
	}

	/**
	 * Getter for jButtonDeselect
	 * 
	 * @return the jButtonDeselect
	 */
	public JButton getjButtonDeselect() {
		return jButtonDeselect;
	}

	/**
	 * Getter for jButtonInfo
	 * 
	 * @return the jButtonInfo
	 */
	public JButton getjButtonInfo() {
		return jButtonInfo;
	}

	/**
	 * Getter for jButtonLoad
	 * 
	 * @return the jButtonLoad
	 */
	public JButton getjButtonLoad() {
		return jButtonLoad;
	}

	/**
	 * Getter for the jButtonQuit
	 * 
	 * @return the jButtonQuit
	 */
	public JButton getjButtonQuit() {
		return jButtonQuit;
	}

	/**
	 * Getter for the jButtonRemove
	 * 
	 * @return the jButtonRemove
	 */
	public JButton getjButtonRemove() {
		return jButtonRemove;
	}

	/**
	 * Getter for jButtonSave
	 * 
	 * @return the jButtonSave
	 */
	public JButton getjButtonSave() {
		return jButtonSave;
	}

	/**
	 * Getter for jButtonStart
	 * 
	 * @return the jButtonStart
	 */
	public JButton getjButtonStart() {
		return jButtonStart;
	}

	/**
	 * Getter for jButtonStep
	 * 
	 * @return the jButtonStep
	 */
	public JButton getjButtonStep() {
		return jButtonStep;
	}

	/**
	 * Getter for jButtonStop
	 * 
	 * @return the jButtonStop
	 */
	public JButton getjButtonStop() {
		return jButtonStop;
	}

	/**
	 * Getter for jSliderX
	 * 
	 * @return the jSliderX
	 */
	public JSlider getjSliderX() {
		return jSliderX;
	}

	/**
	 * Getter for jSliderY
	 * 
	 * @return the jSliderY
	 */
	public JSlider getjSliderY() {
		return jSliderY;
	}

	/**
	 * Getter for jTextFieldX
	 * 
	 * @return the jTextFieldX
	 */
	public JTextField getjTextFieldX() {
		return jTextFieldX;
	}

	/**
	 * Getter for jTextFieldY
	 * 
	 * @return the jTextFieldY
	 */
	public JTextField getjTextFieldY() {
		return jTextFieldY;
	}

	/**
	 * Getter for jComboBoxAdd
	 * 
	 * @return the jComboBoxAdd
	 */
	public JComboBox getjComboBoxAdd() {
		return jComboBoxAdd;
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Constructor ///////////////////////////
	// ////////////////////////////////////////////////////////

	/**
	 * Constructor for OceanLifeGui. It initialize all components of the GUI
	 */
	public OceanLifeGui() {
		initComponents();
	}

	// /////////////////////////////////////////////////////////
	// ///////////////// Methods//// ///////////////////////////
	// /////////////////////////////////////////////////////////

	/**
	 * Initialize all GUI components
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		// add the mouseListener to the OceanGraphic
		OceanLifeController.getOceanGraphic().addMouseListener(OceanLifeController.getHandler().getMouseListener());

		// initialize all the Buttons of the GUI
		jButtonAdd = new JButton();
		jButtonAdd.setBackground(Color.gray);
		jButtonAdd.setForeground(Color.WHITE);
		jButtonAdd.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonClear = new JButton();
		jButtonClear.setBackground(Color.gray);
		jButtonClear.setForeground(Color.WHITE);
		jButtonClear.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonDeselect = new JButton();
		jButtonDeselect.setBackground(Color.gray);
		jButtonDeselect.setForeground(Color.WHITE);
		jButtonDeselect.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonStart = new JButton();
		jButtonStart.setBackground(Color.gray);
		jButtonStart.setForeground(Color.WHITE);
		jButtonStart.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonStop = new JButton();
		jButtonStop.setBackground(Color.gray);
		jButtonStop.setForeground(Color.WHITE);
		jButtonStop.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonQuit = new JButton();
		jButtonQuit.setBackground(Color.gray);
		jButtonQuit.setForeground(Color.WHITE);
		jButtonQuit.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonInfo = new JButton();
		jButtonInfo.setBackground(Color.gray);
		jButtonInfo.setForeground(Color.WHITE);
		jButtonInfo.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonRemove = new JButton();
		jButtonRemove.setBackground(Color.gray);
		jButtonRemove.setForeground(Color.WHITE);
		jButtonRemove.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonSave = new JButton();
		jButtonSave.setBackground(Color.gray);
		jButtonSave.setForeground(Color.WHITE);
		jButtonSave.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonLoad = new JButton();
		jButtonLoad.setBackground(Color.gray);
		jButtonLoad.setForeground(Color.WHITE);
		jButtonLoad.addMouseListener(OceanLifeController.getHandler().getMouseListener());
		jButtonStep = new JButton();
		jButtonStep.setBackground(Color.gray);
		jButtonStep.setForeground(Color.WHITE);
		jButtonStep.addMouseListener(OceanLifeController.getHandler().getMouseListener());

		// initializing all Textfields
		jTextFieldX = new JTextField("0");
		jTextFieldX.setBackground(Color.DARK_GRAY);
		jTextFieldX.setForeground(new Color(255, 255, 255));
		jTextFieldX.addFocusListener(OceanLifeController.getHandler().getFocusListener());

		jTextFieldY = new JTextField("0");
		jTextFieldY.setBackground(Color.DARK_GRAY);
		jTextFieldY.setForeground(new Color(255, 255, 255));
		jTextFieldY.addFocusListener(OceanLifeController.getHandler().getFocusListener());

		// initializing all JLabels
		jLabelSpeed = new JLabel();
		jLabelSpeed.setForeground(new Color(255, 255, 255));
		jLabelList = new JLabel();
		jLabelList.setForeground(new Color(255, 255, 255));
		jLabelOceanControl = new JLabel();
		jLabelOceanControl.setForeground(new Color(255, 255, 255));
		jLabelAdd = new JLabel();
		jLabelAdd.setForeground(new Color(255, 255, 255));
		jLabelX = new JLabel();
		jLabelX.setForeground(new Color(255, 255, 255));
		jLabelY = new JLabel();
		jLabelY.setForeground(new Color(255, 255, 255));
		jLabelRemove = new JLabel();
		jLabelRemove.setForeground(new Color(255, 255, 255));
		jLabelMenuPanel = new JLabel();
		jLabelMenuPanel.setForeground(new Color(255, 255, 255));

		// initializing all sliders
		jSliderX = new JSlider(JSlider.HORIZONTAL, 0, OceanLifeController.getOcean().getWidth(), 0);
		jSliderX.setBackground(Color.DARK_GRAY);
		jSliderX.addChangeListener(OceanLifeController.getHandler().getSlideListener());
		jSliderX.setMajorTickSpacing(50);
		jSliderX.setSnapToTicks(true);

		jSliderY = new JSlider(JSlider.HORIZONTAL, 0, OceanLifeController.getOcean().getDepth(), 0);
		jSliderY.setBackground(Color.DARK_GRAY);
		jSliderY.addChangeListener(OceanLifeController.getHandler().getSlideListener());
		jSliderY.setMajorTickSpacing(50);
		jSliderY.setSnapToTicks(true);

		// initializing the jSliderSpeed
		jSliderSpeed = new JSlider();
		jSliderSpeed.setBackground(Color.DARK_GRAY);
		jSliderSpeed.setValue(125);
		jSliderSpeed.setMajorTickSpacing(25);
		jSliderSpeed.setMaximum(250);
		jSliderSpeed.setMinimum(10);
		jSliderSpeed.setPaintTicks(true);
		jSliderSpeed.setSnapToTicks(true);

		// initializing the checkbox for random coordination
		checkboxRandCoord = new JCheckBox();
		checkboxRandCoord.setForeground(new Color(255, 255, 255));
		checkboxRandCoord.setBackground(Color.DARK_GRAY);

		// initializing the checkbox for random coordination
		checkboxRandObj = new JCheckBox();
		checkboxRandObj.setForeground(new Color(255, 255, 255));
		checkboxRandObj.setBackground(Color.DARK_GRAY);

		// Create label table
		Hashtable labelTable = new Hashtable();

		JLabel slow = new JLabel("Slow");
		slow.setForeground(new Color(255, 255, 255));
		slow.setFont(new Font("Arial", 1, 13));

		JLabel defaul = new JLabel("Default");
		defaul.setForeground(new Color(255, 255, 255));

		JLabel fast = new JLabel("Fast");
		fast.setForeground(new Color(255, 255, 255));
		fast.setFont(new Font("Arial", 1, 13));

		labelTable.put(new Integer(30), slow);
		labelTable.put(new Integer(120), defaul);
		labelTable.put(new Integer(230), fast);
		jSliderSpeed.setLabelTable(labelTable);
		jSliderSpeed.setPaintLabels(true);
		jSliderSpeed.addChangeListener(OceanLifeController.getHandler().getSlideListener());

		// initializing the jSpinnerCount
		jSpinnerCount = new JSpinner();
		jSpinnerCount.setForeground(new Color(255, 255, 255));
		jSpinnerCount.setBackground(Color.LIGHT_GRAY);
		jSpinnerCount.setValue(1);

		// set the color of the Panel
		this.getContentPane().setBackground(Color.DARK_GRAY);
		// set the Title of the Frame
		this.setTitle("Ocean Life Pure");
		// Quit the Program when the user close it
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// start the JFRAME in full screen mode
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		/*
		 * initializing the jList set up the list with removable ocean objects
		 */
		jListObjects = new JList(new DefaultListModel());
		jListObjects.addListSelectionListener(OceanLifeController.getHandler().getListSelectionListener());
		jListObjects.setBackground(Color.DARK_GRAY);
		jListObjects.setSelectionBackground(new Color(206, 206, 206));
		jListObjects.setSelectionForeground(new Color(255, 255, 255));
		jListObjects.setCellRenderer(cellRenderer);
		jListObjects.setListData(OceanLifeController.getOcean().getOceanObjects().toArray());
		jListObjects.setLayoutOrientation(JList.VERTICAL);
		jListObjects.setVisibleRowCount(JList.VERTICAL);

		jPanelOcean = new JPanel();
		jScrollPane1 = new JScrollPane();

		// initializing the jComboBox
		jComboBoxAdd = new JComboBox();
		jComboBoxAdd.setBackground(Color.DARK_GRAY);
		jComboBoxAdd.setForeground(new Color(255, 255, 255));

		GroupLayout jPanelOceanLayout = new GroupLayout(jPanelOcean);
		jPanelOcean.setLayout(jPanelOceanLayout);
		jPanelOceanLayout.setHorizontalGroup(jPanelOceanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 883, Short.MAX_VALUE)
		// add ocean graphic
				.addComponent(OceanLifeController.getOceanGraphic()));
		jPanelOceanLayout.setVerticalGroup(jPanelOceanLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 696, Short.MAX_VALUE)
		// add ocean graphic
				.addComponent(OceanLifeController.getOceanGraphic()));

		jComboBoxAdd.setModel(new DefaultComboBoxModel(new String[] { "Fish", "Bubble", "Plant", "Stone", "Shark" }));

		jLabelAdd.setFont(new Font("Comic Sans MS", 1, 16));
		jLabelAdd.setText("ADD OPTIONS");

		jLabelX.setText("X");

		jLabelY.setText("Y");

		jLabelRemove.setFont(new Font("Comic Sans MS", 1, 15));
		jLabelRemove.setText("REMOVE OPTIONS");

		jScrollPane1.setViewportView(jListObjects);

		jLabelList.setFont(new Font("Tahoma", 1, 12));
		jLabelList.setText("Objects in the Ocean");

		jButtonRemove.setText("Remove");
		jButtonRemove.setFont(new Font("Arial", 1, 13));

		jButtonClear.setText("Clear");
		jButtonClear.setFont(new Font("Arial", 1, 13));

		jButtonDeselect.setText("Deselect");

		jLabelOceanControl.setFont(new Font("Arial", 1, 17));
		jLabelOceanControl.setText("Ocean Control");

		jButtonLoad.setText("Load");
		jButtonLoad.setFont(new Font("Arial", 1, 13));

		jButtonStep.setText("Step");
		jButtonStep.setFont(new Font("Arial", 1, 13));

		jButtonSave.setText("Save");
		jButtonSave.setFont(new Font("Arial", 1, 13));

		jButtonStart.setText("Start");
		jButtonStart.setFont(new Font("Arial", 1, 13));

		jButtonStop.setText("Stop");
		jButtonStop.setFont(new Font("Arial", 1, 13));

		jButtonQuit.setText("Quit");
		jButtonQuit.setFont(new Font("Arial", 1, 13));

		jButtonAdd.setText("Add Object");
		jButtonAdd.setFont(new Font("Arial", 1, 13));

		jLabelSpeed.setText("Speed");

		jButtonInfo.setText("Information");
		jButtonInfo.setFont(new Font("Arial", 1, 13));

		checkboxRandCoord.setText("Random Coordinates");
		checkboxRandObj.setText("Random Object");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanelOcean, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup().addGap(105, 105, 105).addComponent(jLabelAdd)
																.addGap(80, 80, 80))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addGroup(
																														GroupLayout.Alignment.TRAILING,
																														layout.createSequentialGroup()
																																.addComponent(
																																		jLabelRemove)
																																.addGap(98, 98, 98))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGroup(
																																		layout.createParallelGroup(
																																				GroupLayout.Alignment.LEADING,
																																				false)
																																				.addGroup(
																																						layout.createParallelGroup(
																																								GroupLayout.Alignment.LEADING)
																																								.addGroup(
																																										GroupLayout.Alignment.TRAILING,
																																										layout.createSequentialGroup()
																																												.addGap(0,
																																														0,
																																														Short.MAX_VALUE)
																																												.addGroup(
																																														layout.createParallelGroup(
																																																GroupLayout.Alignment.LEADING)
																																																.addGroup(
																																																		layout.createSequentialGroup()
																																																				.addComponent(
																																																						jButtonStart,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						70,
																																																						GroupLayout.PREFERRED_SIZE)
																																																				.addPreferredGap(
																																																						LayoutStyle.ComponentPlacement.UNRELATED)
																																																				.addComponent(
																																																						jButtonStop,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						70,
																																																						GroupLayout.PREFERRED_SIZE)
																																																				.addGap(10,
																																																						10,
																																																						10)
																																																				.addComponent(
																																																						jButtonQuit,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						70,
																																																						GroupLayout.PREFERRED_SIZE))
																																																.addGroup(
																																																		layout.createParallelGroup(
																																																				GroupLayout.Alignment.TRAILING,
																																																				false)
																																																				.addComponent(
																																																						jButtonInfo,
																																																						GroupLayout.Alignment.LEADING,
																																																						GroupLayout.DEFAULT_SIZE,
																																																						GroupLayout.DEFAULT_SIZE,
																																																						Short.MAX_VALUE)
																																																				.addGroup(
																																																						layout.createSequentialGroup()
																																																								.addComponent(
																																																										jButtonSave,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										70,
																																																										GroupLayout.PREFERRED_SIZE)
																																																								.addPreferredGap(
																																																										LayoutStyle.ComponentPlacement.UNRELATED)
																																																								.addComponent(
																																																										jButtonLoad,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										70,
																																																										GroupLayout.PREFERRED_SIZE)
																																																								.addPreferredGap(
																																																										LayoutStyle.ComponentPlacement.RELATED)
																																																								.addComponent(
																																																										jButtonStep,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										70,
																																																										GroupLayout.PREFERRED_SIZE))
																																																				.addComponent(
																																																						jSliderSpeed,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						GroupLayout.DEFAULT_SIZE,
																																																						GroupLayout.PREFERRED_SIZE))))
																																								.addGroup(
																																										layout.createSequentialGroup()
																																												.addGroup(
																																														layout.createParallelGroup(
																																																GroupLayout.Alignment.LEADING)
																																																.addGroup(
																																																		layout.createSequentialGroup()
																																																				.addGroup(
																																																						layout.createParallelGroup(
																																																								GroupLayout.Alignment.LEADING)
																																																								.addComponent(
																																																										jScrollPane1,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										131,
																																																										GroupLayout.PREFERRED_SIZE)
																																																								.addGroup(
																																																										layout.createSequentialGroup()
																																																												.addGap(9,
																																																														9,
																																																														9)
																																																												.addComponent(
																																																														jLabelList)))
																																																				.addGap(18,
																																																						18,
																																																						18)
																																																				.addGroup(
																																																						layout.createParallelGroup(
																																																								GroupLayout.Alignment.LEADING,
																																																								false)
																																																								.addComponent(
																																																										jButtonRemove,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										109,
																																																										GroupLayout.PREFERRED_SIZE)
																																																								.addComponent(
																																																										jButtonClear,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										109,
																																																										GroupLayout.PREFERRED_SIZE)
																																																								.addComponent(
																																																										jButtonDeselect,
																																																										GroupLayout.PREFERRED_SIZE,
																																																										109,
																																																										GroupLayout.PREFERRED_SIZE)))
																																																.addGroup(
																																																		layout.createSequentialGroup()
																																																				.addComponent(
																																																						jLabelX)
																																																				.addGap(6,
																																																						6,
																																																						6)
																																																				.addComponent(
																																																						jTextFieldX,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						92,
																																																						GroupLayout.PREFERRED_SIZE)
																																																				.addGap(10,
																																																						10,
																																																						10)
																																																				.addComponent(
																																																						jLabelY)
																																																				.addPreferredGap(
																																																						LayoutStyle.ComponentPlacement.UNRELATED)
																																																				.addComponent(
																																																						jTextFieldY,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						94,
																																																						GroupLayout.PREFERRED_SIZE))
																																																.addGroup(
																																																		layout.createSequentialGroup()
																																																				.addComponent(
																																																						jComboBoxAdd,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						174,
																																																						GroupLayout.PREFERRED_SIZE)
																																																				.addPreferredGap(
																																																						LayoutStyle.ComponentPlacement.RELATED)
																																																				.addComponent(
																																																						jSpinnerCount,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						43,
																																																						GroupLayout.PREFERRED_SIZE))
																																																.addGroup(
																																																		layout.createSequentialGroup()
																																																				.addGap(8,
																																																						8,
																																																						8)
																																																				.addComponent(
																																																						jSliderX,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						94,
																																																						GroupLayout.PREFERRED_SIZE)
																																																				.addGap(28,
																																																						28,
																																																						28)
																																																				.addComponent(
																																																						jSliderY,
																																																						GroupLayout.PREFERRED_SIZE,
																																																						94,
																																																						GroupLayout.PREFERRED_SIZE))
																																																.addComponent(
																																																		jButtonAdd,
																																																		GroupLayout.PREFERRED_SIZE,
																																																		250,
																																																		GroupLayout.PREFERRED_SIZE))
																																												.addGap(0,
																																														0,
																																														Short.MAX_VALUE)))
																																				.addGroup(
																																						layout.createSequentialGroup()
																																								.addComponent(
																																										checkboxRandCoord,
																																										GroupLayout.PREFERRED_SIZE,
																																										GroupLayout.DEFAULT_SIZE,
																																										GroupLayout.PREFERRED_SIZE)
																																								.addPreferredGap(
																																										LayoutStyle.ComponentPlacement.RELATED)
																																								.addComponent(
																																										checkboxRandObj,
																																										GroupLayout.PREFERRED_SIZE,
																																										GroupLayout.DEFAULT_SIZE,
																																										GroupLayout.PREFERRED_SIZE)))
																																.addGap(4, 4, 4)))
																								.addGroup(
																										GroupLayout.Alignment.TRAILING,
																										layout.createSequentialGroup()
																												.addComponent(jLabelOceanControl,
																														GroupLayout.PREFERRED_SIZE,
																														120,
																														GroupLayout.PREFERRED_SIZE)
																												.addGap(84, 84, 84)))
																				.addGroup(
																						GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup().addComponent(jLabelSpeed)
																								.addGap(122, 122, 122)))))));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jPanelOcean, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabelAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jComboBoxAdd, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(jSpinnerCount, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(jLabelX)
																.addComponent(jLabelY)
																.addComponent(jTextFieldY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
												.addComponent(jTextFieldX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(jSliderX, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
												.addComponent(jSliderY, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButtonAdd)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(checkboxRandObj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(checkboxRandCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelRemove, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabelList)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup().addComponent(jButtonRemove).addGap(18, 18, 18)
																.addComponent(jButtonClear).addGap(18, 18, 18).addComponent(jButtonDeselect))
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelOceanControl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(3, 3, 3)
								.addComponent(jLabelSpeed)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jSliderSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jButtonInfo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGap(13, 13, 13)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonLoad, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonStep, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonSave, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGap(21, 21, 21)
								.addGroup(
										layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonStart, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonStop, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonQuit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
	}// </editor-fold>
}
