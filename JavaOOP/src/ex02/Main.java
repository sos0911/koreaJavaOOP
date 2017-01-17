package ex02;

import java.util.HashSet;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// main method내에서 로직처리를 한다는건 있을 수 없는 일.
		Random r = new Random();
		// generic
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() != 10) {
			int k = r.nextInt(30) + 1;
			set.add(k);   // autoboxing
		}
		System.out.println(set);

	}

}
