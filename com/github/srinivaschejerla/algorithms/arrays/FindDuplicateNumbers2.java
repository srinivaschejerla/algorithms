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

public class FindDuplicateNumbers2 {      
    /** 
     * Approach-2 : Adhoc thinking : Sort + Scan -> Check if sorting the given input array helps
     *  
     * TC = (sort + scan)*c = (nlogn + (n-1)) * c = nlogn * c = O(nlogn)
     *  - TC for sorting is nlogn
     * 
     * SC = O(1) - because "i" is only one contant variable used in scan process
     * 
     * What is the problem with this approach? - TC is still high
     * 
     * Benchmarking for 5 runs -> FindDuplicateNumbers2' 100000 false true  - 6ms
     * 
     * Windows 10, 16g RAM, Default JVM settings
     * 
     * */     
    
    public static int find(int arr[]) {

        Arrays.sort(arr);                       // sort the given arry - nlogn 
        
        // System.out.println(Arrays.toString(arr));

        // length = 3 ,  Ex:  [2,5,8] 

        // i=1, 1<3, 2 - true  - 5 == 2 - false
        // i=2, 2<3, 3 - true  - 8 == 5 - false
        // i=3, 3<3, 3 - false - 

        for(int i = 1; i<arr.length; ++i) { // loop through the given array, not index is starting from 1, because we compare with previous value , that way we don't go beyond the last element
            // System.out.println(i);
            if(arr[i] == arr[i-1]) {        // compare current index value with previous index value
                return arr[i]; //           // return if match found!
            }
        }

        return Integer.MAX_VALUE;           // return MAX integer for checking in parent function
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
     * 
     * Execution example 
     *  >java com.github.srinivaschejerla.algorithms.list.FindDuplicateNumbers2 100 true true 
     */
    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);               // read array size from command line
        boolean printArrary = Boolean.valueOf(args[1]);     // read boolean value from command line , this is to whether to print input array values
        boolean benchMark = Boolean.valueOf(args[2]);       // read benchmark boolean value from command line, this is to print benchmarking values
           
        // construct random array 
        int inputArr[] = new int[size];
        /*Random r = new Random();

        for(int k=0; k<inputArr.length; k++) {
            inputArr[k] = r.nextInt(2*size);
        }*/

        testCase1(inputArr);

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