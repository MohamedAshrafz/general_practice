package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array_2D_DS {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(-9, -9, -9, 1, 1, 1)));
        arr.add(new ArrayList<>(List.of(0, -9, 0, 4, 3, 2)));
        arr.add(new ArrayList<>(List.of(-9, -9, -9, 1, 2, 3)));
        arr.add(new ArrayList<>(List.of(0, 0, 8, 6, 6, 0)));
        arr.add(new ArrayList<>(List.of(0, 0, 0, -2, 0, 0)));
        arr.add(new ArrayList<>(List.of(0, 0, 1, 2, 4, 0)));


//        arr.get(0).add(1);
        int x = hourglassSum(arr);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        List<Integer> sumsArr = new ArrayList<>();
        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.get(i).size() - 2; j++) {
                sumsArr.add(calcHourglassFor(i, j, arr));
            }
        }

        return Collections.max(sumsArr);
    }

    public static int calcHourglassFor(int iArg, int jArg, List<List<Integer>> arr) {
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum += arr.get(iArg).get(jArg + j);
            sum += arr.get(iArg + 2).get(jArg + j);
        }
        sum += arr.get(iArg + 1).get(jArg + 1);

        return sum;
    }
}
