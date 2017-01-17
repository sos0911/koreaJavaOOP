package booksearch.service;

import java.util.ArrayList;

import booksearch.dao.BookDAO;
import booksearch.dto.BookDTO;

public class BookService {

	public ArrayList<BookDTO> findBookByKeyword(String keyword) {
		// 로직처리가 나와요..
		// 일반 로직은 service에서 구현을 하구요.
		// Database처리는 service에서 직접 구현하지 않아요.
		// Database처리는 DAO를 이용해서 처리해요.
		BookDAO dao = new BookDAO();
		return dao.select(keyword);
	}

	public boolean deleteByNumber(String number) {
		//
		BookDAO dao = new BookDAO();
		return dao.delete(number);
	}

}








