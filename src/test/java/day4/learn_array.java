package day4;

public class learn_array {


    // project , package ,class
    // class level variable & local variable
    // object creation + calling constr & pass parameter in Constr
    // Inheritance , how to use it
    // How to call a variable / method ...
    // Loop + EF Else ...

    String runtimeApplicationDate = "The purchase date is 11-11-2023";

    String Database_PD = "11-11-2023";


    public static void main(String[] args) {

        learn_array obj = new learn_array();
        obj.learn_int_type_array_exam(); /// Assume this  is First Test ...
        obj.get_the_purchaseDate(); // This is Second Test ...



    }

    public void learn_int_type_array(){


        int[] ROLL = {1,2,3,4,5,6,7,8,9,10};

        int lenth_of_my_array = ROLL.length; // How to get length of an array ....


        // Array Index ..
        // 0 positoin = 1
        // 1st position = 2
        // n==10

        // (n-1) position = last element

        for(int i=0;i<lenth_of_my_array;i++){

        }
    }

    public void learn_int_type_array_exam(){

        try {

            // Declare an Array
            int[] EMP_ID = new int[12];

            // initialize some value into an array ...

            EMP_ID[0] = 1001;
            EMP_ID[1] = 1002;
            EMP_ID[2] = 1003;
            EMP_ID[3] = 1004;
            EMP_ID[4] = 1005;
            EMP_ID[5] = 1006;

            // (n-1) position = last element

            // Get the array element ....
            System.out.println("The Employee of position 4 is" + EMP_ID[4]);
            System.out.println("The Employee of position 4 is" + EMP_ID[12]);
        }
        catch(Exception e){
            // This block execute if TRY is having some issue ...
            e.printStackTrace();
            System.out.println("There is some issue in learn_int_type_array_exam");


        }
        finally {
            System.out.println("This block always execute ..");
        }


    }


    public void learn_String_Type_Array(){

        String[] FRUITS = new String[5];
        FRUITS[0]="APPLE";
        FRUITS[1]="BANANA";
        FRUITS[2]="COCONUT";
        FRUITS[3]="PEARS";
        FRUITS[4]="ORANGE";

        // length ..
        // print first fruit..
        // Loop the fruit ...

        // Replace the existing value ... if there is any changes ...
    }

    public void get_the_purchaseDate(){


        System.out.println("This is Second test starting .....get_the_purchaseDate");
        String[] the_runtime_dateValue = runtimeApplicationDate.split(" ");
        System.out.println(the_runtime_dateValue[0]);
        System.out.println(the_runtime_dateValue[1]);

        if(the_runtime_dateValue[4].equals(Database_PD)){
            System.out.println("The Purchase Date match-->"+the_runtime_dateValue[4]);
        }

        String[] Split_the_date = the_runtime_dateValue[4].split("-");

        System.out.println("The Purchase Year is -->"+Split_the_date[2]);



    }




}
