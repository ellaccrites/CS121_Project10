import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {
	double balance;

	public static void main(String[] args){
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	}// end main

	public CheckingAccount(){
		this.balance = 0d;
	}// end no param constructor
	
	public CheckingAccount(double balance){
		this.balance = balance;
	}// end constructor
	
	public String menu(){
		System.out.println("0) Quit");
		System.out.println("1) Check balance");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.print("Choose 0-3: ");

		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		
		System.out.println();
		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.menu();
			if(userChoice.equals("0")){
				System.out.print("Leaving Account Menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("Checking balance...");
				this.checkBalance();
			} else if(userChoice.equals("2")){
				System.out.println("Making a deposit...");
				this.makeDeposit();
			} else if(userChoice.equals("3")){
				System.out.println("Making a withdrawal...");
				this.makeWithdrawal();
			} else{
				System.out.println("Not a valid input.");
			}// end else if
			System.out.println();
		}// end while
	}// end start
	
	public double getBalance(){
		return this.balance;
	}// end getBalance
	
	public String getBalanceString(){
		String result = String.format("$%.02f", this.balance);
		return result;
	}// end get balance string
	
	public void setBalance(double balance){
		this.balance = balance;
	}// end setBalance
	
	public void checkBalance(){
		System.out.println();
		System.out.println("Current balance: " + this.getBalanceString());
	}// end checkBalance
	
	private double getDouble(){
		Scanner input = new Scanner(System.in);
		String amount = input.nextLine();
		
		double doubleAmount = 0d;
		try{
			doubleAmount = Double.parseDouble(amount);
		}catch(NumberFormatException e){
			System.out.println("Please input a number.");
		}// end try
		return doubleAmount;
	}// end getDouble
	
	public void makeDeposit(){
		System.out.println();
		System.out.print("Amount to deposit? ");
		double newBalance = this.balance + getDouble();
		this.setBalance(newBalance);

		System.out.println("New balance: " + getBalanceString());
	}// end makeDeposit
	
	public void makeWithdrawal(){
                System.out.println();
		System.out.print("Amount to withdrawal? ");
		double toWithdraw = 0d;
		toWithdraw = getDouble();

		if(toWithdraw > this.balance){
			System.out.println("Insufficient funds.");
		}else{
			double newBalance = this.balance - toWithdraw;
			this.setBalance(newBalance);
			System.out.println("New balance: " + getBalanceString());
		}// end if else
	}// end makeWithdrawal

}// end class
