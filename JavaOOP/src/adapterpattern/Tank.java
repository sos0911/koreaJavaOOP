package adapterpattern;

public class Tank implements TerranInterface{
 public Tank() {
}
	@Override
	public void attack() {
		System.out.println("sidge and shoot !");
	}

	@Override
	public void move() {
		System.out.println("move, sir !");
	}

}
