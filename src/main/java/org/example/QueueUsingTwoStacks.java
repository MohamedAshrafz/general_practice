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
        StringBuilder outStr = new StringBuilder();
        CustomQueue<Integer> customQueue = new CustomQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            if (type == TYPE_ENQUEUE) {
                customQueue.enqueue(sc.nextInt());
            } else if (type == TYPE_DEQUEUE) {
                customQueue.dequeue();
            } else {
                outStr.append(customQueue.peek()).append("\n");
            }
        }

        ps.print(outStr);

        ps.flush();
        ps.close();
        sc.close();
    }

    static class CustomQueue<T> {
        private static final boolean IS_ENQUEUED = true;
        private static final boolean IS_DEQUEUED = false;

        private final Stack<T> enqueueStack;
        private final Stack<T> dequeueStack;
        private Boolean enqueueDequeueFlag = IS_ENQUEUED;

        public CustomQueue() {
            enqueueStack = new Stack<T>();
            dequeueStack = new Stack<T>();
        }

        public void enqueue(T element) {
            if (enqueueDequeueFlag == IS_DEQUEUED) {
                int n = dequeueStack.size();
                for (int i = 0; i < n; i++) {
                    enqueueStack.push(dequeueStack.pop());
                }
                enqueueDequeueFlag = IS_ENQUEUED;
            }
            enqueueStack.push(element);
        }

        public T dequeue() {
            if (enqueueDequeueFlag == IS_ENQUEUED) {
                int n = enqueueStack.size();
                for (int i = 0; i < n; i++) {
                    dequeueStack.push(enqueueStack.pop());
                }
                enqueueDequeueFlag = IS_DEQUEUED;
            }
            return dequeueStack.pop();
        }

        public T peek() {
            if (enqueueDequeueFlag == IS_ENQUEUED) {
                int n = enqueueStack.size();
                for (int i = 0; i < n; i++) {
                    dequeueStack.push(enqueueStack.pop());
                }
                enqueueDequeueFlag = IS_DEQUEUED;
            }
            return dequeueStack.peek();
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
