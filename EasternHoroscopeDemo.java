//Alexis Martinez 
//12-09-2022
//Shows a persons eastern horoscope information based off the information gathered using MyDate object
public class EasternHoroscopeDemo {

	public static void main(String[] args) {
		
		MyDate d1 = new MyDate();
		d1.setYear(Input.getInteger("\nEnter the year (1922...2022): ", 1922, 2022));
		d1.setMonth(Input.getInteger("\nEnter the month (1...12): ", 1, 12));
		
		switch(d1.getMonth()) {
	    case 1: 
	    case 3: 
	    case 5: 
	    case 7: 
	    case 8: 
	    case 10: 
	    case 12:
	        d1.setDay(Input.getInteger("\nEnter the day (1...31): ", 1, 31));
	        break;
	    case 4: 
	    case 6: 
	    case 9: 
	    case 11:
	        d1.setDay(Input.getInteger("\nEnter the day (1...30): ", 1, 30));
	        break;
	    case 2:
	        if(d1.isLeapYear())
	            d1.setDay(Input.getInteger("\nEnter the day (1...29): ", 1, 29));
	        else
	            d1.setDay(Input.getInteger("\nEnter the day (1...28): ", 1, 28));
	        break;
	}

		
		EasternHoroscope w1 = new EasternHoroscope();
		w1.setDate(d1);
		
		System.out.printf("\n%s\n", w1);
		
		EasternHoroscope w2 = new EasternHoroscope();
		MyDate d2 = new MyDate();
		d2.setYear(Input.getInteger("\nEnter the year (1922...2022): ", 1922, 2022));
		d2.setMonth(Input.getInteger("\nEnter the month (1...12): ", 1, 12));
		
		switch(d2.getMonth()) {
	    case 1: 
	    case 3: 
	    case 5: 
	    case 7: 
	    case 8: 
	    case 10: 
	    case 12:
	        d2.setDay(Input.getInteger("\nEnter the day (1...31): ", 1, 31));
	        break;
	    case 4: 
	    case 6: 
	    case 9: 
	    case 11:
	        d2.setDay(Input.getInteger("\nEnter the day (1...30): ", 1, 30));
	        break;
	    case 2:
	        if(d1.isLeapYear())  // Note: You've used d1 here, please verify if it's intended or if you meant d2.
	            d2.setDay(Input.getInteger("\nEnter the day (1...29): ", 1, 29));
	        else
	            d2.setDay(Input.getInteger("\nEnter the day (1...28): ", 1, 28));
	        break;
	}

		w2.setDate(d2);
 
		System.out.printf("\n%s\n", w2);
		
		if (w1.isCompatible(w2))
			System.out.println("\nThey are compatible\n");
		else
			System.out.println("\nThey are NOT compatible\n");
	}
}