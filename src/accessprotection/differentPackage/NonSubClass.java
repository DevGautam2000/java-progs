package accessprotection.differentPackage;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 2:13 PM
     DESCRIPTION:

INPUT/OUTPUT:

VALIDATION OF ACCESS PROTECTION

FROM NONSUBCLASS IN ACCESSPROTECTION.DIFFERENTPACKAGE

publicVar= ACCESSIBLE
protectedVar= NOT ACCESSIBLE
noModifierVar= NOT ACCESSIBLE
privateVar= NOT ACCESSIBLE

*/

import accessprotection.OutlineForNonSubClass;
import accessprotection.samepackage.MainClass;

// non sub class in different package
//NonSubClass inherits abstract class OutlineForNonSubClass
public class NonSubClass extends OutlineForNonSubClass {

    public static void main(String[] args) {
        OutlineForNonSubClass nonSubClass = new NonSubClass(); //instantiation of NonSubClass object
        nonSubClass.changeVars();// call changeVars() to modify accessible variables
    }

    //overriding the changeVars() to modify accessible variables of MainClass
    @Override
    public void changeVars() {
        MainClass mainClass = new MainClass();
        //mainClass.priVar = change; // ERROR (not accessible)
        // mainClass.proVar = change; // ERROR (not accessible)
        // mainClass.noModifierVar = change; // ERROR (not accessible)
        mainClass.publicVar = change;
        System.out.println(detail);
        System.out.println(mainClass); //display access
    }
}