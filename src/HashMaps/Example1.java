package HashMaps;

//4:14,

import java.util.HashMap;

public class Example1 {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;
        int c = 88;

        HashMap<String, Integer> happy = new HashMap<String, Integer>();
        happy.put("a",10);
        happy.put("b", 3);
        happy.put("c", 88);

        System.out.println(happy.get("c"));


    }

}
