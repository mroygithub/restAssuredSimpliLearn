package day4;

public class static_key_understanding {

    static int roll = 10;
    int emp_id = 2;

    static String std_name = "Ravi";
    String emp_name = "Chandra";

    public static String Addhar_detail = null;

    public static void main(String[] args) {


        static_key_understanding SK = new static_key_understanding();
        System.out.println("The nme of the employee -->"+SK.emp_name);
        System.out.println("The nme of the student -->"+std_name);

        //calculate_salary_variable();
        calculate_salary();

    }

    public static void calculate_salary(){

    }

    public void calculate_salary_variable(){

    }

    public String create_Aadhar(){

        Addhar_detail = "ABCD1234";
        return Addhar_detail;
    }




}
