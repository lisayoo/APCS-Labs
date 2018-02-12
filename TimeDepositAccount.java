/**
 * A savings account that has a penalty fee if money is 
 * withdrawn before a certain number of months.
 */
public class TimeDepositAccount extends SavingsAccount
{
	private int months;
	public static final int PENALTY = 25;
	
	/**
	 * Constructs a time deposit account with a given balance, 
	 * interest rate, and the number of months before withdrawal
	 * is allowed without penalty.
	 * @param initialBalance The initial balance
	 * @param rate The interest rate
	 * @param months The number of months before withdrawal
	 * is allowed without penalty
	 */
	public TimeDepositAccount(double initialBalance, double rate, int months)
	{
		super(initialBalance, rate);
		this.months = months;
	}
	
	/**
	 * Returns the number of months before withdrawal 
	 * is allowed without penalty.
	 * @return The minimum months
	 */
	public int getMonths()
	{
		return months;
	}
	
	/**
	 * Withdraws money from the bank account.
	 * @param amount The amount to withdraw
	 */
	public void withdraw(double amount)
	{
		super.withdraw(amount);
		if (months > 0)
		{
			super.withdraw(PENALTY);
		}
	}
	
	/**
	 * Adds the earned interest to the account balance.
	 */
	public void endOfMonth()
	{
		months--;
		super.endOfMonth();
	}
}
