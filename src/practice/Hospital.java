package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 06/05/21 AT 7:25 PM
     DESCRIPTION: 
     
*/

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Hospital {
    protected static ArrayList<Patient> arl = new ArrayList<>();
    protected static String joinDate;

    public static void main(String[] args)
            throws IOException {
        char l;
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        joinDate = formatter.format(currentDate.getTime());
        Patient p1 = new Patient(1, "Raja", "Miyapur,Hyderabad", 40, 'm', "Fever", 250f, joinDate);
        arl.add(p1);
        Patient p2 = new Patient(2, "Rani", "Madhapur,Hyderabad", 45, 'f', "Cough", 250f, joinDate);
        arl.add(p2);
        Patient p3 = new Patient(3, "James", "Hydernagar,Hyderabad", 56, 'm', "Cancer", 250f, joinDate);
        arl.add(p3);
        do {
            Patient p = new Patient();
            System.out.println("Enter 1 to register a Patient \n 2 to update Patient details \n 3 to deactivate Patient details \n 4 to display Patient details");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    p.registerPatient();
                    System.out.println("Patient Registered Successfully !!!");
                    p.showPatientDetails();
                    break;
                case 2:
                    p.showPatientDetails();
                    p.updatePatientDetails();
                    break;
                case 3:
                    p.removeInactivePatient();
                    break;
                case 4:
                    Collections.sort(arl);
                    p.showPatientDetails();
                    break;
                default:
                    System.out.println("Patient does not exist with the entered ID");
                    System.out.println("Try again");
                    break;
            }
            System.out.println("Do you want to continue selecting options (y/n):");
            l = (char) br.read();
        } while (l == 'y');

    }/*End of main() method */

}
/* **** End of HospitalProcess class ****** */

