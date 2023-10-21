package org.example;

import java.io.PrintStream;
import java.util.Scanner;

public class SimpleTextEditor {

    private static final int TYPE_APPEND = 1;
    private static final int TYPE_DELETE = 2;
    private static final int TYPE_PRINT = 3;
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == TYPE_APPEND) {
                str.append(sc.nextLine());
            } else if (type == TYPE_DELETE) {
                int numberOfDeletedChars = sc.nextInt();
                str.delete(str.length() - numberOfDeletedChars - 1, str.length() - 1);
            } else if (type == TYPE_PRINT){
                ps.print(str.charAt(sc.nextInt()));
            } else {

            }
        }

        ps.flush();
        ps.close();
        sc.close();
    }
}
