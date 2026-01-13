package com.yoogesh.data.structure.backtracking.av;


import java.util.ArrayList;
import java.util.List;

public class Example_5 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 0, 0, 0},
                          {1, 1, 0, 1},
                          {0, 1, 0, 0},
                          {1, 1, 1, 1}
        };
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        if (matrix[0][0] == 1) {
            backtrack(matrix, Choice.getChoices(), result, temp, 0, 0);
            System.out.println(result); // [DRDDRR]
        } else {
            System.out.println("Rat gets trapped. No where he could go!!");
        }
    }

    private static void backtrack(int[][] matrix, List<Choice> choices, List<String> result, StringBuilder temp, int row, int column) {
        int maxRowLength = matrix.length;
        int maxColumnLength = matrix[0].length;

        if(row < 0 || column < 0 || row >= maxRowLength || column >= maxColumnLength || matrix[row][column] == 0){
            return;
        }

        if (row == maxRowLength - 1 && column == maxColumnLength - 1) {
            result.add(temp.toString());
            return;
        }

        for (Choice choice : choices) {
            int newRow = row + choice.getRow();
            int newColumn = column + choice.getColumn();
            char direction = choice.getDirection();

            if (newRow >= 0 && newRow < maxRowLength && newColumn >= 0  && newColumn < maxColumnLength && matrix[newRow][newColumn] == 1) {
                int currentCell = matrix[row][column];
                matrix[row][column] = 0; // mark the current cell as visited maze
                temp.append(direction);
                backtrack(matrix, choices, result, temp, newRow, newColumn);
                matrix[row][column] = currentCell;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }



}