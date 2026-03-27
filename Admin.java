import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu {
	private String userName;
	private String PIN;

        public static void main(String[] args){
		Admin a = new Admin();
		a.start();
	}// end main
	
	public Admin(){
		this.setUserName("admin");
		this.setPin("0000");
	}// end constructor
	
	public void start(){
		System.out.println("user: " + this.getUserName() + "Pin: " + this.getPin());
	}// end start
	
	public String menu(){
                System.out.println("-- In Admin Menu --");
                System.out.println("0) Quit");
                System.out.println("1) Print full customer report");
                System.out.println("2) Add a customer");
                System.out.println("3) Apply interest to savings accounts");
                System.out.print("Choose 0-3: ");

                Scanner input = new Scanner(System.in);
                String userChoice = input.nextLine();
                System.out.println();

                return userChoice;
        }// end menu
	
	public String getReport(){
		String report = "User Name: " + this.userName + ", PIN: " + this.PIN;
		return report;
	}// end getReport
}// end class def

