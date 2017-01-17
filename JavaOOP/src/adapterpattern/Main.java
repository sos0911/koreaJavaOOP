package adapterpattern;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<TerranInterface> unit = new ArrayList<TerranInterface>();
			unit.add(new Marine());
			unit.add(new Marine());
			unit.add(new Marine());
			unit.add(new Tank());
			unit.add(new MedicAdapter(new Medic()));
			for(TerranInterface tmp : unit){
				tmp.move();
			}
			for(TerranInterface tmp : unit){
				tmp.attack();
				System.out.println("수정 예정입니다");
			}
		
	}

}
