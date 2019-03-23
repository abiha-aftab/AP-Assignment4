/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

/**
 *
 * @author CIT
 */
public class Models {
    
    int[][] board = new int[3][3];
    public int movCount = 0;

    public void setChoice(int f, Value v) {
        int val = 0;
        if (v == Value.O) {
           val = 1;
        }
        else if (v == Value.X) {
            val = -1;
        } 
        board[f / 3][f % 3] = val;
        movCount++;
    }

    public boolean checkBoard() 
    {
        int DiagonalLR = 0;
        int DiagonalRL = 0;
        int sumColumns = 0;
        int sumRows = 0;

        for(int j=0,k=0;j<3&&k<3;j++,k++)
        {
           DiagonalLR = DiagonalLR+board[j][k];
        }
        
         for(int j=0,k=2;j<3&&k>=0;j++,k--)
        {
           DiagonalRL = DiagonalRL +board[j][k];
        }
        
        if (Math.abs(DiagonalLR) == 3 || Math.abs(DiagonalRL) == 3) {
            return true;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                sumRows = sumRows+ board[i][j];
            }
            if ( Math.abs(sumRows) == 3) {
                return true;
            }
            else {
                sumRows = 0;
            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                sumColumns = sumColumns+ board[j][i];
            }
            if (Math.abs(sumColumns) == 3) {
                return true;
            }
            else {
                sumColumns = 0;
            }
        }
        return false;
    }
}
