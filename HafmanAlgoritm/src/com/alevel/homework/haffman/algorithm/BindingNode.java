package com.alevel.homework.haffman.algorithm;

import com.alevel.homework.haffman.algorithm.Node;

public class BindingNode extends Node{
        Node left;
        Node right;


        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        BindingNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
            sum = left.sum + right.sum;
        }
    }
