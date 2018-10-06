package com.alevel.homework.haffman.algorithm;


import java.io.IOException;

/**
 * @author Vitalii Usatyi
 * <p>
 * Receives the way to File and flag ("--compress" or "--decompress").
 * This implementation implements the algorithm conceptually and don't physically compress the file.
 */
public class Application {
    private static final String DECOMPRESS = "--decompress";
    private static final String COMPRESS = "--compress";

    private Application() {

    }

    public static Application instance() {
        return new Application();
    }

    public void run(String[] args) {
        final String source = args[0];
        final String mod = args[1];

        try {
            if (args.length < 1) {
                System.out.println("no parameters");
                System.exit(1);
            }
            if (COMPRESS.equals(mod)) {
                Compressor.instance().compress(source);
            } else if (DECOMPRESS.equals(mod)) {
                Decompressor.instance().decompress(source);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IOException | UnexpectedFileFormatException | NoSuchElementOfCodeException e) {
            e.printStackTrace();
        }
    }
}
