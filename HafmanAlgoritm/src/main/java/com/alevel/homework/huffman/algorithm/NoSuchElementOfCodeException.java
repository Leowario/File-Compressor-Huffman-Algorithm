package com.alevel.homework.huffman.algorithm;

/**
 * @author Vitalii Usatyi
 *
 * This exceptions is throws when no elements has been found in decode table.
 */
public class NoSuchElementOfCodeException extends Exception{
    public NoSuchElementOfCodeException() {
        super();
    }

    NoSuchElementOfCodeException(String message) {
        super(message);
    }
}
