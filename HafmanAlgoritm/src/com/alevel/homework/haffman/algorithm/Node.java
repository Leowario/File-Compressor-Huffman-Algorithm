package com.alevel.homework.haffman.algorithm;

/**
 * @author Vitalii Usatyi
 */
public abstract class Node implements Comparable<Node> {
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
