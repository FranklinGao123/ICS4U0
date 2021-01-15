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
public class P1 {

    static int iteritive(int number) {
        int sum = 0;
        for (int index = 0; index < String.valueOf(number).length(); index++) {
            sum += String.valueOf(number).charAt(index) - '0';
        }
        return sum;
    }

    static int recursive(int number) {
        if (String.valueOf(number).length() == 1) {
            return number;
        } else {
            return String.valueOf(number).charAt(0) - '0' + recursive(Integer.parseInt(String.valueOf(number).substring(1, (String.valueOf(number).length()))));
        }
    }

    public static void main(String[] args) throws IOException {
        FastReaderConsole scanner = new FastReaderConsole();
        int number = scanner.nextInt();
        System.out.println(iteritive(number));
        System.out.println(recursive(number));
    }
}
