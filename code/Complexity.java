
public class Complexity {

	private static int MATRIX_SIZE = 4;
	private static final int ITERATION_DEPENDENT_COUNTER = 9;
	private static final int SIZE_DEPENDENT_COUNTER = 10;
	private static final int SIZE_MULTIPLIER = 2;
	private static final String FILE_NAME = "Complexity.csv";
	private static FileWriter writer;
	
	/**
	 * Finds the (mean) average time for each matrix size
	 * @return Average Time
	 */
	public static long findAverageTimeComplexity() {
		long averageTime = 0;
		long totalTime = 0;

		for (int i = 0; i < SIZE_DEPENDENT_COUNTER; i++) {
			MatrixMultiplication algorithm = new BasicMultiplier();
			totalTime += algorithm.findComputationTime(MATRIX_SIZE);
		}
		averageTime = totalTime / SIZE_DEPENDENT_COUNTER;
		return averageTime;
	}

	/**
	 * Doubles the size of the Matrix
	 */
	public void IncreaseSize() {
		MATRIX_SIZE *= SIZE_MULTIPLIER;
	}

	/**
	 * For each input size, find the average time taken to execute and write each value to a CSV file
	 */
	public static void main(String[] args) {
		writer = FileWriter.getInstance();
		writer.initialiseWriter(FILE_NAME);
		Complexity comp = new Complexity();

		for (int i = 0; i < ITERATION_DEPENDENT_COUNTER; i++) {
			long average = findAverageTimeComplexity();
			writer.writeLine(average);
			System.out.println("AVERAGE: " + average);
			comp.IncreaseSize();
		}
		writer.close();
	}
}