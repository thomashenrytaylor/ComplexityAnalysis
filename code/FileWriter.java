import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * A class that allows writing lines to a single file (using the Singleton
 * design pattern)
 */

public class FileWriter {

	private static FileWriter instance;
	private PrintWriter writer;

	public static FileWriter getInstance() {
		if (instance == null) {
			instance = new FileWriter();
		}
		return instance;
	}

	public void initialiseWriter(String fileName) {
		try {
			this.writer = new PrintWriter(fileName);
		} catch (FileNotFoundException exception) {
			System.err.println("ERROR: The file " + "\"" + fileName + "\"" + " was not found.  Try again...");
		}
	}

	public void writeLine(long line) {
		writer.println(line);
		writer.flush();
	}

	public void close() {
		writer.close();
	}
}