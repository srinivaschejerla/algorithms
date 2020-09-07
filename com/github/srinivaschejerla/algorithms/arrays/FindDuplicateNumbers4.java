package com.github.srinivaschejerla.algorithms.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Array problems 
 * 
 * Array implements list based Data Storage Structure with index access
 * Array in Java can store primitive data or object data
 * 
 */

public class FindDuplicateNumbers4 {

    /** 
     * Approach-4 : Adhoc thinking - with same array memory
     * 
     * Instaed of using Aux memory like in previous approach, use same given input array to 
     *  create logic, basically negate the same value - if found already negated then that means duplicated.
     * 
     * TC = 1 scan + comparisions = n * c  = O(n)
     * 
     * SC =  couple local variables = constant space = O(1)
     * 
     * Benchmarking for 5 runs -> FindDuplicateNumbers3' 100000 false true  - 4ms
     * 
     * Windows 10, 16g RAM, Default JVM settings
     * 
     * 
     * */     
    public static int find(int inputArr[]) {
        for(int i = 0; i<inputArr.length; i++) {               // for each element in the input array                            
            int value = inputArr[i];
            value = Math.abs(value);
            
            if(inputArr[value] < 0) {
                return -inputArr[value];
            }

            inputArr[value] = - inputArr[value];                           
        }

        return Integer.MAX_VALUE;                           // return integer MAX for checking in parent function 
    }

    public static void testCase1(int inputArr[]) {

        int i=0;
        for(i=0; i<inputArr.length-1; i++) {
            inputArr[i] = i+1;

            //System.out.println("i="+inputArr[i]);
        }

        inputArr[i] = i;

        //System.out.println("i="+inputArr[i]);
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
        //Random r = new Random();
        
        /*for(int k=0; k<inputArr.length; k++) {
            inputArr[k] = r.nextInt(100);
        }*/

        testCase1(inputArr); // populate input array values such a way any of the array value is not grater than the array size.

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
        int value = FindDuplicateNumbers4.find(inputArr);

        if(benchMark) {
            long endTime = System.currentTimeMillis();
            System.out.println("End time : "+ endTime +" ms");
                    
            System.out.println("Total execution time : "+ (endTime - startTime) + " ms");
        }

        if(printArrary) {
            System.out.println(Arrays.toString(inputArr));
        }

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }               
    }
}