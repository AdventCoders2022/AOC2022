package com.practice.day4;

public class VerifyBoard {

	public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] C = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[j][i] = A[i][j];
        return C;
    }
	
	public boolean rowColEquals(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int x = array[0];
            if (x != array[i])
                return false;
        }
        return true;
    }
	
	public boolean isWinnerFound(int[][] array) {
		// Added the new comment line to check
		String st = "TestCheckString";

		System.out.println("Print STring" + st);
		boolean rowsHaveSameValue = false, colssHaveSameValue = false;
        for (int i = 0; i < array.length; i++) {
            if (rowColEquals(array[i])) {
            	rowsHaveSameValue = true;
            }
        }
        array = transpose(array);
        for (int i = 0; i < array.length; i++) {
            if (rowColEquals(array[i])) {
            	colssHaveSameValue = true;
            }
        }
        
        return (rowsHaveSameValue || colssHaveSameValue);
    }
}
