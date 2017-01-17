package adapterpattern;

public class Marine implements TerranInterface {
   public Marine() {
}
	@Override
	public void attack() {
		System.out.println("reload and shoot !");
	}

	@Override
	public void move() {
		System.out.println("move ! move !");
	}

}
