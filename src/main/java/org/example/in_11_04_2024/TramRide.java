package org.example.in_11_04_2024;

public class TramRide {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(solve(4, 1, 3, arr));

        int[] arr = {12, 6, 2, 6, 2};
        System.out.println(solve(5, 3, 4, arr));
    }

    static long solve(int N, int start, int finish, int[] Ticket_cost){
        start = start - 1;
        finish = finish - 1;
        // Write your code here
        long result = 0;
        long arrSum = 0;
        for(int element: Ticket_cost){
            arrSum += element;
        }
        int distance = Math.abs(finish - start);
        int i = start;
        if(distance > N / 2){
            while(i != finish){
                result += Ticket_cost[i];
                i = (i + 1) % N;
            }
        } else {
            while(i != finish){
                i = i - 1;
                if (i == -1){
                    i = N - 1;
                }
                result += Ticket_cost[i];
            }
        }

        if(result > arrSum / 2) {
            result = arrSum - result;
        }
        return result;
    }
}
