package com.google.challenges.level3b;

public class Answer {

	static private Cell[][] cells;
	static private Cell exit = null;

	public static int answer(int[][] maze) {
		initCells(maze);
		linkCells(maze);
		cells[0][0].hello();
		// System.out.println(exit.best);
		return exit.best;
	}

	static private void initCells(int[][] maze) {
		int rows = maze.length;
		int columns = maze[0].length;
		cells = new Cell[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				cells[row][col] = new Cell();
			}
		}
		exit = cells[rows - 1][columns - 1];
	}

	static private void linkCells(int[][] maze) {
		int rows = maze.length;
		int cols = maze[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				cells[row][col].wall = maze[row][col] == 1;
				cells[row][col].up = row == 0 ? null : cells[row - 1][col];
				cells[row][col].left = col == 0 ? null : cells[row][col - 1];
				cells[row][col].down = row == (rows - 1) ? null : cells[row + 1][col];
				cells[row][col].right = col == (cols - 1) ? null : cells[row][col + 1];
			}
		}
	}
}

class Cell {

	static final int UP = 0;
	static final int LEFT = 1;
	static final int DOWN = 2;
	static final int RIGHT = 3;

	public boolean wall;
	public Integer best = null;
	public Integer bestWithoutWall = null;
	public Integer bestWithWall = null;

	public Cell up;
	public Cell left;
	public Cell down;
	public Cell right;

	public void hello() {
		hello(0, null, UP);
	}

	public void hello(final Integer myBestWithoutWall,
			final Integer myBestWithWall, final int from) {
		boolean changed = false;
		if (wall == false) {
			if (myBestWithoutWall != null) {
				changed |= updateBestWithoutWall(myBestWithoutWall + 1);
			}
			if (myBestWithWall != null) {
				changed |= updateBestWithWall(myBestWithWall + 1);
			}
		} else {
			this.bestWithoutWall = null;
			if (myBestWithoutWall != null) {
				changed |= updateBestWithWall(myBestWithoutWall + 1);
			}
		}

		if (changed) {
			if (from == UP) {
				if (left != null) left.hello(bestWithoutWall, bestWithWall, RIGHT);
				if (down != null) down.hello(bestWithoutWall, bestWithWall, UP);
				if (right != null) right.hello(bestWithoutWall, bestWithWall, LEFT);
			} else if (from == LEFT) {
				if (up != null) up.hello(bestWithoutWall, bestWithWall, DOWN);
				if (down != null) down.hello(bestWithoutWall, bestWithWall, UP);
				if (right != null) right.hello(bestWithoutWall, bestWithWall, LEFT);
			} else if (from == DOWN) {
				if (up != null) up.hello(bestWithoutWall, bestWithWall, DOWN);
				if (left != null) left.hello(bestWithoutWall, bestWithWall, RIGHT);
				if (right != null) right.hello(bestWithoutWall, bestWithWall, LEFT);
			} else if (from == RIGHT) {
				if (up != null) up.hello(bestWithoutWall, bestWithWall, DOWN);
				if (left != null) left.hello(bestWithoutWall, bestWithWall, RIGHT);
				if (down != null) down.hello(bestWithoutWall, bestWithWall, UP);
			}
		}
	}

	private boolean updateBestWithoutWall(int newBestWithoutWall) {
		if (bestWithoutWall == null || bestWithoutWall > newBestWithoutWall) {
			this.bestWithoutWall = newBestWithoutWall;
			updateBest(this.bestWithoutWall);
			if (this.bestWithWall != null
					&& this.bestWithoutWall <= this.bestWithWall)
				this.bestWithWall = null;
			return true;
		}
		return false;
	}

	private boolean updateBestWithWall(int newBestWithWall) {
		if ((bestWithoutWall == null || bestWithoutWall > newBestWithWall)
				&& (bestWithWall == null || bestWithWall > newBestWithWall)) {
			this.bestWithWall = newBestWithWall;
			updateBest(this.bestWithWall);
			return true;
		}
		return false;
	}

	private void updateBest(int value) {
		if (best == null || best > value) best = value;
	}

}