package org.example;

public class RegEx {
    public static void main(String[] args) {
        String s1 = "abcabcabcabb";

        System.out.println(s1.matches("(abc)*..."));
        System.out.println(s1.matches("(abc)*.*"));

        // start with[^] abc then any characters and[+] end[$] with bb
        System.out.println(s1.matches("(^(abc).*)+((bb)$)"));
        // like the previous or start with anything and end with bb
        System.out.println(s1.matches("(^(abc).*)+((bb)$)|(.*)+((bb)$)"));

        // a, b or c then any chars
        System.out.println(s1.matches("[abc].*"));

        // a, b or c then b or d which are (ab, ad, bb, bd, cb, cd)
        System.out.println(s1.matches(".*[abc][bd].*"));
        s1 = "abcabcabcbddabce";
        // abc then b, d or e
        System.out.println(s1.replaceAll("abc[bde]", "X"));

        // abc repeated any number of times more than 0
        System.out.println(s1.matches("(abc)+"));
        s1 = "abcabcabc";
        // abc repeated any number of times more than 0
        System.out.println(s1.matches("(abc){3}"));

        System.out.println(s1.matches("\t"));

    }
}
