package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeftRotation {

    public static void main(String[] args) {
        System.out.println(rotateLeft(2, List.of(1,2,3,4,5)));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        Deque<Integer> baseQueue = new LinkedList<>(arr);

        for (int i = 0; i < d; i++) {
            baseQueue.addLast(baseQueue.removeFirst());
        }

        return new ArrayList<>(baseQueue);
    }
}
