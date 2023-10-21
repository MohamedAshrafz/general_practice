package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayDS {
    public static void main(String[] args) {
        List<Integer> ogArr = List.of(1, 2, 3, 4, 5);
        System.out.println(reverseArray(ogArr));
    }

    public static List<Integer> reverseArray2(List<Integer> a) {
        List<Integer> reversedArr = new ArrayList<>(Collections.nCopies(a.size(), -1));
        for (int i = 0; i < a.size(); i++) {
            reversedArr.set(a.size() - i - 1, a.get(i));
        }
        return reversedArr;
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> reversedArr = new ArrayList<>(a);
        for (int i = 0; i < a.size() / 2; i++) {
            int temp = reversedArr.get(reversedArr.size() - i - 1);
            reversedArr.set(reversedArr.size() - i - 1, reversedArr.get(i));
            reversedArr.set(i, temp);
        }
        return reversedArr;
    }
}
