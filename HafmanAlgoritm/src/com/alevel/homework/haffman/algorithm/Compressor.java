package com.alevel.homework.haffman.algorithm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author Vitalii Usatyi
 */
class Compressor {
    private Compressor() {

    }

    static Compressor instance() {
        return singleton.VALUE.value;
    }

    enum singleton {
        VALUE;
        Compressor value = new Compressor();
    }

    void compress(String directory) throws IOException {
        HaffmanTree haffmanTree = HaffmanTreeFactory.instance().create(directory);
        String encode = haffmanTree.buildEncode();
        Map<String, Character> decodeMap = haffmanTree.buildDecodeMap();
        Meta.writeMeta(directory, decodeMap);
        createCompressedFile(directory, encode);
    }

    private void createCompressedFile(String directory, String encode) throws IOException {
        FileOutputStream fos = new FileOutputStream(directory + ".compressed");
        for (int i = 0; i < encode.length(); i += 8) {
            for (int j = 0; j < 8 && (i + j) < encode.length(); j++) {
                String currentSting = encode.charAt(i + j) + "";
                if ("1".equals(currentSting)) {
                    fos.write("1".getBytes());
                } else {
                    fos.write("0".getBytes());
                }
            }
        }
    }
}