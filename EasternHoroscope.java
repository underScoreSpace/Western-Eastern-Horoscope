//Alexis Martinez
//12-09-2022
import java.util.ArrayList;

public class EasternHoroscope extends MyDate 
{
	private static ArrayList<String> easternSign;
	
	public EasternHoroscope()
	{
		easternSign = new ArrayList<String>(); 
		easternSign.add("Monkey - wise, intelligent, confident, charismatic, loyal, and inventive");
		easternSign.add("Rooster - beautiful, kind-hearted, hard-working, courageous, independent, humorous and honest");
		easternSign.add("Dog - honest, friendly, faithful, loyal, smart, straightforward, and responsible");
		easternSign.add("Pig - happy, easygoing, honest, trusting, educated, sincere and brave");
		easternSign.add("Rat - intelligent, charming, quick-witted, practical, and ambitious");
		easternSign.add("Ox - hardworking, honest, creative, ambitious, cautious, and patient");
		easternSign.add("Tiger - friendly, brave, competitive, charming and endowed with authority");
		easternSign.add("Rabbit - kind-hearted, friendly, intelligent, cautious, skillful, and gentle");
		easternSign.add("Dragon - powerful, kind-hearted, successful, innovative, brave, and courageous");
		easternSign.add("Snake - wise, discreet, agile, attractive and full of sympathy");
		easternSign.add("Horse - clever, active, energetic, quick-witted, fashionable, and agile");
		easternSign.add("Goat - polite, mild mannered, shy, imaginative, determined and well-mannered");
	}
	
	/**
	 * accepts a MyDate object and sets the date
	 * @param newDate
	 */
	public void setDate(MyDate newDate)
	{
		super.setDay(newDate.getDay());
		super.setMonth(newDate.getMonth());
		super.setYear(newDate.getYear());
	}
	
	/**
	 * returns the index needed to find the horoscope
	 * @return
	 */
	public int getIndex() 
	{
		return getYear() % 12;
	}
	
	/**
	 * returns sign information of horoscope
	 * @return
	 */
	public String getSignInformation()
	{
		return easternSign.get(getIndex());
	}
	
	/**
	 * returns only the sign name
	 * @return
	 */
	public String getSign()
	{
		String temp[] = getSignInformation().split("-");
		
		return temp[0].trim();
	}
	
	/**
	 * return String of the current object
	 */
	public String toString()
	{
		return getSignInformation();
	}
	
	/**
	 * accepts another instance of the eastern horoscope and determines if they are compatible
	 * @param obj
	 * @return
	 */
	public boolean isCompatible(EasternHoroscope obj)
	{
		String group1 = "Rat, Dragon, and Monkey";
		String group2 = "Ox, Snake, and Rooster";
		String group3 = "Tiger, Horse, and Dog";
		String group4 = "Rabbit, Goat, and Pig";
		
		String currentSign = getSign();
		
		String secondPersonSign = obj.getSign();
		
		if ((group1.contains(currentSign) && group1.contains(secondPersonSign)) ||
			(group2.contains(currentSign) && group2.contains(secondPersonSign)) ||
			(group3.contains(currentSign) && group3.contains(secondPersonSign)) ||
			(group4.contains(currentSign) && group4.contains(secondPersonSign)))
			return true;
		
		else
			return false;
	}
}