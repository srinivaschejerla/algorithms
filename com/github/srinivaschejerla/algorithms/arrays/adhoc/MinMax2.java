package com.github.srinivaschejerla.algorithms.adhoc;

public class MinMax2 {

    public static void main(String args[]) {
        System.out.println("######################//#endregion");

        int a[] = {23,1,4,13,56,32,8,64};
        int min = a[0];
        int max = a[1];

        if(a[0]>a[1]) {
            max = a[0];
            min = a[1];
        }

        for(int i=2; i<a.length-1; i++) {
            var tmpMin = a[i];

            if(tmpMin > a[i+1]) {
                tmpMin = a[i+1];
            }

            if (tmpMin < min)  {
                min = tmpMin;
            }
            
            if(max < a[i+1]) {
                max = a[i+1];
            }
        }

        System.out.println("min = "+ min);
        System.out.println("max = "+ max);
    }
}
