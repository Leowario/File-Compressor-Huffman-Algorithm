package Algorithm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Meta {
    private Meta(){
    }
    static Meta instace(){
        return  new Meta();
    }


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
        Map<String, Character> metaMap = new HashMap<>();
        Path path = Paths.get(directory + ".meta");
        List<String> strings = Files.readAllLines(path);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            metaMap.put(s.substring(3, s.length()), s.charAt(0));
        }
        return metaMap;
    }
}
