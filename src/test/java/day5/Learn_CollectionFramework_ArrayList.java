package day5;

import java.util.*;

public class Learn_CollectionFramework_ArrayList {

    public static void main(String[] args) {
        Learn_CollectionFramework_ArrayList AR = new Learn_CollectionFramework_ArrayList();
        AR.implementArrayList();
    }

    public void implementArrayList(){

        ArrayList<String> Mobile_name = new ArrayList<String>();

        // How to add element into an ArrayList ...

            // Assign value ...
        Mobile_name.add("LAVA");
        Mobile_name.add("KARBON");
        Mobile_name.add("POCO 5");
        Mobile_name.add("README 6");
        Mobile_name.add("SAMSUNG 9");
        Mobile_name.add("LENOVO 10");

        // Read / get the ArrayList Value ....
        System.out.println(Mobile_name);
        System.out.println(Mobile_name.get(0));
        System.out.println(Mobile_name.get(1));

        // Get Length of An ArrayList ..

        System.out.println("ArrayList Length is --->"+Mobile_name.size());


        // Remove ..element

        Mobile_name.remove(0);
        System.out.println(Mobile_name);

        // Reset some data ..

        Mobile_name.set(0,"IPHONE");
        System.out.println(Mobile_name);

        // Remove all Elements from an ArrayList ..

        Mobile_name.clear();
        System.out.println("Afer Clear ArrayList is -->"+Mobile_name);














    }
}
