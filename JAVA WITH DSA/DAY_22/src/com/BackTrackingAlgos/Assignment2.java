package com.BackTrackingAlgos;

public class Assignment2 {
	static final int N = 6;
	static boolean isValid (int [][] maze, int x , int y) {
		return (x >= 0 && y>=0 && y<N && maze[x][y]==1);
	}
	static void printSolution(int[][] sol) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(" "+sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean solveMazeUtil(int [][] maze, int x, int y, int [][]sol) {
		if(x==N-1 && y==N-1) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isValid(maze,x,y)) {
			sol[x][y] = 1;
			if(solveMazeUtil(maze, x+1, y, sol))
				return true;
			if(solveMazeUtil(maze, x, y+1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	
	static boolean solveMaze(int[][] maze) {
		int [][] sol = new int[N][N];
		if(!solveMazeUtil(maze, 0, 0, sol)) {
			System.out.println("Solution doesn't exist");
			return false;
		}
		
		System.out.println("Solution:");
		printSolution(sol);
		return true;
	}
	
	public static void main(String args[]) {
		int maze[][] = {
				{ 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 1 },
				{ 0, 0, 0, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 1 }
		};
		solveMaze(maze);
	}

}
