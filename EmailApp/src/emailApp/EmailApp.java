package emailApp;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first name : ");
		String First = sc.next();
		
		System.out.print("Enter your last name : ");
		String Last = sc.next();
		Email em1= new Email(First , Last);
	     
	      String newEmail = Character.toString(First.charAt(0)) + Character.toString(Last.charAt(0)) ;
		 em1.setAlternateMail(newEmail +  "@gmail.com");
      System.out.print("Your alternative email is : " + em1.getAlternateEmail());
	}

}
