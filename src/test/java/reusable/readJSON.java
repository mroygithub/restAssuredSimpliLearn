package reusable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class readJSON {

    public static Object obj;
    public static JSONObject jo;
    public static JSONArray ja;

    public static void main(String args[]) throws Exception{

        readJSON obj = new readJSON();
        obj.read_Json_File();
    }

    public void read_Json_File() throws Exception {

        obj = new JSONParser().parse(new FileReader("/Users/mithunroy/IdeaProjects/comtestrestAssuredSL/dataTest.json"));

// typecasting obj to JSONObject

        jo = (JSONObject) obj;
        ja = (JSONArray) jo.get("HomePage");

        Iterator itr2 = ja.iterator();

        while (itr2.hasNext()) {
            Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                //System.out.println(pair.getKey() + " : " + pair.getValue());
                if (pair.getKey().toString().equals("TC_001")) {
                    //System.out.println(pair.getValue());
                    String[] sub = pair.getValue().toString().split(",");
                    for (int c = 0; c < sub.length; c++) {
                        //  System.out.println(sub[c]);
                        System.out.println(sub[c].split(":")[0].replaceAll("[{}\"]", ""));
                        System.out.println(sub[c].split(":")[1].replaceAll("[{}\"]", ""));

                    }
                }
            }

        }
    }


}
