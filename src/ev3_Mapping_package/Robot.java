package ev3_Mapping_package;

public class Robot {
	
	double distanceWheels;
	double wheelDiamenter;
	double wheelCircumference;
	double spinCircumference;
	double fullSpinWheelTacho;

	public Robot(double wheelDiameter, double distanceWheels){
		this.wheelDiamenter = wheelDiameter;
		this.distanceWheels = distanceWheels;
		this.wheelCircumference = (2 * Math.PI * wheelDiameter / 2);
		this.spinCircumference = (2 * Math.PI * distanceWheels / 2);
		this.fullSpinWheelTacho = ((spinCircumference / wheelCircumference) * 360);
	}
	
	public double wheelCircumference(){
		return wheelCircumference;
	}

	public double spinCircumference(){
		return spinCircumference;
	}

	public double fullSpinWheelTacho(){
		return fullSpinWheelTacho;
	}
	
}
