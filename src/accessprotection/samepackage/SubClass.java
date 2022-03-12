package accessprotection.samepackage;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 1:43 PM
     DESCRIPTION:

INPUT/OUTPUT:

VALIDATION OF ACCESS PROTECTION

FROM SUBCLASS IN ACCESSPROTECTION.SAMEPACKAGE

publicVar= ACCESSIBLE
protectedVar= ACCESSIBLE
noModifierVar= ACCESSIBLE
privateVar= NOT ACCESSIBLE
*/

//subclass in same package
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
        //privateVar //ERROR not accessible
        protectedVar = publicVar = noModifierVar = change;
    }
}
