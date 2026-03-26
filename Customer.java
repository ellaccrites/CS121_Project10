import java.util.*;
import java.io.*;

public class Customer extends User implements HasMenu {
	CheckingAccount checking;
	SavingsAccount savings;

	public static void main(String[] args){
		Customer c = new Customer("Alice", "0000");
		c.start();
	}// end main
	
	public Customer(){
		this.checking = new CheckingAccount();
		this.savings = new SavingsAccount();
		System.out.println();
	}// end customer
	
	public Customer(String userName, String PIN){
		this.setUserName(userName);
		this.setPin(PIN);

		this.checking = new CheckingAccount(5d);
                this.savings = new SavingsAccount(10d);
	}// end customer with params
	
    	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.menu();
			if(userChoice.equals("0")){
				System.out.println("Leaving Customer Menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("-- In Checking Account --");
				this.checking.start();
			} else if(userChoice.equals("2")){
				System.out.println("-- In Savings Account --");
				this.savings.start();
			} else if(userChoice.equals("3")){
				this.changePin();
			} else {
				System.out.println("Not a valid input.");
			}// end else if
			System.out.println();
		}// end while
	}// end start
	
	public String menu(){
		System.out.println("-- In Customer Menu --");
		System.out.println("0) quit");
		System.out.println("1) manage Checking Account");
		System.out.println("2) manage Savings Account");
		System.out.println("3) change PIN");
		System.out.print("Choose 0-3: ");

		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		System.out.println();

		return userChoice;
	}// end menu
	
	public void changePin(){
		Scanner input = new Scanner(System.in);
		System.out.print("What would you like to change PIN to? ");
		String newPin = input.nextLine();
		this.setPin(newPin);
	}// end changePIN
	
	public String getReport(){
		String report = "User: " + this.getUserName() + ", Checking: $" + this.checking.getBalance() + ", Savings: $" + this.savings.getBalance();
		return report;
	}// end getReport
}// end class
