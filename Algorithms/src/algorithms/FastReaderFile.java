package algorithms;

import java.util.*;
import java.io.*;

/**
 * A Object for inputing different types of input data types
 *
 * @author Franklin Gao
 * @version 1.0 (current version number of program)
 * @since 1.8 (the version of the package this class was first added to)
 */
public class FastReaderFile {

    /**
     * buffering character-input stream
     */
    BufferedReader br;
    /**
     * a string tokenizer
     */
    StringTokenizer st;
    /**
     * Checks if the file is missing
     */
    boolean fileMissing;

    /**
     * This is the constructor function for new input, initializes br Sends
     * error message is file is missing
     */
    public FastReaderFile() throws FileNotFoundException {
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
        } else {
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
