package accessprotection.samepackage;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 1:27 PM
     DESCRIPTION: Java program to validate Access Protection Table

ALGORITHM(MainClass):

Algorithm Name: Validation of Access protection
Algorithm Description: Java program to validate access protection table

VARIABLES:

Input Variable: (compile time input to all variables)
Output Variable: privateVar, protectedVar, noModifierVar, publicVar

STEPS:

0. Start
1. Create a base package AccessProtection
2. Create a sub package SamePackage in AccessProtection
3. Create a MainClass with data members as:
        public String publicVar
        protected String protectedVar
        String noModifierVar
        private String privateVar

    and method changeVars() to modify the variables accessible

4. In main() do
5. MainClass mainClass = new MainClass() // instantiation of MainClass object
6. mainClass.changeVars() // modify the variables accessible
7. Display variables modified or not
8. Stop

INPUT/OUTPUT:

VALIDATION OF ACCESS PROTECTION

FROM MAINCLASS IN ACCESSPROTECTION.SAMEPACKAGE

publicVar= ACCESSIBLE
protectedVar= ACCESSIBLE
noModifierVar= ACCESSIBLE
privateVar= ACCESSIBLE
*/

//MainClass whose variables are to be accessed
public class MainClass {

    private static final String NO_ACCESS = "NOT ACCESSIBLE";
    private static final String ACCESS = "ACCESSIBLE";

    static { // static block
        System.out.println("VALIDATION OF ACCESS PROTECTION\n");
    }

    // variable declaration
    public final String PACKAGE;
    public final String CLASS;
    public String publicVar;
    public String change;
    public String detail;
    protected String protectedVar;
    String noModifierVar;
    private String privateVar;

    { //instance block
        PACKAGE = getClass().getPackageName().toUpperCase();
        CLASS = getClass().getSimpleName().toUpperCase();
        detail = "FROM " + CLASS + " IN " + PACKAGE + "\n";
        change = ACCESS;
        protectedVar = noModifierVar = privateVar = publicVar = NO_ACCESS;
    }

    public static void main(String[] args) {

        MainClass mainClass = new MainClass(); // instantiation of MainClass object
        mainClass.changeVars(); // call changeVars() to modify the variables
        System.out.println(mainClass.detail);
        System.out.println(mainClass); //display access
    }

    // method to modify variables
    public void changeVars() {
        privateVar = noModifierVar = protectedVar = publicVar = change;
    }

    // overriding the toString() to display access
    @Override
    public String toString() {
        return "publicVar= " + publicVar +
                "\nprotectedVar= " + protectedVar +
                "\nnoModifierVar= " + noModifierVar +
                "\nprivateVar= " + privateVar +
                "\n";
    }
}
