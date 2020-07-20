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

public class FindDuplicateNumbers1 {
  
    /**
     * 
     * @param arr
     * @return value
     * 
     * Approach-1 : Scan each element to find duplicate
     * 
     * Primitive thinking
     * Pick each element in a given input arrary 
     * and scan through all remaining elements in that array until
     * end of the array.
     * (n-1) + (n-2) + (n-3) ------ 1
     * n(n-1)/2 = (n^2 - n) / 2 = (n^2 - n) * c  = O(n^2)
     * Note:
     * - (n^2-n) is coming to n^2 at worst case
     * - and 'c' = 1/2 is constant - BigO
     * TC = O(n^2)
     * SC = O(1) : This is because of variables used in the stack area of the running 
     * program to store execution data  
     * 
     * We used varialble like i, j in "for loops"
     * We call it constant space as we have countable variables -2 in this case
     * 
     * What is problem here? : TC is very high 
     * Benchmark results? : 
     * 
     * 
     * 
     */     
    public static int find(int arr[]) {        
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {                    
                    return arr[i];
                }
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
        int value = FindDuplicateNumbers1.find(inputArr);

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