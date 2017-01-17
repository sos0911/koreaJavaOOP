package myexception;

import java.util.Random;

public class Main {
public static void test() throws Exception{
	System.out.println("호출됩니다");
	// 만약 exception 처리코드가 필요하다면?
}
	public static void main(String[] args) {
		
		try{
			// 만약 강제로 exception을 발생시키고 싶다면?
			test();
			
		}
		catch(Exception e){
			// 이 부분은 발생한 exception을 처리하여 
			// 프로그램이 정상적으로 계속 수행될 수 있도록
			// 처리하는 코드가 나와야 해요.
			System.out.println(e);
		} 
		
		
		
		
		
		
	}

}
