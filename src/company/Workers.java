package company;

import java.util.Scanner;

public class Workers {

	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String position;
	private String courses = "";
	private String quality, production, logistics, maintenance, planning, complaints;
	private String id;
	private char firstDepartmentLetter;
	private int defaultPasswordLenght = 10;
	private int priceProgramming = 750; 
	private int priceMsOffice = 500; 
	private int priceAutoCad = 350; 
	private double balance = 0;
	double payment = 0;
	boolean positivePayment = true;
	boolean rightCourseSelection = true;
	
	
	// Constructor

		public Workers() {

			this.firstName = setFirstName();
			
			this.lastName = setLastName();

			this.position = setPosition();

			this.department = setDepartment();

			this.email = setEmail();

			this.password = randomPassword(defaultPasswordLenght);

			this.id = setID();
			
			setCourse();

			payment();

		}

		// Ask for the firstName

		private String setFirstName() {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter worker first name ");
			this.firstName = in.nextLine();
			return firstName;
		}

		// Ask for the lastName

		private String setLastName() {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter worker last name ");
			this.lastName = in.nextLine();
			return lastName;
		}

		// Ask for the position

		private String setPosition() {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter worker position : \n1 - Manager "
					+ "\n2 - Leader \n3- Specialist \n4 - Assistant \n5 - Trainee \n6 - Manual Worker");
			int positionChoice = in.nextInt();
			
			switch (positionChoice) {
			case 1 : return "Manager";
			
			case 2 : return "Leader";
			
			case 3 : return "Specialist";
			
			case 4 : return "Assistant";
			
			case 5 : return "Trainee";
			
			case 6 : return "Manual Worker";
			}
			return "Unidentified position";
			
		}
			
			
		// Ask for the department

		private String setDepartment() {

			Scanner in = new Scanner(System.in);
			System.out.println("\nPodaj department: \n1 - Quality \n2 - Production \n3 - Logistics "
					+ "\n4 - Maintenance \n5 - Planning \n6 - Complaints");
			int departmentChoice = in.nextInt();
			
			switch(departmentChoice) {
			
			case 1 : quality = "Quality";
			return quality;
			
			case 2 : production = "Production";
			return production;
			
			case 3 : logistics = "Logistics";
			return logistics;
			
			case 4 : maintenance = "Maintenance";
			return maintenance;
			
			case 5 : planning = "Planning";
			return planning;
			
			case 6 : complaints = "Complaints";
			return complaints;
			}
			return "Unidentified department";
			
		}

		
		
		
		
		// Generate the email

		private String setEmail() {
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "MAN.com";
			return email;
		}
		
		
		
		

		// Generate random password

		private String randomPassword(int length) {
			String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ1234567890";
			char[] password = new char[length];
			for (int i = 0; i < length; i++) {
				int rand = (int) (Math.random() * passwordSet.length());
				password[i] = passwordSet.charAt(rand);
			}
			return new String(password);
		}

		
		
		
		// Generate worker ID

		private String setID() {
			int randomNumber = (int) (Math.random() * Math.pow(10, 4));
			id = department.substring(0, 1) + randomNumber;
			//firstDepartmentLetter + "" + 
			return id;
		}

		
		
		
		// Enroll worker to the courses

		public void setCourse() {
			System.out.println(
					"\nCourse Prices : \n1 -Programming - 750 $ \n2 -MSOffice - 500 $ \n3 -AutoCad - 350 $");
			do {
				System.out.println("Enter the course number");
				Scanner in = new Scanner(System.in);
				try {
					int courseNumber = in.nextInt();
					if (courseNumber != 1 && courseNumber != 2 & courseNumber != 3) {
						throw new WrongCourseSelection(courseNumber);
					}
					else if (courseNumber == 1){
						courses = courses + "Programming";
						balance = balance + priceProgramming;
						rightCourseSelection = true;
					}
					else if (courseNumber == 2){
						courses = courses + "MSOffice";
						balance = balance + priceMsOffice;
						rightCourseSelection = true;
					}
					else if (courseNumber == 3){
						courses = courses + "AutoCad";
						balance = balance + priceAutoCad;
						rightCourseSelection = true;
					}
				}catch (WrongCourseSelection e) {
					System.out.println(e.toString());
					rightCourseSelection = false;
					}
				}while (!rightCourseSelection);
				System.out.println("Thanks for the enroll");
		}

	
		// Pay for the courses

		public void payment() {
			
			System.out.println("Bill: " + balance +"$");
			do {
			System.out.println("Enter the payment amount");
			Scanner in = new Scanner(System.in);
			try {
				payment = in.nextDouble();
				if (payment < 0 || payment > balance) {
					throw new NegativePaymentException(payment, balance);
				}
				else {
					positivePayment = true;
				}
			} catch (NegativePaymentException e) {
				System.out.println(e.toString());
				positivePayment = false;
			}
		}while(!positivePayment);	
			
		System.out.println("Thanks for the payment of " + payment + " $");
		balance = balance - payment;
		
		}

		// Show info

		public String info() {
			return "First Name: " + firstName + "\nLast Name: " + lastName + "\nPosition: " + position + "\nDepartment: " + department
					+ "\nWorker ID: " + id + "\nEmail: " + email + "\nPassword: " + password + "\nChosen courses: " + courses + "\nBill balance: " + balance + " $";
		}

	}