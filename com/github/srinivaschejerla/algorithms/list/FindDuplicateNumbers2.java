package com.github.srinivaschejerla.algorithms.list;

import java.util.Arrays;
import java.util.Random;

/**
 * Array problems 
 * 
 * Array implements list based Data Structure with index access
 * Array in Java can store primitive data or object data
 * 
 */

public class FindDuplicateNumbers2 {      
    /** 
     * Approach-2 : Sort + Scan -> Check if sorting the given input array will help
     * - Adhoc thinking 
     * 
     * TC = (sort + scan)*c = (nlogn + (n-1)) * c = nlogn * c = O(nlogn)
     *  -    TC for sorting is nlogn
     * 
     * SC = O(1) - because i is one contant used in scan
     * 
     * Problem - TC is high
     *      
     * Benchmark results 
     * 
     * - 1,000
     * - 10,000
     * - 1,00,000
     * - 10,00,000
     * - 1,00,00,000
     * - 10,00,00,000
     * 
     * */     
    
    public static int find(int arr[]) {

        Arrays.sort(arr);
        
        // System.out.println(Arrays.toString(arr));

        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                return arr[i];
            }
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Test cases and bench marking
     * 
     * @param args
     */
    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);
        boolean printArrary = Boolean.valueOf(args[1]);
        boolean benchMark = Boolean.valueOf(args[2]);
           
        // construct random array 
        int inputArr[] = new int[size];
        Random r = new Random();

        for(int k=0; k<inputArr.length; k++) {
            inputArr[k] = r.nextInt(100);
        }

        // print array
        if(printArrary) {
            System.out.println(Arrays.toString(inputArr));
        }

        // Benchmark code
        long startTime = 0;
        if(benchMark) {
            startTime = System.currentTimeMillis();        
            System.out.println("Start time : "+ startTime + " ms");
        }
                
        // Find duplicate number call
        int value = FindDuplicateNumbers2.find(inputArr);

        if(benchMark) {
            long endTime = System.currentTimeMillis();
            System.out.println("End time : "+ endTime +" ms");
                    
            System.out.println("Total execution time : "+ (endTime - startTime) + " ms");
        }

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }               
    }      
}