package util;

import java.io.*;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/19
 */
public class FileUtil {

	public static BufferedReader getFileReader(String path) {
		return getFileReader(new File(path));
	}

	public static BufferedReader getFileReader(File file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return reader;
	}

	public static String readFromFile(String path) {
		return readFromFile(new File(path));
	}

	public static String readFromFile(File file) {
		if (!file.exists()) {
			throw new RuntimeException("No such file.");
		}
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = reader.readLine()) != null) {
				sb.append(s).append('\n');
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void writeToFile(String path, String content) {
		writeToFile(new File(path), content);
	}

	public static void writeToFile(File file, String content) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
