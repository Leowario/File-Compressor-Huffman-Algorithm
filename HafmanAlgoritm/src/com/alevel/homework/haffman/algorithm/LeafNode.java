package com.alevel.homework.haffman.algorithm;

public class LeafNode extends Node{
        char symbol;


        @Override
        void buildCode(String code) {
            super.buildCode(code);
        }

        LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }
