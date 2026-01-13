package com.yoogesh.data.structure.backtracking.av;

public class Example_2 {
    public static void main(String[] args) {
        Character[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        StringBuilder result = new StringBuilder();

        //since my solution can start from anywhere in a matrix and not necessarily from 0, we need to do this here!!
        // and call a backtracking only if the first character i.e. charAt(0) matches
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char current = matrix[i][j];
                if (word.charAt(0) == current) {
                    backtrack(matrix, word, result, i, j, 1);
                }
            }
        }
        System.out.println(result.toString().equals("true")); // true
    }

    private static void backtrack(Character[][] matrix, String word, StringBuilder result, int row, int column, int start) {

        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length) {
            return;
        }

        //base condition
        if (start == word.length()) {
            result.append("true");
            return;
        }

        char currentCharacter = matrix[row][column];
        matrix[row][column] = '#';

        //backtracking
        if (row > 0 && matrix[row - 1][column] == word.charAt(start)) backtrack(matrix, word, result, row - 1, column, start + 1); // top
        if (row < matrix.length - 1 && matrix[row + 1][column] == word.charAt(start)) backtrack(matrix, word, result, row + 1, column, start + 1); // bottom,
        if (column > 0 && matrix[row][column - 1] == word.charAt(start)) backtrack(matrix, word, result, row, column - 1, start + 1); // left
        if (column < matrix[0].length-1 && matrix[row][column + 1] == word.charAt(start)) backtrack(matrix, word, result, row, column + 1, start + 1); // right

        matrix[row][column] = currentCharacter;
    }


}
