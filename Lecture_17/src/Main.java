import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> resultBytes = new ArrayList<>();


        StringBuilder builder = new StringBuilder();
        String compressedString = builder.toString();

        for (int i = 0; i < compressedString.length(); i++) {
            String chink= compressedString.substring(i,i+8);
            resultBytes.add(chink);
            i+=8;
            byte b = (byte) Integer.parseInt(chink, 2);
            Integer.parseInt(chink,2);

            while (chink.length()<8) {
                chink = chink.concat("8");
            }
            resultBytes.add(chink);

        }





        File file = new File("C:/robots.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] content = new byte[fis.available()];//???
            System.out.println("Total file size to read (in bytes) : "
                    + fis.available());


            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }


        } catch (Exception e) {

        }
    }
private static byte calculateFrequaci(byte[] content){
        int []frequaci = new int[255];
    for (int i = 0; i < content.length; i++) {
        byte letter = content[i];
        frequaci[letter]++;
    }

}

}
