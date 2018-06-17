package Algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HaffmanTree {
    static String encode = "";

    private HaffmanTree() {

    }

    public static HaffmanTree instace() {
        return new HaffmanTree();
    }

    public class Node implements Comparable<Node> {
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

    public String getEncode() {
        return encode;
    }

    HaffmanTree buildTree(String directory) {
        Map<Character, Node> charNodes = new HashMap<>();//мапа которая за символом выдает узел с этим символом
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        byte[] bytes;
        Map<Character, Integer> symbolAndCout = new HashMap<>();//колекция содержащяя символ и его частоту
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

        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (symbolAndCout.containsKey(c)) {//если такой сивол уже есть в масиве то увеличиваем его чатсотату на 1
                symbolAndCout.put(c, symbolAndCout.get(c) + 1);
            } else {//иначе помещяем в колецию символ с частотой 1
                symbolAndCout.put(c, 1);
            }
        }

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
        buildEncode(directory, charNodes, bytes);
        return new HaffmanTree();
    }

    private void buildEncode(String directory, Map<Character, Node> charNodes, byte[] bytes) {
        Map<String, Character> deCodeMap = new HashMap<>();//contains code and symbol
        for (Map.Entry<Character, Node> map : charNodes.entrySet()) {
            deCodeMap.put(map.getValue().code, map.getKey());//creating decoding map
        }
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (charNodes.containsKey(c)) {
                encode += charNodes.get(c).code;//creating final encode
            }
        }
        Meta.writeMeta(directory, deCodeMap);
    }
}