package com.yoogesh.data.structure.backtracking.av;

import java.util.ArrayList;
import java.util.List;

// 9. Largest Number in K-Swap
public class Example_3 {
    public static void main(String[] args) {
        String s = "2177";
        int k = 2;
        List<Long> result = new ArrayList<>();
        result.add(Long.parseLong(s));
        backtrack(s.toCharArray(), k, result, 0);
        System.out.println(result.stream().max((first, second) -> first.compareTo(second)).get()); // btw here you can find a max
    }

    private static void backtrack(char[] s, int k, List<Long> result, int start) {

        //base condition
        if(start == s.length || k == 0){
            StringBuilder sb = new StringBuilder();
            for(char next: s){
                sb.append(next);
            }
            result.add(Long.parseLong(sb.toString()));
            return;
        }

        // findout the max value
        int maxValue = s[start];
        for(int i=start+1; i<s.length; i++){
            int j = s[i];
            if(j > maxValue){
                maxValue = j;
            }
        }

        //if the start itself is max, then just move ahead
        /*if(s[start] == maxValue){
            start++;
        }*/

        //backtracking
        for(int i=start+1; i<s.length; i++){
            int j = s[i];
            if(s[start] < j && j == maxValue){
                swap(s, start, i);
                backtrack(s, k-1, result, start +1);
                swap(s, i, start);
            }
        }

        // handling scenario if start itself is max and doesn't enter inside if condition above inside for loop
        // Horizontal drifting
        backtrack(s, k, result, start+1);
    }


    private static void swap(char[] temp, int a, int b){
        char t = temp[a];
        temp[a] = temp[b];
        temp[b] = t;
    }
}