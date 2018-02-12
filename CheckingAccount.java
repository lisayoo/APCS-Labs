/**
 * A checking account that charges transaction fees.
 */
public class CheckingAccount extends BankAccount
{
    private int transactionCount;
    
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;
    
    /**
     * Constructs a checking account with a given balance.
     * @param initialBalance The initial balance
     */
    public CheckingAccount(double initialBalance)
    {
        //Construct superclass
        super(initialBalance);
        
        //Initialize transaction count
        transactionCount = 0;
    }
    
    /**
     * Deposits money into the bank account.
     * @param amount The amount to deposit
     */
    public void deposit(double amount)
    {
        transactionCount++;
        //Now add amount to balance
        super.deposit(amount);
    }
    
    /**
     * Withdraws money from the bank account.
     * @param amount The amount to withdraw
     */
    public void withdraw(double amount)
    {
        transactionCount++;
        //Now subtract amount from balance
        super.withdraw(amount);
    }
    
    /**
     * Deducts the accumulated fees and resets the
     * transaction count.
     */
    public void endOfMonth()
    {
        if (transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTION_FEE *
                   (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }
}