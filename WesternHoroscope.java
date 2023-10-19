//Alexis Martinez
//12-09-2022
import java.util.ArrayList;

public class WesternHoroscope extends MyDate {
	private static ArrayList<String>westernSign;
	
	public WesternHoroscope() {
		westernSign = new ArrayList<String>();
		westernSign.add("Unknown");
		westernSign.add("Capricorn - Ambitious, pessimistic, and responsible");
		westernSign.add("Aquarius - Unique, idealistic, and friendly");
		westernSign.add("Pisces - Creative, empathetic, and intuitive");
		westernSign.add("Aries - Courageous, passionate, and confident");
		westernSign.add("Taurus - Reliable, stubborn, and patient");
		westernSign.add("Gemini - Social, impulsive, and intelligent");
		westernSign.add("Cancer - Sensitive, nostalgic, and protective");
		westernSign.add("Leo - Generous, self-centered, and charismatic");
		westernSign.add("Virgo - perfectionist, critical, and hard-workings");
		westernSign.add("Libra - clever, indecisive, and charming");
		westernSign.add("Scorpio - Mysterious, private, and loyal");
		westernSign.add("Sagittarius - Honest, optimistic, and independent");
	}
	
	/**
	 * accepts a MyDate object and sets the date
	 * @param newDate
	 */
	public void setDate(MyDate newDate) {
		super.setDay(newDate.getDay());
		super.setMonth(newDate.getMonth());
		super.setYear(newDate.getYear());
	}
	
	/**
	 * returns an integer based off of the day entered, the integer returned is the month
	 * @return
	 */
	public int getIndex() {
		switch(super.getMonth()){
		case 1:
			if(super.getDay() <= 19)
				return 1;
			else 
				return 2;
		case 2:
			if(super.getDay() <= 18)
				return 2;
			else 
				return 3;
		case 3: 
			if(super.getDay() <= 20)
				return 3;
			else 
				return 4;
		case 4: 
			if(super.getDay() <= 19)
				return 4;
			else 
				return 5;
		case 5: 
			if(super.getDay() <= 20)
				return 5;
			else 
				return 6;
		case 6: 
			if(super.getDay() <= 20)
				return 6;
			else 
				return 7;
		case 7: 
			if(super.getDay() <= 22)
				return 7;
			else
				return 8;
		case 8: 
			if(super.getDay() <= 22)
				return 8;
			else 
				return 9;
		case 9:
			if(super.getDay() <= 22)
				return 9;
			else 
				return 10;
		case 10:
			if(super.getDay() <= 22)
				return 10;
			else 
				return 11;
		case 11:
			if(super.getDay() <= 21)
				return 11;
			else 
				return 12;
		case 12:
			if(super.getDay() <= 21)
			return 12;
		else 
			return 1;
		default:
			return 0;
		}
	}
	
	/**
	 * returns the sign information based off the month
	 * @return
	 */
	public String getSignInformation() {
		return westernSign.get(getIndex());
	}	
	
	/**
	 * returns just the sign
	 * @return
	 */
	public String getSign() {
		String temp[] = getSignInformation().split("-");
		
		return temp[0].trim();
	}
	/**
	 * 
	 * @return String of the current object
	 */
	
	public String toString() {
		return getSignInformation();
	}
	
	
	/**
	 * return true if both signs are in the same group
	 * @param obj
	 * @return
	 */
	
	public boolean isCompatible(WesternHoroscope obj) {
		String group1 = "Aries Leo Sagittarrius";
		String group2 = "Taurus Virgo Capricorn";
		String group3 = "Gemini Libra Aquarius";
		String group4 = "Cancer Scorpio Pisces";
		
		String currentSign = getSign();
		
		String secondPersonSign = obj.getSign();
		
		if((group1.contains(currentSign) && group1.contains(secondPersonSign)) || 
		   (group2.contains(currentSign) && group2.contains(secondPersonSign)) ||
		   (group3.contains(currentSign) && group3.contains(secondPersonSign)) ||
		   (group4.contains(currentSign) && group4.contains(secondPersonSign)))
			return true;
		else 
			return false;
	}
}