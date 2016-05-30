package ev3_Mapping_package;

public class Robot {
	
	private double distanceWheels;
	private double wheelDiameter;
	private double wheelCircumference;
	private double spinCircumference;
	private double fullSpinWheelTacho;

	public Robot(double wheelDiameter, double distanceWheels){
		this.wheelDiameter = wheelDiameter;
		this.distanceWheels = distanceWheels;
		this.wheelCircumference = (2 * Math.PI * this.wheelDiameter / 2);
		this.spinCircumference = (2 * Math.PI * this.distanceWheels / 2);
		this.fullSpinWheelTacho = ((spinCircumference / wheelCircumference) * 360);
	}
	
	public double getWheelCircumference(){
		return wheelCircumference;
	}

	public double getSpinCircumference(){
		return spinCircumference;
	}

	public double getFullSpinWheelTacho(){
		return fullSpinWheelTacho;
	}
	
}
