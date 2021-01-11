package algorithms;
import algorithms.FastReaderFile;
import algorithms.FastReaderConsole;
import java.util.*;
import java.io.*;
import java.time.Clock;


public class Searching {
    static int linearSearch(int[] array, int key){
        for(int index = 0; index < array.length; index++){
            if(array[index]==key){
                return index;
            }
        }
        return -1;
    }
    
    static int binarySearch(int[] array, int key){
        int left = 0, right = array.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(array[mid]==key){
                return mid;
            }else if(array[mid]>key){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    
//    public static class FastReader {
//
//        BufferedReader br;
//        StringTokenizer st;
//        
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//        
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//        
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//        
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//        
//        float nextFloat() {
//            return Float.parseFloat(next());
//        }
//        
//        String nextLine() {
//            String str = null;
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        FastReader s = new FastReader();
//        int n = s.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i<n; i++){
//            arr[i]=s.nextInt();
//        }
//        System.out.println(binarySearch(arr,5));
//    }

    public static void main(String[] args) throws IOException {
        FastReaderConsole scanner = new FastReaderConsole();
        FileWriter out = new FileWriter("output.txt");
        int size = scanner.nextInt();
        Clock clock = Clock.systemDefaultZone();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        long milliseconds = clock.millis();
        out.write(linearSearch(array, 1577968505)+"\n");
        long linearTime = clock.millis()-milliseconds;
        out.write(linearTime+"\n");
        milliseconds = clock.millis();
        Arrays.sort(array);
        out.write(binarySearch(array, 1577968505)+"\n");
        long binaryTime = clock.millis()-milliseconds;
        out.write(binaryTime+"\n");
        out.write("Binary Search is "+((double)linearTime/binaryTime)+" times faster\n");
        out.close();
    }
}
