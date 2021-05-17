package com.github.srinivaschejerla.algorithms.adhoc;

public class MinMax1 {

    public static void main(String args[]) { 

        int a[] = {2 , 4, 1, 5, 7, 3};

        // input  - 2 , 4, 1, 5, 7, 3

        // first 2 numbers we know what is min what is max 

        // 2 min, 4 max  -  1 comparision 

        //  leaving first 2 digits,  each other digit is compared with first 2 to find 
        //  current is min or max   -   2 comparisions for each digit 

        //  1 +  (n-2) * 2  =   1 + (2n - 4) = 3n - 3  

        int min = a[0];
        int max = a[1];

        if(a[0]>a[1]) {
            max = a[0];
            min = a[1];
        }

        for ( int i=2; i<a.length-1; i++ ) {
            if(a[i] < min) {
                min = a[i];
            } else if(a[i] > max){
                max = a[i];
            }
        }

        System.out.println("min = "+ min);
        System.out.println("max = "+ max);
    }

}