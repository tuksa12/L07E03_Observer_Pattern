package de.tum.in.ase.eist;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusGUI extends TemperatureGUI {

	public CelsiusGUI(TemperatureModel model, Point location) {
		super("Celsius Temperature", model, location);
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}

	//TODO: 1.4.1: Implement onUpdate: Invoke the method setDisplay() with the new value converted to a String

	class RaiseTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseC(1.0);
		}
	}

	class LowerTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseC(-1.0);
		}
	}

	class DisplayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			double value = getDisplay();
			getModel().setC(value);
		}
	}
}