//this program was written by andrew sears
import java.util.Scanner;
import static java.lang.System.out;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner input = new Scanner(System.in);	
      out.println("        Employee Lookup Program");				//program title
      out.println("A) Find all employees with a given title");	//give user options
      out.println("B) Find a single employee");
      out.println("X) Exit the program");
      out.print("          Enter your choice: ");					//ask for choice
      String holder = input.next();								//take choice as string
      char given = holder.charAt(0);								//turn input into a char
      if(given == 'A'){											//if given is char A
         out.println("1)   Hourly Employee");					//give user options
         out.println("2)   Salaried Emplyee");
         out.println("3)   Supervisory Employees");
         out.println("       Enter 1, 2, or 3: ");				//ask for input
         int type = input.nextInt();								//take input as int
         out.printf("%17s %15s %18s %19s\n", "name", "id", "gross", "employed");	//print formated header
         out.printf("%53s %15s\n","Weekly", "Since");
         out.printf("%50s\n\n","Pay");
         if(type == 1) {											//if input was 1
            readFile(1);										//call readfile method and pass 1
         }
         else if(type == 2) {									//if input was 2
            readFile(2);										//call readfile method and pass 2
         }
         else if(type == 3) {									//if input was 3
            readFile(3);										//call readfile method and pass 3
         }
         else {													//if input was not valid
            out.println("invalid input");						//print input was invalid
         }
      }
      else if (given == 'B'){										//if given is char B
         out.print("Enter the ID of the employee: ");			//ask for id number
         int giveId = input.nextInt();							//take input as int
         readFile(giveId);										//call readfile and pass id
      }
      else if (given == 'X');										//if given is char X
      else{														//if input was not valid
         out.println("invalid input");							//print input was invalid
      }
      input.close();												//close scanner
   }
	
	
	
   public static void readFile(int typ) throws FileNotFoundException {
      Scanner inputFile = new Scanner(new File("employeeData.txt"));	//open read file
      int single = 0;											//Declare single int
      for(int i = 19;i != 0;i--){								//loop 19 times
         String line = inputFile.nextLine();					//take in next line of file
         String[] array = line.split(";");					//split up line by each string
         String title = array[0];							//Declare variables based on txt formate
         String name = array[1];								
         String address = array[2];
         String id = array[3];
         String bossId = array [4];
         String startYear = array [5];
         if (array[0].equals("Hourly")) {					//if title is hourly
            String rate = array [6];						//Declare remaining variables for hourly
            int length = line.length();						//get length of line read and read in hours
            int tens = Character.getNumericValue(line.charAt(length-2));	//would not work with using array D:
            int ones = Character.getNumericValue(line.charAt(length-1));
            int hours = (tens * 10) + ones;					//calculate total hours
            if(typ == 1) {									//if input was 1
               out.printf("%20s %15s %8s %.02f %15s\n",name , id , "" ,		//formated print of hourly employee
                  	hourlyEmployee.getGrossWeeklPay(Float.parseFloat(rate), hours) , startYear);
            }
            else if(typ == Integer.parseInt(id)) {			//if input and id match
               out.println(name + "   " + id + " " + title + " Employee, "		//formated print of hourly employee
                  	+ "employed since " + startYear);
            }
            else single++;									//add one to singles to determine in no print occurred
         }
         else if (array[0].equals("Salaried")) {				//if title is salaried
            String salary = array [6];						//Declare remaining variables
            if(typ == 2) {									//if input was 2
               out.printf("%20s %15s %8s %.02f %15s\n", name , id , "" , 		//formated print of salaried employee
                  	salariedEmployee.getGrossWeeklyPay(Float.parseFloat(salary)) , startYear);
            }
            else if(typ == Integer.parseInt(id)) {			//if input and id match
               out.println(name + "   " + id + " " + title +		//formated print of salaried employee
                  	" Employee, employed since " + startYear);
            }
            else single++;									//add one to single
         }
         else if (array[0].equals("Supervisor")) {			//if title is supervisor
            String salary = array [6];						//Declare remaining variables 
            String bonus = array [7];
            if(typ == 3) {									//if input was 3
               out.printf("%20s %15s %8s %.02f %15s\n", name , id , "", 	//formated print for supervisor
                  	supervisor.getGrossWeeklyPay(Float.parseFloat(salary),Float.parseFloat(bonus)) , startYear);
            }
            else if(typ == Integer.parseInt(id)) {			//if input and id match
               out.println(name + "   " + id + " " + title + 	//formated print for sipervisor
                  	", employed since " + startYear);	
            }	
            else single++;									//add one to single
         }
      }
      inputFile.close();
      if(single == 19)										//if no print statements occurred 
         out.println("Sorry, no employee with ID "+ typ +" was found"); //no match found
   }
	
}
