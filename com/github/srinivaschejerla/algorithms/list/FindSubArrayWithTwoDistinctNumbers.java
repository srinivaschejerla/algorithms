package com.github.srinivaschejerla.algorithms.list;

import java.util.Arrays;
import java.util.Random;

import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;

/**
 *  -------------  IN PROGRESS ----------------------
 * 
 * - Find sub array with only 2 distinct numbers from given input array
 * - The difference of two distinct numbers should be 1
 * 
 * Run - FindSubArrayWithTwoDistinctNumbers 5
 */
 public class FindSubArrayWithTwoDistinctNumbers {

    public static int find(int[] in) {

        int sidx =-1, eidx = -1, sv=0,ev=0, maxStartIdx=-1, maxEndIdx=-1, maxlen=0;
        int uniqueNum1 = -1, uniqueNum2 = -1;
        
        
        for(int i=0; i<in.length-1;i++) {  // [1,1,1,3,3,2,2]

            if(in[i] < in[i+1]) {
                sv = in[i]; ev = in[i+1];
            } else {
                sv = in[i+1]; ev = in[i];
            }

            System.out.println("sv="+sv + ", ev="+ev);

            if((ev-sv) <= 1) {
                if(sidx == -1) {
                    sidx = i; uniqueNum1 = -1; uniqueNum2 = -1;
                }

                eidx = i+1;

                if((ev-sv) == 1) {
                    if( uniqueNum1 == -1 ) {
                        uniqueNum1 = sv;
                        uniqueNum2 = ev;
                     } else {
                        if(!((sv == uniqueNum1 || sv == uniqueNum2) 
                            && (ev == uniqueNum1 || ev == uniqueNum2))) {
                                break;
                            }
                    }
                }
                
            } else {
                sidx = -1; eidx = -1;                
            }

            int len = eidx - sidx;
            if(len >= maxlen) {
                maxlen = len;

                maxStartIdx = sidx; 
                maxEndIdx = eidx;                
            }

            System.out.println("sidx="+sidx + ", eidx="+eidx);

            System.out.println("maxlen = "+ maxlen);
        }

        System.out.print("Max unique sub array = [");
        for(; maxStartIdx<=maxEndIdx;maxStartIdx++) {
            System.out.print(in[maxStartIdx]);
            if(maxStartIdx < maxEndIdx) System.out.print(",");
        }

        System.out.print("]");
        System.out.println();

        //if(unique == false) maxlen = 0;

        return maxlen+1;
    }
    public static void main(String args[]) {

        // read size of the array
        int size = Integer.parseInt(args[0]);

        // read array values or create test case
        int[] in = new int[size]; // = {1,1,1,3,3,2,2};
        Random r = new Random();
        for(int i=0; i< in.length; i++) {
            in[i] = r.nextInt(5);
        }

        System.out.println(Arrays.toString(in));

        long startTime = System.currentTimeMillis();
        // call the find method 
        int length = FindSubArrayWithTwoDistinctNumbers.find(in);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime-startTime;

        // time analysis
        System.out.println("Total execution time = "+ totalTime +" ms");   
        
        System.out.println("Max Length = "+ length);
    }
}