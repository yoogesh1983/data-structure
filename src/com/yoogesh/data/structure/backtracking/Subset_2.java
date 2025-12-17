package com.yoogesh.data.structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_2 {


    /* 90.Given an array nums that may contain duplicates, return all possible subsets (the power sets)
             The solution set must not contain duplicate subsets. Return the solution in any order.
             Input: [1, 2, 2]
             Output: [[], [1], [1,2], [1,2,2], [2], [2,2]]

             time complexity:
                       t = O(n) [for every time you are pushing temp into result]
                             +
                           O(2^n) [ we are calling backtracking function 2^n times]
                         = O(n*2^n)

             Space complexity:
                      s = O(n*2) [You are storing 2^n of subsets]
                           +
                         O(n) [length of each subset can go upto n]
                        = O(n*2^n)
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Arrays.sort(arr);    // to handle the scenario of {2,1,2}
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, result, new ArrayList<>(), 0);
        System.out.println(result);

    }

    private static void backtrack(int[] arr, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            backtrack(arr, result, temp, i + 1);
            temp.removeLast();

        }
    }
}
