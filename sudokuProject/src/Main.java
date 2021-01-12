package sudokuProject;

import java.util.ArrayList;
import java.util.List;

import sudokuProject.constants.SudokuConstant;
import sudokuProject.thread.SquareThread;
//import sudokuProject.constants.SudokuInput;
import sudokuProject.thread.ThreadColumn;
import sudokuProject.thread.ThreadLigne;

public class Main {

	public static void main(String[] args) {

		System.out.println("**********Debut du programme**********");
		List<Thread> threads = new ArrayList<>();
		// Checker les Lignes
		for (int i = 0; i < 9; i++) {
			ThreadLigne threadLigne1 = new ThreadLigne(i);
			threadLigne1.start();
			threads.add(threadLigne1);
		}

		// Check les colon
		for (int j = 0; j < 9; j++) {
			ThreadColumn threadColumn = new ThreadColumn(j);
			threadColumn.start();
			threads.add(threadColumn);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				SquareThread squareThread = new SquareThread(3 * i, 3 * j, 3 * i + 3, 3 * j + 3);
				squareThread.start();
				threads.add(squareThread);
			}
		}

		System.out.println(" number de thread est " + threads.size());
		for (Thread t : threads) {
			try {
				System.out.println(t.getName());
				t.join(); /// j'attend la fin de tout les thrad;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (getSudokuStatus())
			System.out.println("LE SUDOKU EST  VALID ");
		else {
			System.out.println(" LE SUDOKU N'EST PAS VALID ");
		}

		System.out.println("**********la fin du programme**********");

	}

	static boolean getSudokuStatus() {
		for (int i = 0; i < 9; i++) {
			if (!SudokuConstant.getLIGNE_VALID()[i] || !SudokuConstant.getLIGNE_VALID()[i]) {
				return false;
			}
		}
		return true;
	}
}
