package templatemethodpattern;

import java.util.ArrayList;
import java.util.Random;

public class Woman extends Human{
	
	@Override
	public void search() {
		System.out.println("마음에 드는 남성을 찾는다 !");
	}
	@Override
	public void doAction() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("이야기를 하고 웃어요 !");
		list.add("이야기를 잘 들어줘요 !");
		list.add("리액션을 크게 해요 !");
		int num = (new Random()).nextInt(list.size());
		System.out.println(list.get(num));
	}
	
	
}
