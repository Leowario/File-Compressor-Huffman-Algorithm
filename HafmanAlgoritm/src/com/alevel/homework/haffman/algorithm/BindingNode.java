package com.alevel.homework.haffman.algorithm;


class BindingNode extends Node {
    Node left;
    Node right;

    BindingNode(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = left;
        this.right = right;
        sum = left.sum + right.sum;
    }

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }
}
