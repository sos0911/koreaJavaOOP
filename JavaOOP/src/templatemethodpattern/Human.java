package templatemethodpattern;

public abstract class Human {
	public void makeFriends(){
		dress();
		search();
		doAction();
		confess();
	}
	public void dress(){
		System.out.println("옷을 입는다 !");
	}
	public void confess(){
		System.out.println("고백을 해요 !");
	}
	
	public abstract void search();
	public abstract void doAction();
		
}
