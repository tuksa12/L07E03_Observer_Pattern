package de.tum.in.ase.eist;

import javax.swing.*;
import java.awt.*;

public final class TemperatureApplication {

	private TemperatureApplication() {
		// Private constructor because a utility class should not be instantiable.
	}

	//TODO Part 0: Before you start coding have a look at the project to create an overview & understanding how it works
	//TODO Part 2: Create a new class KelvinGUI as subclass to TemperatureGUI and as an observer to the TemperatureModel.

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		TemperatureModel temperature = new TemperatureModel();

		FahrenheitGUI fahrenheitGUI = new FahrenheitGUI(temperature, new Point(100, 100));
		fahrenheitGUI.show();

		CelsiusGUI celsiusGUI = new CelsiusGUI(temperature, new Point(100, 250));
		celsiusGUI.show();

		SliderGUI sliderGUI = new SliderGUI(temperature, new Point(20, 100));
		sliderGUI.show();

		GaugeGUI gaugeGUI = new GaugeGUI(temperature, new Point(200, 200));
		gaugeGUI.show();

		//TODO Part 2: Instantiate the new KelvinGUI here and show it.
	}
}
