package bai3;

public class Account {
	protected double balance;
	protected String acct_id;
	
	public Account () {};
	public Account(String id) {
		this.acct_id = id;
		this.balance = 0;
	}
	
	public void setAcct_id(String id) {this.acct_id = id;}
	public void setBalance(double balance) {this.balance = balance;}
	
	public String getAcct_id() {return this.acct_id;}
	public double getBalance() {return this.balance;}
	
	public void withdraw(double aMount) {
		this.balance = balance+aMount;
	}
	
	public boolean deposit(double aMount) {
		if (aMount>balance) {
			return false;
		} else {
			this.balance = balance-aMount;
			return true;
		}
	}
	
	@Override
	public String toString() {
		return String.format("ACC|%s|%.2f", acct_id,balance);
	}
}
