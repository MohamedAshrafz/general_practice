package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArrays {

    public static void main(String[] args) {
        System.out.println(matchingStrings(List.of("ab", "ab", "abc", "xzxb"), List.of("bc", "abc", "ab")));
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> queriesCounts = new ArrayList<>(Collections.nCopies(queries.size(), 0));


        Map<String, Integer> stringsMap = new HashMap<>();

        for (String str : queries) {
            stringsMap.put(str, 0);
        }

        for (String str : stringList) {
            Integer currentStrCount = stringsMap.get(str);
            if (currentStrCount != null){
                stringsMap.put(str, currentStrCount + 1);
            }
        }

        int i = 0;
        for (String str : queries) {
            queriesCounts.set(i, stringsMap.get(str));
            i++;
        }

        return  queriesCounts;
    }
}
