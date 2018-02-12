/**
 * An account that earns interest at a fixed rate
 */
public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minBalance;
    
    /**
     * Constructs a bank account with a given interest rate.
     * @param rate The interest rate
     */
    public SavingsAccount(double initialBalance, double rate)
    {
    	super(initialBalance);
    	interestRate = rate;
        minBalance = initialBalance;
    }
    
    /**
     * Returns the minimum balance.
     * @return The minimum balance
     */
    public double getMinBalance()
    {
    	return minBalance;
    }
    
    /**
     * Returns the interest rate.
     * @return The interest rate
     */
    public double getInterestRate()
    {
    	return interestRate;
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount)
    {
    	super.withdraw(amount);
    	if (minBalance > Double.parseDouble(getBalance()))
    	{
    		minBalance = Double.parseDouble(getBalance());
    	}
    }
    
    /**
     * Adds the earned interest to the account balance.
     */
    public void endOfMonth()
    {
        double interestCents = (int) (minBalance * interestRate + 0.5);
        double interest = interestCents / 100;
        deposit(interest);
        minBalance = Double.parseDouble(getBalance());
    }
}