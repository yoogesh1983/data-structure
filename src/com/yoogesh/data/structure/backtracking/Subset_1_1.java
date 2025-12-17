package com.yoogesh.data.structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subset_1_1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(Arrays.stream(arr).boxed().collect(Collectors.toList()), result, new ArrayList<>());
        System.out.println(result);

    }

    private static  void backtrack(List<Integer> arr, List<List<Integer>> result, List<Integer> temp){

        result.add(new ArrayList<>(temp));

        for(int i=0; i< arr.size(); i++){

            temp.add(arr.get(i));

            List<Integer> ls = new ArrayList<>();
            for(int j=0; j<arr.size(); j++){
                if(i==j) continue;
                ls.add(arr.get(j));
            }

            backtrack(ls, result, temp);
            temp.removeLast();
        }
    }
}
