package Lab8;

import java.util.ArrayList;

public class Customer {
    private static int noOfAccounts = 1;
    //instance variables
    private int ID;
    private String firstName;
    private String lastName;
    private String country;
    private String passportNumber;
    private ArrayList <Account> accounts;   
    //constructor
    public Customer(String firstName, String lastName, String country, String passportNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.passportNumber = passportNumber;
        accounts = new ArrayList<Account>();
        ID = noOfAccounts;
        noOfAccounts++;
    }
    public ArrayList <Account> getAccounts()
    {
        return accounts;
    }

    public void openAccount(String type, String creationDate)
    {
        Account account = new Account(type, this, creationDate); //changed object type for revision
        System.out.println("Opened a new account (" + ID + ") for customer " + firstName + " " + lastName);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account);
    }
    
    public String toString()
    {
        String result = "";

        result += "******************************************************************************\n";
        result += "Customer Information:\n";
        result += "Customer ID:     " + ID + "\n";
        result += "Name:         " + firstName + " " + lastName + "\n";
        result += "Country:       " + country + "\n";
        result += "Passport Number: " + passportNumber + "\n";
        result += "Accounts: \n";
        for(int i = 0; i < accounts.size(); i++)
        {
            result += "Account ID:      " + accounts.get(i).getID() + "          Type:     " + accounts.get(i).getType() + "       Status: " + accounts.get(i).getStatus() + "\n";
        }
        result += "******************************************************************************";
        return result;
    }

}
