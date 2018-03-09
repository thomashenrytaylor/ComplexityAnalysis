import java.util.Random;

public class DataGenerator {
	
	/**
	 * Method to create a populated IntMatrix of a specified size
	 * @param dim Size of the Matrix
	 * @return The new Matrix
	 */
	public static IntMatrix getMatrix(int dim) {
		IntMatrix value = new IntMatrix(dim);
		Random generator = new Random();
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				int num = generator.nextInt(9) + 0;
				value.set(i, j, num);
			}
		}
		return value;
	}
}