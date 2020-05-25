package calender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Calender {

	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String SAVE_FILE = "calendar.dat";
	private HashMap <Date, ScheItem> scheMap;
	
	public Calender() {
		scheMap = new HashMap <Date, ScheItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists())
			return;
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String words[] = line.split(",");
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				ScheItem si = new ScheItem(date, detail);
				scheMap.put(si.getDate(),si);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param date ex: "2020-05-25"
	 * @param sche
	 * throws ParseException
	 */
	 
	public void registerSchedule(String strDate, String sche) {
		ScheItem s = new ScheItem(strDate, sche);
		scheMap.put(s.getDate(), s);
		
		File f = new File(SAVE_FILE);
		String item = s.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ScheItem searchSche(String strDate) {
		Date date = ScheItem.getDatefromString(strDate);
		return scheMap.get(date);
		}
	
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
		System.out.println();
		System.out.println();
	}
	
private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4;
		
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
		count += day - 1;
		
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

	public static void main(String[] args) throws ParseException {
		Calender cal = new Calender();
		System.out.println(cal.getWeekday(1970, 1, 1) == 4);
		System.out.println(cal.getWeekday(1971, 1, 1) == 5);
		System.out.println(cal.getWeekday(1972, 1, 1) == 6);
		System.out.println(cal.getWeekday(1973, 1, 1) == 1);
		System.out.println(cal.getWeekday(1974, 1, 1) == 2);
//		숫자를 입력받아 해당하는 달의 최대 일수를출력하는 프로그램
		
		cal.registerSchedule("2020-05-25", "Let's eat beef");
		
		System.out.println(cal.searchSche("2020-05-25").equals("Let's eat beef"));
		
		}
	}

