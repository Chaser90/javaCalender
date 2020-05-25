package calender;


public class Calender {

	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isLeapYear(int year) {
		if( year %4 == 0 && (year %100 != 0 || year %400 ==0)) {
			return true;
		}else
		return false;
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
		return LEAP_MAX_DAYS[month -1];	
		}else {
		return MAX_DAYS[month - 1];
	}
}
	
	public void printCalender(int year, int month){
		System.out.printf("<<%d년 %d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA ");
		System.out.println("---------------------");
		
		//get weekday automatically
		int weekday = getWeekday(year, month, 1);
		
		//print blank space
		for(int i=0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		
		
		for(int i =1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		count++;
		for (int i = count; i<= maxDay; i++) {
			System.out.printf("%3d",i);
			if(i % 7 == delim) {
				System.out.println();
			}
		
		
		}
	}
	
private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 3;
		
		int count = 0;
		
		for(int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
//		System.out.println(count);
		for(int i =1; i<month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY)% 7;
//		System.out.println(count);
		return weekday;
	}


//		System.out.println();
//		System.out.println("  1  2  3  4  5  6  7 ");
//		System.out.println("  8  9 10 11 12 13 14 ");
//		System.out.println(" 15 16 17 18 19 20 21 ");
//		System.out.println(" 22 23 24 25 26 27 28 ");
//	}

	public static void main(String[] args) {
		Calender cal = new Calender();
		System.out.println(cal.getWeekday(1970, 1, 1) == 3);
		System.out.println(cal.getWeekday(1971, 1, 1) == 4);
		System.out.println(cal.getWeekday(1972, 1, 1) == 5);
		System.out.println(cal.getWeekday(1973, 1, 1) == 0);
		System.out.println(cal.getWeekday(1974, 1, 1) == 1);
//		숫자를 입력받아 해당하는 달의 최대 일수를출력하는 프로그램
		
			
		}
	}

