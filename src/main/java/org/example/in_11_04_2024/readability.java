package org.example.in_11_04_2024;

import java.util.Scanner;

public class readability {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str;
            if (sc.hasNextLine()) {
                str = sc.nextLine();
                System.out.println("Grade: " + ((int) calcReadability(str) > 16 ? "16" : (int) calcReadability(str) > 16 ? "1" : (int) calcReadability(str)));
            }
        }
    }

    public static float calcReadability(String paragraph) {
        int spacesNo = 0;
        int separatorsNo = 0;
        int lettersNo = 0;
        float L, S;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c == ' ')
                spacesNo++;
            else if (c == '!' || c == '?' || c == '.') {
                separatorsNo++;
            } else if (Character.isAlphabetic(c)) {
                lettersNo++;
            }
        }

        L = (float) lettersNo / (spacesNo + 1) * 100;
        S = (float) separatorsNo / (spacesNo + 1) * 100;

        return Math.round(0.0588f * L - 0.296f * S - 15.8f);
    }
}
