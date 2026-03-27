import java.util.*;
import java.io.*;

public class SavingsAccount extends CheckingAccount implements HasMenu, Serializable {
	private double interestRate = .05d;

	public static void main(String[] args){
		SavingsAccount sa = new SavingsAccount();
		sa.start();
	}// end main
	
	public SavingsAccount(){
		this.balance = 0d;
	}// end constructor
	
	public SavingsAccount(double balance){
                this.balance = balance;
        }// end constructor
	
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
}// end class
