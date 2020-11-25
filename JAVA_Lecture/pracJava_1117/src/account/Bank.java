package account;

public class Bank {
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if (balance > MAX_BALANCE || balance < MIN_BALANCE) {
			this.balance = this.balance;
		} else {
			this.balance = balance;
		}
	}
	public Bank() {

	}
	
	
}
