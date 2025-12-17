package com.yoogesh.data.structure.backtracking.av;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 8. Permutation of strings using backtracking
public class Example_2 {
    public static void main(String[] args) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), result, 0);
        System.out.println(result); // [abc, acb, bac, bca, cab, cba]
    }

    private static void backtrack(char[] s, List<String> result, int start) {

        //base case
       if(start == s.length){
           StringBuilder sb = new StringBuilder();
           for(char next: s){
               sb.append(next);
           }
           result.add(sb.toString());
           return;
       }

        //recursion
        Set<Character> set = new HashSet<>();
        for(int i=start; i<s.length; i++){
            char j = s[i];
            if(!set.contains(j)){
                set.add(j);
                swap(s, start, i);
                backtrack(s, result, start+1);
                swap(s, i, start);
            }
        }

    }

    private static void swap(char[] temp, int a, int b){
        if(temp[a] != temp[b]){
            char t = temp[a];
            temp[a] = temp[b];
            temp[b] = t;
        }
    }
}