package com.alevel.homework.haffman.algorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HaffmanTreeFactory {
    private static String encode = "";
    private Map<Character, Node> charNodes = new HashMap<>();
    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    private Map<Character, Integer> symbolAndCount = new HashMap<>();
    private byte[] bytes;

    private HaffmanTreeFactory() {

    }

    static HaffmanTreeFactory instance() {
        return singleton.VALUE.value;
    }

    public enum singleton {
        VALUE;
        private HaffmanTreeFactory value = new HaffmanTreeFactory();
    }

    HaffmanTree create(String directory) {

        readBytesFromFile(directory);
        initializeSequenceOfCharacters(bytes, symbolAndCount);
        buildLeafNodes();
        buildInternalNodes();
        Node root = priorityQueue.poll();
        root.buildCode("");
        return new HaffmanTree(directory, charNodes, bytes);
    }

    private void buildInternalNodes() {
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            priorityQueue.add(new Node.InternalNode(first, second));
        }
    }

    private void readBytesFromFile(String directory) {
        try (FileInputStream fileInputStream = new FileInputStream(directory)) {
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private void buildLeafNodes() {
        for (Map.Entry<Character, Integer> entry : symbolAndCount.entrySet()) {
            Node.LeafNode leafNode = new Node.LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }
    }

    private void initializeSequenceOfCharacters(byte[] bytes, Map<Character, Integer> symbolAndCount) {
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (symbolAndCount.containsKey(c)) {
                symbolAndCount.put(c, symbolAndCount.get(c) + 1);
            } else {
                symbolAndCount.put(c, 1);
            }
        }
    }
}