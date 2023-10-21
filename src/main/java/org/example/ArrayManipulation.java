package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayManipulation {

    public static void main(String[] args) {
        arrayManipulation(5,
                List.of(List.of(1, 2, 100),
                        List.of(2, 5, 100),
                        List.of(3, 4, 100)));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        List<Long> arr = new ArrayList<>(Collections.nCopies(n + 1, 0L));


        for (List<Integer> query : queries) {
            arr.set(query.get(0), arr.get(query.get(0)) + Long.valueOf(query.get(2)));
            if (query.get(1) + 1 < arr.size()) {
                arr.set(query.get(1) + 1, arr.get(query.get(1) + 1) - Long.valueOf(query.get(2)));
            }
        }

        long x = 0L, max = Long.MIN_VALUE;

        for (Long element : arr) {
            x += element;
            if (x > max) {
                max = x;
            }
        }

        return max;
    }
}
