package labexamfourthsem;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 06/05/21 AT 10:53 AM
     DESCRIPTION:

     QUESTION SET: 4
     QP1
     NAME: GAUTAM CHANDRA SAHA
     REG NO: 201900099

ALGORITHM:

Algorithm name: Implementation of interface
Algorithm description: Program in Java to if food for a country is healthy or not

VARIABLES:
Input variables: vitamin, mineral, fats, protein, carbohydrate
Output variables: none

STEPS:
0.Create interface Breakfast with methods
    checkCarb()
    checkNutri()
   to override
1.create class Indian and Chinese to implement Breakfast
    1.1 override the checkNutri and checkCarb methods
2.instantiate object of both the classes and give input if nutrients are present or not
3.invoke checkNutri() to check if food is healthy or not
4.Stop

PSEUDOCODE: checkCarb() {
        if (this.carbohydrate >= 200) do{
            System.out.println("Breakfast is healthy\n");
        } else {
            System.out.println("Breakfast is not healthy\n");
        }
    }

PSEUDOCODE: checkNutri() {
        if (!this.vitamin || !this.mineral || !this.fats || !this.protein) do {
            System.out.println("Breakfast is not healthy\n");
        } else {
            checkCarb();
        }
    }


INPUT/OUTPUT:

IMPLEMENTATION OF INTERFACES AND INHERITANCE

Indian Food
Breakfast is not healthy

Chinese Food
Breakfast is healthy

*/


interface Breakfast {
    void checkCarb();

    void checkNutri();
}

class Indian implements Breakfast {
    static { //static block
        System.out.println("IMPLEMENTATION OF INTERFACES AND INHERITANCE\n");
    }

    //declare variables
    private final boolean vitamin;
    private final boolean mineral;
    private final boolean fats;
    private final boolean protein;
    private final int carbohydrate;

    //constructor
    public Indian(boolean vitamin, boolean mineral, boolean fats, boolean protein, int carbohydrate) {
        this.vitamin = vitamin;
        this.mineral = mineral;
        this.fats = fats;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
    }


    @Override
    public void checkCarb() { //over ride to check carbohydrates in food
        if (this.carbohydrate >= 200) {
            System.out.println("Breakfast is healthy\n");
        } else {
            System.out.println("Breakfast is not healthy\n");
        }
    }

    @Override
    public void checkNutri() { //over ride to check if food has all nutrients
        if (!this.vitamin || !this.mineral || !this.fats || !this.protein) {
            System.out.println("Breakfast is not healthy\n");
        } else {
            checkCarb(); //invoke to check carb count
        }
    }
}

//class extends Indian and implicitly implements Breakfast
//NOTE: class extended to facilitate code reuse
class Chinese extends Indian {

    //constructor
    public Chinese(boolean vitamin, boolean mineral, boolean fats, boolean protein, int carbohydrate) {
        super(vitamin, mineral, fats, protein, carbohydrate);
    }
}

//main class
public class QP1 {

    public static void main(String[] args) {

        //instantiate object fo class Indian
        Indian indianFood = new Indian(true, true, false, true, 300);
        System.out.println(indianFood.getClass().getSimpleName() + " Food");
        indianFood.checkNutri(); //invoke to check nutrients in food
        //NOTE: the checkCarb method is invoked in checkNutri() method

        //instantiate object fo class Chinese
        Chinese chineseFood = new Chinese(true, true, true, true, 250);
        System.out.println(chineseFood.getClass().getSimpleName() + " Food");
        chineseFood.checkNutri(); //invoke to check nutrients in food
        //NOTE: the checkCarb method is invoked in checkNutri() method

    }
}
