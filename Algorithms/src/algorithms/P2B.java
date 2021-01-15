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
public class P2B {

    static boolean check(char a, char b) {
        if (a == b && (a == 'i' || a == 'l' || a == 'm' || a == 'n' || a == 'o' || a == 't' || a == 'u' || a == 'v' || a == 'w' || a == 'x')) {
            return true;
        } else if ((a == 'd' && b == 'b') || (b == 'd' && a == 'b')) {
            return true;
        } else if ((a == 'q' && b == 'p') || (b == 'q' && a == 'p')) {
            return true;
        } else if ((a == 's' && b == 'z') || (b == 's' && a == 'z')) {
            return true;
        }
        return false;
    }

    static boolean check(char a) {
        if (a == 'i' || a == 'l' || a == 'm' || a == 'n' || a == 'o' || a == 't' || a == 'u' || a == 'v' || a == 'w' || a == 'x') {
            return true;
        }
        return false;
    }

    static int iterative(String word) {
        int pointerA = 0;
        int pointerB = 0;
        int sum = 0;
        while (pointerA < word.length() - 1) {
            boolean work = true;
            String temp = word.substring(pointerA, pointerB + 1);
            if (temp.length() > 1) {
                for (int i = 0; i < temp.length() / 2; i++) {
                    if (!check(temp.charAt(i), temp.charAt(temp.length() - i - 1))) {
                        work = false;
                        break;
                    }
                }
                if (work && temp.length() % 2 == 1) {
                    if (!check(temp.charAt(temp.length() / 2))) {
                        work = false;
                    }
                }
            } else {
                if (!check(temp.charAt(0))) {
                    work = false;
                }
            }
            if (work) {
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

    static boolean recursiveCheck(String word) {
        if (word.length() == 1) {
            if (check(word.charAt(0))) {
                return true;
            }
            return false;
        } else if (word.length() == 2) {
            if (check(word.charAt(0), word.charAt(1))) {
                return true;
            }
            return false;
        } else {
            return (check(word.charAt(0), word.charAt(word.length() - 1)) & recursiveCheck(word.substring(1, word.length() - 1)));
        }
    }

    static int recursive(String word, int pointerA, int pointerB) {
        boolean work = false;
        if (recursiveCheck(word.substring(pointerA, pointerB + 1))) {
            work = true;
        }
        pointerB--;
        if (pointerB < pointerA) {
            pointerA++;
            pointerB = word.length() - 1;
            if (pointerA == word.length()) {
                return 0;
            }
        } else if (pointerB == -1) {
            return 0;
        }
        if (work) {
            return 1 + recursive(word, pointerA, pointerB);
        } else {
            return recursive(word, pointerA, pointerB);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReaderConsole s = new FastReaderConsole();
        String word = s.next().toLowerCase();
        System.out.println(iterative(word));
        System.out.println(recursive(word, 0, word.length() - 1));
    }
}
