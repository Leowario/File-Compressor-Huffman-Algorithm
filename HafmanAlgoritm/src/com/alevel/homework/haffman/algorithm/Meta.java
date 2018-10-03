package com.alevel.homework.haffman.algorithm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class Meta {
    private Meta() {
    }

    /**
     * Creates a meta file in the same directory as a compressed file, writes the deCode table to file.
     */
    static void writeMeta(String directory, Map<String, Character> deCodeMap) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(directory + ".meta")) {
            for (Map.Entry<String, Character> map : deCodeMap.entrySet()) {
                String entryValue = map.getValue() + ": " + map.getKey();
                fileOutputStream.write(entryValue.getBytes());
                fileOutputStream.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Character> readMeta(String directory) throws IOException {
        Map<String, Character> decodeMap = new HashMap<>();
        Path path = Paths.get(directory + ".meta");
        List<String> strings = Files.readAllLines(path);
        for (int i = 0; i < strings.size(); i++) {
            String currentRow = strings.get(i);
            decodeMap.put(getCode(currentRow), getSymbol(currentRow));
        }
        return decodeMap;
    }

    private static char getSymbol(String currentRow) {
        return currentRow.charAt(0);
    }

    private static String getCode(String currentRow) {
        return currentRow.substring(3, currentRow.length());
    }
}
