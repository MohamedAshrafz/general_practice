package org.example;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private static final int TYPE_ENQUEUE = 1;
    private static final int TYPE_DEQUEUE = 2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        CustomQueue<Integer> customQueue = new CustomQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == TYPE_ENQUEUE) {
                customQueue.enqueue(sc.nextInt());
            } else if (type == TYPE_DEQUEUE) {
                customQueue.dequeue();
            } else {
                ps.println(customQueue.peek());
            }
        }

        ps.flush();
        ps.close();
        sc.close();
    }

    static class CustomQueue<T> {

        private final Stack<T> enqueueStack;
        private final Stack<T> dequeueStack;

        public CustomQueue() {
            enqueueStack = new Stack<T>();
            dequeueStack = new Stack<T>();
        }

        public void enqueue(T element) {
            enqueueStack.push(element);
        }

        public T dequeue() {
            if (dequeueStack.isEmpty()) {
                moveToDequeueStack();
            }
            return dequeueStack.pop();
        }

        public T peek() {
            if (dequeueStack.isEmpty()) {
                moveToDequeueStack();
            }
            return dequeueStack.peek();
        }

        private void moveToDequeueStack() {
            int n = enqueueStack.size();
            for (int i = 0; i < n; i++) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

    }


}

//10      q = 10 (number of queries)
//1 42    1st query, enqueue 42
//2       dequeue front element
//1 14    enqueue 42
//3       print the front element
//1 28    enqueue 28
//3       print the front element
//1 60    enqueue 60
//1 78    enqueue 78
//2       dequeue front element
//2       dequeue front element
