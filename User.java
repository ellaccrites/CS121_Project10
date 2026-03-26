import java.util.*;
import java.io.*;

abstract class User implements HasMenu, Serializable {
	String userName;
	String PIN;
	
	public boolean login(String userName, String PIN){;
                if(userName.equals(this.userName)){
                        if(PIN.equals(this.PIN)){
                                return true;
                        } else {
                                return false;
                        }// end if else
                } else {
                        return false;
                }// end if else
        }// end login with parameters
	
	public boolean login(){
		Scanner input = new Scanner(System.in);
		System.out.println("if you see this, you're in the wrong login.");
		System.out.print("User name: ");
		String userName = input.nextLine();

		System.out.print("PIN: ");
		String PIN = input.nextLine();
		
		if(userName.equals(this.userName)){
			if(PIN.equals(this.PIN)){
			System.out.println();
				return true;
			} else {
				System.out.println();
				return false;
			}// end if else
		} else {
			System.out.println();
			return false;
		}// end if else
	}// end login
	
    	public void setUserName(String userName){
		this.userName = userName;
	}// end setUserName
	
    	public String getUserName(){
		return this.userName;
	}// end getUserName
	
   	public void setPin(String PIN){
		this.PIN = PIN;
	}// end setPIN
	
    	public String getPin(){
		return this.PIN;
	}// end getPIN
	
    	public abstract String getReport();
}// end class
