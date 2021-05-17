package com.github.srinivaschejerla.algorithms.adhoc;

public class MinMax3 {

    public static void main(String args[]) {
        System.out.println("######################//#endregion");

        int a[] = {23,1,4,13,56,32,8,64};
        int min = a[0];
        int max = a[1];

        // find min , max in 3 numbers set
        if(min > max) {
            min = max;
            max = a[0];
        }

        for(int i=3; i<a.length-1; i++) {
            var tmpMin = a[i]; // 4,3,5
            var tmpMax = a[i];

            if(a[i] > a[i+1]) {
                tmpMin = a[i+1];
            } 

            if(tmpMin > a[i+2]) {
                tmpMin = a[i+2];
            }

            if(a[i] < a[i+1]) {
                tmpMax = a[i+1];
            } 

            if(tmpMax < a[i+2]) {
                tmpMax = a[i+2];
            }

            if (tmpMin < min)  {
                min = tmpMin;
            }
            
            if(tmpMax < max) {
                max = tmpMin;
            }
        }

        System.out.println("min = "+ min);
        System.out.println("max = "+ max);
    }
}
