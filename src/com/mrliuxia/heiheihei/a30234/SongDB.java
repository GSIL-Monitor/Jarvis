package com.mrliuxia.heiheihei.a30234;

import java.io.File;
import java.util.Scanner;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/28
 */
public class SongDB {

	public static void main(String[] args) {
		String dbPath = args[0];
		File dbFile = new File(dbPath);
		if (dbFile.exists()) {
			new SongFrame(dbPath, true);
		}else {
			Scanner scan = new Scanner(System.in);
			boolean flag = true;
			while (flag) {
				System.out.println("File doesn't exists. Do you want to create it? y/n");
				String cmd = scan.next().toLowerCase();
				switch (cmd) {
					case "y":
						flag = false;
						new SongFrame(dbPath, false);
						break;
					case "n":
						flag = false;
						System.exit(0);
						break;
					default:
						System.out.println("Invalid command.");
						break;
				}
			}
		}



	}

}
