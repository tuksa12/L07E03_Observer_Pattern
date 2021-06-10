package de.tum.in.ase.eist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KelvinGUI extends TemperatureGUI{

    public KelvinGUI(TemperatureModel model, Point location) {
        super("Celsius Temperature", model, location);
        addRaiseTempListener(new KelvinGUI.RaiseTempListener());
        addLowerTempListener(new KelvinGUI.LowerTempListener());
        addDisplayListener(new KelvinGUI.DisplayListener());
    }


    //TODO: 1.4.1: Implement onUpdate: Invoke the method setDisplay() with the new value converted to a String

    @Override
    public void onUpdate(Double newState) {
        Double kelvin = TemperatureConverter.convertCelsiusToKelvin(newState);
        setDisplay(kelvin.toString());
    }

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
