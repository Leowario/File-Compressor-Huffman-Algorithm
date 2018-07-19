import java.io.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
//        try (FileInputStream fileInputStream = new FileInputStream("E:/Java/asd.patch")){
//new File("E:/Java/alevel.txt");
//
//
//           // byte []bytes = new byte[1024];
//            byte [] bytes = Files.readAllBytes()
//            while (fileInputStream.read(bytes)>0){//read возращаетсколько байтов она прочла и
//                System.out.println(new String(bytes));
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("sdasd");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("sadasd");
//            e.printStackTrace();
//        }
//        finally {
//
//        }

        File fileOut = new File("E:/Java/FileFrom.patch");//из которого копируем
        File fileIn = new File("E:/Java/FileTo.patch");//в который копируем
        if (!fileOut.exists()) {
            System.out.println("File is not exist");

        }
        if (!fileIn.exists()) {
            fileIn.createNewFile();
        }
        byte[] bytes = new byte[256];

        FileInputStream fileInputStream = new FileInputStream(fileOut);
        FileOutputStream fileOutputStream = new FileOutputStream(fileIn);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        while (fileInputStream.read(bytes) > 0) {//читаем из фаила из которого копируем
            fileOutputStream.write(bytes);//записываем в ваил в который копируем
        }



        System.out.println();
    }

}
