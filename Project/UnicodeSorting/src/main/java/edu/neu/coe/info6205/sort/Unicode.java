package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Unicode {

    public void MSDSort(List<String> hindiWords) {
        try {
            List<String> list = new ArrayList<>();
            int i = 0;
            while(i<hindiWords.size()){
                byte[] arr = hindiWords.get(i).getBytes("UTF-8");
                list.add(new String(arr, "UTF-8"));
                i++;
            }
            MSDSort.sort(list);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void LSDSort(List<String> hindiWords) {
        try {
            List<String> list = new ArrayList<>();
            int i=0;
            while(i< hindiWords.size()){
                byte[] arr = hindiWords.get(i).getBytes("UTF-8");
                list.add(new String(arr, "UTF-8"));
                i++;
            }
            LSDStringSort.sort(list);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


    public static void main(String[] args) throws IOException {
        Unicode obj = new Unicode();
        List<String> words = FileUtil.hindiWordsList("hindiWordsEx.csv");
        Supplier<List<String>> supplyObj = () -> {
            Collections.shuffle(words);
            return words;
        };
        String[] wordsArray = words.toArray(new String[0]);

        Benchmark_Timer<List<String>> msdTimerObj = new Benchmark_Timer<>("Benchmark Test", null, (x) -> obj.MSDSort(words), null);
        double totalMSDTime = msdTimerObj.runFromSupplier(supplyObj, 10);
        System.out.println("Time Taken for MSD Radix Sort: " + totalMSDTime + "ms");

        Benchmark_Timer<List<String>> lsdTimerObj = new Benchmark_Timer<>("Benchmark Test", null, (x) -> obj.LSDSort(words), null);
        double totalLSDTime = lsdTimerObj.runFromSupplier(supplyObj, 10);
        System.out.println("Time Taken for LSD Radix Sort: " + totalLSDTime + "ms");


        Consumer<List<String>> dualPivotQuickSortConsumer = (x) -> DualPivotQuickSort.sort(wordsArray);
        calculateBenchMark(supplyObj, wordsArray, dualPivotQuickSortConsumer, "Time taken for Dual-pivot Quick Sort: ");
        TimSort timSort = new TimSort();
        Consumer<List<String>> timSortConsumer = (x) -> timSort.sort(wordsArray, 0, wordsArray.length);
        calculateBenchMark(supplyObj, wordsArray, timSortConsumer, "Time taken for Timsort: ");
    }

    private static void calculateBenchMark(Supplier<List<String>> supplyObject, String[] stringArray, Consumer listConsumer, String description) {
        Benchmark_Timer<List<String>> benchmarkTimer = new Benchmark_Timer<>("Benchmark Test", null, listConsumer, null);
        double sortTime = benchmarkTimer.runFromSupplier(supplyObject, 100);
//        show(stringArray, description);

        System.out.println("Array output with " + description);
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
        System.out.println(description + "Time Taken: " + sortTime + "ms");
    }
}
