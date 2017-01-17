package templatemethodpattern;

import java.util.ArrayList;
import java.util.Random;

public class Man extends Human{
			// 이성친구를 만드는 과정을 프로그램으로 모델링
	
	
	@Override
	public void search() {
		System.out.println("마음에 드는 여성을 찾는다 !");
	}
	@Override
	public void doAction() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("선물을 구입해요 !");
		list.add("꽃을 사요 !");
		list.add("부모님의 선물을 사요 !");
		list.add("청취와 위로를 잘 해 줘요 !");
		int num = (new Random()).nextInt(list.size());
		System.out.println(list.get(num));
	}
	
}
