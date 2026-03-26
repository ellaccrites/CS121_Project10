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
		System.out.println();
		boolean keepGoing = true;
		while(keepGoing){
			String userChoice = menu();
			if(userChoice.equals("0")){
				System.out.println("Exiting system...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("-- Administrator Login --");
				boolean status = this.admin.login();
				if(status){
					this.adminStart();
				} else {
					System.out.println("Incorrect username or password.");
				}// end if
				System.out.println();
			} else if(userChoice.equals("2")){
				this.customerLogin();
				// call cutomer login function
			} else {
				System.out.println("Please enter 0, 1, or 2");
			}// end else if
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
				this.fullCustomerReport();
			} else if(userChoice.equals("2")){
				System.out.println("Preparing to add user...");
				this.addUser();
			} else if(userChoice.equals("3")){
				System.out.println("Applying interest...");
				this.applyInterest();
			} else{
				System.out.println("Please enter 0, 1, 2, or 3");
			}// end if else
			System.out.println();
		}// end while
	}// end adminStart
	
	public void customerLogin(){
		System.out.println("-- Customer Login --");
		Scanner input = new Scanner(System.in);
                System.out.print("User name: ");
                String userName = input.nextLine();
                System.out.print("PIN: ");
                String PIN = input.nextLine();

		Customer currentCustomer  = new Customer();
		for(int i = 0; i < customers.size(); i++){
			boolean status = customers.get(i).login(userName, PIN);
			if(status){
				currentCustomer = customers.get(i);
			} else {
				System.out.println("Login unsuccessful.");
			}// end if else
		}// end for
		System.out.println();
		currentCustomer.start();
	}// end customerLogin
	
	public void addUser(){
		System.out.println("Please enter the folowing information...");
		Scanner input = new Scanner(System.in);
                System.out.print("User name: ");
                String userName = input.nextLine();
                System.out.print("PIN: ");
                String PIN = input.nextLine();

		Customer c = new Customer(userName, PIN);
		customers.add(c);
	}// end addUser
	
	public void fullCustomerReport(){
		for(int i = 0; i < customers.size(); i++){
			String report = customers.get(i).getReport();
			System.out.println(report);
		}// end for
	}// end fullCustomerReport
	
	public void applyInterest(){
		for(int i = 0; i < customers.size(); i++){
			customers.get(i).savings.calcInterest();	
		}// end for
		fullCustomerReport();
	}// end applyInterest
}// ends class def

class CustomerList extends ArrayList<Customer> {};

