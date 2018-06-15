package Algorithm;

import Exceprion.UnexpectedFileFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Decompressor {

    private Decompressor(){

    }
    public static Decompressor instace(){
        return new Decompressor();
    }

    private static Map<String, Character> codeSymbol = new HashMap<>();

    void decompress(String directory) throws IOException,UnexpectedFileFormat {
        //#TODO Сделать проверку на коректность файла и бросать исключение если формат не знаком
//       if (!directory.contains(".compressed")){
//           throw new UnexpectedFileFormat("Unexpected file Format");
//       }
        readMeta(directory);
        FileOutputStream decomressedFile = new FileOutputStream(directory);
        Path path = Paths.get(directory + ".compressed");//read table
        List<String> strings = Files.readAllLines(path);
        String currentCode = "";
        String s = strings.get(0);
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)+"").equals("1")){
                currentCode+="1";
            }
            else if((s.charAt(i)+"").equals("0")) {
                currentCode+="0";
            }
            if (codeSymbol.containsKey(currentCode)){
                decomressedFile.write(codeSymbol.get(currentCode));
                currentCode="";
            }
        }
    }

    private static void readMeta(String directory) throws IOException {
        Path path = Paths.get(directory + ".meta");//read table
        List<String> strings = Files.readAllLines(path);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            codeSymbol.put(s.substring(3, s.length()), s.charAt(0));//add to map(code,symbol)
        }
    }
}
