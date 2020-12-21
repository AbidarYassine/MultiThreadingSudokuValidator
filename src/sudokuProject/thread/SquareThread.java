package sudokuProject.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sudokuProject.constants.SudokuConstant;

public class SquareThread extends Thread {

	private int i1;
	private int j1;
	private int i2;
	private int j2;
	Lock verrou = new ReentrantLock();

	public SquareThread(int i1, int j1, int i2, int j2) {
		verrou.lock();
		this.i1 = i1;
		this.j1 = j1;
		this.i2 = i2;
		this.j2 = j2;
		verrou.unlock();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		synchronized (this) {
			if (!correct(i1, j1, i2, j2)) {
				System.out
						.println("un problem dans le square " + "(" + i1 + "," + i2 + ")" + "(" + j1 + "," + j2 + ")");
			} else {
				System.out
						.println("C'est bon pour  le square " + "(" + i1 + "," + j2 + ")" + "(" + j1 + "," + j2 + ")");
				this.interrupt();
			}
		}

	}

	synchronized boolean correct(int i1, int j1, int i2, int j2) {
		int sum = 0;
		for (int i = i1; i < i2; i++) {
			for (int j = j1; j < j2; j++) {
				sum += SudokuConstant.getSudoku_invalid()[i][j];
			}
		}
		if (SudokuConstant.SOME_PREVU == sum)
			return true;
		return false;
	}
}
