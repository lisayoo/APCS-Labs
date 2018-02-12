/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public abstract class BankAccount
{
    private double balance;
    
    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount()
    {
        balance = 0;
    }
    
    /**
     * Constructs a bank account with a given balance.
     * @param initialBalance The initial balance
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount The amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    
    /**
     * Returns the current balance of the bank account.
     * @return The current balance
     */
    public String getBalance()
    {
    	if ((balance * 100) % 10 == 0)
    	{
    		return balance + "0";
    	}
    	else
    	{
    		return Double.toString(balance);
    	}
    }
    
    /**
     * Transfers money from the bank account to another account.
     * @param amount The amount to transfer
     * @param other The other account
     */
    public void transfer(double amount, BankAccount other)
    {
        withdraw(amount);
        other.deposit(amount);
    }
    
    public abstract void endOfMonth();
    
    /**
     * Completes a series of five transactions.
     * @param account A bank account
     */
    public static void test(BankAccount account)
    {
    	account.deposit(200);
    	account.withdraw(100);
    	account.deposit(150);
    	account.withdraw(50);
    	account.withdraw(70);
    	account.endOfMonth();
    }
}