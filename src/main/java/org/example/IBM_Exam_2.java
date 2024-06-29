package org.example;

public class IBM_Exam_2 {

    public static void main(String[] args) {
        System.out.println(findMaxNum(2, 7, 3));
    }

    public static int findMaxNum(int x, int y, int z) {
        // Write your code here
        int diff = Math.abs(x - y);
        // the number of operations is NOT enough to reach y
        if (z < diff) {
            if (y > x) {
                return x + z;
            } else {
                return x;
            }
        }
        // the number of operations is enough to reach y
        if (y > x) {
            // getting how much excess do we have
            int more_than_enough = z - diff;
            return y + more_than_enough / 2;
        } else if (y < x) {
            // getting how much excess do we have
            int more_than_enough = z - diff;
            return x + more_than_enough / 2;
        } else {
            // x == y
            return x + z / 2;
        }
    }
}
