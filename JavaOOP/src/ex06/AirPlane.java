package ex06;

public class AirPlane extends Plane {

	public AirPlane() {
		// TODO Auto-generated constructor stub
	}
	
	public AirPlane(String planeName, int fuelSize) {
		super(planeName,fuelSize);
	}
	@Override
	public void flight(int distance) {
		// 10운항시 연료량 30감소
		int currentFuel = getFuelSize();
		setFuelSize(currentFuel - (distance*3));
	}

}
