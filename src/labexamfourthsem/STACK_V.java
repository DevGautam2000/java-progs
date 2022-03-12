package labexamfourthsem;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 06/05/21 AT 2:57 PM
     DESCRIPTION: 

INPUT/OUTPUT:


FROM STATIC METHOD:

NON_STATIC_VAR: NOT ACCESSIBLE
STATIC_VAR: ACCESSIBLE


FROM NON STATIC METHOD:

NON_STATIC_VAR: ACCESSIBLE
STATIC_VAR: ACCESSIBLE
*/

public class STACK_V {
    private static final String ACCESSIBILITY = "NOT ACCESSIBLE";
    private static final String CHANGED = "ACCESSIBLE";
    private static String STATIC_VAR = ACCESSIBILITY;
    private String NON_STATIC_VAR = ACCESSIBILITY;

    public static void main(String[] args) {

        STACK_V obj = new STACK_V();
        tryToAccessNonStaticVar();

        obj.tryToAccessStaticVarFromNonStaticMethod();
        System.out.println(obj); // ----> invokes the toString() method


    }

    //method to show static var is accessible from
    //static method but non static var is not accessible

    private static void tryToAccessNonStaticVar() {
        STATIC_VAR = CHANGED;
        //NON_STATIC_VAR = CHANGED; ----> throws error
        System.out.println("\nFROM STATIC METHOD:\n");
        System.out.println(new STACK_V());

    }

    //method to show static var is accessible from non static method

    private void tryToAccessStaticVarFromNonStaticMethod() {
        STATIC_VAR = CHANGED;
        NON_STATIC_VAR = CHANGED;
        System.out.println("\nFROM NON STATIC METHOD:\n");
    }

    @Override
    public String toString() {
        return "NON_STATIC_VAR: " + NON_STATIC_VAR + "\n" +
                "STATIC_VAR: " + STATIC_VAR + "\n";
    }


}


