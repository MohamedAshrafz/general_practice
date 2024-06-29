package org.example;

import java.util.regex.Pattern;

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

    private String getValidPhoneNumber(String str) {
        String strippedString = str.replace(" ", "");

        if (strippedString.matches("((^\\+9665)|(^9665)|(^009665)|(^5)|(^05))(\\d){8}")) {
            return strippedString.replaceFirst("((^\\+9665)|(^9665)|(^009665)|(^5)|(^05))", "+9665");
        } else if (strippedString.matches("((^\\+201)|(^201)|(^00201)|(^01))(\\d){9}")) {
            return strippedString.replaceFirst("(^\\+201)|(^201)|(^00201)|(^01)", "+201");
        }
        return null;
    }

    private static String modifyQueryPagination(String query, int start, int limit) {

        String returnedQ = query.replaceAll(Pattern.compile("LIMIT\\s*", Pattern.CASE_INSENSITIVE).pattern(), "LIMIT " + limit);
        returnedQ = returnedQ.replaceAll(Pattern.compile("OFFSET\\s*", Pattern.CASE_INSENSITIVE).pattern(), "OFFSET " + limit);

        return returnedQ;
    }
}
