package bank.controller;

import java.util.HashMap;
import java.util.Scanner;

import bank.dto.BankDTO;
import bank.service.BankService;

public class BankController {
	
	public BankController() {
		
		Scanner s = new Scanner(System.in);
		String menu = null;
		do {
			System.out.println("=== 은행시스템입니다. ===");
			System.out.println("1. 입금업무");
			System.out.println("2. 출금업무");
			System.out.println("3. 이체업무");
			System.out.println("4. 종료");
			menu = s.nextLine();
			if( menu.equals("1")) {
				// 입금
				BankDTO dto = new BankDTO();
				System.out.print("입금할 사람의 이름을 입력하세요 : ");
				dto.setName(s.nextLine());
				System.out.println("입금할 금액을 입력하세요 : ");
				dto.setBalance(s.nextInt());
				s.nextLine();
				BankService service = new BankService();
				dto = service.deposit(dto);
				System.out.println(dto.getName() + "님의 잔액은 "
						+ dto.getBalance() + " 입니다.");
			}
			if( menu.equals("2")) {
				BankDTO dto = new BankDTO();
				System.out.print("출금할 사람의 이름을 입력하세요 : ");
				dto.setName(s.nextLine());
				System.out.println("출금할 금액을 입력하세요 : ");
				dto.setBalance(s.nextInt());
				s.nextLine();
				BankService service = new BankService();
				dto = service.withdraw(dto);
				System.out.println(dto.getName() + "님의 잔액은 "
						+ dto.getBalance() + " 입니다.");
				
			}
			if( menu.equals("3")) {
				BankDTO depositDto = new BankDTO();
				BankDTO withdrawDto = new BankDTO();
				System.out.print("입금할 사람의 이름을 입력하세요 : ");
				depositDto.setName(s.nextLine());
				System.out.print("출금할 사람의 이름을 입력하세요 : ");
				withdrawDto.setName(s.nextLine());
				System.out.println("이체할 금액을 입력하세요 : ");
				int money = s.nextInt();
				depositDto.setBalance(money);
				withdrawDto.setBalance(money);				
				s.nextLine();
				
				BankService service = new BankService();
				HashMap<String, BankDTO> map = 
						service.transfer(depositDto,withdrawDto);
				depositDto = map.get("deposit");
				withdrawDto = map.get("withdraw");
				System.out.println("입금자  : " + depositDto.getName() + "님의 잔액은 "
						+ depositDto.getBalance() + " 입니다.");
				System.out.println("출금자  : " + withdrawDto.getName() + "님의 잔액은 "
						+ withdrawDto.getBalance() + " 입니다.");

			}			
		} while( !menu.equals("4"));
		
	}
}
