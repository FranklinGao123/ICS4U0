package algorithms;

import algorithms.FastReaderFile;
import algorithms.FastReaderConsole;
import java.util.*;
import java.io.*;
import java.time.*;

public class Sorting {
    
    

    static int[] bubbleSort(int[] array) {
        for (int pass = 0; pass < array.length; pass++) {
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int tempVariable = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = tempVariable;
                }
            }
        }
        return array;
    }

    static int[] selectionSort(int[] array) {
        for (int pass = 0; pass < array.length; pass++) {
            int bigIndex = 0;
            for (int index = 1; index < array.length-pass; index++) {
                if (array[index] > array[bigIndex]) {
                    bigIndex = index;
                }
            }
            int tempVariable = array[array.length-pass-1];
            array[array.length-pass-1] = array[bigIndex];
            array[bigIndex] = tempVariable;
        }
        return array;
    }

    
    public static void main(String[] args)  throws IOException {
        // TODO code application logic here
        FastReaderFile scanner = new FastReaderFile();
        FileWriter out = new FileWriter("output.txt");
        FileWriter bubbleSortFile = new FileWriter("BubbleSort.txt");
        FileWriter selectionSortFile = new FileWriter("SelectionSort.txt");
        int size = scanner.nextInt();
        Clock clock = Clock.systemDefaultZone();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        long milliseconds = clock.millis();
        int[] bubbleArray = bubbleSort(array);
        long bubbleTime = clock.millis()-milliseconds;
        out.write("Bubble Sort Time: "+ bubbleTime +" milliseconds\n");
        for(int index = 0; index<size; index++){
            bubbleSortFile.write(bubbleArray[index]+"\n");
        }
        milliseconds = clock.millis();
        int[] selectionArray =selectionSort(array);
        long selectionTime = clock.millis()-milliseconds;
        out.write("Selection Sort Time: "+ selectionTime +" milliseconds\n");
        for(int index = 0; index<size; index++){
            selectionSortFile.write(selectionArray[index]+"\n");
        }
        out.write("Selection Sort is "+((double)bubbleTime/selectionTime)+" times faster\n");
        out.close();
        bubbleSortFile.close();
        selectionSortFile.close();
        
    }

}
