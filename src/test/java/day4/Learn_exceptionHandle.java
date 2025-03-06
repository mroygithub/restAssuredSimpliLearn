package day4;

public class Learn_exceptionHandle {

    // try , catch , finally ... method body
    // throws ... method declaration
    // throw ... method body

    // 1st API test .... success ..
    // 2nd API test ...... there is some runtime error ...
    // 3rd API test


    //100th API test




    public static void main(String[] args) throws Exception {

        Learn_exceptionHandle LEH = new Learn_exceptionHandle();
        LEH.validate_Passport_Details();

    }

    public void validate_Passport_Details(){


        String passportNumber = "ABE123Z1";

        int length_of_passport_String = passportNumber.length();
        if(length_of_passport_String!=8){
            throw new ArithmeticException("The Passport typed is not matching the length ...");
        }
        if(length_of_passport_String==8){
            System.out.println("The Passport typed is available in the DB");
        }



    }


}
