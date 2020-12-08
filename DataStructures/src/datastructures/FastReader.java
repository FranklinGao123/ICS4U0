/**
 * A Object for taking in different types of input data types
 *
 * @author Franklin Gao
 *
 */
package datastructures;

import java.util.*;
import java.io.*;

public class FastReader {

    /*
    This is my input reader
    
    Atributes
    ------------
    br : BufferedReader
        It is a buffering character-input stream
    st : StringTokenizer
        It is a string tokenizer
    fileMissing:
        Checks if the file is missing
    Methods
    ------------
    next() -> String
        Reads the next Input Line and returns the next token as a String
    nextInt() -> Integer
        Runs next() in order to receive the next token and the next token as a Integer
    nextLong() -> Long
        Runs next() in order to receive the next token and returns the next token as a Long
    nextDouble() -> Double
        Runs next() in order to receive the next token and returns the next token as a Double
    nextFloat() -> Float
        Runs next() in order to receive the next token and returns the next token as a Float
    nextLine() -> String
        Reads the next Input Line and returns the whole line as a String
     */
    BufferedReader br;
    StringTokenizer st;
    boolean fileMissing;

    /**
     * This is the constructor function for new input, initializes br
     */
    public FastReader() throws FileNotFoundException {
        fileMissing = false;
        try {
            File myFile = new File("input.txt");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
        } catch (FileNotFoundException f) {
            System.out.println("File not found");
            fileMissing = true;
        }
    }

    /**
     * Reads the next Input Line
     *
     * @catch failure to read from input
     *
     * @returns the next token as a String
     */
    String next() {
        if (!fileMissing) {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    System.out.println("Failed to read from file");
                }
            }
            return st.nextToken();
        }else{
            return null;
        }
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
