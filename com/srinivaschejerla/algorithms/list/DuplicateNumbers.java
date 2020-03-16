package com.srinivaschejerla.algorithms.list;

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
        * - here 'c' is constant i.e, '1/2' 
        *    
        * TC = O(n^2)
        * 
        * SC = O(1) : This is because of variables used
        *  in the stack area of the running program at run time 
        *  to store execution data  
        * 
        *  We used varialble like i, j to for indexing in lopps, 
        *  we call it constant space as we have countable variables
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

    // Approach-2 : 
    public static void find1(int arr[]) {

    }

    public static void main(String args[]) {
        
        // construct random array 
        int inputArr[] = new int[100];
        Random r = new Random();

        for(int k=0; k<100; k++) {
            inputArr[k] = r.nextInt(10000);
        }

        System.out.println(Arrays.toString(inputArr));

        int value = DuplicateNumbers.find(inputArr);

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }
    }
}