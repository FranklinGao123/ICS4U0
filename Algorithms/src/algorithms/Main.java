package algorithms;

import algorithms.FastReaderFile;
import algorithms.FastReaderConsole;
import algorithms.ChessRank;
import java.util.*;
import java.io.*;
import java.time.Clock;

public class Main {

    static int linearSearch(ChessRank[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index].getRank() == key) {
                return index;
            }
        }
        return -1;
    }

    static int binarySearch(ChessRank[] array, int key) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (array[mid].getRank() == key) {
                return mid;
            } else if (array[mid].getRank() > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static ChessRank[] bubbleSort(ChessRank[] array) {
        for (int pass = 0; pass < array.length; pass++) {
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index].getRank() > array[index + 1].getRank()) {
                    ChessRank tempVariable = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = tempVariable;
                }
            }
        }
        return array;
    }

    static ChessRank[] insertionSort(ChessRank[] array) {
        for (int key = 1; key < array.length; key++) {
            ChessRank temp = new ChessRank(array[key].getID(), array[key].getRank());
            int index = key - 1;
            while (index > -1) {
                if (temp.getRank() < array[index].getRank()) {
                    array[index + 1] = array[index];
                    index--;
                } else {
                    array[index + 1] = temp;
                    break;
                }
            }
            if (index == -1) {
                array[0] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        FastReaderFile scanner = new FastReaderFile();
        FileWriter out = new FileWriter("output.txt");
        FileWriter bubble = new FileWriter("Bubblesort.txt");
        FileWriter insertion = new FileWriter("InsertionSort.txt");
        int size = scanner.nextInt();
        Clock clock = Clock.systemDefaultZone();
        ChessRank[] array = new ChessRank[size];
        for (int index = 0; index < size; index++) {
            array[index] = new ChessRank(index, scanner.nextInt());
        }

        //Code for timing bubbble vs insertion sort
        out.write("Sorting \n");
        long milliseconds = clock.millis();

        /*Bubble Sort Time
        ChessRank[] bubbleSorted = bubbleSort(array);
        long bubbleTime = clock.millis()-milliseconds;
        for(int index = 0; index<size; index++){
            bubble.write(bubbleSorted[index].getRank()+"\n");
        }
        out.write("Bubble Sort: "+bubbleTime+" milliseconds\n");
         */

 /*Insertion Sort
        ChessRank[] insertionSorted = insertionSort(array);
        long insertionSort = clock.millis()-milliseconds;
        for(int index = 0; index<size; index++){
            insertion.write(insertionSorted[index].getRank()+"\n");
        }
        out.write("Insertion Sort: "+insertionSort+" milliseconds\n");
         */
        //out.write("Insertion Sort is "+((double)bubbleTime/insertionSort)+" times faster\n");
        //Code for timing the Binary Search vs Linear 
        // Code for linear
        /*
        milliseconds = clock.millis();
        out.write("Index Number "+linearSearch(array, 1311407666)+"\n");
        long linearTime = clock.millis()-milliseconds;
        out.write("Linear Search: "+linearTime+" milliseconds\n");

        //Binary Search time
        milliseconds = clock.millis();
        Arrays.sort(array);
        long quickSort = clock.millis()-milliseconds;
        //out.write("Quick Sort: " + quickSort+ " milliseconds\n");
        out.write("Index Number "+binarySearch(array, 1577968505)+"\n");
        long binaryTime = clock.millis()-milliseconds;
        out.write("Binary Search: "+binaryTime+" milliseconds\n");
         */
        //out.write("Binary Search is "+((double)linearTime/binaryTime)+" times faster\n");
        out.close();
        bubble.close();
        insertion.close();
    }

}
