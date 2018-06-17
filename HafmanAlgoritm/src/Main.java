import Algorithm.Application;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String s = " sadasd.txt.compressed";
        System.out.println(s.substring(0,s.length()-11)+".meta");
        Application.instace().run(args);

    }

}
