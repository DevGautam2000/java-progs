package labs;/*
            AUTHOR: GAUTAM CHANDRA SAHA
            REG NO: 201900099
            DATE & TIME: 19/03/2021 AT 1:30 PM
            DESCRIPTION: Java program to implement static keyword

  ALGORITHM:

Algorithm name: Concept of static variable and function in class Bank.
Algorithm description: Program in Java to define a class named Bank, and show concept of static variable and function.

VARIABLES:
Input variables: name,typeOfAcc,accNo,choice
Output variables: noOfTrans,noOfAccounts,name,typeOfAcc,accNo,balance

STEPS:

 0.Start.
 1.Create a class called Bank with data members noOfTrans,noOfAccounts,name,typeOfAcc,accNo,balance and functions to:
    1.To read inputs

    2.To deposit an amount

    3.To withdraw amount after checking current balance

    4.Display number of transactions (use static function).

 2.For read():
  2.1.Read the inputs into the object data members.

 3.For deposit():
    3.1.First check amount to be deposited is greater than 0 or not
    3.2.If it is than we add in balance
        balance+<--amount
    3.3. noOfTrans is incremented.

 4.For withdraw():
    4.1. First check the withdraw amount is greater than 0 or no if yes than
    4.2. check balance-amount >= 0 or not if true than we withdraw
    4.3. Else we display a message.
    4.4. noOfTrans is incremented.

 5. For getNoOfTrans():
    return the noOfTrans   (which is a static variable)

 6.In main():
   6.1.Create a menu driven program : 1 to create acc, 2 to deposit, 3 to withdraw,4 to see total transaction, 5 to Exit.
   6.2. Ask choice:
   6.3. If 1 than we create an account by inputting name,typeOfAcc,accNo in read().
   6.4. If 2 than we call deposit() function of the object.
   6.5. If 3 than we call withdraw() function of the object.
   6.6. If 4 than we call function getNoOfTrans().
   And 5 to exit.

 7.In listAccounts():
    7.1. This function is used to show the accounts in Bank and ask user to choose an account.
    7.2. Choose for deposit,withdraw etc.

 8.Stop.





 IMPLEMENTATION OF STATIC KEYWORD

CUSTOMER BANK

      MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 1

Enter details below:

Name: Gautam
A/c no: 12354789
A/c type: Savings

      MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 1

Enter details below:

Name: Dipen
A/c no: 14756984
A/c type: Current

     MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 2

The Accounts with bank are:

Sl no: 1

Name: Gautam
A/c no: 12354789
A/c type: Savings
__________________________


Sl no: 2

Name: Dipen
A/c no: 14756984
A/c type: Current
__________________________

Select A/c to transact(1/2/3...): 2

Enter deposit amount: 400
Amount deposited

      MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 3

The Accounts with bank are:

Sl no: 1

Name: Gautam
A/c no: 12354789
A/c type: Savings
__________________________


Sl no: 2

Name: Dipen
A/c no: 14756984
A/c type: Current
__________________________


Select A/c to transact(1/2/3...): 2

Avail. Bal: Rs. 400.0

Enter amount:200

Amount withdrawn

      MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 4

Transactions in bank: 3

      MENU
1.Create a new Account
2.Deposit into account.
3.Withdraw from account.
4.See total transactions.
5.Exit

Enter your choice: 5

 */

import java.util.*;

public class Bank {

    private static int noOfTrans, noOfAccounts;
    private String name, typeOfAcc;
    private long accNo;
    private double balance;

    public static int getNoOfTrans() {
        return noOfTrans;
    }

    public static void main(String[] args) {

        System.out.println("IMPLEMENTATION OF STATIC KEYWORD\n\nCUSTOMER BANK");
        ArrayList<Bank> customer = new ArrayList<>();

        Scanner get = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.print("\n      MENU \n" + "1.Create a new Account \n" + "2.Deposit into account. \n"
                    + "3.Withdraw from account.\n" + "4.See total transactions.\n" + "5.Exit\n\n"
                    + "Enter your choice: ");
            choice = get.nextInt();

            switch (choice) {

                case 1: // read details into acc
                    customer.add(new Bank());

                    System.out.println("\nEnter details below:\n");
                    System.out.print("Name: ");
                    String name = get.next();
                    System.out.print("A/c no: ");
                    long accNo = get.nextLong();
                    System.out.print("A/c type: ");
                    String type = get.next();

                    customer.get(noOfAccounts++).read(name, type, accNo);
                    break;

                case 2: // to deposit into account
                    if (noOfAccounts < 1) {
                        System.out.println("\nNo account created.\n");

                    } else if (noOfAccounts == 1) {
                        System.out.print("\nEnter deposit amount: ");
                        double amount = get.nextDouble();
                        customer.get(noOfAccounts - 1).deposit(amount);
                    } else {

                        int selectAcc = listAccounts(customer, get);

                        System.out.print("\nEnter deposit amount: ");
                        double amount = get.nextDouble();
                        customer.get(selectAcc - 1).deposit(amount);

                    }
                    break;

                case 3: // withdraw from account

                    if (noOfAccounts < 1) {
                        System.out.println("\nNo account created.\n");
                    } else if (noOfAccounts == 1) {
                        customer.get(noOfAccounts - 1).withdraw();
                    } else {

                        int selectAcc = listAccounts(customer, get);
                        customer.get(selectAcc - 1).withdraw();

                    }
                    break;

                case 4: // see total transactions in bank
                    System.out.println("\nTransactions in bank: " + getNoOfTrans());
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input.\n");
            }

        }

    }

    public static int listAccounts(ArrayList<Bank> customer, Scanner get) {
        System.out.println("\nThe Accounts with bank are: ");
        int count = 0;

        for (Bank accHolder : customer) {
            System.out.println("\nSl no: " + (++count) + "\n\nName: " + accHolder.name + "\nA/c no: " + accHolder.accNo
                    + "\nA/c type: " + accHolder.typeOfAcc + "\n__________________________\n");

        }

        System.out.print("\nSelect A/c to transact(1/2/3...): ");

        return get.nextInt();
    }

    public void read(String name, String typeOfAcc, long accNo) {
        this.name = name;
        this.typeOfAcc = typeOfAcc;
        this.accNo = accNo;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            System.out.println("Amount deposited");
            this.balance += amount;
            noOfTrans++;
        } else {
            System.out.println("Minimum amount is 1 INR");
        }
    }

    public void withdraw() {
        System.out.println("\nAvail. Bal: Rs. " + getBalance());

        if (getBalance() > 0) {

            Scanner getAmt = new Scanner(System.in);
            System.out.print("\nEnter amount:");
            double amount = getAmt.nextDouble();

            if (amount > 0) {

                if ((getBalance() - amount) >= 0) {
                    this.balance -= amount;
                    System.out.print("\nAmount withdrawn\n");
                    noOfTrans++;
                } else {
                    System.out.println("Withdrawal not possible\nInsufficient balance.");
                }
            } else {
                System.out.println("Minimum amount is 1 INR");
            }

        } else {
            System.out.println("\nWithdrawal not possible.\n");
        }

    }
}
