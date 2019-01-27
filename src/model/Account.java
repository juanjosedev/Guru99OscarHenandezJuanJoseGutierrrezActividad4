package model;

public class Account {
	
	private int no;
	private String type;
	private int balance;
	
	public Account(int no, String type) {
		this.no = no;
		this.type = type;
		this.balance = 0;
	}
	
	public Account(int no, String type, int balance) {
		this.no = no;
		this.type = type;
		this.balance = balance;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [no=" + no + ", type=" + type + ", balance=" + balance + "]";
	}

}
