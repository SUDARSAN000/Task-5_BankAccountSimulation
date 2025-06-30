package Day_5;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private static int accountCount = 1001;
	
	private String accountNumber;
	private String holderName;
	private double balance;
	private List<Transaction>transactions;
	
	public String getAccountNumber() { return accountNumber; }

	public String getHolderName() { return holderName; }
	
	public Account(String holderName) {
		this.accountNumber = "ACC" + accountCount++;
		this.holderName = holderName;
		this.balance = 0.0;
		this.transactions = new ArrayList<>();
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Amount must be greater that zero !\n");
			return;
		}
		balance += amount;
		transactions.add(new Transaction("Deposit", amount));
		System.out.println("Amount Deposited Successfully...\n");
	}
	
	public void withdrawl(double amount) {
		if(amount <= 0) {
			System.out.println("Amount must be greater than zero !\n");
			return;
		}
		if(amount > balance) {
			System.out.println("Insufficient Balance ! \n");
			return;
		}
		balance -= amount;
		transactions.add(new Transaction("Withdrawl", amount));
		System.out.println("Amount withdrawn successfully...\n");
	}
	
	public void viewBalance(){
		System.out.println();
		System.out.println("AccountNumber : "+accountNumber);
		System.out.println("HolderName : "+holderName);
		System.out.println("Balance : "+balance+"\n");
	}
	
	public void transactionHistory(){
		if(transactions.isEmpty()) {
			System.out.println("No Transactions Available !\n");
			return;
		}
		System.out.println("Transaction History : ");
		transactions.forEach(System.out::println);
		System.out.println();
	}
}
