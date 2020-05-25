package calender;

import java.util.Scanner;

public class Prompt {
	
	public int parseDay(String week) {
		if(week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("wd")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
			else
				return 0;
	}

	public void runPrompt() {
		
		Scanner scan = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = 1;
		int year= 2020;
		
		
		while (true) {
			System.out.println();
			System.out.println("연도을 입력하세요");
			System.out.println("year> ");
			year = scan.nextInt();
			if(year == -1) {
				break;
		}
			System.out.println("달을 입력하세요");
			System.out.print("Month> ");
			month = scan.nextInt();
			
			
			if (month < 0) {
				break;
			}
			if (year <=0 || month > 12) {
				continue;
			}
			
			cal.printCalender(year, month);

					
		}
		System.out.println("The end");
		
		scan.close();
		
	}
	
	public static void main(String[] args) {
		//셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
