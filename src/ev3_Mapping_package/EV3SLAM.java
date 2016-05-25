package ev3_Mapping_package;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class EV3SLAM {

	// Global Variables
	DifferentialPilot pilot;
	Ultrasonic ultrasonic;
	private EV3UltrasonicSensor us;
	ArrayList<Float> environmentCoordinates = new ArrayList<Float>();

	/*
	 * 
	 * This program requires Java1.7 and leJOS_EV3_0.9.0-beta
	 * 
	 * pilot = new DifferentialPilot(4.2f, 11.5f, Motor.B, Motor.C);
	 * 
	 * Sets up the Differential pilot with the values: - double Wheel diameter -
	 * double Distance between the center of the tires - RegulatedMotor
	 * leftMotor - RegulatedMotor rightMotor
	 * 
	 * One full turn of a wheel results in a distance traveled of 13.195 cm (2 *
	 * PI * WheelRadius = 2 * PI * 2.1 = 13.195)
	 * 
	 * - Motor.C.resetTachoCount();
	 * - pilot.travel(13.195);
	 * - System.out.println(Motor.C.getTachoCount());
	 * Should print out: 360
	 * 
	 */

	public static void main(String[] args) throws Exception {
		// Initialization of the EV3SLAM Class
		new EV3SLAM();
	}

	public EV3SLAM() throws IOException {
		
		Robot robot = new Robot(4.2, 11.5); // parameters in cm
		pilot = new DifferentialPilot(4.2f, 11.5f, Motor.B, Motor.C); // parameters in cm
		
		EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S2);
		SampleProvider distanceMode = us.getDistanceMode();

		// We initialize an instance of our own Ultrasonic Class
		ultrasonic = new Ultrasonic(distanceMode);
		
		while ((Motor.C.getTachoCount()) < robot.fullSpinWheelTacho) {
			pilot.rotate(360 / 36);
			float distance = ultrasonic.distance();
			environmentCoordinates.add(distance);
		}

		pilot.stop();

		// We create a new instance of the SaveFile-Class
		// And we save all the measurement-coordinates to it.
		SaveFile save = new SaveFile();
		save.saveToFile("coordinates", environmentCoordinates);
	}

}
