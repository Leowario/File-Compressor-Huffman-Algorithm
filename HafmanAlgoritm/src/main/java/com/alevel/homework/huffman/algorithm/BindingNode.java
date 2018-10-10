package com.alevel.homework.huffman.algorithm;


import static com.google.common.base.Preconditions.checkNotNull;

class BindingNode extends Node {
    final Node left;
    final Node right;

    BindingNode(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = checkNotNull(left);
        this.right = checkNotNull(right);
        sum = left.sum + right.sum;
    }

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }
}
