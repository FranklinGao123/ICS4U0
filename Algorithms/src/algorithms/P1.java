/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;
import java.util.*;
import java.io.*;
/**
 *
 * @author frank
 */
public class P1 {
    public static class FastReader {

        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
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
        
        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        float nextFloat() {
            return Float.parseFloat(next());
        }
        
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
    
    static int iteritive(int number){
        int sum = 0;
        for(int index = 0; index<String.valueOf(number).length(); index++){
            sum+=String.valueOf(number).charAt(index)-'0';
        }
        return sum;
    }
    
    static int recursive(int number){
        if(String.valueOf(number).length()==1){
            return number;
        }else{
            return String.valueOf(number).charAt(0) - '0' + recursive(Integer.parseInt(String.valueOf(number).substring(1, (String.valueOf(number).length()))));
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int number = scanner.nextInt();
        System.out.println(iteritive(number));
        System.out.println(recursive(number));
    }
}
