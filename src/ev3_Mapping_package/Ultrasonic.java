package ev3_Mapping_package;

import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;

public class Ultrasonic extends AbstractFilter {
	
	float[] sample;
	
	public Ultrasonic(SampleProvider source){
		super(source);
		sample = new float[source.sampleSize()];
	}
	
	//Everytime we call distance() it will fetch a distance
	//from the Ultrasonic sensor and return it for us.
	public float distance(){
		super.fetchSample(sample, 0);
		return sample[0];
	}

}
