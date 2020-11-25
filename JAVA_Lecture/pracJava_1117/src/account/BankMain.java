package account;

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		bank.setBalance(10000);
		System.out.println("ÇöÀçÀÜ°í : " + bank.getBalance());
		bank.setBalance(-100);
		System.out.println("ÇöÀçÀÜ°í : " + bank.getBalance());
		bank.setBalance(30000);
		System.out.println("ÇöÀçÀÜ°í : " + bank.getBalance());
	}
}
