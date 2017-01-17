package ex01;

import java.util.Random;

public class VehicleTest {

	public static void main(String[] args) {
			
		Vehicle v1 = new Vehicle("LEE","010-1234-5678",50000);
		Vehicle v2 = new Vehicle("LEE","010-1765-1228",80000);
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		
		if( v1.equals(v2) ) {
			System.out.println("동일한 사용자 여부 : true");
		} else {
			System.out.println("동일한 사용자 여부 : false");
		}

	}

}
