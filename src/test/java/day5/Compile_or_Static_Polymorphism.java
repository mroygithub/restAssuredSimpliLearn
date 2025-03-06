package day5;

public class Compile_or_Static_Polymorphism {

    public static void main(String[] args) {
        Compile_or_Static_Polymorphism obj = new Compile_or_Static_Polymorphism();
        obj.addition(2,3);
        System.out.println(obj.addition(2.1,3.2));
        System.out.println(obj.addition(2.12,3.25));
    }


    public int addition(int a , int b){
        return a+b;
    }

    public int addition(int a , int b, int c){
        return a+b+c;
    }

    public double addition(double a , double b){

        return a+b;
    }

    public void clickAndWait(int a){ // a = static time



    }
    public void clickAndWait(){ // a = dynamic wait  time



    }

    public String read_Global_sheet(String fileType){

        return "data";

    }

    public String read_Global_sheet(String fileType , String key){

        return "data";

    }


}
