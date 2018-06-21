package com.alevel.homework.haffman.algorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HaffmanTree {
    private static String encode = "";

    private HaffmanTree() {

    }

    static HaffmanTree instance() {
        return new HaffmanTree();
    }

    public class Node implements Comparable<Node> {
        int sum;
        String code;

        Node(int sum) {
            this.sum = sum;
        }

        void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return (Integer.compare(sum, o.sum));
        }
    }

    class InternalNode extends Node {
        Node left;

        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
            sum = left.sum + right.sum;
        }
    }

    class LeafNode extends Node {

        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            // System.out.println(symbol + ": " + code);
        }

        LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    String getEncode() {
        return encode;
    }

    HaffmanTree buildTree(String directory) {
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        byte[] bytes;
        Map<Character, Integer> symbolAndCout = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(directory);
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (symbolAndCout.containsKey(c)) {
                symbolAndCout.put(c, symbolAndCout.get(c) + 1);
            } else {
                symbolAndCout.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolAndCout.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            priorityQueue.add(new InternalNode(first, second));
        }
        Node root = priorityQueue.poll();
        root.buildCode("");
        buildEncode(directory, charNodes, bytes);
        return new HaffmanTree();
    }

    private void buildEncode(String directory, Map<Character, Node> charNodes, byte[] bytes) {
        Map<String, Character> deCodeMap = new HashMap<>();
        for (Map.Entry<Character, Node> map : charNodes.entrySet()) {
            deCodeMap.put(map.getValue().code, map.getKey());
        }
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (charNodes.containsKey(c)) {
                encode += charNodes.get(c).code;
            }
        }
        Meta.writeMeta(directory, deCodeMap);
    }
}