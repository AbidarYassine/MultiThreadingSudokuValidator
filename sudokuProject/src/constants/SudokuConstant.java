package sudokuProject.constants;

public class SudokuConstant {
	public static final int SOME_PREVU = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;
	private static boolean LIGNE_VALID[]= new boolean[9];
	private static boolean COLOM_VALID[]= new boolean[9];
	public static boolean[] getLIGNE_VALID() {
		return LIGNE_VALID;
	}



	



	public static void setLIGNE_VALID(int ligne,boolean status) {
		LIGNE_VALID[ligne]=status;
	}



	public static boolean[] getCOLOM_VALID() {
		return COLOM_VALID;
	}



	public static void setCOLOM_VALID(int colom,boolean status) {
		COLOM_VALID[colom]=status;
	}



	private static int[][] sudoku_valid = { 
			                                { 7, 2, 6, 4, 9, 3, 8, 1, 5 }, 
			                                { 3, 1, 5, 7, 2, 8, 9, 4, 6 },
			                                { 4, 8, 9, 6, 5, 1, 2, 3, 7 }, 
			                                { 8, 5, 2, 1, 4, 7, 6, 9, 3 },
			                                { 6, 7, 3, 9, 8, 5, 1, 2, 4 },
			                                { 9, 4, 1, 3, 6, 2, 7, 5, 8 },
			                                { 1, 9, 4, 8, 3, 6, 5, 7, 2 }, 
			                                { 5, 6, 7, 2, 1, 4, 3, 8, 9 },
			                                { 2, 3, 8, 5, 7, 9, 4, 6, 1 } 
			                                };
	
	
	
	private static int[][] sudoku_invalid = { 
			                                { 7, 7, 6, 4, 9, 3, 8, 1, 5 }, 
                                            { 3, 1, 5, 7, 2, 8, 9, 4, 6 },
                                            { 4, 2, 9, 6, 5, 1, 2, 3, 7 }, 
                                            { 8, 5, 2, 1, 1, 7, 6, 9, 3 },
                                            { 6, 7, 3, 3, 3, 5, 1, 2, 4 },
                                            { 9, 4, 1, 3, 6, 2, 7, 5, 8 },
                                            { 1, 9, 4, 8, 3, 2, 5, 7, 2 }, 
                                            { 5, 6, 5, 2, 1, 4, 3, 8, 9 },
                                            { 2, 3, 8, 5, 4, 9, 4, 6, 1 }
                                            };



	public static int[][] getSudoku_valid() {
		return sudoku_valid;
	}



	public static void setSudoku_valid(int[][] sudoku_valid) {
		SudokuConstant.sudoku_valid = sudoku_valid;
	}



	public static int[][] getSudoku_invalid() {
		return sudoku_invalid;
	}



	public static void setSudoku_invalid(int[][] sudoku_invalid) {
		SudokuConstant.sudoku_invalid = sudoku_invalid;
	}
	

}
