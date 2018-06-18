package Algorithm;


import Exception.UnexpectedFileFormat;
import Exeprion.NoSuchElementOfCodeExeption;

import java.io.*;

public class Application {

    private static final String DECOMPRESS = "--decompress";
    private static final String COMPRESS = "--compress";

    private Application() {

    }

    public static Application instance() {
        return new Application();
    }

    public void run(String[] args) {
        if (args.length < 1) {
            System.out.println("no parameters");
            System.exit(1);
        }
        final String directory = args[0];
        final String mod = args[1];

        if (COMPRESS.equals(mod)) {
            try {
                Compressor.instance().compress(directory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (DECOMPRESS.equals(mod)) {
            try {
                Decompressor.instance().decompress(directory);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnexpectedFileFormat un) {
                un.printStackTrace();
            } catch (NoSuchElementOfCodeExeption ns) {
                ns.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}











