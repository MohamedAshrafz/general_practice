package org.example;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    private static final int TYPE_APPEND = 1;
    private static final int TYPE_DELETE = 2;
    private static final int TYPE_PRINT = 3;

    static StringBuilder strBuilder = new StringBuilder();
    static Stack<Integer> operations = new Stack<>();
    static Stack<String> addedDeletedStr = new Stack<>();
    static Scanner sc = new Scanner(System.in);
    static PrintStream ps = new PrintStream(System.out);

    public static void main(String[] args) {

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == TYPE_APPEND) {
                String appendedStr = sc.next().replace(" ", "");
                append(appendedStr, true);
            } else if (type == TYPE_DELETE) {
                int numberOfDeletedChars = sc.nextInt();
                delete(numberOfDeletedChars, true);
            } else if (type == TYPE_PRINT) {
                ps.append(String.valueOf(strBuilder.charAt(sc.nextInt() - 1))).append("\n");
            } else {
                int operation = operations.pop();
                String str = addedDeletedStr.pop();

                if (operation == TYPE_APPEND) {
                    delete(str.length(), false);
                } else {
                    append(str, false);
                }
            }
        }

        ps.flush();
        ps.close();
        sc.close();
    }

    public static void append(String appendedStr, boolean remember) {
        strBuilder.append(appendedStr);

        if (remember) {
            operations.push(TYPE_APPEND);
            addedDeletedStr.push(appendedStr);
        }
    }

    public static void delete(int numberOfDeletedChars, boolean remember) {
        String deletedStr =
                strBuilder.substring(strBuilder.length() - numberOfDeletedChars, strBuilder.length());
        strBuilder.delete(strBuilder.length() - numberOfDeletedChars, strBuilder.length());

        if (remember) {
            operations.push(TYPE_DELETE);
            addedDeletedStr.push(deletedStr);
        }
    }

}

//0       abcde   1 fg        append fg
//1       abcdefg 3 6         print the 6th letter - f
//2       abcdefg 2 5         delete the last 5 letters
//3       ab      4           undo the last operation, index 2
//4       abcdefg 3 7         print the 7th characgter - g
//5       abcdefg 4           undo the last operation, index 0
//6       abcde   3 4         print the 4th character - d


//8       Q = 8
//1 abc   ops[0] = '1 abc'
//3 3     ops[1] = '3 3'
//2 3     ...
//1 xy
//3 2
//4
//4
//3 1
