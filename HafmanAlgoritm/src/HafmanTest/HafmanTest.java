package HafmanTest;

//import Algorithm.Decompressor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HafamanTest {
    public HafamanTest() {

    }

    class Node implements Comparable<Node> {
        int sum;//частота повторений символа
        String code;//путь по дереву  к сиволу

        public Node(int sum) {
            this.sum = sum;
        }

        void buildCode(String code) {//постоение кода узла
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {//сравниваем текущюю частоту с переданной
            return (Integer.compare(sum, o.sum));
        }
    }

    class InternalNode extends Node {//внутрений узел
        Node left;
        Node right;

        @Override
        void buildCode(String code) {//присваеваем коды для левого и правого узла
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
            sum = left.sum + right.sum;
        }
    }

    class LeafNode extends Node {//листовой узел(листья) (имеют символ и частоту его повторения)
        char symbol;

        public char getSymbol() {
            return symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }


    public void run(String directory, boolean compression) throws IOException{
        if (compression) {
            compress(directory);
        } else {
            //Decompressor.decompress(directory);
        }
    }

    private void compress(String directory) {
        byte[] bytes;
        try {
            FileInputStream fileInputStream = new FileInputStream(directory);
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String s = new String(bytes);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }


        Map<Character, Integer> symbolAndCout = new HashMap<>();//колекция содержащяя символ и его частоту

        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (symbolAndCout.containsKey(c)) {//если такой сивол уже есть в масиве то увеличиваем его чатсотату на 1
                symbolAndCout.put(c, symbolAndCout.get(c) + 1);
            } else {//иначе помещяем в колецию символ с частотой 1
                symbolAndCout.put(c, 1);
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();//мапа которая за символом выдает узел с этим символом

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : symbolAndCout.entrySet()) {

            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);//добовляем в мапу символ и узел в котором он содержеться
            priorityQueue.add(leafNode);//добавляем в очредь все листья-узелы(символ, частота)
        }
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();//достаем узел с наименьшей частототой и удалем его из очереди
            Node second = priorityQueue.poll();//
            priorityQueue.add(new InternalNode(first, second));//ложим  в очередь новый внутрений узел у которого
            //есть листья(левый узел и правый)
        }
        Node root = priorityQueue.poll();//проверка
        root.buildCode("");//проверка
//
        //TODO# записать в файил мапу по которой будем разжимать файл. Нужно чтобы по коду мы получали сам сивол
        // System.out.println(encode);

        String encode = "";
        Map<String, Character> deCodeMap = new HashMap<>();//contains code and symbol

        try (FileInputStream fileInputStream1 = new FileInputStream(directory)) {

            for (Map.Entry<Character, Node> map : charNodes.entrySet()) {
                deCodeMap.put(map.getValue().code, map.getKey());//creating decoding map
            }

            for (int i = 0; i < bytes.length; i++) {
                char c = (char) bytes[i];

                if (charNodes.containsKey(c)) {

                    encode += charNodes.get(c).code;//creating final encode

                }
            }
            //bayting and write in the file(compress)
            //#TODO написать таблицу в файл
            try (FileOutputStream fileOutputStream1 = new FileOutputStream(directory + ".compressed")) {
                System.out.println(encode.length());
                for (int i = 0; i < encode.length(); i += 8) {
                    byte a = 0;
                    for (int j = 0; j < 8 && (i + j) < encode.length(); j++) {
                        String currentSting = encode.charAt(i + j) + "";
                        if (currentSting.equals("1")) {
                            a = (byte) (a | 1);
                            a = (byte) (a << 1);
                        } else {
                            a = (byte) (a << 1);
                        }
                    }
                    fileOutputStream1.write(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //write table
        writeTableToFile(directory, deCodeMap);


        System.out.println(encode);

    }

    private void writeTableToFile(String directory, Map<String, Character> deCodeMap) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(directory + ".meta")) {
            for (Map.Entry<String, Character> map : deCodeMap.entrySet()) {

                String entryValue = map.getValue() + ": " + map.getKey();
                fileOutputStream.write(entryValue.getBytes());
                fileOutputStream.write("\n".getBytes());
            }}
        catch (IOException e){
            e.printStackTrace();
        }
    }





}
