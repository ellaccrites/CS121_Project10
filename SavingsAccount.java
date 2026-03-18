import java.util.*;

public class SavingsAccount extends CheckingAccount implements HasMenu {
	private double interestRate = .05d;

	public static void main(String[] args){
		SavingsAccount sa = new SavingsAccount();
		sa.start();
	}// end main

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
