package org.example.in_11_04_2024;

import java.util.ArrayList;
import java.util.Scanner;

public class TramRide2 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        while (sc.hasNextInt()) {
//            list.add(sc.nextInt());
//        }
//        System.out.println(solve(100000, 55435, 77030, list.toArray()));


        int[] arr = {1, 2, 3, 4};
        System.out.println(solve(4, 1, 3, arr));

//        int[] arr = {12, 6, 2, 6, 2};
//        System.out.println(solve(5, 4, 3, arr));

//        int[] arr = {1, 2, 3, 4};
//        System.out.println(solve(4, 1, 3, arr));
    }

//    static long solve(int N, int start, int finish, Object[] Ticket_cost) {
//        int startAsIndex = start - 1;
//        int finishAsIndex = finish - 1;
//        int distance = finishAsIndex - startAsIndex < 0 ? N - Math.abs(finishAsIndex - startAsIndex) : finishAsIndex - startAsIndex;
//        long sumOfAll = 0;
//        for (Object val : Ticket_cost) {
//            sumOfAll += (Integer) val;
//        }
//
//        boolean direction = distance <= N / 2;
//
//        long sumOfFirstDirection = 0;
//        if (direction) {
//            for (int i = 0; i < distance; i++) {
//                sumOfFirstDirection += (Integer) Ticket_cost[(startAsIndex + i) % N];
//            }
//        } else {
//            distance = N - distance;
//            for (int i = 0; i < distance; i++) {
//                sumOfFirstDirection += (Integer) Ticket_cost[(finishAsIndex + i) % N];
//            }
//        }
//
//        return sumOfFirstDirection < sumOfAll / 2 ? sumOfFirstDirection : sumOfAll - sumOfFirstDirection;
//    }

    static long solve(int N, int start, int finish, int[] Ticket_cost) {
        int startAsIndex = start - 1;
        int finishAsIndex = finish - 1;
        int distance = finishAsIndex - startAsIndex < 0 ? N - Math.abs(finishAsIndex - startAsIndex) : finishAsIndex - startAsIndex;
        long sumOfAll = 0;
        for (int val : Ticket_cost) {
            sumOfAll += val;
        }

        boolean direction = distance <= N / 2;

        long sumOfFirstDirection = 0;
        if (direction) {
            for (int i = 0; i < distance; i++) {
                sumOfFirstDirection += Ticket_cost[(startAsIndex + i) % N];
            }
        } else {
            distance = N - distance;
            for (int i = 0; i < distance; i++) {
                sumOfFirstDirection += Ticket_cost[(finishAsIndex + i) % N];
            }
        }
        return sumOfFirstDirection < sumOfAll / 2 ? sumOfFirstDirection : sumOfAll - sumOfFirstDirection;
    }
}
