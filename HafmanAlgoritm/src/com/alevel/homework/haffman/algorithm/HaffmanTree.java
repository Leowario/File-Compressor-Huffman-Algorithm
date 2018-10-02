package com.alevel.homework.haffman.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class HaffmanTree {
    private Map<Character, Node> charNodes;
    private byte[] bytes;

    HaffmanTree( Map<Character, Node> charNodes, byte[] bytes) {
        this.charNodes = charNodes;
        this.bytes = bytes;
    }

    String buildEncode() {
        String encode = "";
        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];
            if (charNodes.containsKey(c)) {
                encode += charNodes.get(c).code;
            }
        }
        return encode;
    }

    Map<String, Character> buildDeCodeMap() {
        Map<String, Character> deCodeMap = new HashMap<>();
        for (Map.Entry<Character, Node> map : charNodes.entrySet()) {
            deCodeMap.put(map.getValue().code, map.getKey());
        }
        return deCodeMap;
    }
}
