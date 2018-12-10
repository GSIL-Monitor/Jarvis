package com.mrliuxia.heiheihei.date0415;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/15
 */
public class SmallAreaIncomePropertyReport {

	public static void main(String[] args) {
		new SmallAreaIncomePropertyReport().readToConsole(args[0]);
	}

	private void readToConsole(String path) {
		File file = new File(path);
		System.out.println("File: " + file.getAbsolutePath() + "\n\n");
		BufferedReader reader = null;
		String s = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
