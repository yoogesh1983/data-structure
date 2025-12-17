package com.yoogesh.data.structure.backtracking.av;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 6. Permutation of strings by using simple recursion (not backtracking)
public class Example_1 {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        backtrack(s, result, "");
        System.out.println(result); // [abc, acb, bac, bca, cab, cba]
    }

    private static void backtrack(String s, List<String> result, String temp) {

        //base case
        if (s.isEmpty()) {
            result.add(temp);
            return;
        }
        Set<Character> set = new HashSet<>();

        //recursion
        for (int i = 0; i < s.length(); i++) {
            char extractedString = s.charAt(i);
            if (set.contains(extractedString)) {
                continue;
            }
            set.add(extractedString);

            String PassByValueForremainingString = s.substring(0, i) + s.substring(i + 1); // We must create a new String and cannot reference the same temp object here
            String passByValueForTemp = temp + extractedString;    // We must create a new String and cannot reference the same temp object here

            backtrack(PassByValueForremainingString, result, passByValueForTemp);
        }
    }
}