package Algorithm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Meta {
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
}
