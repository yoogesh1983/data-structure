package com.yoogesh.data.structure.backtracking.av;

import java.util.ArrayList;
import java.util.List;

// 11 N Digit numbers with digits in increasing order
public class Example_4 {

    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result, temp, 2, 1); // even if you ignore start. it will work. it is her just for efficiency!!
        System.out.println(result);
    }


    public static void backtrack(List<Integer> result, List<Integer> temp, int n, int start) {
        // If single digit, no need recursive
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return;
        }

        //base condition
        if (temp.size() == n) {
            StringBuilder j = new StringBuilder();
            for (Integer next : temp) {
                j.append(next);
            }
            result.add(Integer.parseInt(j.toString()));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if(temp.isEmpty() || temp.getLast() < i){
                temp.add(i);
                backtrack(result, temp, n, start+1);
                temp.removeLast();
            }
        }
    }
}