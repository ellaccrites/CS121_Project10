import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

	public static void main(String[] args){
		new Bank();
	}// end main
	
	public Bank(){
		this.start();
	}// end constructor
	
	public String menu(){
                System.out.println("-- Bank Menu --");
                System.out.println("0) exit");
                System.out.println("1) Login as admin");
                System.out.println("2) Login as user");
		System.out.println();
                System.out.print("Choose 0-2: ");

                Scanner input = new Scanner(System.in);
                String userChoice = input.nextLine();
                System.out.println();

                return userChoice;
        }// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = menu();
			if(userChoice.equals("0")){
				System.out.println("Exiting system...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("Administrator Login");
			} else if(userChoice.equals("2")){
				System.out.println("Customer Login");
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}// end else if
			System.out.println();
		}// end while
	}// end start

}// ends class def

class CustomerList extends ArrayList<Customer> {};

