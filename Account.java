package Lab8;
public class Account 
{
    //static data member
    private static int noOfAccounts = 1; 
    //Instance Data Members
    private int ID;
    private Double maxLoanLimit;
    private Double maxDebtLimit;
    private Double balance;
    private String owner;
    private String type;
    private String creationDate;
    private Double loanAmount = 0.0;
    private int numberOfLoans = 0;
    private Double debt;
    private boolean isActive;
    
    //constructor method
    public Account(String type, String owner, String creationDate)
    {
        //constructing the type owner
        this.type = type;
        this.owner = owner;
        //creation date
        creationDate = creationDate.replace('-', '/');
        this.creationDate = creationDate;
        // assigns an unique id        
        ID = noOfAccounts;
        //assigns the defult values
        Double balance = 0.0;
        Double maxLoanLimit = 0.0;
        Double maxDebtLimit = 0.0;
        Double debt = 0.0;
        isActive = true;
        //Assigns maxLoanLimit based on account type
        if (type.equals("student")) 
        {
            maxLoanLimit = 4000.0;
        }
        else if (type.equals("personal")) 
        {
            maxLoanLimit = 2000.0;
        }
        else if(type.equals("business"))
        {
            maxLoanLimit = 100000.0;
        }
        else if(type.equals("investment"))
        {   
            maxLoanLimit = 10000.0;
        }
        this.maxLoanLimit = maxLoanLimit;
        //Assigns the maxDebtLimit as half of the maxLoanLimit of the account
        maxDebtLimit = maxLoanLimit / 2;
        this.maxDebtLimit = maxDebtLimit;
        this.debt = debt;
        this.balance = balance;
        
        noOfAccounts++;
    } 
    //Getter methods
    public String getType()
    {
        return type;
    }
    public Boolean getIsActive()
    {
        return isActive;
    } 
    public Double getBalance()
    {
        return balance;
    }
    public Double getDebt()
    {
        return debt;
    }
    public String getStatus()
    {
        if (isActive) 
        {
            return "Active";
        }
        else
        {
            return "Deactive";
        }
    }
    public int getID()
    {
        return ID;
    }
    public double getLoan()
    {
        return loanAmount;
    }
    //Setter methods
    public void withdrawCash(Double amount)
    {
        if(isActive)
        {
            if(amount >= 0)
            {
                balance -= amount;
                if (balance < 0.0) 
                {
                    debt -= balance;
                    if (debt <= maxDebtLimit) 
                    {
                        System.out.println("Cash withdrawal of $" + amount + " from account " + ID);
                        balance = 0.0;
                    }
                    else
                    {
                        debt += balance;
                        balance += amount;
                        System.out.println("Withdrawal failed. Insufficient debt limit.");
                    }
                
                }
                else
                {
                    System.out.println("Cash withdrawal of $" + amount + " from account " + ID);
                }
            }
            else
            {
                System.out.println("Amount can't be negative!");
            }
        }
    }
    public void depositCash(Double amount)
    {
        if(isActive )
        {
            if(amount >= 0)
            {
                if (debt != 0.0) 
                {
                    debt -= amount;
                    if (debt < 0.0) 
                    {
                        balance = balance - debt;
                        System.out.println("Cash deposit of $" + amount + " into account " + ID); 
                        debt = 0.0;
                    }
                }
                else
                {
                    balance += amount;
                    System.out.println("Cash deposit of $" + amount + " into account " + ID); 
                }
            }
            else
            {
                System.out.println("Amount can't be negative!");
            }
        }   
    }
    public void deactivate()
    {
        isActive = false;
        System.out.println("Account " + ID + " has been deactivated.");
    }
    public void activate()
    {
        isActive = true;
        System.out.println("Account " + ID + " has been activated.");
    }
    public boolean hasDebt()
    {
        
        return debt != 0.0;
    }
    // service methods transfer
    public void transfer(Account destAccount, Double amount)
    {
        if (isActive && destAccount.getIsActive()) 
        {
            if(amount >= 0)
            {
                balance -= amount;
                if (balance < 0.0) 
                {
                    debt -= balance;
                    balance = 0.0;
                    if (debt <= maxDebtLimit) 
                    {
                        destAccount.balance += amount;
                        System.out.println("Transferred $" + amount + " (debt) from account " + ID + " to account " + destAccount.ID); 
                    }
                    else
                    {
                        debt += balance;
                        balance += amount;
                        System.out.println("Transaction failed. Unsufficent debt limit.");
                    }
                }
                else
                {
                    destAccount.balance += amount;
                    System.out.println("Transferred $" + amount + " from account " + ID + " to account " + destAccount.ID);
                } 
            }
            else
            {
                System.out.println("Amount can't be negative!");
            }
        }
        else
        {
            System.out.println("Transaction failed. One or both accounts are inactive.");
        }
    }
    public boolean requestLoan(Double loanAmount)
    {
        if(isActive)
        {
            if(loanAmount >=0)
            {
                if (loanAmount <= maxLoanLimit) 
                {
                    this.loanAmount = loanAmount;
                    balance += loanAmount;
                    numberOfLoans++;
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    //display method
    public String toString()
    {
        String result = "";
        result +=  "************************************************* \n";
        result +=  "Account Information: \n";
        result +=  "ID:     " + ID + "\n" + "Type:     " + type + "\n" + "Owner:     " + owner + "\n";
        result +=  ("Balance:     $" + balance + "\n");
        result +=  ("Max Loan Limit: $" + maxLoanLimit + "\n");
        result +=  ("Max Debt Limit: $" + maxDebtLimit + "\n");
        result +=  ("Creation Date:   " + creationDate + "\n");
        result +=  ("Loan Amount:     $" + loanAmount + "\n");
        result +=  ("Number of Loans: " + numberOfLoans + "\n");
        result +=  ("Debt:         $" + debt + "\n");
        result +=  ("Status:    " + getStatus() + "\n");
        result +=  ("*************************************************");
        return result;
    }
}
