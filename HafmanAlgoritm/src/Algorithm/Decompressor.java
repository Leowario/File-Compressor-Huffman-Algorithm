package Algorithm;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exceptions.UnexpectedFileFormat;
import Exceptions.NoSuchElementOfCodeExeption;

class Decompressor {

    private Decompressor() {

    }

    static Decompressor instance() {
        return new Decompressor();
    }

    private static Map<String, Character> codeSymbol = new HashMap<>();

    void decompress(String directory) throws IOException, UnexpectedFileFormat, NoSuchElementOfCodeExeption {
        if (!directory.substring(directory.length() - 11, directory.length()).contains(".compressed")) {
            throw new UnexpectedFileFormat("Unexpected file Format");
        }
        String originalDirectory = directory.substring(0, directory.length() - 11);
        codeSymbol = Meta.readMeta(originalDirectory);
        FileOutputStream decomressedFile = new FileOutputStream(originalDirectory);
        Path path = Paths.get(directory);//read table
        List<String> strings = Files.readAllLines(path);
        String currentCode = "";
        String s = strings.get(0);
        boolean isWrote = false;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) + "").equals("1")) {
                currentCode += "1";
            } else if ((s.charAt(i) + "").equals("0")) {
                currentCode += "0";
            }
            if (codeSymbol.containsKey(currentCode)) {
                isWrote = true;
                decomressedFile.write(codeSymbol.get(currentCode));
                currentCode = "";
            }
        }
        if (!isWrote) {
            throw new NoSuchElementOfCodeExeption();
        }
    }
}
