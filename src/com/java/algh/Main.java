package com.java.algh;

import com.sun.scenario.effect.Merge;

import java.util.SortedMap;

public class Main {
    //Merge two subarrays of arr[]
    //First subarray is arr[1..m]
    //Second subarray is arr[m+1..r]
   public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        //Find sizes of tow subarrays to be merged
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        //Copy data to temp arrays
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        //Merge the temp arrays
        //Initial indexes of first and second subarrays
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    //Merge function that sorts arr[l..r] using merge()
    public static void merge (int [] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j <right){
            if(l[i] <= r[j]){
                a[k++] = l[i++];
            }
            else{
                a[k++] = r[j++];
            }
        }
        while (i < left){
            a[k++] = l[i++];
        }
        while (j < right){
            a[k++] = r[j++];
        }
    }

//    //A utility function to print array of size n
//    static void printArray(int arr[]) {
//        int n = arr.length;
//        for (int i = 0; i < n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }

    public static void main(String[] args) {
        int [] a = {12, 11, 13, 5, 6, 7};
        mergeSort(a, a.length);
        for(int i=0; i< a.length; i++)
            System.out.println(a[i]);

    }

}

