//Alexis Martinez
//12-09-2022
//This program allows you to see your Name, Birthday, day of the week you were born on, western and eastern horoscopes. It also allows you to compare to others and output that list to a text file.
import java.util.Scanner;
import java.io.*;
public class Exam3 {
	public static void main (String[] args)throws IOException {
		
		displayBanner();
		
		Person personOne = new Person();
		Person personTwo = new Person();
		Person people = new Person();
		MyDate date = new MyDate();
		MyDate dateTwo = new MyDate();
		MyDate peopleDates = new MyDate();
		WesternHoroscope westernSignOne = new WesternHoroscope();
		WesternHoroscope westernSignTwo = new WesternHoroscope();
		WesternHoroscope peoplesWesternSign = new WesternHoroscope();
		EasternHoroscope easternSignOne = new EasternHoroscope();
		EasternHoroscope easternSignTwo = new EasternHoroscope();
		EasternHoroscope peoplesEasternSign = new EasternHoroscope();
	
		boolean check = false;
		
		do {
			
			displayMenu();
			
			int option = Input.getInteger("\n\t\tOption: ", 0, 4);
			
			if(option == 1) {
				check = true;
				
				personOne.setFName(Input.getString("\n\t\tEnter your first name: "));
				personOne.setMName(Input.getString("\n\t\tEnter your middle name: "));
				personOne.setLName(Input.getString("\n\t\tEnter your last name: "));
			
				date.setYear(Input.getInteger("\n\t\tEnter your birth year (1922...2022): ", 1922, 2022));
				date.setMonth(Input.getInteger("\n\t\tEnter your birth month (1...12): ", 1, 12));
				date.setDay(Input.getInteger(String.format("\n\t\tEnter your birth day (1...%d): ", date.getMaxDay()), 1, date.getMaxDay()));
				
				
				personOne.setBirthDate(date);
				System.out.println("\n\tYour information:");
				System.out.println("\t---------------------------------------------------------------------------------------------------------");
				System.out.println(personOne);
			}
			
			if(option == 2 && check == true) {
				
				personTwo.setFName(Input.getString("\n\t\tEnter second person's first name: "));
				personTwo.setMName(Input.getString("\n\t\tEnter second person's middle name: "));
				personTwo.setLName(Input.getString("\n\t\tEnter second person's last name: "));
				
				dateTwo.setYear(Input.getInteger("\n\t\tEnter birth year (1922...2022): ", 1922, 2022));
				dateTwo.setMonth(Input.getInteger("\n\t\tEnter birth month (1...12): ", 1, 12));
				dateTwo.setDay(Input.getInteger(String.format("\n\t\tEnter birth day (1...%d): ", dateTwo.getMaxDay()), 1, dateTwo.getMaxDay()));
				
				personOne.setBirthDate(date);
				personTwo.setBirthDate(dateTwo);
				System.out.println("\n\tPerson #1's Information:");
				System.out.println("\t---------------------------------------------------------------------------------------------------------");
				System.out.println(personOne);
				System.out.println("\n\tPerson #2's Information: ");
				System.out.println("\t---------------------------------------------------------------------------------------------------------");
				System.out.println(personTwo);
				
				westernSignOne.setDate(date);
				easternSignOne.setDate(date);
				westernSignTwo.setDate(dateTwo);
				easternSignTwo.setDate(dateTwo);
				
				System.out.println("\n\tResult:");
				System.out.println("\t---------------------------------------------------------------------------------------------------------");
				if(westernSignOne.isCompatible(westernSignTwo) && easternSignOne.isCompatible(easternSignTwo))
				System.out.printf("\n\t%s is highly compatible with %s.\n", personOne.getFullName(), personTwo.getFullName());
				else System.out.printf("\n\t%s is NOT compatible with %s.\n", personOne.getFullName(), personTwo.getFullName());
			}
			
			if(option == 3 && check == true) {
			
				String fileName = Input.getString("\n\t\tEnter an input data file name (PEOPLE.TXT): ");
				
				File file = new File(fileName);
				 if(!file.exists())
					{
						System.out.printf("\n\t\tERROR: The file, %s, is not found.\n", file);
						continue;
					}
				Scanner fileRead = new Scanner(file);
				westernSignOne.setDate(date);
				easternSignOne.setDate(date);
				System.out.println("\n\tPerson #1's Information:");
				System.out.println("\t---------------------------------------------------------------------------------------------------------");
				System.out.println(personOne);
				System.out.println("\n\tYou are highly compatible with:");
				int count = 0;
				int numOfPeople = 0;
				
				while(fileRead.hasNext()) {
					if(fileRead.hasNext()) 
						numOfPeople++;
					
					String fileInput = fileRead.nextLine();
					
					String peopleData [] = fileInput.split(","); 
					
					people.setFName(peopleData[0]);
					people.setMName(peopleData[1]);
					people.setLName(peopleData[2]);

					String month = peopleData[3];
					
					String dates[] = month.split("-");
					
					String birthDays = dates[1];
					int convertedDay = Integer.parseInt(birthDays);
		
					String birthMonths = dates[0];
					int convertedMonth = Integer.parseInt(birthMonths);
					
					String birthYears = dates[2];
					int convertedYear = Integer.parseInt(birthYears);
					
					peopleDates.setYear(convertedYear);
					peopleDates.setMonth(convertedMonth);
					peopleDates.setDay(convertedDay);
					
					people.setBirthDate(peopleDates);
			
					peoplesWesternSign.setDate(peopleDates);
					peoplesEasternSign.setDate(peopleDates);
					
					if(westernSignOne.isCompatible(peoplesWesternSign) && easternSignOne.isCompatible(peoplesEasternSign)) 
						System.out.println(people);
					
					if(!westernSignOne.isCompatible(peoplesWesternSign) || !easternSignOne.isCompatible(peoplesEasternSign))
						count++;	
				}
				if(count == numOfPeople)
					System.out.println("\n\t\tYou are not compatible with anyone on the list.");
				fileRead.close();			
			}
			
			if(option == 4 && check == true) {
				
				String fileName = Input.getString("\n\t\tEnter an input data file name (PEOPLE.TXT): ");
				
				File file = new File(fileName);
				if(!file.exists())
					{
						System.out.printf("\n\t\tERROR: The file, %s, is not found.\n", file);
						continue;
					}
				 
				String writeFile = Input.getString("\n\t\tEnter an output data file name (RESULTS.TXT): ");
				
				File fileTwo = new File(writeFile);
				
				if(fileTwo.exists()) {
					char answer = Input.getChar("\n\t\tFile, "+ writeFile +", already exists. Do you want to overwrite (Y-yes or N-no) ? ", 'Y', 'N');
					if(answer == 'Y');
					else if(answer == 'N')
						continue;
				}
				
				PrintWriter outputFile = new PrintWriter(writeFile);
				Scanner fileRead = new Scanner(file);
				westernSignOne.setDate(date);
				easternSignOne.setDate(date);
				outputFile.println("\n\tPerson #1's Information:");
				outputFile.println("\t---------------------------------------------------------------------------------------------------------");
				outputFile.println(personOne);
				outputFile.println("\n\tYou are highly compatible with:");
				int count = 0;
				int numOfPeople = 0;
				
				while(fileRead.hasNext()) {
					if(fileRead.hasNext()) 
						numOfPeople++;
					
					String fileInput = fileRead.nextLine();
					
					String peopleData [] = fileInput.split(","); 
					
					people.setFName(peopleData[0]);
					people.setMName(peopleData[1]);
					people.setLName(peopleData[2]);

					String month = peopleData[3];
					
					String dates[] = month.split("-");
					
					String birthDays = dates[1];
					int convertedDay = Integer.parseInt(birthDays);
		
					String birthMonths = dates[0];
					int convertedMonth = Integer.parseInt(birthMonths);
					
					String birthYears = dates[2];
					int convertedYear = Integer.parseInt(birthYears);
					
					peopleDates.setYear(convertedYear);
					peopleDates.setMonth(convertedMonth);
					peopleDates.setDay(convertedDay);
					
					people.setBirthDate(peopleDates);
			
					peoplesWesternSign.setDate(peopleDates);
					peoplesEasternSign.setDate(peopleDates);
					
					if(westernSignOne.isCompatible(peoplesWesternSign) && easternSignOne.isCompatible(peoplesEasternSign)) 
						outputFile.println(people);
					
					if(!westernSignOne.isCompatible(peoplesWesternSign) || !easternSignOne.isCompatible(peoplesEasternSign))
						count++;	
				}
				if(count == numOfPeople)
					outputFile.println("\n\t\tYou are not compatible with anyone on the list.");
				
				fileRead.close();	
				outputFile.close();
			}
			
			if(option == 0) {
				System.out.println("\n\tGoodbye!");
				System.exit(0);
			}
			
			while(check != true)
			{
				System.out.println("\n\t\tERROR: Option 1 has not been performed. Please complete before selecting this option.\n");
				break;
			}	
		}while(true);
		
	}
	
	public static void displayBanner() {
		System.out.println("\n\t Western and Eastern Horoscope (12-04-2022)");
		System.out.println("\t=========================================================================================================");
		System.out.println("\t                                                 |            |");
		System.out.println("\t                                                 |            |                  .      .");
		System.out.println("\t JJJJJJJ                                    -----+-----       |            |   (( \\    /");
		System.out.println("\t    J                                           /|\\  ---------+--------    |   ))  \\WW/ _  _");
		System.out.println("\t    J                                         ./ | \\          |       -----+-- oo__@@\\\\/^\\/^\\");
		System.out.println("\t    J                                         /*.*.*\\         |           /|\\  Y,,,,_):\\ / ^ \\");
		System.out.println("\t    J                                       */**.   +\\*       |          / | \\      {_|:/ ^ ^ \\");
		System.out.println("\t    J     aa    v   v    aa                */*****.   \\*      |         /  |  \\_____{_\\ :\\^ ^ ^\\");
		System.out.println("\t    J    a  a   v   v   a  a               /********  .\\      |        /   |  (,____{_ \\ :\\^ ^ ^\\   /\\");
		System.out.println("\t    J    a  a   v   v   a  a              / .***-***. . \\     |       /    |    \\  {__{|.:|)^\\^\\^\\ <.:>");
		System.out.println("\t J  J    a  a    v v    a  a             /     *.*.*     \\    |      /     |     \\{___{(,,):)  ^\\^\\ ||");
		System.out.println("\t J  J    a  a    v v    a  a            (((((((((-)))))))))   |     /      |  ___{____{  .:::)    ^\\||");
		System.out.println("\t  JJ      aa a    v      aa a               ...........       |    /       | (,,__{___{/  .:::)     ||");
		System.out.println("\t                                                              |   (((((((((-))))))){__(   :) .:)-._/:|");
		System.out.println("\t                                                         +++++++++++  ...........   (,,____:)\\______/");
	}
	
	public static void displayMenu() {
		System.out.println("\t==========================================================================================================");
		System.out.println("\t\t1. Your Information.");
		System.out.println("\t\t2. Check to see if you are compatible with another person.");
		System.out.println("\t\t3. Display compatible list between you and a list of people.");
		System.out.println("\t\t4. Output compatible list between you and a list of people.");
		System.out.println("\t------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t0. Exit the program.");
		System.out.println("\t==========================================================================================================");
	}
	
}