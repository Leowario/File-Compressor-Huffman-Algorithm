package Algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Decompressor {

    private static Map<String, Character> codeSymbol = new HashMap<>();

    static void decompress(String directory) throws IOException {
        //#TODO Сделать проверку на коректность файла и бросать исключение если формат не знаком
        readMeta(directory);
        FileOutputStream decomressedFile = new FileOutputStream(directory + ".decompressed");//#TODO сделать чтоб брался коректный файл
        FileInputStream compressedFile = new FileInputStream(directory + ".compressed");//#TODO сделать чтоб брался коректный файл
        byte test1 = Byte.parseByte("01101011", 2);
        byte test2 = Byte.parseByte("00101011", 2);
        byte[]bytes ={test1,test2};
        byte byetesOfCompereesedFile[] = new byte[compressedFile.available()];
        compressedFile.read(byetesOfCompereesedFile);
        String currentCode = "";
        for (int i = 0; i < byetesOfCompereesedFile.length; i++) {
            byte currentByte = byetesOfCompereesedFile[i];
//            byte currentByte = bytes[i];
            System.out.println("YYY " + (int) currentByte);
            int byteTemp = (int) currentByte;
            for (int j = 0; j < 8; j++) {
                if((byteTemp & 128)>0){
                    currentCode+="1";
                }else if((byteTemp&128)<0) {
                    currentCode+="0";
                }
                if(codeSymbol.containsKey(currentCode)){
                    decomressedFile.write(codeSymbol.get(currentCode));
                currentCode="";
                }
                byteTemp=byteTemp<<1;
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
