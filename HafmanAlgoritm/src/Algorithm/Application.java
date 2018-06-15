package Algorithm;


import Exceprion.UnexpectedFileFormat;

import java.io.*;

public class Application {

    private static final String DECOMPRESS = "--decompress";
    private static final String COMPRESS = "--compress";

    private Application() {

    }

    public static Application instace() {
        return new Application();
    }

    public void run(String[] args) {
        if (args.length < 1) {
            System.out.println("no parameters");
            System.exit(1);
        }
        if (!args[1].equals(DECOMPRESS) || !args[0].equals(COMPRESS)) {

        }
        final String directory = args[0];
        final String mod = args[1];

        if (COMPRESS.equals(mod)) {
            try {
                Compressor.instace().compress(directory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (DECOMPRESS.equals(mod)) {
            try {
                Decompressor.instace().decompress(directory);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnexpectedFileFormat un) {
                un.printStackTrace();
            }
        }
    }
}











