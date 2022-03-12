package sessional;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 28/04/21 AT 3:57 PM
     DESCRIPTION: 
     
*/

class Sweet {
    void price() {
        System.out.print("Sweet=$10 ");
    }
}

class Sugar extends Sweet {
    void price() {
        super.price();
        System.out.print("Sugar=$20");
    }
}

class Test {
    public static void main(String args[]) {
        String S = "Hello" + 5 + "World" + 10;
        System.out.println(S);
    }
}