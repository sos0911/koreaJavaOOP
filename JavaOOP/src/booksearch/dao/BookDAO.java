package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import booksearch.dto.BookDTO;

public class BookDAO {

	public ArrayList<BookDTO> select(String keyword) {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = 
			 "select btitle, bauthor from book where btitle like ?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				BookDTO dto = new BookDTO();
				dto.setBtitle(title);
				dto.setBauthor(author);
				list.add(dto);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	public boolean delete(String number) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = 
			 "delete from book where bisbn = ?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, number);
			// 결과 레코드 집합을 가져오는 select가 아니예요.
			// insert, update, delete => executeUpdate()
			int tmp = pstmt.executeUpdate();
			// 리턴값이 int로 나와요..
			// 결과값이 의미하는 바는 영향을 받은 레코드의 수.
			if( tmp == 1 ) {
				result = true;
			}
			pstmt.close();
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}









