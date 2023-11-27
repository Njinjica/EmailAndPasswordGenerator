package emailapp;

import java.util.*;

public class Email {

	private String firstName;
	private String email;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLenght = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";

	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED : " + this.firstName + " " + this.lastName);
		this.department = setDepartment();
		//System.out.println("Department : " + this.department);
		this.password = randomPassword(defaultPasswordLenght);
		//System.out.println("Your password is :" + this.password);

		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
		//System.out.println("Your email is:" + email);
	}

	private String setDepartment() {
		System.out.print("New worker, "+firstName+"\nChoose department \n1. Sales \n2. Development \n3. Accounting \n0. None\n");
		Scanner upis = new Scanner(System.in);
		int depChoice = upis.nextInt();
		switch (depChoice) {
		case 1:
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		case 0:
			return "none";
		default:
			return "";
		}
	}

	private String randomPassword(int lenght) {
		String passwordSet = "ABCDEFGHIJKLMNOPQSRTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz!#$%^&*";
		char[] password = new char[lenght];
		for (int i = 0; i < lenght; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password); // jer je array of char
	}

	private void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	private void changeEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	private void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME:"+firstName+" "+lastName+"\nCOMPANY EMIAL:"+email+"\nPASSWORD:"+password+"\nMAILBOX CAPACITY:"+mailboxCapacity+"mb";
		
	}
	
}

