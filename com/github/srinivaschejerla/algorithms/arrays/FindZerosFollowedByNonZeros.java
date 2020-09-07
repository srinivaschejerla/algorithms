package com.github.srinivaschejerla.algorithms.arrays;

import java.util.Arrays;
import java.util.Random;

public class FindZerosFollowedByNonZeros {

    FindZerosFollowedByNonZeros(){}

    int find(int[] arr) {

        int count = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0 || i == arr.length-1){
                count = i+1;
                break;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int size = Integer.parseInt(args[0]);

        FindZerosFollowedByNonZeros fzfbn = new FindZerosFollowedByNonZeros();
        int[] arr = new int[size];
        Random r = new Random();

        for(int i =0; i<size; i++) {
           arr[i] = r.nextInt(2);
        }

        System.out.println(Arrays.toString(arr));
        
        int count = fzfbn.find(arr);
        
        System.out.println(count);

    }
    
}