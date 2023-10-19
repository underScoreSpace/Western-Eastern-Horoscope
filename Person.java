//Alexis Martinez
//12-09-2022
public class Person {
	private String fName;
	private String mName;
	private String lName;
	private MyDate birthDate;
	private WesternHoroscope western;
	private EasternHoroscope eastern;
	
	public Person() {
		fName = "Unknown";
		mName = "Unknown";
		lName = "Unknown";
		birthDate = new MyDate();
		western = new WesternHoroscope();
		eastern = new EasternHoroscope();
	}
	
	/**
	 * accepts a string and sets it to fName
	 * @param name
	 */
	public void setFName(String name) {
		fName = name;
	}
	
	/**
	 * returns first name
	 * @return
	 */
	public String getFName() {
		return fName;
	}
	
	/**
	 * accepts a string and sets it to mName
	 * @param name
	 */
	public void setMName(String name) {
		mName = name;
	}
	
	/**
	 * returns middle name
	 * @return
	 */
	public String getMName() {
		return mName;
	}
	
	/**
	 * returns middle name initial
	 * @return
	 */
	public char getMNameInitial() {
		return mName.charAt(0);
	}
	
	/**
	 * accepts a string and sets it to lName
	 * @param name
	 */
	public void setLName(String name) {
		lName = name;
	}
	
	/**
	 * returns the last name 
	 * @return
	 */
	public String getLName() {
		return lName;
	}
	
	/**
	 * returns full name with only the first letter of the middle name
	 * @return
	 */
	public String getFullName() {
		String fullName = String.format("%s %s. %s", getFName(), getMNameInitial(), getLName());
		return fullName;
	}
	
	/**
	 * accepts a MyDate object and sets the date
	 * @param obj
	 */
	public void setBirthDate(MyDate obj) {
		birthDate.setYear(obj.getYear());
		birthDate.setMonth(obj.getMonth());
		birthDate.setDay(obj.getDay());
		western.setDate(obj);
		eastern.setDate(obj);
	}
	
	/**
	 * returns the birth date formatted
	 * @return
	 */
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	/**
	 * returns western horoscope information
	 * @return
	 */
	public WesternHoroscope getWesternHoroscope() {
		return western;
	}
	
	/**
	 * returns eastern horoscope information
	 * @return
	 */
	public EasternHoroscope getEasternHoroscope() {
		return eastern;
	}
	/**
	 * returns a string that has all information formatted
	 */
	public String toString() {
		String temp = String.format("\n\t\tName: %s %s. %s", getFName(), getMNameInitial(), getLName());	
		
		temp += String.format("\n\t\tBirth date: %s", getBirthDate());
		temp += String.format("\n\t\tWestern Horoscope: %s", getWesternHoroscope());
		temp += String.format("\n\t\tEastern Horoscope: %s", getEasternHoroscope());
		
		return temp;
	}
}