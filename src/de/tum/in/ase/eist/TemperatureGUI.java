package de.tum.in.ase.eist;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO Part 1.5: implement Observer<Double>
public abstract class TemperatureGUI {

	private static final int BORDER_SIZE = 4;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 110;

	private final String label;
	private final TemperatureModel model;
	private JFrame temperatureFrame;
	protected JPanel controlPanel;
	protected JTextField display;
	protected JButton raiseTempButton;
	protected JButton lowerTempButton;
	private final Point location;

	public TemperatureGUI(String label, TemperatureModel model, Point location) {
		this.model = model;
		this.label = label;
		this.location = location;
		createUI();
		// TODO Part 1.6: add the object as observer to the subject
	}

	protected void createUI() {
		display = new JTextField();
		raiseTempButton = new JButton("Raise");
		lowerTempButton = new JButton("Lower");

		controlPanel = new JPanel(new BorderLayout());
		controlPanel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		controlPanel.add("North", new JLabel(label));
		controlPanel.add("Center", display);

		JPanel buttons = new JPanel();
		buttons.add(lowerTempButton);
		buttons.add(raiseTempButton);
		controlPanel.add("South", buttons);
	}

	public void show() {
		if (temperatureFrame == null) {
			temperatureFrame = new JFrame(label);
			temperatureFrame.add(controlPanel);
			temperatureFrame.addWindowListener(new CloseListener());
			temperatureFrame.setSize(WIDTH, HEIGHT);
			temperatureFrame.setLocation(location);
		}
		temperatureFrame.setVisible(true);
	}

	public void setDisplay(String string) {
		display.setText(string);
	}

	public double getDisplay() {
		try {
			return Double.parseDouble(display.getText());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}

	public void addDisplayListener(ActionListener listener) {
		display.addActionListener(listener);
	}

	public void addRaiseTempListener(ActionListener listener) {
		raiseTempButton.addActionListener(listener);
	}

	public void addLowerTempListener(ActionListener listener) {
		lowerTempButton.addActionListener(listener);
	}

	protected TemperatureModel getModel() {
		return model;
	}

	public static class CloseListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent event) {
			event.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}
