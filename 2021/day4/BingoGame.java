package com.practice.day4;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BingoGame {

	private static final int ROWS = 5;
	private static final int COLS = 5;
//	static int[] nums = { 94,21,58,16,4,1,44,6,17,48,20,92,55,36,40,63,62,2,47,7,46,72,85,24,66,49,34,56,98,41,84,23,86,64,28,90,39,97,73,81,12,69,35,26,75,8,32,77,52,50,5,96,14,31,70,60,29,71,9,68,19,65,99,57,54,61,33,91,27,78,43,95,42,3,88,51,53,30,89,87,93,74,18,15,80,38,82,79,0,22,13,67,59,11,83,76,10,37,25,45};
	static int[] nums = {7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1};
	public static void main(String[] args) {
		System.out.println("Hello World");

		int inputCount = getInputCount(nums);
		System.out.println("Total Count ="+ inputCount);
		
		Set<Integer> set = new HashSet<>();
		while(set.size() < 25){
				int random = nums[new Random().nextInt(nums.length)];
				set.add(random);
		}
		Set<Integer> randomSet1 = getRandomSet(nums);
		int[][] board1 = constructBoard(randomSet1);
		Set<Integer> randomSet2 = getRandomSet(nums);
		int[][] board2 = constructBoard(randomSet2);
		Set<Integer> randomSet3 = getRandomSet(nums);
		int[][] board3 = constructBoard(randomSet3);

		System.out.println("******* BOARD 1 *******");
		printBoard(board1);
		System.out.println("******* BOARD 2 *******");
		printBoard(board2);
		System.out.println("******* BOARD 3 *******");
		printBoard(board3);

		System.out.println("******* AFTER MARKING FIRST SET*******");
		
		int[] draw1 = { 7, 4, 9, 5,11, 8};
		board1 = checkForWinner(board1, draw1 );
		board2 = checkForWinner(board2, draw1 );
		board3 = checkForWinner(board3, draw1 );
		
		System.out.println();
		System.out.println("******* AFTER MARKING SECOND SET*******");
		int[] draw2 = { 17, 23, 2, 0, 14, 21};
		board1 = checkForWinner(board1, draw2 );
		board2 = checkForWinner(board2, draw2 );
		board3 = checkForWinner(board3, draw2 );
		
		System.out.println();
		System.out.println("******* AFTER MARKING THIRD SET*******");
		int[] draw3 = { 3};
		checkForWinner(board1, draw3 );
		checkForWinner(board2, draw3 );
		checkForWinner(board3, draw3 );

	}
	
	public static int[][] checkForWinner(int[][] board,  int[] draw) {
		boolean verifyWinner = false;
			board = markMatchedData(board, draw );
			verifyWinner = verifyWinner(board);
		
		return board;
	}
	public static int getInputCount(int[] nums) {
		 int count = 0;
	        for (int i : nums) {
	            count++;
	        }
	        System.out.println("Count is: " + count);
		return count;
		
	}
	
	public static Set<Integer> getRandomSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		while(set.size() < 25){
			int random = nums[new Random().nextInt(nums.length)];
			set.add(random);
		}
		return set;
	}
	
	public static int[][] constructBoard(Set<Integer> set) {
		int[][] result = new int[ROWS][COLS];
		int i=0, j=0;
		System.out.println(set.size());
		for (int n : set) {
			if (j == COLS) {
				i++;
				j = 0;
			}
			result[i][j] = n;
			System.out.println(" "+i + "," + j + " " + n);
			j++;
		}
		return result;
	}
	
	public static void printBoard(int[][] board) {
		System.out.println("Marked Board.......");
		for (int row=0; row<ROWS; row++) {
			for (int col=0; col<COLS; col++) {
				System.out.print(" " + board[row][col]);
			}
			System.out.println();
		}
	}
	
	public static int[][] markMatchedData(int[][] board, int[] draw) {
		for (int k = 0; k < draw.length; k++) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == draw[k]) {
						board[i][j] = 0;
					}
				}
			}
		}
		
		printBoard(board);
		return board;
	}
	
	public static boolean verifyWinner(int[][] board) {
		VerifyBoard verifyBoard = new VerifyBoard();
		boolean winnerFound = verifyBoard.isWinnerFound(board);
		System.out.println("winnerFound "+ winnerFound);
		return winnerFound;
	}
}
