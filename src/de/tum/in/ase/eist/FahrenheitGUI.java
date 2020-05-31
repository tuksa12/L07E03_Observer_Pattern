package de.tum.in.ase.eist;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FahrenheitGUI extends TemperatureGUI {

	public FahrenheitGUI(TemperatureModel model, Point location) {
		super("Fahrenheit Temperature", model, location);
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}

	// TODO 1.4.2: implement the update method of Observer: invoke setDisplay(...) using the Fahrenheit value by
	// converting the Celsius value using TemperatureConverter and the converting this Fahrenheit value to a string

	class RaiseTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseF(1.0);
		}
	}

	class LowerTempListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getModel().increaseF(-1.0);
		}
	}

	class DisplayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			double value = getDisplay();
			getModel().setF(value);
		}
	}
}
