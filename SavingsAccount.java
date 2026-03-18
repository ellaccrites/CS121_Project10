import java.util.*;
import java.io.*;

public class SavingsAccount extends CheckingAccount implements HasMenu {
	double balance;
	private double interestRate;

	public static void main(String[] args){
		SavingsAccount sa = new SavingsAccount();
		sa.start();
	}// end main

	public SavingsAccount(){
		this.balance = 0d;
	}// end no param constructor
	
	public SavingsAccount(double balance){
		this.balance = balance;
	}// end constructor
	
	public String menu(){
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal");
		System.out.print("Choose 0-3: ");

		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();

		return userChoice;
	}// end menu
	
	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = this.menu();
			if(userChoice.equals("0")){
				System.out.println("Leaving Account Menu...");
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
		System.out.println("Current balance: " + this.getBalanceString());
	}// end checkBalance
	
	public void calcInterest(){
		double interestEarned = this.balance * this.interestRate;
		this.balance = this.balance + interestEarned;
	}// end calcInterest
	
	public void setInterestRate(double interestRate){
		this.interestRate = interestRate;
	}// end setInterestRate
	
	public void getInterestRate(){
		System.out.print(this.interestRate);
	}// end getInterestRate

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
		System.out.print("Amount to deposit? ");
		double newBalance = this.balance + getDouble();
		this.setBalance(newBalance);

		System.out.println("New balance: " + getBalanceString());
	}// end makeDeposit
	
	public void makeWithdrawal(){
                System.out.print("Amount to withdrawal? ");
		double toWithdraw = 0d;
		toWithdraw = getDouble();

		if(toWithdraw > this.balance){
			System.out.println("There is not enough in account to withdraw entered amount.");
		}else{
			double newBalance = this.balance - toWithdraw;
			this.setBalance(newBalance);
			System.out.println("New balance: " + getBalanceString());
		}// end if else
	}// end makeWithdrawal

}// end class
