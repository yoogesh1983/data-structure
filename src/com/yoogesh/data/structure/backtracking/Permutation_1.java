package com.yoogesh.data.structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation_1 {


    /* 46. Given an array nums of distinct integers, returns all possible permutations. you can return
           the answer in any order.
             Input: [1, 2, 3]
             Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]

             Note: Total number of permutations can be made is always n! i.e. 3! = 6

             time complexity:
                       t = O(n) [Temp variable. since we are popping and reusing. it takes just n space]
                             +
                           O(n!) [ Save a result. and the result is n!]
                         = O(n*n!)

             Space complexity:
                      s = O(n) [For temp]
                           +
                         O(n!) [For result]
                        = O(n*n!)
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(Arrays.stream(arr).boxed().collect(Collectors.toList()), result, new ArrayList<>());
        System.out.println(result);

    }

    private static void backtrack(List<Integer> nums, List<List<Integer>> result, List<Integer> temp) {
        if(temp.size() == nums.size()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if(temp.contains(nums.get(i))){
                continue;
            }
            temp.add(nums.get(i));
            backtrack(nums, result, temp);
            temp.removeLast();
        }
    }
}
