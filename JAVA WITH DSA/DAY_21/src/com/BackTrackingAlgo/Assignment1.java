package com.BackTrackingAlgo;

public class Assignment1 {

    static final int N = 8;
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }
    static boolean solveKnightsTourUtil(int[][] board, int moveX, int moveY, int moveCount, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (moveCount == N * N)
            return true;
        for (k = 0; k < 8; k++) {
            nextX = moveX + xMove[k];
            nextY = moveY + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTourUtil(board, nextX, nextY, moveCount + 1, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtracking
            }
        }
        return false;
    }
    static boolean solveKnightsTour() {
        int[][] board = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                board[x][y] = -1;
        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
        board[0][0] = 0;
        if (!solveKnightsTourUtil(board, 0, 0, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(board);

        return true;
    }
    static void printSolution(int[][] board) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solveKnightsTour();
    }
}
