package bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import bank.dao.BankDAO;
import bank.dto.BankDTO;

public class BankService {
	
	public BankService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);	
		}
	}
	
	public BankDTO deposit(BankDTO dto) {
        // 로직처리를 해요.
		// DB처리를 해요.
		// Transaction처리를 위해서 Database Connection처리를
		// Service에서 해 줘야 해요!!
		Connection con = null;
		try {
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
		
			BankDAO dao = new BankDAO(con);
			
			BankDTO result = dao.select(dto);
			
			if( result != null ) {
				dto = dao.updateDeposit(dto);
				if( dto != null ) {
					con.commit();
				} else {
					con.rollback();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return dto;
	}

	public BankDTO withdraw(BankDTO dto) {
		
		Connection con = null;
		try {
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
		
			BankDAO dao = new BankDAO(con);
			
			BankDTO result = dao.select(dto);

			if( (result != null) && (result.getBalance() >= dto.getBalance()) ) {
				dto = dao.updateWithdraw(dto);
				if( dto != null ) {
					con.commit();
				} else {
					con.rollback();
				}				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return dto;
	}

	public HashMap<String, BankDTO> transfer(BankDTO depositDto, BankDTO withdrawDto) {
		HashMap<String, BankDTO> result = 
				new HashMap<String, BankDTO>();
		result.put("deposit",deposit(depositDto));
		result.put("withdraw",withdraw(withdrawDto));
		return result;
	}
}






