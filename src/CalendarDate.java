import java.util.*;

public class CalendarDate implements Comparable<CalendarDate>{

	private int month;
	private int day;
	
	public CalendarDate(int month, int day){
		setdate(month, day);
	}
	
	private void setdate(int month, int day){
		if (month < 1 || month > 12){
			throw new IllegalArgumentException("illegal month");
		}
		if (day < 1 || day > 31){
			throw new IllegalArgumentException("illegal day");
		}
		this.month = month;
		this.day = day;
	}
	
	
	public static void main (String[] args){
		ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>();
		dates.add(new CalendarDate(2, 22));   // Washington
		dates.add(new CalendarDate(10, 30));  // Adams
		dates.add(new CalendarDate(4, 13));	// Jefferson
		dates.add(new CalendarDate(3, 16));	// Madison
		dates.add(new CalendarDate(4, 28));	// Monroe
		System.out.println("birthdays = " + dates);
		Collections.sort(dates);
		System.out.println("birthdays = " + dates);

	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public String toString(){
		return month + " / " + day;
	}

	@Override
	public int compareTo(CalendarDate o) {
		// TODO Auto-generated method stub
		if (o instanceof CalendarDate){
			if (this.month != o.getMonth()){
				return this.month - o.getMonth();
			}else{
				return this.day - o.getDay();
			}
		} else {
			throw new IllegalArgumentException("not CalandarDate type");
		}
	}
}
