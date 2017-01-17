package adapterpattern;

public class Medic implements MedicInterface{

	@Override
	public void heal() {
			System.out.println("healing !");
	}

	@Override
	public void move() {
		 System.out.println("move, gentlemens !");
	}

}
