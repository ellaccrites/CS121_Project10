import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
	Admin admin = new Admin();
	CustomerList customers = new CustomerList();

	public static void main(String[] args){
		new Bank();
	}// end main
	
	public Bank(){
    		// uncomment the next two lines to refresh data

    		//this.loadSampleCustomers();
    		//this.saveCustomers();
    		this.loadCustomers();
    		this.start();
    		this.saveCustomers();
  	} // end constructor
	
	public String menu(){
                System.out.println("-- Bank Menu --");
                System.out.println("0) Exit system");
                System.out.println("1) Login as admin");
                System.out.println("2) Login as customer");
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
				System.out.print("Quitting Admin menu...");
				keepGoing = false;
			} else if(userChoice.equals("1")){
				System.out.println("Generating cusomer report...");
				this.fullCustomerReport();
			} else if(userChoice.equals("2")){
				System.out.println("Preparing to add customer...");
				this.addCustomer();
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
		for(Customer customer: customers){
			boolean status = customer.login(userName, PIN);
			if(status){
				currentCustomer = customer;
			}// end if
		}// end for	
			
		if(currentCustomer == null){
			System.out.println("Could not login. Please check username and password.");
		}// end if

		currentCustomer.start();
	}// end customerLogin
	
	public void addCustomer(){
		System.out.println("Please enter the folowing information:");
		Scanner input = new Scanner(System.in);
                System.out.print("User name: ");
                String userName = input.nextLine();
                System.out.print("PIN: ");
                String PIN = input.nextLine();

		Customer c = new Customer(userName, PIN);
		customers.add(c);
	}// end addUser
	
	public void fullCustomerReport(){
		for(Customer customer: customers){
			System.out.println(customer.getReport());
		}// end for
	}// end fullCustomerReport
	
	public void applyInterest(){
		for(Customer customer: customers){
			customer.savings.calcInterest();
                }// end for
		System.out.println("Printing Updated User Report...");
		fullCustomerReport();
	}// end applyInterest
	
	public void loadSampleCustomers(){
		customers.add(new Customer("Anna", "1111"));
		customers.add(new Customer("Benny", "2222"));
		customers.add(new Customer("Carol", "3333"));
	}// end loadSampleCustomers
	
	public void loadCustomers(){
		try {
			FileInputStream fi = new FileInputStream("Customers.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			customers = (CustomerList)obIn.readObject();

			obIn.close();
			fi.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}// end try
        }// end loadCustomers
	
	public void saveCustomers(){
		try {
			FileOutputStream fo = new FileOutputStream("Customers.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(customers);
			obOut.close();
			fo.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}// end try
	}// end saveCustomers

}// end class def	

class CustomerList extends ArrayList<Customer> {};

