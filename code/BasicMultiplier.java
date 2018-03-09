public class BasicMultiplier extends MatrixMultiplication {

	private IntMatrix first;
	private IntMatrix second;
	private IntMatrix result;
	private long startTime;
	private long endTime;
	private long totalTime;

	@Override
	void initialise(int size) {
		first = DataGenerator.getMatrix(size);
		second = DataGenerator.getMatrix(size);
		displayMatrix(first);
		displayMatrix(second);
	}

	@Override
	long execute() {
		startTime = System.nanoTime();
		result = multiply(first, second);
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		return totalTime;
	}

	@Override
	void printResults() {
		System.out.println(toString() + " Algorithm Complete"
				+ "\nAlgorithm produced the following matrix in " + totalTime + " nanoseconds");
		displayMatrix(result);
	}

	public String toString() {
		return "Basic Multiplier";
	}

	public IntMatrix multiply(IntMatrix a, IntMatrix b) {
		int dim = a.getDim();
		IntMatrix result = new IntMatrix(dim);

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				int sum = 0;
				for (int k = 0; k < dim; k++) {
					sum += a.get(i, k) * b.get(k, j);
				}
				result.set(i, j, sum);
			}
		}

		return result;
	}

}