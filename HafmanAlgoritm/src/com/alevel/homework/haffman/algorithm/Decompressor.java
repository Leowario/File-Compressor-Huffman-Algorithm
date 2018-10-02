package com.alevel.homework.haffman.algorithm;


import com.alevel.homework.haffman.exceptions.NoSuchElementOfCodeException;
import com.alevel.homework.haffman.exceptions.UnexpectedFileFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class Decompressor {

    private Decompressor() {

    }

    static Decompressor instance() {
        return new Decompressor();
    }

    void decompress(String directory) throws IOException, UnexpectedFileFormat, NoSuchElementOfCodeException {
        if (!isValidFile(directory)) {
            throw new UnexpectedFileFormat();
        }
        //TODO is necessary to check for *.meta and *.compressed file ?
        String originalDirectory = directory.substring(0, directory.length() - 11);
        Map<String, Character> codeSymbolMap = Meta.readMeta(originalDirectory);
        FileOutputStream fos = new FileOutputStream(originalDirectory);
        Path path = Paths.get(directory);//read table
        List<String> strings = Files.readAllLines(path);
        String haffmanCode = strings.get(0);
        createDecompressedFile(codeSymbolMap, fos, haffmanCode);
    }

    private void createDecompressedFile(Map<String, Character> codeSymbolMap, FileOutputStream fos, String haffmanCode) throws IOException, NoSuchElementOfCodeException {
        boolean isWrote = false;
        String currentCode = "";
        for (int i = 0; i < haffmanCode.length(); i++) {
            if ("1".equals(haffmanCode.charAt(i) + "")) {
                currentCode += "1";
            } else if ("0".equals(haffmanCode.charAt(i) + "")) {
                currentCode += "0";
            }
            if (codeSymbolMap.containsKey(currentCode)) {
                isWrote = true;
                fos.write(codeSymbolMap.get(currentCode));
                currentCode = "";
            }
        }
        if (!isWrote) {
            throw new NoSuchElementOfCodeException();
        }
    }

    private boolean isValidFile(String directory) {
        return directory.substring(directory.length() - 11, directory.length()).contains(".compressed");
    }
}
