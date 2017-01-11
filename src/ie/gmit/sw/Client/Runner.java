package ie.gmit.sw.Client;

import ie.gmit.sw.Client.config.*;
import java.util.*;
import ie.gmit.sw.Server.*;

public class Runner {
	public static void main(String[] args) throws Throwable{
		
		Scanner console = new Scanner(System.in);
		
		// Asking user to select a action
		System.out.println("Enter Your Choice (1-4)"
				+ "\n1. Connect To The Server."
				+ "\n2. Print File Listings."
				+ "\n3. Download File"
				+ "\n4. Quit.");
		// Reading in the users choice
		int selection = console.nextInt();
		
		// Creating instances of other classes
		Connect con = new Connect();
		Parser parse = new Parser();
		XMLParser xParse = new XMLParser(parse);
		xParse.initRun();
		
		// While the choice is not 4 keep looping
		while (selection != 4){
			// If the user selects 1, connect to the server
			if(selection == 1){
				con.runCon();
			}
			else if(selection == 2){
				System.out.println("Printing files");
			}
			else if(selection == 3){
				System.out.println("Downloading file");
			}
			else if(selection == 4){
				System.out.println("Ending program");
				console.close();
				con.closeCon();
			}
			// Subsequent read of the menu
			System.out.println("Enter Your Choice (1-4)"
					+ "\n1. Connect To The Server."
					+ "\n2. Print File Listings."
					+ "\n3. Download File"
					+ "\n4. Quit.");
			 selection = console.nextInt();
			
		}
	}
	
}

