package sudokuProject.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sudokuProject.constants.SudokuConstant;

public class ThreadLigne extends Thread {
	private int ligne;

	Lock verrou = new ReentrantLock();

	public ThreadLigne(int ligne) {
		super();
		verrou.lock();
		this.ligne = ligne;
		verrou.unlock();
	}

	@Override
	public void run() {
		synchronized (this) {
			int sum = 0;
			for (int j = 0; j < 9; j++) {
				sum += SudokuConstant.getSudoku_valid()[ligne][j];
			}
			if (sum == SudokuConstant.SOME_PREVU) {
				System.out.println(" c'est bon pour la ligne " + (ligne + 1));
				SudokuConstant.setLIGNE_VALID(ligne, true);
			} else {
				System.out.println(" un probleme au niveau du ligne " + (ligne + 1));
				SudokuConstant.setLIGNE_VALID(ligne, false);
				this.interrupt();
			}

		}

	}

}
