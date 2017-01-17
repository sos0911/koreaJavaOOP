package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			// transaction을 설정
			con.setAutoCommit(false);
			String sql = "delete from book";
			PreparedStatement pstmt = con.prepareStatement(sql);

			int result = pstmt.executeUpdate();
			
			System.out.println("총 삭제된 레코드 수는 : " + result);

			if( result == 745 ) {
				// 정상적인 처리
				con.commit();
			} else {
				// 비정상적인 처리
				con.rollback();
			}
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}

	}

}
