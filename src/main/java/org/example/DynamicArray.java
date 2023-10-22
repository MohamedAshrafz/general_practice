package org.example;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    public static void main(String[] args) {
        dynamicArray(2, List.of(List.of(1, 0, 5),
                List.of(1, 1, 7),
                List.of(1, 0, 3),
                List.of(2, 1, 0),
                List.of(2, 1, 1)));
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        int lastAnswer = 0;
        int calculatedIndex;
        int type;
        int y;

        for (List<Integer> query : queries) {
            type = query.get(0);
            y = query.get(2);
            calculatedIndex = ((query.get(1) ^ lastAnswer) % n);

            switch (type) {
                case 1: {
                    arr.get(calculatedIndex).add(y);
                    break;
                }
                case 2: {
                    lastAnswer = arr.get(calculatedIndex).get(y % arr.get(calculatedIndex).size());
                    answers.add(lastAnswer);
                    break;
                }
            }
        }
        return answers;
    }
}
