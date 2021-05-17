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
     * http://mathforum.org/library/drmath/view/61212.html
     * n(n-1)/2 = (n^2 - n) / 2 = (n^2 - n) * c  = O(n^2)
     * Note:
     * - (n^2-n) is coming to n^2 at worst case
     * - and 'c' (1/2) here is a constant  i.e, BigO
     * TC = O(n^2)
     * SC = O(1) : This is because of variables used in the stack area of the running 
     * program to store execution data  
     * 
     * We used varialble like i, j in "for loops"
     * We call it constant space as we have countable variables, in this case only 2 variables used
     * 
     * What is the problem with this approach here? : TC is very high 
   * 
     *  Benchmarking for 5 runs -> FindDuplicateNumbers1' 100000 false true  - 1970ms
     * 
     * Windows 10, 16g RAM, Default JVM settings
     * 
     */     
    public static int find(int arr[]) {        
        for(int i=0; i<arr.length; i++) {           // loop through 0th arry  index till last but one element  
            for(int j=i+1; j<arr.length; j++) {     // loop through 1st array index to till last but one element 
                if(arr[i] == arr[j]) {              // compare arry values by using first loop index and second loop index              
                    return arr[i];                  // return arry value if match
                }
            }
        }

        return Integer.MAX_VALUE;                   // return integer MAX value if there is no match, this MAX return is only used as a constant to check in parent function
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
     * @param args - arraySize (int), printArry (boolean), benchMar (boolean) 
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
            //System.out.println("Start time : "+ startTime + " ms");
        }
                
        // Find duplicate number call
        int value = FindDuplicateNumbers1.find(inputArr);

        if(benchMark) {
            long endTime = System.currentTimeMillis();
            //System.out.println("End time : "+ endTime +" ms");
                    
            System.out.println("Total execution time : "+ (endTime - startTime) + " ms");
        }

        if(Integer.MAX_VALUE == value) {
            System.out.println("Not Found! "+ value);
        } else {
            System.out.println("Found! "+ value);
        }               
    }   
}