package com.alevel.homework.haffman.algorithm;

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

    static class InternalNode extends Node {
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

    static class LeafNode extends Node {

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
}

