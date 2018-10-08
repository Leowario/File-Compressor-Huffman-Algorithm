package com.alevel.homework.haffman.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class HaffmanTree {
    private final Map<Character, Node> charNodeMap;
    private final byte[] bytesOfFile;

    HaffmanTree(Map<Character, Node> charNodeMap, byte[] bytesOfFile) {
        this.charNodeMap = charNodeMap;
        this.bytesOfFile = bytesOfFile;
    }

    String buildEncode() {
        StringBuilder encoded = new StringBuilder();
        for (byte aByteOfFile : bytesOfFile) {
            char currentChar = (char) aByteOfFile;
            if (charNodeMap.containsKey(currentChar)) {
                Node node = charNodeMap.get(currentChar);
                encoded.append(node.code);
            }
        }
        return encoded.toString();
    }

    Map<String, Character> buildDecodeMap() {
        Map<String, Character> decodeMap = new HashMap<>();
        charNodeMap.forEach((character, node) -> decodeMap.put(node.code, character));
        return decodeMap;
    }
}
