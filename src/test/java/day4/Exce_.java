package day4;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;

public class Exce_ {

    String Addhar_detail=null;

    public static void main(String[] args) throws Exception {

            checkfile();


    }


    public static void checkfile() throws Exception {


        File myfile = new File("/Users/mithunroy/Downloads/Azzx.pdf");
        FileImageInputStream stream = new FileImageInputStream(myfile);
        System.out.println("File Exists");


    }



}
