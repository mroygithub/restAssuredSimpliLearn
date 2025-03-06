package day5;

public class Sound_implementation {

    public static void main(String[] args) {


        AnimalSound AS = new AnimalSound();
        CAT CT = new CAT();
        DOG DG = new DOG();

        AS.sound(); // print Generic sound statement
        // Below would print as per Animal ..
        CT.sound();
        DG.sound();






    }
}
