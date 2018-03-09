public abstract class MatrixMultiplication {
	
	abstract void initialise(int matrixSize);
	abstract long execute();
	abstract void printResults();
	
	/**
	 * Template Method
	 * @param testSize Dimension size of matrices
	 * @param occurrences Number of test Instances
	 */
	public final long findComputationTime(int matrixSize) {
		initialise(matrixSize); 		// initialise the matrices 
		long result = execute();		// calculate algorithm execution time
		printResults();				// print execution times 
		
		return result;
	}
	
	/**
	 * Display matrix contents
	 * @param input Matrix to display
	 */
	void displayMatrix(IntMatrix input) {
		int dim = input.getDim();
		int[][] matrix = input.getValues();
		
		boolean seperator = false;
		
		for(int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				int val = input.get(i, j);
				int length = String.valueOf(val).length();
				if (length > 1)
					seperator = true;
			}
		}
		
		for (int i = dim; i > 0; i--) {
			if (seperator)
				System.out.print("------");
			else 
				System.out.print("-----");
		}
		System.out.println();

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.print("| ");
				System.out.print(matrix[i][j]);
				System.out.print(" |");
			}
			System.out.println();
		}
		
		for (int i = dim; i > 0; i--) {
			if (seperator)
				System.out.print("------");
			else 
				System.out.print("-----");		
		}
		System.out.println();
	}
}