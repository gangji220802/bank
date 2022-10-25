

import java.util.Scanner;

public class BankApplication {

		private static Account[] accountArray = new Account[100];
		private static Scanner scanner = new Scanner(System.in);
		public static int cnt = 0;
		
		public static void main(String[] args) {
			boolean run = true;
			while(run) {
				System.out.println("----------------------------------------");
				System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
				System.out.println("----------------------------------------");
				System.out.println("선택> ");
				
				int selectNo = scanner.nextInt();
				
				if(selectNo == 1) {
					createAccount();
				}else if(selectNo == 2) {
					accountList();
				}if(selectNo == 3) {
					deposit();
				}else if(selectNo == 4) {
					withdraw();
				}else if(selectNo == 5) {
					run = false;
				}
			}
			System.out.println("프로그램 종료");
		} // main
		
		// 계좌 생성하기
		private static void createAccount() {
			String ano = null;
			String owner = null;
			int balance = 0;
			System.out.println("----------");
			System.out.println("계좌생성");
			System.out.println("----------");

			System.out.print("계좌번호 : "); //계좌번호 입력
			ano = scanner.next();
			
			System.out.print("계좌주 : "); //계좌주 입력
			owner = scanner.next();

			System.out.print("초기입금액 : "); //입금액 입력
			balance = scanner.nextInt();

			accountArray[cnt++] = new Account(ano, owner, balance);
			System.out.println("결과: 계좌가 생성되었습니다.");
				
				
			
       }
			
		
		//계좌 목록보기
		private static void accountList() {
			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] == null) {
					break;
				}
				System.out.println(accountArray[i].getAno() + "\t"
						+ accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
				}
			}
		
		// 예금하기
		private static void deposit() {
			System.out.println("---------------");
			System.out.println("예금");
			System.out.println("---------------");
			
			System.out.print("계좌 번호 : ");
			String ano = scanner.next();
			System.out.print("예금액 : ");
			Account acc = findAccount(ano);
			if(acc !=null)
			{
				acc.setBalance(findAccount(ano).getBalance() + scanner.nextInt());
				System.out.println("예금이 성공되었습니다.");
			}else {
				System.out.println("계좌번호 오류");
			}
				
		}
		
		// 출금하기
		private static void withdraw() {
			System.out.println("---------------");
			System.out.println("출금");
			System.out.println("---------------");
			System.out.print("계좌 번호 : ");
			String ano = scanner.next();
			System.out.print("출금액 : ");
			int withdraw = scanner.nextInt();

			if (findAccount(ano) == null) {
				System.out.println("입력한 계좌번호를 찾지 못했습니다.");
			} else {
				if (withdraw > findAccount(ano).getBalance()) {
					System.out.println("잔액보다 큰 액수를 입력하셨습니다.");
				} else {
					findAccount(ano).setBalance(findAccount(ano).getBalance() - withdraw);
					System.out.println("결과: 출금이 성공되었습니다.");
				}
			}
		}
		// Account 배열에서 ano와 동일한 Account 객체 찾기
		private static Account findAccount(String ano) {
			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] == null) {
					break;
				}
				if(accountArray[i].getAno().equals(ano)) {
					return accountArray[i];
				}
			}
			System.out.println("해당 계좌번호를 찾을 수 없습니다.");
			return null;
		}
}	
