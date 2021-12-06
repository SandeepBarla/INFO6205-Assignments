package edu.neu.coe.info6205.sort;

import java.util.List;

public class MSDSort {

    private static final int R = 2560; // radix
    private static final int M = 15; // cutoff for small subarrays
    private static String[] auxiliaryArray; // auxiliary array for distribution

    private static int charAt(String str, int n) {
        return n<str.length() ? str.charAt(n) : -1;
    }

    public static void sort(List<String> list) {
        int N = list.size();
        auxiliaryArray = new String[N];
        sort(list, 0, N - 1, 0);
    }

    private static void sort(List<String> list, int low, int high, int n) { // Sort from list[low] to list[high], starting at the dth
        // character.
        if (high <= low + M) {
            InsertionSort.sort(list, low, high, n);
            return;
        }
        int[] count = new int[R + 2]; // Compute frequency counts.

        int i = low;
        while(i<=high){
            count[charAt(list.get(i), n) + 2]++;
            i++;
        }
        int r = 0;
        while(r<R+1){
            count[r + 1] += count[r];
            r++;
        }

        i=low;
        while(i<=high){
            auxiliaryArray[count[charAt(list.get(i), n) + 1]++] = list.get(i);
            i++;
        }// Distribute.
        i=low;
        while(i<=high){
            list.set(i, auxiliaryArray[i - low]);
            i++;
        }// Copy back.
        // Recursively sort for each character value.
        r = 0;
        while(r<R){
            sort(list, low + count[r], low + count[r + 1] - 1, n + 1);
            r++;
        }
    }
}
