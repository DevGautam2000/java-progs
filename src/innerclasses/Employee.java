package innerclasses;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 24/04/21 AT 12:27 AM
     DESCRIPTION:

*/

import java.util.*;

public class Employee {

    private static final Scanner get = new Scanner(System.in);
    private final int eId;

    public Employee(int eId) {
        this.eId = eId;
    }

    public static void main(String[] args) {

        Map<Integer, EmployeeDetails> employeeDetails = new LinkedHashMap<>();

        while (true) {
            System.out.println("   MENU\n" +
                    "1.Add new employee\n" +
                    "2.Get employee details\n" +
                    "3.Exit");
            System.out.print("\nEnter choice: ");
            int choice = get.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("\nEnter details:\n");
                    get.nextLine();
                    System.out.print("Name: ");
                    String name = get.nextLine();
                    System.out.print("Employee Id: ");
                    int eId = get.nextInt();
                    System.out.print("Designation: ");
                    String designation = get.next();
                    System.out.print("Address: ");
                    get.nextLine();
                    String address = get.nextLine();
                    System.out.print("Age: ");
                    int age = get.nextInt();
                    System.out.print("Phone no: ");
                    String phone = get.next();
                    System.out.print("Join date: ");
                    String joinDate = get.next();

                    employeeDetails.put(eId, new Employee(eId).new EmployeeDetails(address, name, designation, phone, age, joinDate));

                }
                case 2 -> {
                    System.out.println("\nEnter employee id: ");
                    int eId = get.nextInt();

                    for (Map.Entry<Integer, EmployeeDetails> entry :
                            employeeDetails.entrySet()) {
                        if (eId == entry.getKey()) {
                            System.out.println(entry.getValue());
                        }
                    }
                }

                case 3 -> System.exit(0);

                default -> {
                    System.out.println("\nInvalid Input");
                }
            }
        }

    }

    class EmployeeDetails {
        private final String address, name, designation;
        private final String phoneNum;
        private final int age;
        private final String joinDate;

        public EmployeeDetails(String address, String name, String designation, String phoneNum, int age, String joinDate) {
            this.address = address;
            this.name = name;
            this.designation = designation;
            this.phoneNum = phoneNum;
            this.age = age;
            this.joinDate = joinDate;
        }

        @Override
        public String toString() {
            return "\nDetails of Employee\n" +
                    "\nE_Id: " + eId +
                    "\nAddress: " + address +
                    "\nName: " + name +
                    "\nDesignation: " + designation +
                    "\nPhone No: " + phoneNum +
                    "\nAge: " + age +
                    "\nJoin Date: " + joinDate + "\n";
        }


    }
}
