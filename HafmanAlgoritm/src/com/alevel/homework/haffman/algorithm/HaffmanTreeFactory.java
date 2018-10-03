package com.alevel.homework.haffman.algorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vitalii Usatyi
 */
class HaffmanTreeFactory {
    private Map<Character, Node> charNodeMap = new HashMap<>();
    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    private Map<Character, Integer> sequenceOfSymbolsMap = new HashMap<>();
    private byte[] bytesOfFile;

    private HaffmanTreeFactory() {

    }

    static HaffmanTreeFactory instance() {
        return singleton.VALUE.value;
    }

     enum singleton {
        VALUE;
        private HaffmanTreeFactory value = new HaffmanTreeFactory();
    }

    HaffmanTree create(String directory) {
        readBytesFromFile(directory);
        initializeSequenceOfSymbols(bytesOfFile, sequenceOfSymbolsMap);
        buildLeafNodes();
        buildInternalNodes();
        Node root = priorityQueue.poll();
        root.buildCode("");
        return new HaffmanTree(charNodeMap, bytesOfFile);
    }

    private void readBytesFromFile(String directory) {
        try (FileInputStream fileInputStream = new FileInputStream(directory)) {
            bytesOfFile = new byte[fileInputStream.available()];
            fileInputStream.read(bytesOfFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private void buildInternalNodes() {
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            priorityQueue.add(new Node.InternalNode(first, second));
        }
    }

    private void buildLeafNodes() {
        for (Map.Entry<Character, Integer> entry : sequenceOfSymbolsMap.entrySet()) {
            Node.LeafNode leafNode = new Node.LeafNode(entry.getKey(), entry.getValue());
            charNodeMap.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }
    }

    private void initializeSequenceOfSymbols(byte[] bytes, Map<Character, Integer> symbolAndCount) {
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