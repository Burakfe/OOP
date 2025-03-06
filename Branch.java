package Lab8;

import java.util.ArrayList;

public class Branch {
    //instance data members
    private int ID;
    private String name;
    private static int noOfAccounts = 0;
    private Double balanceValue;
    private Double loanDebt;
    private ArrayList<Account> accounts;

    //constructor
    public Branch (String name)
    {
        this.name = name;
        ID = noOfAccounts + 1;
        balanceValue = 0.0;
        loanDebt = 0.0;
        ArrayList<Account> accounts = new ArrayList<>();

        noOfAccounts++;
    }
    public void addAccount(Account account)
    {
        accounts.add(account);
        noOfAccounts++;
        
        balanceValue += account.getBalance();
        loanDebt += account.getLoan();
        
        
    }
    public String toString()
    {
        String output = "";
        output += "ID:       " + ID;
        output += "Name:      " +name;
        output += "Number of Accounts:  " + noOfAccounts;
        output += "Total Balance:     " + balanceValue;
        output += "Total Loan Debt: " + loanDebt;
        output += "***************************************";
        
        return output;
    }
    







}
