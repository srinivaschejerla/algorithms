package com.srinivaschejerla.algos.basic.list;

import java.util.Arrays;
import java.util.Random;

/**
 * Array problems 
 * 
 * Array implements list based Data Structure with index access
 * Array in Java can store primitive data or object data
 * 
 */

public class DuplicateNumbers {

    
    /** 
        * Approach-1 : Primitive thinking 
        * 
        * Pick each element in a given input arrary 
        * and scan through all remaining elements in that array until
        * end of the array.
        * (n-1) + (n-2) + (n-3) ------ 1
        * n(n-1)/2 = (n^2 - n) / 2 = (n^2 - n) * c  = O(n^2)
        * Note:
        * - (n^2-n) is coming to n^2 at worst case
        * - and 'c' = 1/2 is constant - BigO
        *    
        * TC = O(n^2)
        * 
        * SC = O(1) : This is because of variables used in the stack area of the running 
        * program to store execution data  
        * 
        *  We used varialble like i, j in for lopps
        *  We call it constant space as we have countable variables
        * 
    */        
    public static int find1(int arr[]) {        
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
     * Approach-2 : Adhoc thinking
     * May be Sorting the given input array first will help?
     * 
     * TC = (sort + scan)*c = nlogn + (n-1) * c = nlogn * c = O(nlogn)
     *  -    complexity for sorting is nlogn
     * 
     * SC = O(1) - because i is one contant used in scan
     * 
     * */     
    public static int find2(int arr[]) {

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
     * Approach-3 : Adhoc thinking
     * May be Sorting the given input array first will help?
     * 
     * TC = soft + scan = nlogn + (n-1) = nlogn = O(nlogn)
     * 
     * complexity for sorting is logn
     * 
     * */     
    public static int find3(int arr[]) {

        Arrays.sort(arr);
        
        // System.out.println(Arrays.toString(arr));

        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i] == arr[i+1]) {
                return arr[i];
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String args[]) {        
        int size = Integer.parseInt(args[0]);

        // construct random array 
        int inputArr[] = new int[size];
        Random r = new Random();

        for(int k=0; k<inputArr.length; k++) {
            inputArr[k] = r.nextInt(100000);
        }

        //System.out.println(Arrays.toString(inputArr));

        // Benchmark code
        long startTime = System.currentTimeMillis();        
        System.out.println("Start time : "+startTime);
        
        // Approach -1 
        // int value = DuplicateNumbers.find1(inputArr);

        // Approach -2
        // int value = DuplicateNumbers.find2(inputArr);

        // Approach -3
        int value = DuplicateNumbers.find3(inputArr);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime);

        long totalTime = endTime - startTime;
        System.out.println("Total execution time : "+ totalTime);

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }
    }
}