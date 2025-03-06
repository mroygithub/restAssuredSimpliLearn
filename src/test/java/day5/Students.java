package day5;

public class Students extends Person{

    public void message(){

        System.out.println("This will print a Student's message ....");
    }

    public void Display_different_messages(){

        // To display the message inside Student Class ...

        message();

        // To display the messages inside Person's Class ...

        super.message();

    }
}
