package com.github.srinivaschejerla.algorithms.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


/**
 * 
 * Find element X in square matrix
 * 
 * 
 * 1) Each row is sorted
 * 2) First element of each row is grater than the last element of the previous row
 * 
 * Ex:  1,2,3
 *      4,5,6
 *      7,8,9
 * 
 * find 6
 * 
 *  
 * Approach  : Divide & Pruning
 * 
 * 
 * TC - O(nlogn)
 * SC - O(1)
 * 
 * I/O :
 * java com.github.srinivaschejerla.algorithms.arrays.FindCeilOfAnArray 10000000 765 false true  
 * Total execution time : 17 ms
 * Found! 766
 * 
 */

public final class Search2DMatrix2 {

    static int find(int[][] arr, int x){
        int value = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            System.out.println("row :"+ i);
            value = findX(arr[i], x);
            if(value == x) break;
        }

        return value;

    }

    private static int findX(int[] arr, int x) {

        int mid = 0;

        int value = Integer.MIN_VALUE;
        int l=0, r=arr.length-1;
        
        for(int i=0; i<arr.length; i++) {

            mid = (l+r)/2;

            if(arr[mid] == x)  {
                return arr[mid];  
            } else if(arr[mid] > x) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return value;
    }

    public static void testCase1(int arr[][]) {
        Random r = new Random();
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                arr[i][j] = r.nextInt(arr.length+10);                
            }
        }
        
        Arrays.sort(arr, Comparator.comparingDouble(a -> a[0]));
    } 

     /**
     * Test cases and bench marking
     * 
     * @param args - arraySize (int), printArry (boolean), benchMar (boolean) 
     */
    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);               // read array size from command line
        int x = Integer.parseInt(args[1]);                  // find x
        boolean printArrary = Boolean.valueOf(args[2]);     // read boolean value from command line , this is to whether to print input array values
        boolean benchMark = Boolean.valueOf(args[3]);       // read benchmark boolean value from command line, this is to print benchmarking values
           
        // construct random array 
        int inputArr[][] = new int[size][size];
        /*Random r = new Random();

        for(int k=0; k<inputArr.length; k++) {
            inputArr[k] = r.nextInt(2*size);
        }*/

        testCase1(inputArr);

        // print array
        if(printArrary) {
            for(int[] arr : inputArr) {
                System.out.println(Arrays.toString(arr));
            }
        }
            

        // Benchmark code
        long startTime = 0;
        if(benchMark) {
            startTime = System.currentTimeMillis();        
            //System.out.println("Start time : "+ startTime + " ms");
        }
                
        // Find duplicate number call
        int value = Search2DMatrix1.find(inputArr, x);

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