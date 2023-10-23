package org.example;

public class UsingRunnableAndLambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Printing from runnable as lambda expression")).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from runnable as anonymous class");
            }
        }).start();
    }
}
