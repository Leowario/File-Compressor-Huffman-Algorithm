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
     * Creates a meta file in the same source as a compressed file, writes the deCode table to file.
     */
    static void writeMeta(String source, Map<String, Character> deCodeMap) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(source + ".meta")) {
            for (Map.Entry<String, Character> map : deCodeMap.entrySet()) {
                String entryValue = map.getValue() + ": " + map.getKey();
                fileOutputStream.write(entryValue.getBytes());
                fileOutputStream.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Character> readMeta(String source) throws IOException {
        Map<String, Character> decodeMap = new HashMap<>();
        Path path = Paths.get(source + ".meta");
        List<String> strings = Files.readAllLines(path);
        for (String currentRow : strings) {
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
