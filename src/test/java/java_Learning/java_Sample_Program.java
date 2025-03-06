package java_Learning; // This is Package Name

public class java_Sample_Program {  // This is Class Name

    public int Employee_id = 102; // Class level int type variable with value assigned
    public int Employee_id_1; // Class level int type variable without any assigned value
    public String Employee_name = "MITHUN"; // Class level String type variable with value assigned

    public static void main(String args[]) throws Exception{ // This is main function

        java_Sample_Program obj = new java_Sample_Program(); // Object of class java_Sample_Program

        // Calling method add_two_String and passing String type parameter : Python
        System.out.println(obj.add_two_String("Pyhton"));




    }

    public void add_two_number(int b , int c){ // void type method which accept 2 int type parameters:b,c
        int mit = b+c; // mit = local variable of type int
        System.out.println("The added value is ==>"+ mit);
        System.out.println(Employee_id); // Calling class level variable from method add_two_number
    }

    public int add_two_numbers(){ // int type method
        int a = 4+9;
        System.out.println("The added value is ==>"+ a);
        System.out.println(Employee_id);
        return a; // This is a return statement
    }

    public String add_two_String(String  Language){ // String type method which accept 1 String type parameter
        return "Welcome To"+" "+Language+" "+"World";
    }





}


