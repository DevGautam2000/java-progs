package labs;/*
            AUTHOR: GAUTAM CHANDRA SAHA
            REG NO: 201900099
            DATE & TIME: 22/03/2021 AT 5:30 PM
            DESCRIPTION: Java program to implement inheritance

  ALGORITHM:

Algorithm name: Implementation of  inheritance
Algorithm description: Program in Java to define a class named Accounts, and show concept of abstract class and inheritance

VARIABLES:
Input variables: customerName,accType,accNo,accBal
Output variables: customerName, accNo, accBal, accType,totalTrans,totalCustomer,S_total_trans,C_total_trans

STEPS:
0.Start.
 1.Create a class Account (abstract class ) with data members Acc_no, customerName, Acc_bal, Acc_type, Total_trans and Total_customer.
    which has member functions withdraw (), deposit () and display() to display all the details(this is a abstract function).
 2.Create another class S_Account which Inherit the base class Account  with data member S_total_trans, that stores total no of transaction
   in S_Account.
 3.Now we write the display() function in S_Account class to display the details of customer.
 4.Create another derived class named C_Account from base class Account with data  member C_total_trans,
    that stores total no of transaction in C_Account.
 5.Now we write the display() function in C_Account class to display the details of customer.
 6.In main class
    6.1.Create an object of S_Account and than invoke deposit and withdraw function to affect the account balance.
    6.2.Than we invoke the display function to display the details along with S_total_trans.
    6.3.Than Create an object of C_Account and than invoke deposit and withdraw function to affect the account balance.
    6.4.Than we invoke the display function to display the details along with C_total_trans.
 7.Stop.

INPUT/OUTPUT:

IMPLEMENTATION OF INHERITANCE AND SUPER KEYWORD

ACCOUNTS


    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 1

    TYPE
1.Savings
2.Credit

Enter choice: 1

Enter details below:

Name: Gautam
A/c no: 1234

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 2

    TYPE
1.Savings
2.Credit

Enter choice: 1

Enter deposit amount: 4500
Amount deposited

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 3

    TYPE
1.Savings
2.Credit

Enter choice: 1

Avail. Bal: Rs. 4500.0

Enter amount:500

Amount withdrawn

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 4

    VIEW TRANSACTIONS
1.Total Transactions in bank
2.Total Transactions in individual Savings
3.Total Transactions in individual Current

Enter choice: 1

Transactions in Bank: 2
Customers in Bank: 1

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 4

    VIEW TRANSACTIONS
1.Total Transactions in bank
2.Total Transactions in individual Savings
3.Total Transactions in individual Current

Enter choice: 2

The Accounts with bank are:

Sl no: 1

Name: Gautam
A/c no: 1234
__________________________


Select A/c to transact(1/2/3...): 1

Transactions in Account: 2

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 5

    TYPE
1.Savings
2.Credit

Enter choice: 1

The Accounts with bank are:

Sl no: 1

Name: Gautam
A/c no: 1234
__________________________


Select A/c to transact(1/2/3...): 1

Name: Gautam
A/c no: 1234
A/c bal: 4000.000000
A/c type: Savings
Total transactions: 2

    MENU
1.Open an account
2.Deposit
3.Withdraw
4.View transactions
5.Display account details
6.Exit

Enter choice: 6

 */

import java.util.*;

abstract class Accounts {

    private static int totalTrans, totalCustomer;
    private final int accNo;
    private final String customerName, accType;
    private double accBal;


    //parameterized constructor
    public Accounts(int accNo, double accBal, String customerName, String accType) {
        this.accNo = accNo;
        this.accBal = accBal;
        this.customerName = customerName;
        this.accType = accType;
    }

    public static void setTotalCustomer() { //method to increment no. of customers
        totalCustomer++;
    }

    public static int getTotalTrans() { //getter for total transactions
        return totalTrans;
    }

    public static int getTotalCustomer() { //getter for total customers
        return totalCustomer;
    }

    public double getAccBal() { //getter for account balance
        return accBal;
    }

    public int getAccNo() { //getter for account no.
        return accNo;
    }

    public String getCustomerName() { //getter for customer name
        return customerName;
    }

    boolean withdraw() { //method to withdraw an amount

        boolean withdrawn = false; //flag to check if amount was withdrawn
        System.out.println("\nAvail. Bal: Rs. " + getAccBal()); //print available balance

        if (getAccBal() > 0) { //if balance is > 0

            Scanner getAmt = new Scanner(System.in);
            System.out.print("\nEnter amount:");
            double amount = getAmt.nextDouble(); //get the amount to be withdrawn


            if (amount > 0) { //if amount is > 0

                if ((getAccBal() - amount) >= 0) { //if the difference of balance-amount >= 0
                    this.accBal -= amount; //withdraw
                    System.out.print("\nAmount withdrawn\n");
                    totalTrans++; //increment transactions
                    withdrawn = true; //change flag
                } else {
                    System.out.println("Withdrawal not possible\nInsufficient balance.");
                }
            } else {//if amount is <= 0
                System.out.println("Minimum amount is 1 INR");
            }

        } else { // if no balance in account
            System.out.println("\nWithdrawal not possible.\n");
        }
        return withdrawn; //return flag
    }

    boolean deposit(double amount) { //method to deposit into account

        boolean deposited = false; //flag to check if amount deposited

        if (amount > 0) {  //if amount is > 0
            System.out.println("Amount deposited");
            this.accBal += amount;
            totalTrans++;
            deposited = true;
        } else {
            System.out.println("Minimum amount is 1 INR");
        }

        return deposited; //return flag
    }

    void display() { //method to display associated details
        System.out.printf("\nName: %s\nA/c no: %d\nA/c bal: %f\nA/c type: %s", customerName, accNo, accBal, accType);
    }
}


//for a savings account
class S_Account extends Accounts { //inherited from Accounts

    private static int savTotalCustomers;
    private int S_total_trans;


    //parameterized constructor
    public S_Account(int accNo, String customerName) {
        super(accNo, 0, customerName, "Savings");

    }

    public static void setSavTotalCustomers() { //method to increment customers of savings a/c and total customers in bank
        S_Account.savTotalCustomers++;
    }

    public static int getSavTotalCustomers() { //getter for total customers using saving a/c
        return savTotalCustomers;
    }

    public int getS_total_trans() { //getter for total transaction of an individual account
        return S_total_trans;
    }

    @Override
    boolean withdraw() { //overridden method to withdraw amount
        if (super.withdraw()) {
            this.S_total_trans++;
            return true;
        }

        return false;
    }

    @Override
    boolean deposit(double amount) { //overridden method to deposit amount
        if (super.deposit(amount)) {
            this.S_total_trans++;
            return true;
        }

        return false;
    }

    @Override
    void display() { //overridden method to display account details
        super.display();
        System.out.println("\nTotal transactions: " + S_total_trans);
    }
}

//for a current account
class C_Account extends Accounts {

    private static int curTotalCustomers;
    int C_total_trans;

    //parameterized constructor
    public C_Account(int accNo, String customerName) {
        super(accNo, 0, customerName, "Current");

    }

    public static void setCurTotalCustomers() { //method to increment customers of current a/c and total customers in bank
        C_Account.curTotalCustomers++;
    }

    public static int getCurTotalCustomers() { //getter for total customers using current a/c
        return curTotalCustomers;
    }

    public int getC_total_trans() { //getter for total transactions of an individual account
        return C_total_trans;
    }

    @Override
    boolean withdraw() {
        if (super.withdraw()) { //overridden method to withdraw amount
            this.C_total_trans++;
            return true;
        }

        return false;
    }

    @Override
    boolean deposit(double amount) { //overridden method to deposit amount
        if (super.deposit(amount)) {
            this.C_total_trans++;
            return true;
        }

        return false;
    }

    @Override
    void display() { //overridden method to display details of an account
        super.display();
        System.out.println("\nTotal transactions: " + C_total_trans);
    }
}

//MAIN CLASS
public class Acc {

    public static void print(String stringToPrint) {
        System.out.print(stringToPrint);
    }

    public static void printL(String stringToPrint) {
        System.out.println(stringToPrint);
    }

    //MAIN FUNCTION
    public static void main(String[] args) {

        //to store savings customer
        ArrayList<S_Account> savCustomers = new ArrayList<>();

        //to store current customer
        ArrayList<C_Account> curCustomers = new ArrayList<>();

        //GUI
        printL("\nIMPLEMENTATION OF INHERITANCE AND SUPER KEYWORD");
        printL("\nACCOUNTS\n");

        Scanner get = new Scanner(System.in); //scanner object

        while (true) { //infinite loop

            //MENU
            print("\n    MENU\n" +
                    "1.Open an account\n" +
                    "2.Deposit\n" +
                    "3.Withdraw\n" +
                    "4.View transactions\n" +
                    "5.Display account details\n" +
                    "6.Exit\n");

            print("\nEnter choice: ");
            int choice = get.nextInt(); //enter choice

            switch (choice) {

                case 1: // read details into acc
                    print("\n    TYPE\n" +
                            "1.Savings\n" +
                            "2.Credit\n");
                    print("\nEnter choice: ");
                    int choiceType = get.nextInt();

                    switch (choiceType) {
                        case 1: // to open a savings account


                            System.out.println("\nEnter details below:\n");
                            System.out.print("Name: ");
                            String nameSav = get.next();
                            System.out.print("A/c no: ");
                            int accNoSav = get.nextInt();

                            savCustomers.add(new S_Account(accNoSav, nameSav)); //append new S_Account object in the ArrayList
                            S_Account.setSavTotalCustomers();
                            Accounts.setTotalCustomer();
                            break;

                        case 2: // to open a credit account

                            System.out.println("\nEnter details below:\n");
                            System.out.print("Name: ");
                            String nameCur = get.next();
                            System.out.print("A/c no: ");
                            int accNoCur = get.nextInt();

                            curCustomers.add(new C_Account(accNoCur, nameCur)); //append new C_Account object in the ArrayList
                            C_Account.setCurTotalCustomers();
                            Accounts.setTotalCustomer();
                            break;

                        default:
                            printL("\nInvalid input.\n");
                    }

                    break;

                case 2: // to deposit into account

                    print("\n    TYPE\n" +
                            "1.Savings\n" +
                            "2.Credit\n");
                    print("\nEnter choice: ");
                    int choiceDeposit = get.nextInt();

                    switch (choiceDeposit) {

                        case 1: // to deposit into savings account

                            if (S_Account.getSavTotalCustomers() < 1) { //if no acc. created
                                System.out.println("\nNo account created.\n");

                            } else if (S_Account.getSavTotalCustomers() == 1) { //for single acc
                                System.out.print("\nEnter deposit amount: ");
                                double amount = get.nextDouble();
                                savCustomers.get(S_Account.getSavTotalCustomers() - 1).deposit(amount);

                            } else { //for multiple accounts

                                int selectAcc = listAccountsOfSav(savCustomers, get); // list the savings account

                                System.out.print("\nEnter deposit amount: ");
                                double amount = get.nextDouble();
                                savCustomers.get(selectAcc - 1).deposit(amount); //get the specific account object

                            }

                            break;

                        case 2: // to deposit into current account

                            if (C_Account.getCurTotalCustomers() < 1) { //if no acc. created
                                System.out.println("\nNo account created.\n");

                            } else if (C_Account.getCurTotalCustomers() == 1) { //for single acc
                                System.out.print("\nEnter deposit amount: ");
                                double amount = get.nextDouble();
                                curCustomers.get(C_Account.getCurTotalCustomers() - 1).deposit(amount);

                            } else {//for multiple accounts

                                int selectAcc = listAccountsOfCur(curCustomers, get); // list the current account

                                System.out.print("\nEnter deposit amount: ");
                                double amount = get.nextDouble();
                                curCustomers.get(selectAcc - 1).deposit(amount); //get the specific account object

                            }

                            break;

                        default:
                            printL("\nInvalid input.\n");
                    }


                    break;

                case 3: // withdraw from account
                    print("\n    TYPE\n" +
                            "1.Savings\n" +
                            "2.Credit\n");
                    print("\nEnter choice: ");
                    int choiceWithdraw = get.nextInt();

                    switch (choiceWithdraw) {

                        case 1: // to withdraw from savings account

                            if (S_Account.getSavTotalCustomers() < 1) { //if no acc. created
                                System.out.println("\nNo account created.\n");

                            } else if (S_Account.getSavTotalCustomers() == 1) { //for single acc
                                savCustomers.get(0).withdraw();

                            } else {
                                int selectAcc = listAccountsOfSav(savCustomers, get); //list saving accounts
                                savCustomers.get(selectAcc - 1).withdraw(); // get specific account object
                            }

                            break;

                        case 2: // to withdraw from current account

                            if (C_Account.getCurTotalCustomers() < 1) { //if no acc. created
                                System.out.println("\nNo account created.\n");

                            } else if (C_Account.getCurTotalCustomers() == 1) { //for single acc
                                curCustomers.get(0).withdraw();

                            } else {
                                int selectAcc = listAccountsOfCur(curCustomers, get);//list current accounts
                                curCustomers.get(selectAcc - 1).withdraw(); // get specific account object
                            }

                            break;

                        default:
                            printL("\nInvalid input.\n");
                    }


                    break;

                case 4: //  transactions

                    print("\n    VIEW TRANSACTIONS\n" +
                            "1.Total Transactions in bank\n" +
                            "2.Total Transactions in individual Savings\n" +
                            "3.Total Transactions in individual Current\n");
                    print("\nEnter choice: ");
                    int choiceTransaction = get.nextInt();


                    switch (choiceTransaction) {

                        case 1: //total transactions in bank

                            if (Accounts.getTotalCustomer() >= 1) { //for multiple accounts
                                printL("\nTransactions in Bank: " + Accounts.getTotalTrans());
                                printL("Customers in Bank: " + Accounts.getTotalCustomer());

                            } else {
                                printL("\nNo accounts in Bank.");
                            }


                            break;

                        case 2: //total Transactions in individual Savings

                            if (S_Account.getSavTotalCustomers() >= 1) { //for multiple accounts
                                int selectSavAcc = listAccountsOfSav(savCustomers, get); //list saving accounts
                                printL("\nTransactions in Account: " + savCustomers.get(selectSavAcc - 1).getS_total_trans());

                            } else {
                                printL("\nNo Saving accounts in Bank.");
                            }

                            break;

                        case 3: //total Transactions in individual current

                            if (C_Account.getCurTotalCustomers() >= 1) { //for multiple accounts
                                int selectCurAcc = listAccountsOfCur(curCustomers, get); //list current accounts
                                printL("\nTransactions in Account: " + curCustomers.get(selectCurAcc - 1).getC_total_trans());
                            } else {
                                printL("\nNo Current accounts in Bank.");
                            }

                            break;

                        default:
                            printL("\nInvalid input.\n");
                    }

                    break;

                case 5: // display account details
                    print("\n    TYPE\n" +
                            "1.Savings\n" +
                            "2.Credit\n");
                    print("\nEnter choice: ");
                    int choiceDisplay = get.nextInt();

                    switch (choiceDisplay) {
                        case 1: //display saving account details
                            if (S_Account.getSavTotalCustomers() >= 1) { //for multiple accounts
                                int selectSavAcc = listAccountsOfSav(savCustomers, get); //list saving accounts
                                savCustomers.get(selectSavAcc - 1).display();

                            } else {
                                printL("\nNo Saving accounts in Bank.");
                            }

                            break;

                        case 2: //display current account details
                            if (C_Account.getCurTotalCustomers() >= 1) { //for multiple accounts
                                int selectCurAcc = listAccountsOfCur(curCustomers, get); //list current accounts
                                curCustomers.get(selectCurAcc - 1).display();

                            } else {
                                printL("\nNo Current accounts in Bank.");
                            }
                            break;

                        default:
                            printL("\nInvalid input.\n");
                    }

                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid input.\n");
            }


        }

    }

    public static int listAccountsOfSav(ArrayList<S_Account> customer, Scanner get) { //method to list all saving accounts
        System.out.println("\nThe Accounts with bank are: ");
        int count = 0;

        for (S_Account accHolder : customer) { // print name and acc no. for each saving account
            System.out.println("\nSl no: " + (++count) + "\n\nName: " + accHolder.getCustomerName() + "\nA/c no: " + accHolder.getAccNo()
                    + "\n__________________________\n");

        }

        System.out.print("\nSelect A/c to transact(1/2/3...): ");

        return get.nextInt(); //return choice
    }

    public static int listAccountsOfCur(ArrayList<C_Account> customer, Scanner get) { //method to list all current accounts
        System.out.println("\nThe Accounts with bank are: ");
        int count = 0;

        for (C_Account accHolder : customer) { // print name and acc no. for each current account
            System.out.println("\nSl no: " + (++count) + "\n\nName: " + accHolder.getCustomerName() + "\nA/c no: " + accHolder.getAccNo()
                    + "\n__________________________\n");

        }

        System.out.print("\nSelect A/c to transact(1/2/3...): ");

        return get.nextInt(); //return choice
    }
}

