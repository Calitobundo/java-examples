package test;

public class Test2 {


    public static void main(String[] args) {

        double value = 8.68;



        double quarter = (int)(value * 100) / 25;
        double rest = ((value * 100) % 25) / 100;


        System.out.println("Quarter: " + quarter);
        System.out.println("Rest: "+rest);


//        owed *= 100;
//        quarter = owed / 25;
//        owed = owed - (quarter * 25);
//        owed /= 100;
//        printf("Quarters: %d, balance owing $%.2lf\n", quarter, owed);


    }
}
