package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 입력을 받아요!!
		// 입력을 받기위해서는 기본적으로 Stream이라는걸 이용해야 해요.
		// Stream을 직접이용하는건 우리 나중에 다시 하고.. 여기서는 좀 쉬운 형태로
		// 사용자로부터 입력을 받을꺼예요.
		Scanner s = new Scanner(System.in);
		System.out.print("검색어를 입력하세요 : ");
		String keyword = s.nextLine();
		
		// JDBC( Java Database Connectivity )
		// 총 6단계를 거쳐서 java program이 Database를 이용
		// 조심해야 하는건..Database 프로그램은  예외상황에 대한
		// 처리가 같이 나와야 해요!!
		// Exception Handling이라고 해요.
		// try ~ catch()
		try {
			// 1. 드라이버 로딩.
			// 자바가 특정 데이터베이스를 이용하기 위해서는
			// 특수한 class의 instance가 필요해요.
			// java ------ JDBC Driver ----> database
			// 앗..파일을 찾았어요. 이 파일을 우리 프로젝트에서
			// 사용하기 위해 경로를 설정.
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 데이터베이스에 접속
			// 접속을 위해서는 크게 3가지가 필요해요.
			// ID / PW / 어느데이터베이스에 접속할건지에 대한 주소.
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			// 3. 문장 생성( SQL 질의 작성 )
			// SQL에서 사용할 수 있는 wildcard중에 "%" => 0개 이상의 문자열
			//                                    %java%
			// IN parameter인 "?"를 이용해서 코드를 읽기 쉽게 만들 수 있어요.
			String sql = 
			 "select btitle, bauthor from book where btitle like ?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			// 4. 실행
			// 실행시 조심해야 할건..어떤 종류의 sql을 사용하는지에 따라 실행하는 method가
			// 달라져요.
			// 데이터를 얻어오는 경우( select ~~ )
			ResultSet rs = pstmt.executeQuery();
			// 5. 결과처리단계( ?? )
			// 지금의 경우는 select를 이용해서 결과데이터의 집합을 DB로부터 가져온
			// 경우.
			while(rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				System.out.println(title + ", " + author);
			}
			// 6. 사용한 resource를 해제
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}






