package com.github.srinivaschejerla.algorithms.arrays;

import java.util.Arrays;
import java.util.Random;


/**
 * 
 * Find ceil of the x
 * 
 * Approach - 1 : Divide and Prune 
 * 
 * TC - O(log n)
 * SC - O(1)
 * 
 * 
 * java com.github.srinivaschejerla.algorithms.arrays.FindCeilOfAnArray1 10000000 765 false true 
 * Total execution time : 0 ms
 * Found! 766
 * 
 * 
 * 
 */

public final class FindCeilOfAnArray1 {

    static int find(int[] arr, int x){
        int ceilOfX = Integer.MIN_VALUE;
 

        int l=0, r=arr.length-1;
        int m = Integer.MIN_VALUE;

        while(r != l) {
            m = (l+r)/2;

            //System.out.println("l= "+l +", r= "+r+", m="+m + ", arr[m]="+ arr[m]+",x="+x);

           if(arr[m]>x){
               r = m;
           } else {
               l = m+1;
           }

           //System.out.println("---> l= "+l +", r= "+r+", m="+m);

        }

        if(arr[r] > x) {
            ceilOfX = arr[r];
        } else {
            ceilOfX = Integer.MIN_VALUE;
        }
        

        
        return ceilOfX;

    }

    public static void testCase1(int arr[]) {
        Random r = new Random();

        for(int i =0; i<arr.length; i++) {
           
                arr[i] = r.nextInt(arr.length)+1;
            
        }

        Arrays.sort(arr);  
    } 

     /**
     * Test cases and bench marking
     * 
     * @param args - arraySize (int), printArry (boolean), benchMar (boolean) 
     */
    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);               // read array size from command line
        int ceilX = Integer.parseInt(args[1]);              // read array size from command line
        boolean printArrary = Boolean.valueOf(args[2]);     // read boolean value from command line , this is to whether to print input array values
        boolean benchMark = Boolean.valueOf(args[3]);       // read benchmark boolean value from command line, this is to print benchmarking values
           
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
            //System.out.println("Start time : "+ startTime + " ms");
        }
                
        // Find duplicate number call
        int value = FindCeilOfAnArray1.find(inputArr, ceilX);

        if(benchMark) {
            long endTime = System.currentTimeMillis();
            //System.out.println("End time : "+ endTime +" ms");
                    
            System.out.println("Total execution time : "+ (endTime - startTime) + " ms");
        }

        if(Integer.MIN_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }               
    }

}