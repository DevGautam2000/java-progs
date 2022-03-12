package accessprotection.samepackage;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 1:48 PM
     DESCRIPTION:

INPUT/OUTPUT:

VALIDATION OF ACCESS PROTECTION

FROM NONSUBCLASS IN ACCESSPROTECTION.SAMEPACKAGE

publicVar= ACCESSIBLE
protectedVar= ACCESSIBLE
noModifierVar= ACCESSIBLE
privateVar= NOT ACCESSIBLE
*/

import accessprotection.OutlineForNonSubClass;

// non sub class in same package
//NonSubClass inherits abstract class OutlineForNonSubClass
public class NonSubClass extends OutlineForNonSubClass {

    public static void main(String[] args) {
        OutlineForNonSubClass nonSubClass = new NonSubClass(); //instantiation of NonSubClass object
        nonSubClass.changeVars(); // call changeVars() to modify accessible variables
    }

    //overriding the changeVars() to modify accessible variables of MainClass
    @Override
    public void changeVars() {
        MainClass mainClass = new MainClass();
        // sameClass.priVar = change; // ERROR (not accessible)
        mainClass.protectedVar = mainClass.publicVar = mainClass.noModifierVar = change;
        System.out.println(detail);
        System.out.println(mainClass); //display access
    }
}
