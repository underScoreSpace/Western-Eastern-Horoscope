//Alexis Martinez
//12-09-2022
//Demo showing a person object and displaying their info based off of the information gathered
public class PersonDemo {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.setFName(Input.getString("\nEnter your first name: "));
		p1.setMName(Input.getString("\nEnter your middle name: "));
		p1.setLName(Input.getString("\nEnter your last name: "));
		

		MyDate date = new MyDate();
	
		date.setYear(Input.getInteger("\nEnter the year (1922...2022): ", 1922, 2022));
		date.setMonth(Input.getInteger("\nEnter the month (1...12): ", 1, 12));
		date.setDay(Input.getInteger(String.format("\nEnter a valid day (1...%d): ", date.getMaxDay()), 1, date.getMaxDay()));
		
		
		
		p1.setBirthDate(date);
		
		
		System.out.println(p1);
		
	}
}