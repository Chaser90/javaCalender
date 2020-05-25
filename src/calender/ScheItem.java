package calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheItem {
	public Date scheDate;
	public String detail;
	public String peoples = "";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public ScheItem(String date, String detail) {
		this.scheDate = getDatefromString(date);
		this.detail = detail;
	}
	public Date getDate() {
		return scheDate;
	}
	public void addPeople(String name) {
		peoples += name + ",";
	}

	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(scheDate);
		System.out.println(sdate);
		return sdate + "," + "\"" + detail + "\"" + "\n";
	}
}
