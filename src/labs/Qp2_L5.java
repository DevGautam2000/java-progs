package labs;

class Qp2_L5 {

    private String name;
    private int reg_no;
    private char sec;

    Qp2_L5() {

        this.name = "Rahul";
        this.reg_no = 20194568;
        this.sec = 'A';

    }

    //parameterized constructor
    Qp2_L5(String name, int reg_no, char sec) {

        this.name = name;
        this.reg_no = reg_no;
        this.sec = sec;
    }

    public static void main(String[] args) {


        Qp2_L5[] student = new Qp2_L5[5];
        student[0] = new Qp2_L5(); //default constructor

        //parameterized constructor
        student[0] = new Qp2_L5("Gautam", 2019009, 'A');
        student[1] = new Qp2_L5("Rishabh", 2019007, 'A');
        student[2] = new Qp2_L5("Tuhin", 2019005, 'C');
        student[3] = new Qp2_L5("Raju", 2019459, 'B');
        student[4] = new Qp2_L5("Farhan", 2019099, 'B');

        System.out.println("STUDENT DETAILS\n\n____________");
        for (int i = 0; i < 5; i++) {

            student[i].display();

        }
    }

    void display() {

        System.out.printf("Name: %s\nReg. no: %d\nSection: %c\n____________", name, reg_no, sec);
        System.out.println();
    }
}