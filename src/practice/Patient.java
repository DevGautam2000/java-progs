package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 07/05/21 AT 1:34 PM
     DESCRIPTION: 
     
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* *** Patient class to implement operations ****** */
class Patient implements Comparable<Patient> {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int patientID;
    private String patientName;
    private String patientAddress;
    private int age;
    private char patientSex;
    private String patientIllness;
    private float amountForAppointment;
    private String joinDate;

    Patient() {
    }

    Patient(int patientID, String patientName, String patientAddress, int age, char patientSex, String patientIllness, float amountForAppointment, String joinDate) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.age = age;
        this.patientSex = patientSex;
        this.patientIllness = patientIllness;
        this.amountForAppointment = amountForAppointment;
        this.joinDate = joinDate;

    }

    public int compareTo(Patient p) {
        return this.patientID = p.patientID;

    }

    void registerPatient() throws IOException //function to insert new patient records
    {

        int patientID = Hospital.arl.size();
        System.out.println("Enter Patient name:");
        String patientName = br.readLine();
        System.out.println("Enter Patient Address:");
        String patientAddress = br.readLine();
        System.out.println("Enter Patient Age:");
        int age = Integer.parseInt(br.readLine());
        System.out.println("Enter Patient Sex:");
        String temp = br.readLine();
        char patientSex = temp.charAt(0);
        System.out.println("Enter Patient Illness:");
        String patientIllness = br.readLine();
        System.out.println("Enter the amount patient needs to pay for appointment:");
        float amountForAppointment = Float.parseFloat(br.readLine());
        String joinDate = Hospital.joinDate;

        Patient pr = new Patient(patientID + 1, patientName, patientAddress, age, patientSex, patientIllness, amountForAppointment, joinDate);
        Hospital.arl.add(pr);
    }

    void removeInactivePatient() throws IOException //function to remove patient records
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Patient ID:");
        int id1 = Integer.parseInt(br.readLine());
        int flag = 0;
        int flag2 = 0;
        String presentDate;
        String afterAddingDays;
        for (int i = 0; i < Hospital.arl.size(); i++) {
            if (id1 != Hospital.arl.get(i).patientID) {
                flag = 0;

            } else if (id1 == Hospital.arl.get(i).patientID) {
                presentDate = Hospital.arl.get(i).joinDate;
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, 15);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
                afterAddingDays = formatter.format(cal.getTime());
                flag = 1;
                if (presentDate.equals(afterAddingDays)) {

                    System.out.println("Patient deleted as his validity expired");
                    flag2 = 1;

                } else {
                    flag2 = 0;

                }

            }

        }
        if ((flag) == 0) {
            System.out.println("Patient with the entered ID does not exist");

        }
        if (flag2 == 0) {
            System.out.println("Patient has still days left before his appointment expires");

        }

    }

    //Function to update patient records/
    void updatePatientDetails() throws IOException {
        char l;
        Patient p2 = new Patient(patientID, patientName, patientAddress, age, patientSex, patientIllness, amountForAppointment, joinDate);
        do {
            System.out.println("Enter patient ID you want to update:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int idNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < Hospital.arl.size(); i++) {
                if (idNum == Hospital.arl.get(i).patientID) {
                    System.out.println("Enter 1 to change patient's name \n 2 to change patient's address \n 3 to change patient's age \n 4 to change patient's illness \n 5 to change registration fees along with the medical expenses");
                    int ch = Integer.parseInt(br.readLine());
                    switch (ch) {
                        case 1:
                            System.out.println("Enter new patient's name:");
                            p2.patientName = br.readLine();
                            p2.patientID = Hospital.arl.get(i).patientID;
                            p2.patientAddress = Hospital.arl.get(i).patientAddress;
                            p2.age = Hospital.arl.get(i).age;
                            p2.patientSex = Hospital.arl.get(i).patientSex;
                            p2.patientIllness = Hospital.arl.get(i).patientIllness;
                            p2.amountForAppointment = Hospital.arl.get(i).amountForAppointment;
                            p2.joinDate = Hospital.arl.get(i).joinDate;
                            Hospital.arl.set(i, p2);
                            System.out.println("Patient updated !!!");
                            break;
                        case 2:
                            System.out.println("Enter new patient Address:");
                            p2.patientAddress = br.readLine();
                            p2.patientID = Hospital.arl.get(i).patientID;
                            p2.patientName = Hospital.arl.get(i).patientName;
                            p2.age = Hospital.arl.get(i).age;
                            p2.patientSex = Hospital.arl.get(i).patientSex;
                            p2.patientIllness = Hospital.arl.get(i).patientIllness;
                            p2.amountForAppointment = Hospital.arl.get(i).amountForAppointment;
                            p2.joinDate = Hospital.arl.get(i).joinDate;
                            Hospital.arl.set(i, p2);
                            System.out.println("Patient updated !!!");
                            break;
                        case 3:
                            System.out.println("Enter new Patient age:");
                            p2.age = Integer.parseInt(br.readLine());
                            p2.patientID = Hospital.arl.get(i).patientID;
                            p2.patientName = Hospital.arl.get(i).patientName;
                            p2.patientAddress = Hospital.arl.get(i).patientAddress;
                            p2.patientSex = Hospital.arl.get(i).patientSex;
                            p2.patientIllness = Hospital.arl.get(i).patientIllness;
                            p2.amountForAppointment = Hospital.arl.get(i).amountForAppointment;
                            p2.joinDate = Hospital.arl.get(i).joinDate;
                            Hospital.arl.set(i, p2);
                            System.out.println("Patient updated !!!");
                            break;
                        case 4:
                            System.out.println("Enter new Patient illness:");
                            p2.age = Hospital.arl.get(i).age;
                            p2.patientID = Hospital.arl.get(i).patientID;
                            p2.patientName = Hospital.arl.get(i).patientName;
                            p2.patientAddress = Hospital.arl.get(i).patientAddress;
                            p2.patientSex = Hospital.arl.get(i).patientSex;
                            p2.patientIllness = br.readLine();
                            p2.amountForAppointment = Hospital.arl.get(i).amountForAppointment;
                            p2.joinDate = Hospital.arl.get(i).joinDate;
                            Hospital.arl.set(i, p2);
                            System.out.println("Patient updated !!!");
                            break;
                        case 5:
                            System.out.println("Enter the new amount that patient needs to pay:");
                            p2.age = Hospital.arl.get(i).age;
                            p2.patientID = Hospital.arl.get(i).patientID;
                            p2.patientName = Hospital.arl.get(i).patientName;
                            p2.patientAddress = Hospital.arl.get(i).patientAddress;
                            p2.patientSex = Hospital.arl.get(i).patientSex;
                            p2.patientIllness = Hospital.arl.get(i).patientIllness;
                            p2.amountForAppointment = Float.parseFloat(br.readLine());
                            p2.joinDate = Hospital.arl.get(i).joinDate;
                            Hospital.arl.set(i, p2);
                            System.out.println("Patient details updated !!!");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;

                    } /*End of switch block */

                }/*End of if block */

            } /*End of for block */
            System.out.println("Do you want to continue updating (y/n):");
            l = (char) br.read();

        }
        while (l == 'y'); /*End of do-while block */

    }

    /* Function to display patients details*/
    void showPatientDetails() {
        System.out.printf("%-15s%-20s%-30s%-6s%-6s%-15s%-15s%-10s", "Patient-ID", "Patient-Name", "Address", "Age", "Sex", "Illness", "Fees", "Join-date");
        System.out.println("\n_____________________________________________________________________________________________________________________________");
        for (int i = 0; i < Hospital.arl.size(); i++) {
            System.out.printf("%-15d%-20s%-30s%-6d%-6s%-15s%-15f%-10s", Hospital.arl.get(i).patientID, Hospital.arl.get(i).patientName, Hospital.arl.get(i).patientAddress,
                    Hospital.arl.get(i).age, Hospital.arl.get(i).patientSex, Hospital.arl.get(i).patientIllness, Hospital.arl.get(i).amountForAppointment, Hospital.arl.get(i).joinDate);
            System.out.println();
        }
    }

}