package com.github.srinivaschejerla.algorithms.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * Find non-zeros followed by zeros
 * 
 * Apprach : complete scan
 * 
 * TC - O(n) - compare given n numbers in a loop
 * SC - O(1) - word space
 * 
 */
public final class FindZerosFollowedByNonZeros {

    static int find(int[] arr) {

        int count = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0 || i == arr.length-1){
                count = i;
                break;
            }
        }

        return count;
    }

    public static void testCase1(int arr[], int zc) {
        Random r = new Random();

        for(int i =0; i<arr.length; i++) {
            if(i<zc) {
                arr[i] = 0;
            } else {
                arr[i] = r.nextInt(10)+1;
            }
        }
    } 

    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);
        int zc = Integer.parseInt(args[1]);
        boolean printArrary = Boolean.valueOf(args[2]);
        boolean benchMark = Boolean.valueOf(args[3]);
        
        // construct random array 
        int arr[] = new int[size];
        
        testCase1(arr,zc); // populate input array values such a way any of the array value is not grater than the array size.

        // print array
        if(printArrary) {
            System.out.println(Arrays.toString(arr));
        }

        // Benchmark code
        long startTime = 0;
        if(benchMark) {
            startTime = System.currentTimeMillis();        
            System.out.println("Start time : "+ startTime + " ms");
        }
                
        // Find duplicate number call
        int value = FindZerosFollowedByNonZeros.find(arr);

        if(benchMark) {
            long endTime = System.currentTimeMillis();
            System.out.println("End time : "+ endTime +" ms");
                    
            System.out.println("Total execution time : "+ (endTime - startTime) + " ms");
        }

        if(printArrary) {
            System.out.println(Arrays.toString(arr));
        }

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("count = "+ value);
        }               
    }
    
}