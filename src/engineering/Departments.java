package engineering;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 12:21 PM
     DESCRIPTION: 
     
*/

//class having information about departments
public class Departments {

    private final String department;
    private final int sem;
    private final int totalSubjects;

    //constructor
    public Departments(String department, int sem, int totalSubjects) {
        this.department = department;
        this.sem = sem;
        this.totalSubjects = totalSubjects;
    }

    public String getDepartment() { //getter for department
        return department;
    }

    public int getSem() { //getter for semester
        return sem;
    }

    public int getTotalSubjects() { //getter for total subjects
        return totalSubjects;
    }

}
