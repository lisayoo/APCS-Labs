/**
 * Tests the concrete account classes, which include
 * CheckingAccount, SavingsAccount, and TimeDepositAccount.
 * @author Lisa Yoo
 *
 */
public class BankAccountTester 
{
	public static void main(String[] args)
	{
		BankAccount a = new CheckingAccount(158);
		BankAccount b = new SavingsAccount(158, 3);
		BankAccount c = new TimeDepositAccount(158, 3, 4);
				
		BankAccount.test(a);
		System.out.println("Expected balance is $284.00.");
		System.out.println("Balance is $" + a.getBalance() + ".");
		
		BankAccount.test(b);
		System.out.println("Expected balance is $292.74.");
		System.out.println("Balance is $" + b.getBalance() + ".");
		
		BankAccount.test(c);
		System.out.println("Expected balance is $217.74.");
		System.out.println("Balance is $" + c.getBalance() + ".");
	}
	
}
