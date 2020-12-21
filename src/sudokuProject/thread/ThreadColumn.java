package sudokuProject.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sudokuProject.constants.SudokuConstant;

public class ThreadColumn extends Thread {
	private int column;
	Lock verrou = new ReentrantLock();

	public ThreadColumn(int column) {
		super();
		verrou.lock();
		this.column = column;
		verrou.unlock();
	}

	@Override
	public void run() {
		synchronized (this) {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				sum += SudokuConstant.getSudoku_invalid()[i][column];
			}
			if (sum == SudokuConstant.SOME_PREVU) {
				System.out.println(" c'est bon pour le column  " + (column + 1));
				SudokuConstant.setCOLOM_VALID(column, true);
			} else {
				this.interrupt();
				System.out.println(" un probleme au niveau du column " + (column + 1));
				SudokuConstant.setLIGNE_VALID(column, false);

			}
		}

	}

}
