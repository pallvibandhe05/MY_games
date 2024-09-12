package emailApp;

import java.util.Scanner;

public class Email {

	 private String firstName,lastName, password, department,alternateEmail,email,componyName;
	private int mailBoxCapacity, PasswordLength = 10;
	
	//constructor to get first and last name
	 public Email(String firstName, String lastName) {
		 Scanner sc = new Scanner(System.in);
		 this.firstName = firstName;
		 this.lastName = lastName;
		  System.out.print( "Create email for : " + this.firstName +" " +  this.lastName);
		  System.out.println();
		  System.out.print("Enter your company name : ");
		  String componyName = sc.next();
		  System.out.print("Company : " + componyName);
		 this.department = DeptName();
		System.out.println("Departement : " + this.department);
		
		
		
		
		email = firstName.toLowerCase() + "_" + lastName.toLowerCase() + "@" + department +"." +componyName + ".com";
		System.out.println("Your Email is : " + email);
		
		this.password = RandomPass(PasswordLength);
		System.out.println("Your Password is : " + this.password);
	 }
	//ask for dept
	 private String DeptName() {
		 System.out.println("Enter department code \n0 for None\n1 for Sales \n2 for Development \n3 for Management \n4 for Accounting");
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter Department Code : ");
		 int dept = sc.nextInt();
		 if(dept == 1) {
			 return "sales";
		 }if(dept == 2) {
			 return "development";
		 }if(dept == 3) {
			 return "management";
		 }if(dept == 4) {
			 return "accounting";
		 }
		 else
			 return "";
	 }
	
	
	
	
	//create random password
	 private String RandomPass(int length) {
		 String PassSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*_-abcdefghijklmnopqrstuvwxyz";
		 char [] password = new char[length];
		 for(int i = 0; i<length;i++) {
			 int random = (int)(Math.random()*PassSet.length());
			 password[i] = PassSet.charAt(random);
			  
		 }
		 return new String(password);
	 }
	//set Mail capacity
	 public void setMailBox(int capacity) {
		 this.mailBoxCapacity = capacity;
	 }
	//set alternative email
	 public void setAlternateMail(String alternateEmail) {
		 this.alternateEmail = alternateEmail;
	 }
	 
	 //change the password
	 
	 public void ChangePass(String password) {
		 this.password = password;
	 }
	 
	 public int getMailBoc(){
		 return mailBoxCapacity;
	 
	 }
	 public String getAlternateEmail() {
		 return alternateEmail;
		 
	 }
	 public String getPassword() {
		 return password;
		 
	 }
	
	
}
