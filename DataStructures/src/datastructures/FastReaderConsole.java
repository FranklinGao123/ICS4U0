/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class FastReaderConsole {

    /**
     * buffering character-input stream
     */
    BufferedReader br;
    /**
     * a string tokenizer
     */
    StringTokenizer st;
    
    /**
     * This is the constructor function for new input, initializes br
     */
    public FastReaderConsole() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    /**
     * Reads the next Input Line
     *
     * @catch failure to read from input
     *
     * @returns the next token as a String
     */
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    
    /**
     * Runs next() in order to receive the next token
     *
     * @returns the next token as a Integer
     */
    int nextInt() {
        return Integer.parseInt(next());
    }
    
    /**
     * Runs next() in order to receive the next token
     *
     * @returns the next token as a Long
     */
    long nextLong() {
        return Long.parseLong(next());
    }
    
    /**
     * Runs next() in order to receive the next token
     *
     * @returns the next token as a Double
     */
    double nextDouble() {
        return Double.parseDouble(next());
    }
    
    /**
     * Runs next() in order to receive the next token
     *
     * @returns the next token as a Float
     */
    float nextFloat() {
        return Float.parseFloat(next());
    }
    
    /**
     * Reads the next Input Line
     *
     * @returns the whole line as a String
     */
    String nextLine() {
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
