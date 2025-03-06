package reusable;

public class RecresJsonBody {


    public String CreateUserJsonBody(String name , String ssn){

        String body = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"API TEST AUTOMATION LEAD\",\n" +
                "    \"Address\": \"123 Dublin Blvd USA\",\n" +
                "    \"SSN\": \""+ssn+"\"\n" +
                "}";
        return body;
    }











}
