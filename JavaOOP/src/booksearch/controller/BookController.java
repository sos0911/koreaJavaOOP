package booksearch.controller;

import java.util.ArrayList;
import java.util.Scanner;

import booksearch.dto.BookDTO;
import booksearch.service.BookService;

public class BookController {
	
	public BookController() {
				
		// 여기서부터 시작.
		// 입출력을 담당하는 클래스.
		Scanner s = new Scanner(System.in);
		String menu = "0";
		String keyword = null;
		do {
			System.out.println("=== 도서관리 프로그램 ===");
			System.out.println("1. 도서검색(키워드)");
			System.out.println("2. 도서삭제(도서번호입력)");
			System.out.println("3. 종료");
			System.out.print("메뉴를 입력하세요 : ");
			menu = s.nextLine();
			if( menu.equals("1")) {
				System.out.print("키워드를 입력하세요 : ");
				keyword = s.nextLine();
				BookService service = new BookService();
				ArrayList<BookDTO> list = service.findBookByKeyword(keyword);
				
				for( BookDTO dto : list ) {
					System.out.println(dto.getBtitle() + ", " + dto.getBauthor());
				}				
			}			
			if( menu.equals("2")) {
				// 도서삭제				
				System.out.print("도서번호를 입력하세요 : ");
				String number = s.nextLine();
				BookService service = new BookService();
				boolean result = service.deleteByNumber(number);
				if(result) {
					System.out.println("정상적으로 삭제되었습니다.");
				} else {
					System.out.println("먼가 이상해요!!");
				}
			}
			if( menu.equals("3")) {
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
			}
		}
		while( !menu.equals("3") );
		
	}
}




