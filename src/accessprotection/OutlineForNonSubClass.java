package accessprotection;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 11:41 PM
     DESCRIPTION: 
     
*/

//abstract class to be inherited by NonSubClass
public abstract class OutlineForNonSubClass {

    protected String PACKAGE = getClass().getPackageName().toUpperCase(); // get package name
    protected String CLASS = getClass().getSimpleName().toUpperCase(); // get class name
    protected String change = "ACCESSIBLE";
    protected String detail = "FROM " + CLASS + " IN " + PACKAGE + "\n";

    //abstract method to be overridden
    public abstract void changeVars();

}
