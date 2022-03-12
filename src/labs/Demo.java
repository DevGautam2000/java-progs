package labs;/*

            AUTHOR: GAUTAM CHANDRA SAHA
            REG NO: 201900099
            DATE & TIME: 19/03/2021 AT 8:30 PM
            DESCRIPTION: Java program to demonstrate the concept of call by value
                        and call by reference mechanism of method calling.



ALGORITHM:

Algorithm name: Implementation of call_by_value and call_by_reference
Algorithm description: Java program to call_by_value and call_by_reference

VARIABLES:

Input variable: none
Output variable:  val,anotherVal , (Object).value

STEPS:

 0.Start.
 1.create a class callbyvalue it has a function modifyValue(int valuecopy)
    1.1.This function modifies valuecopy.
    1.2.Only to the value of the parameter which is a variable.It also return the valuecopy.
 2.create a class callbyreference it has a function modifyvalueofreference(callbyreference reference)
    2.1.This function has a object in the parameter.
    2.2.This function modifies the value of data member (value).
 3.In main()
    3.1.Take two variables a and b and initialize it to a integer value.
    3.2.Create a object of callbyvalue class then call the function anotherVal=modifyvalue(val).
    3.3.The value of b is changed but a remains the same because it is not refrenced.
    3.4.Again create two objects of callbyreference class like obj1 and obj2.
    3.5.Equalize both obj1=obj2 refrencing .
    3.6.Now call the function modifyvalueofreference like obj1.modifyValueOfReference(obj2).
    3.7.Both the values has been changed.
 4.Stop.



INPUT/OUTPUT:

IMPLEMENTATION OF CALL BY VALUE & CALL BY REFERENCE.


Calling by value

Value: 30
anotherValue: 30

After implementing call by value

Value: 30
anotherValue: 20

Hence, change in one variable did not change the other.


Calling by reference

Value using 1st reference: 40
Value using 2nd reference: 40

After implementing call by reference

Value using 1st reference: 50
Value using 2nd reference: 50

Hence, change of value due to one reference changed the value of other.

 */


class CallByValue {

    public int modifyValue(int valueCopy) {
        valueCopy = 20;
        return valueCopy;
    }
}

class CallByReference {

    int value;

    public void modifyValueOfReference(CallByReference reference) {
        reference.value = 50;
    }
}


public class Demo {


    public static void print(String toPrint) {
        System.out.println(toPrint);
    }

    public static void main(String[] args) {

        print("\nIMPLEMENTATION OF CALL BY VALUE & CALL BY REFERENCE.\n\n");

        //for call by value
        print("Calling by value\n");
        CallByValue callByValue = new CallByValue();
        int val = 30;
        int anotherVal = val;

        print("Value: " + val);
        print("anotherValue: " + anotherVal);

        anotherVal = callByValue.modifyValue(val); //implementing call by value

        print("\nAfter implementing call by value\n");
        print("Value: " + val);
        print("anotherValue: " + anotherVal);
        print("\nHence, change in one variable did not change the other.");


        //for call by reference
        print("\n\nCalling by reference\n");
        CallByReference callingByReference = new CallByReference();
        callingByReference.value = 40;

        CallByReference againCallingByReference = callingByReference;

        print("Value using 1st reference: " + callingByReference.value);
        print("Value using 2nd reference: " + againCallingByReference.value);

        againCallingByReference.modifyValueOfReference(callingByReference); //implementing call by reference
        print("\nAfter implementing call by reference\n");
        print("Value using 1st reference: " + callingByReference.value);
        print("Value using 2nd reference: " + againCallingByReference.value);
        print("\nHence, change of value due to one reference changed the value of other.");

    }
}





