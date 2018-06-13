package Algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Compressor {
    private Compressor() {

    }

    public static Compressor instace() {
        return new Compressor();
    }

    void compress(String directory) throws IOException{
           String encode = HaffmanTree.instace().buildTree(directory);
            FileOutputStream fos = new FileOutputStream(directory + ".compressed");
            System.out.println(encode.length());
            for (int i = 0; i < encode.length(); i += 8) {
                int a = 0;
                for (int j = 0; j < 8 && (i + j) < encode.length(); j++) {
                    String currentSting = encode.charAt(i + j) + "";
                    if (currentSting.equals("1")) {
                        a = (byte)(a | 1);
                        a = (byte)(a << 1);
                    } else {
                        a = (a << 1);
                    }
                }
                System.out.println("ZZZ " + (int) a);
                fos.write(a);
            }
        }
    }






