package com.alevel.homework.haffman.algorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Vitalii Usatyi
 */
class HaffmanTreeFactory {
    private Map<Character, Node> charNodeMap = new HashMap<>();
    private PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    private Map<Character, Integer> charSequenceMap = new HashMap<>();
    private byte[] bytesOfFile;

    private HaffmanTreeFactory() {
    }

    static HaffmanTreeFactory instance() {
        return Singleton.VALUE.value;
    }

    enum Singleton {
        VALUE;
        private HaffmanTreeFactory value = new HaffmanTreeFactory();
    }

    HaffmanTree create(String source) {
        readBytesFromFile(source);
        initializeSequenceOfSymbols(bytesOfFile, charSequenceMap);
        buildLeafNodes();
        buildBindingNodes();
        Node root = priorityQueue.poll();
        root.buildCode("");
        return new HaffmanTree(charNodeMap, bytesOfFile);
    }

    private void readBytesFromFile(String source) {
        try (FileInputStream fileInputStream = new FileInputStream(source)) {
            bytesOfFile = new byte[fileInputStream.available()];
            fileInputStream.read(bytesOfFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private void buildBindingNodes() {
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            priorityQueue.add(new BindingNode(checkNotNull(first), checkNotNull(second)));
        }
    }

    private void buildLeafNodes() {
        charSequenceMap.forEach((character, sequence) -> {
            LeafNode leafNode = new LeafNode(character, sequence);
            charNodeMap.put(character, leafNode);
            priorityQueue.add(leafNode);
        });
    }

    private void initializeSequenceOfSymbols(byte[] bytes, Map<Character, Integer> charSequenceMap) {
        for (byte aByte : bytes) {
            char currentChar = (char) aByte;
            if (charSequenceMap.containsKey(currentChar)) {
                charSequenceMap.put(currentChar, charSequenceMap.get(currentChar) + 1);
            } else {
                charSequenceMap.put(currentChar, 1);
            }
        }
    }
}
