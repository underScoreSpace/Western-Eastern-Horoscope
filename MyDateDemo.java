//Alexis Martinez
//12-09-2022
// This demo shows the methods in MyDate displaying the entered year, month and date as well as formatting that info and finding the day of the week.
public class MyDateDemo {
	public static void main(String[] args) {
		MyDate myDate1 = new MyDate();
		
		myDate1.setYear(Input.getInteger("\nEnter a valid year (1922...2022): ", 1922, 2022));
		
		System.out.printf("\nYear: %d\n", myDate1.getYear());
		
		myDate1.setMonth(Input.getInteger("\nEnter a valid month(1...12): ", 1, 12));
		
		System.out.printf("\nMonth: %d\n", myDate1.getMonth());
		
		myDate1.setDay(Input.getInteger(String.format("\nEnter a valid day (1...%d): ", myDate1.getMaxDay()), 1, myDate1.getMaxDay()));
		
		System.out.printf("\nDay: %d\n", myDate1.getDay());
		
		System.out.printf("\nDay of the Week: %s\n\n", myDate1.getDayName());
		
		System.out.printf("My birth date: %s\n", myDate1.toString());
	}
}