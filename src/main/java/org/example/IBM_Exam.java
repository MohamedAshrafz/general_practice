package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IBM_Exam {
    public static void main(String[] args) {
        System.out.println(getLatestKRequests(List.of("item1"), 1));

    }

    public static List<String> getLatestKRequests(List<String> requests, int K) {
        // Write your code here
        List<String> soln_requests = new ArrayList<String>();
        TreeSet<String> exists_before = new TreeSet<>();
        int counter = 0;
        for(int i = requests.size() - 1; i >= 0; i--){
            String element = requests.get(i);
            if(!exists_before.contains(element)){
                exists_before.add(element);
                soln_requests.add(element);
                counter++;
                if (counter == K){
                    break;
                }
            }
        }
        return soln_requests;
    }
}
