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
                System.out.println("2) Login as customer");
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
				System.out.println("-- Administrator Login --");
				System.out.println();
				boolean status = this.admin.login();
				if(status){
					this.adminStart();
				} else {
					System.out.println("Incorrect username or password.");
				}// end if
			} else if(userChoice.equals("2")){
				System.out.println("Customer Login");
				// call cutomer login function
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}// end else if
			System.out.println();
		}// end while
	}// end start
	
	public void adminStart(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.admin.menu();
			if(userChoice.equals("0")){
				System.out.println("Quitting Admin menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("Generating cusomer report...");
				// call report function
			} else if(userChoice.equals("2")){
				System.out.println("Preparing to add user...");
				// call add user function
			} else if(userChoice.equals("3")){
				System.out.println("Applying interest...");
				// call interest function
			} else{
				System.out.println("Please enter 0, 1, 2, or 3");
			}// end if else
			System.out.println();
		}// end while
	}// end adminStart
}// ends class def

class CustomerList extends ArrayList<Customer> {};

