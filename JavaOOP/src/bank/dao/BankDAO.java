package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.dto.BankDTO;

public class BankDAO {

	private Connection con;
	
	public BankDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public BankDAO(Connection con) {
		this.con = con;
	}
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public BankDTO select(BankDTO dto) {
		BankDTO result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {			
			String sql = "select name,balance from bank where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				result = new BankDTO();
				result.setName(rs.getString("name"));
				result.setBalance(rs.getInt("balance"));
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				pstmt.close();			
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}

	public BankDTO updateDeposit(BankDTO dto) {
		BankDTO result = null;
		PreparedStatement pstmt = null;
		try {			
			String sql = "update bank set balance=balance+? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate();
			if( count == 1 ) {
				result = select(dto);
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();			
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}

	public BankDTO updateWithdraw(BankDTO dto) {
		BankDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			String sql = "update bank set balance=balance-? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setString(2, dto.getName());
			int count = pstmt.executeUpdate();
			if( count == 1 ) {
				con.commit();
				result = select(dto);
			} else {
				con.rollback();
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
				con.close();				
			} catch(Exception e1) {
				System.out.println(e1);
			}			
		}
		return result;
	}
}
