package labs;

public class Main {
    private int sum;


    public static void main(String[] args) {

        int nth;
        nth = Integer.parseInt(args[0]);

        Add(nth);
    }


    private static Main Add(int nth) {

        Main get = new Main();


        for (int i = nth; i >= 0; i--) {

            get.sum += i;

        }


        return get;


    }
}