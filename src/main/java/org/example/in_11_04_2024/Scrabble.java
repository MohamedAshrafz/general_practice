package org.example.in_11_04_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scrabble {

    public static final ArrayList<Integer> values = new ArrayList<Integer>(List.of(1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10));


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1: ");
        String wordPlayer1 = sc.nextLine();
        System.out.println("Player 2: ");
        String wordPlayer2 = sc.nextLine();

        int scorePlayer1 = calculateWord(wordPlayer1);
        int scorePlayer2 = calculateWord(wordPlayer2);

        System.out.printf("Player 1 score is: [%d], player 2 score is [%d]\nThe winner is [%s]",
                scorePlayer1, scorePlayer2, scorePlayer1 > scorePlayer2 ? "Player 1" : scorePlayer1 < scorePlayer2 ? "Player 2" : "Tie!");
    }

    public static int calculateWord(String word) {

        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isAlphabetic(c)) {
                c = Character.toLowerCase(c);

                result += values.get(c - 'a');
            }
        }
        return result;
    }
}
