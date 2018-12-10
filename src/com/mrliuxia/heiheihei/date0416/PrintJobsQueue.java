package com.mrliuxia.heiheihei.date0416;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/15
 */
public class PrintJobsQueue {

	public static void main(String[] args) {
		new PrintJobsQueue();
	}

	private Queue<Job> jobs;
	private Scanner scan;
	private int currNo;
	private Random random;

	public PrintJobsQueue() {
		jobs = new LinkedList<Job>();
		scan = new Scanner(System.in);
		currNo = 1;
		random = new Random(1024l);
		while (true) {
			String command = getCommand();
			switch (command) {
				case "a":
					addJob();
					break;
				case "q":
					quit();
					break;
			}
		}
	}

	private void showCommandMenu() {
		System.out.println("-----Command Table-----");
		System.out.println(" a - add a new job");
		System.out.println(" q - quit and print jobs");
	}

	private String getCommand() {
		while (true) {
			showCommandMenu();
			String s = scan.next().trim().toLowerCase();
			if (s.equals("a") || s.equals("q")) {
				return s;
			}
		}
	}

	private void addJob() {
		jobs.add(new Job(currNo++, random.nextInt(990) + 10));
		System.out.println("Add job succeed.");
	}

	private void quit() {
		while (jobs.size() > 0) {
			Job currJob = jobs.poll();
			System.out.println(currJob);
		}
		System.exit(1);
	}

	private class Job {
		private int no;
		private int printTime;

		public Job(int no, int printTime) {
			this.no = no;
			this.printTime = printTime;
		}

		public int getNo() {
			return no;
		}

		public int getPrintTime() {
			return printTime;
		}

		@Override
		public String toString() {
			return "Job number: " + no + ",  Print time: " + printTime;
		}
	}
}
