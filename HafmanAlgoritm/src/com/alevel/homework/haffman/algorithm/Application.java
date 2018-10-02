package com.alevel.homework.haffman.algorithm;


import com.alevel.homework.haffman.exceptions.UnexpectedFileFormat;
import com.alevel.homework.haffman.exceptions.NoSuchElementOfCodeException;

import java.io.*;
/**
 * @author Vitalii Usatyi
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
        final String directory = args[0];
        final String mod = args[1];

        try {
            if (args.length < 1) {
                System.out.println("no parameters");
                System.exit(1);
            }
            if (COMPRESS.equals(mod)) {
                Compressor.instance().compress(directory);
            } else if (DECOMPRESS.equals(mod)) {
                Decompressor.instance().decompress(directory);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IOException | UnexpectedFileFormat | NoSuchElementOfCodeException e) {
            e.printStackTrace();
        }
    }
}











