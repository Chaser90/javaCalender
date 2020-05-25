package calender;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu(){
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록     ");           
		System.out.println("| 2. 일정 검색     ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말 q. 종료 ");
		System.out.println(" +----------------------+ ");
	}
	
	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner scan = new Scanner(System.in);
		Calender cal = new Calender();
		
		
		boolean isLoop = true;
		while (isLoop) {
		System.out.println("명령 (1, 2, 3, h, q)");
		String cmd = scan.next();
		switch (cmd) {
		case "1":
			cmdRegister(scan, cal);
			break;
		case "2":
			cmdsearchSchedule(scan, cal);
			break;
		case "3":
			cmdCal(scan, cal);
			break;
		case "h":
			printMenu();
			break;
		case "q":
			isLoop = false;
			break;
			}
		}	
		System.out.println("The end");
		scan.close();
		
	}
	
	private void cmdCal(Scanner scan, Calender cal) {
		// TODO Auto-generated method stub
		int month = 1;
		int year= 2020;
		
		System.out.println();
		System.out.println("연도을 입력하세요");
		System.out.println("year> ");
		year = scan.nextInt();
	
		System.out.println("달을 입력하세요");
		System.out.print("Month> ");
		month = scan.nextInt();
		
		if (year <=0 || month > 12) {
			return;
		}
		
		cal.printCalender(year, month);

			
	}

	private void cmdsearchSchedule(Scanner scan, Calender cal) {
		// TODO Auto-generated method stub
		System.out.println("[새 일정 검색]");
		System.out.println("날짜를 입력해 주세요. (yyyy-mm-dd)");
		String date = scan.next();
		ScheItem sche = null;
		sche = cal.searchSche(date);
		if(sche != null) {
			System.out.println(sche.detail);
	
		} else {
			System.out.println("일정이 없습니다.");
		}
	}
	private void cmdRegister(Scanner scan, Calender cal) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = scan.next();
		String text = "";
		System.out.println("일정을 입력해 주세요. (문장의 끝에 !를 입력해 주세요.)" );
		 while (true) {
			 String word = scan.next();
			 text += word + " ";
			 if(word.endsWith("!")) {
				 break;
			 }
		 }
		cal.registerSchedule(date, text);
	}

	public static void main(String[] args) throws ParseException {
		//셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
