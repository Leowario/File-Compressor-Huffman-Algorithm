package com.alevel.homework.haffman.algorithm;


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
        return Singleton.VALUE.value;
    }

    void decompress(String source) throws IOException, UnexpectedFileFormatException, NoSuchElementOfCodeException {
        if (!isValidFile(source)) {
            throw new UnexpectedFileFormatException();
        }
        String originalDirectory = source.substring(0, source.length() - 11);
        Map<String, Character> decodeMap = Meta.readMeta(originalDirectory);
        FileOutputStream fos = new FileOutputStream(originalDirectory);
        Path path = Paths.get(source);
        List<String> strings = Files.readAllLines(path);
        String haffmanCode = strings.get(0);
        decodeFile(decodeMap, fos, haffmanCode);
    }

    private void decodeFile(Map<String, Character> decodeMap, FileOutputStream fos, String haffmanCode) throws IOException, NoSuchElementOfCodeException {
        boolean isWritten = false;
        String currentCode = "";
        for (int i = 0; i < haffmanCode.length(); i++) {
            if ("1".equals(haffmanCode.charAt(i) + "")) {
                currentCode += "1";
            } else if ("0".equals(haffmanCode.charAt(i) + "")) {
                currentCode += "0";
            }
            if (decodeMap.containsKey(currentCode)) {
                isWritten = true;
                fos.write(decodeMap.get(currentCode));
                currentCode = "";
            }
        }
        if (!isWritten) {
            throw new NoSuchElementOfCodeException(currentCode);
        }
    }

    private boolean isValidFile(String source) {
        return source.endsWith(".compressed");
    }

    enum Singleton {
        VALUE;
        Decompressor value = new Decompressor();
    }
}
