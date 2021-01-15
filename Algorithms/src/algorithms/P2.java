/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;
import algorithms.FastReaderConsole;

/**
 *
 * @author frank
 */
public class P2 {

    static int iterative(String word) {
        int pointerA = 0;
        int pointerB = 0;
        int sum = 0;
        while (pointerA < word.length() - 1) {
            String temp = word.substring(pointerA, pointerB + 1);
            if (word.substring(pointerA, pointerB + 1).length() > 1 && isPalindrome(temp)) {
                sum++;
            }
            pointerB++;
            if (pointerB == word.length()) {
                pointerA++;
                pointerB = pointerA;
            }
        }
        return sum;
    }

    static boolean isPalindrome(String word) {
        if (word.length() > 2 && word.charAt(0) == word.charAt(word.length() - 1)) {
            return (true & isPalindrome(word.substring(1, word.length() - 1)));
        } else if (word.length() == 1) {
            return true;
        } else if (word.length() == 2 && word.charAt(0) == word.charAt(1)) {
            return true;
        } else {
            return false;
        }
    }

    static int recursive(String word, int pointerA, int pointerB) {
        boolean work = false;
        if (word.substring(pointerA, pointerB + 1).length() > 1 && isPalindrome(word.substring(pointerA, pointerB + 1))) {
            work = true;
        }
        pointerB--;
        if (pointerB == pointerA) {
            pointerA++;
            pointerB = word.length() - 1;
            if (pointerA == word.length() - 1) {
                if (work) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else if (pointerB == -1) {
            if (work) {
                return 1;
            } else {
                return 0;
            }
        }
        if (work) {
            return 1 + recursive(word, pointerA, pointerB);
        } else {
            return recursive(word, pointerA, pointerB);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReaderConsole scanner = new FastReaderConsole();
        String word = scanner.next().toLowerCase();
        System.out.println(iterative(word));
        System.out.println(recursive(word, 0, word.length() - 1));
    }
}
