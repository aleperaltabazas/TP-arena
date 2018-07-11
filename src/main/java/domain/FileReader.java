package domain;

import java.io.File;
import java.util.Scanner;

public class FileReader {

	public static Scanner openFile(String fileName) {
		try {
			return new Scanner(new File(fileName));
		} catch (Exception e) {
			throw new RuntimeException("File error");
		}
	}

}
