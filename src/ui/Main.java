package ui;

import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import model.Controller;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws Exception {

		Main exe = new Main();
		int option = 0;
		do{	

			exe.menu();
			option = exe.validateIntegerInput();
			exe.executeOption(option);

		}while(option != 4);
	}

	// Incomplete
	public void menu() {

		System.out.println("---------------------------------------------------");
		System.out.println("Welcome, please, choose an option.");
		System.out.println(" ");
		System.out.println("1. Regist project.");
		System.out.println("2. Consult projects which ends after the date.");
		System.out.println("3. Consult projects which start before the date.");
		System.out.println("4. Exit.");
		System.out.println(" ");
		System.out.println("---------------------------------------------------");
	}

	public void executeOption(int option) throws Exception{

		switch(option){

			case 1:

				System.out.println("You choosed regist project.");
				System.out.println(" ");
				registerProject();
				break;
			
			case 2:

				System.out.println("Follow the steps: ");
				System.out.println(" ");
				searchProjectsAfterDate();
				break;
			
			case 3:

				System.out.println("Follow the steps: ");
				System.out.println(" ");
				searchProjectsBeforeDate();
				break;
			
			case 4: 

				System.out.println("Goodbye.");
				break;
		}
	}

    public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Enter integer value."); 
        }
        return option; 
    }

	public void registerProject() throws Exception{

		String name = " ";
		String clientName = " ";
		double budget = 0;
		
		System.out.println("Type the name of the project: ");
		name = reader.next();
		System.out.println("Type the name of the client: ");
		clientName = reader.next();
		System.out.println("Type the initial date of the project: ");
		String initialDateStr = reader.next();
		System.out.println("Type the final date of the project: ");
		String finalDateStr =  reader.next();
		System.out.println("Finally, type the budget of the project: ");
		budget = reader.nextDouble();


		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar initialDate = Calendar.getInstance();
		initialDate.setTime(format.parse(initialDateStr));
		Calendar finalDate = Calendar.getInstance();
		initialDate.setTime(format.parse(finalDateStr));

		boolean confirmMessage = controller.registerProject(name, clientName, initialDate, finalDate, budget);
		if(confirmMessage == true){
			System.out.println("The project has been registed succesfully.");
		}
		else{
			System.out.println("The project hasnt been registed.");
		}
	}

	public void searchProjectsAfterDate() throws Exception{
		
		String dateToEvaluateStr = " ";

		System.out.println("Type the date to evaluate");
		dateToEvaluateStr = reader.next();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Calendar dateToEvaluate = Calendar.getInstance();
		dateToEvaluate.setTime(format.parse(dateToEvaluateStr));

		String confirmMessage = controller.searchProjectsAfterDate(dateToEvaluate);
		if(confirmMessage != " "){
			System.out.println("The projects that ends after " + dateToEvaluateStr + " are: " + confirmMessage);
		}
		else{
			System.out.println("Wasnt find any project that ends after " + dateToEvaluateStr);
		}
	}

	public void searchProjectsBeforeDate() throws Exception {

		String dateToEvaluateStr = " ";

		System.out.println("Type the date to evaluate");
		dateToEvaluateStr = reader.next();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Calendar dateToEvaluate = Calendar.getInstance();
		dateToEvaluate.setTime(format.parse(dateToEvaluateStr));

		String confirmMessage = controller.searchProjectsBeforeDate(dateToEvaluate);
		if(confirmMessage != " "){
		System.out.println("The projects that start before " + dateToEvaluateStr + " are: " + confirmMessage);
		}
		else{
			System.out.println("Wasnt find any project that start before " + dateToEvaluateStr);
		}
	}
}
