package accessprotection.differentPackage;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 1:57 PM
     DESCRIPTION:

INPUT/OUTPUT:

VALIDATION OF ACCESS PROTECTION

FROM SUBCLASS IN ACCESSPROTECTION.DIFFERENTPACKAGE

publicVar= ACCESSIBLE
protectedVar= ACCESSIBLE
noModifierVar= NOT ACCESSIBLE
privateVar= NOT ACCESSIBLE
*/

import accessprotection.samepackage.MainClass;

//subclass in different package
// SubClass inherits MainClass
public class SubClass extends MainClass {


    public static void main(String[] args) {
        SubClass subClass = new SubClass(); // instantiation of SubClass object
        subClass.changeVars(); // call changeVars() to modify accessible variables
        System.out.println(subClass.detail);
        System.out.println(subClass); //display access
    }

    //overriding the changeVars() to modify accessible variables of MainClass
    @Override
    public void changeVars() {
        //privateVar= changed //ERROR not accessible
        //noModifierVar = changed //ERROR not accessible
        protectedVar = publicVar = change;
    }
}
