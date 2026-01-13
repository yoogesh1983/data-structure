package com.yoogesh.data.structure.backtracking.av;

import java.util.ArrayList;
import java.util.List;

public class Choice {
    private char direction;
    private int row;
    private int column;

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Choice(char direction, int row, int column){
        this.direction= direction;
        this.row =row;
        this.column = column;
    }

    public static List<Choice> getChoices(){
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice('L', 0, -1));   // (row, column-n)
        choices.add(new Choice('R', 0, 1));   // (row, column+1)
        choices.add(new Choice('U', -1, 0));  // (row-1, column)
        choices.add(new Choice('D', 1, 0));   // (row+1, column)
        return choices;
    }


}