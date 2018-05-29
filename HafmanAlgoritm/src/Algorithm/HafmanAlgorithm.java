package Algorithm;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HafmanAlgorithm {
    public HafmanAlgorithm() {

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


    public void run(String directory, boolean compression) {
if (compression){
    compress(directory);
}
else {
 //#TODO
}
        }

    private void compress(String directory) {
        byte[] bytes = new byte[20000];
        try {
            FileInputStream fileInputStream = new FileInputStream(directory);
            fileInputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<Character, Integer> SymbolAndCout = new HashMap<>();//колекция содержащяя символ и его частоту
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (SymbolAndCout.containsKey(c)) {//если такой сивол уже есть в масиве то увеличиваем его чатсотату на 1
                SymbolAndCout.put(c, SymbolAndCout.get(c) + 1);
            } else {//иначе помещяем в колецию символ с частотой 1
                SymbolAndCout.put(c, 1);
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();//мапа которая за символом выдает узел с этим символом

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        for (Map.Entry<Character, Integer> entry : SymbolAndCout.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);//добовляем в мапу символ и узел в котором он содержеться
            priorityQueue.add(leafNode);//добавляем в очредь все листья-узелы(символ, частота)
        }
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();//достаем узел с наименьшей частототой и удалем его из очереди
            Node second = priorityQueue.poll();//
            priorityQueue.add(new InternalNode(first, second));//ложим назад в очередь новый внутрений узел у которого
            //есть листья(левый узел и правый)
        }
        Node root = priorityQueue.poll();
        root.buildCode("");
        String encode = " ";

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(directory+".compressed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytesOut = new byte[20000];
        try {
            for (int i = 0; i < bytes.length; i++) {
                char c = (char) bytes[i];
                encode+=charNodes.get(c).code;
              fileOutputStream.write(charNodes.get(c).code.getBytes());//достаем код каж
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(encode);
    }

//    private Node root;
//
//    public HafmanAlgorithm(Node root) {
//        this.root = root;
//    }

//    private static class Node {
//
//
//        private Integer frequency;//частота символа
//
//        private Character character;//символ
//
//        private Node leftChild;
//
//        private Node rightChild;
//
//        public Node(Integer frequency, Character character) {//конструктор для обычного узла
//            this.frequency = frequency;
//            this.character = character;
//        }
//
//        public Node(HafmanAlgorithm left, HafmanAlgorithm right) {//конструктордля главного узла
//            frequency = left.root.frequency + right.root.frequency;
//            leftChild = left.root;
//            rightChild = right.root;
//        }
//
//    }


}


