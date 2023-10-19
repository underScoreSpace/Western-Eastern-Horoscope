//Alexis Martinez
//12-09-2022
public class MyDate {
	
	private final String dayName[] = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	private final String monthName[] = {"unknown", "January","February", "March","April","May", "June", "July", "August","September","October","November","December"};
	private int year;
	private int month;
	private int day;
	private final int maxdays[] = {0,31,28,31,30,31,30,31,31,30,31,30,31}; 
	
	/**
	 * Finds the day of the week based off of the entered day, month and year. 
	 * @return
	 */
	private int zellerCongruence() {
		
		int monthNum = month;
		int dayNum = day;
		int yearNum = year;
		
		if(monthNum == 1){
			monthNum = 13;
			yearNum -= 1;
		}
		
		if(monthNum == 2){
			monthNum = 14;
			yearNum -= 1;
		}
		
		int lastTwoOfYear = yearNum % 100; 
		int firstTwoOfYear = yearNum / 100; 
		
		int dayOfTheWeekPlaceHolder = dayNum + 13 * (monthNum + 1)/5 + lastTwoOfYear + (lastTwoOfYear/4) + (firstTwoOfYear/4) + (5 * firstTwoOfYear);
		int dayOfTheWeek = dayOfTheWeekPlaceHolder % 7;
		
		return dayOfTheWeek;
	}
	
	public MyDate() {
		year = 0;
		month = 0;
		day = 0;
	}
	
	/**
	 * accepts an integer and sets it to the year
	 * @param newYear
	 */
	public void setYear(int newYear) {
		year = newYear;
	}
	
	/**
	 * returns the year
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * accepts an integer and sets it to the month
	 * @param newMonth
	 */
	public void setMonth(int newMonth) {
		month = newMonth;
	}
	
	/**
	 * returns the month
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * accepts an integer and sets it to the day
	 * @param newDay
	 */
	public void setDay(int newDay) {
		day = newDay;
	}
	
	/**
	 * returns the day
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * returns the day of the week
	 * @return
	 */
	public String getDayName() {
		return dayName[zellerCongruence()];
	}
	
	/**
	 * formats all the information gathered into a string 
	 */
	public String toString() {
	
		String daySuffix;

		if(day == 1 || day == 21 || day == 31)
			daySuffix = "st";
		else if(day == 2 || day == 22)
			daySuffix = "nd";
		else if(day == 3 || day == 23)
			daySuffix = "rd";
		else 
			daySuffix = "th";
		
		String temp = String.format("%s, %s %d%s, %d", getDayName(), monthName[month], day, daySuffix, year);
		return temp;
	}
	
	/**
	 * determines if the year is a leap year or not
	 * @return
	 */
	public boolean isLeapYear()
	{
		boolean leap = false;
		
	    if (year % 4 == 0) 
	    {
	      if (year % 100 == 0) 
	      {
	        if (year % 400 == 0)
	          leap = true;
	        else
	          leap = false;
	      }
	      else
	        leap = true;
	    }
	    else
	      leap = false;
	    
	    return leap;
	}
	
	/**
	 * returns the max number of days in a month taking the leap year into account
	 * @return
	 */
	public int getMaxDay() {
		if(month == 2 && isLeapYear())
			return maxdays[month] + 1;
		else
			return maxdays[month];
	}
}