package Day_5;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Day_3.User;

public class BankAccountSimulation {

	private static final Scanner scanner = new Scanner(System.in);
	private static List<Account> accountList = new ArrayList<>();	
	
	public static void main(String[] args) {
		
		System.out.println("___Welcome to the Bank Account Simulation___");
		
		while(true) {
			registrationLogin();
			int choice = getChoice();
			
			try {
				switch(choice) {
					case 1 -> registration();
					case 2 -> login();
					case 3 -> { System.out.println("Exiting... Thankyou ^-^\n"); return;}
					default -> System.out.println("Invalid Choice ! Please select number from 1 to 3\n");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input ! Please try again\n");
				scanner.nextLine();
			}
		}
		
		
	}

	private static void registrationLogin() {
		System.out.println();
		System.out.println("1. Create Account");
		System.out.println("2. Login");
		System.out.println("3. Exit\n");
		System.out.print("Enter choice : ");
	}

	private static void login() {
		System.out.print("Enter your AccountNumber : ");
		String accNumber = scanner.next();
		
		Account user = findAccount(accNumber);
		if(user != null) {
			
			while(true) {
				showMenu();
				int choice = getChoice();
		
				try {
					switch(choice) {
						case 1 -> deposit(user);
						case 2 -> withdrawl(user);
						case 3 -> user.viewBalance();
						case 4 -> user.transactionHistory();
						case 5 -> { return; }
						default -> System.out.println("Invalid Choice ! Please select number from 1 to 5\n");
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid Input ! Please try again\n");
					scanner.nextLine();
				}
			}
		}
		else {
			System.out.println("Invalid AccountNumber !\n");
			return;
		}
	}

	private static void withdrawl(Account user) {
		try {
			System.out.print("Enter Withdrawl Amount : ");
			int amount = scanner.nextInt();
			user.withdrawl(amount);
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input ! Please try again !\n");
			scanner.nextLine();
			return;
		}
	}

	private static void deposit(Account user) {
		try {
			System.out.print("Enter Deposit Amount : ");
			int amount = scanner.nextInt();
			user.deposit(amount);
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input ! Please try again !\n");
			scanner.nextLine();
			return;
		}
	}

	private static Account findAccount(String accNumber) {
		for(Account user : accountList) {
			if(user.getAccountNumber().equalsIgnoreCase(accNumber)) {
				return user;
			}
		}
		return null;
	}

	private static void showMenu() {
		System.out.println();
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawl");
		System.out.println("3. View Balance");
		System.out.println("4. TransactionHistory");
		System.out.println("5. Back to HomePage\n");
		System.out.print("Enter Choice : ");
	}

	private static void registration() {
		System.out.print("Enter your name : ");
		String name = scanner.next();
		Account user = new Account(name);
		accountList.add(user);
		System.out.println("Account Created Successfully...");
		System.out.println("Your AccountNumber : "+user.getAccountNumber()+"\n");
	}

	private static int getChoice() {
		try {
			return scanner.nextInt();
		}
		catch(InputMismatchException e) {
			scanner.nextLine();
			return -1;
		}
	}

}
