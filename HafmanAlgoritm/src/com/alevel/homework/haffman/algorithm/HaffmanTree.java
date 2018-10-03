package com.alevel.homework.haffman.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class HaffmanTree {
    private Map<Character, Node> charNodeMap;
    private byte[] bytesOfFile;

    HaffmanTree(Map<Character, Node> charNodeMap, byte[] bytesOfFile) {
        this.charNodeMap = charNodeMap;
        this.bytesOfFile = bytesOfFile;
    }

    String buildEncode() {
        String encode = "";
        for (int i = 0; i < bytesOfFile.length; i++) {
            char currentSymbol = (char) bytesOfFile[i];
            if (charNodeMap.containsKey(currentSymbol)) {
                encode += charNodeMap.get(currentSymbol).code;
            }
        }
        return encode;
    }

    Map<String, Character> buildDecodeMap() {
        Map<String, Character> decodeMap = new HashMap<>();
        for (Map.Entry<Character, Node> map : charNodeMap.entrySet()) {
            decodeMap.put(map.getValue().code, map.getKey());
        }
        return decodeMap;
    }
}
