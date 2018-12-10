package com.mrliuxia.heiheihei.date0416;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/15
 */
public class ContactList {

	public static void main(String[] args) {
		new ContactList();
	}

	private Map<Name, Data> contactMap;
	private File contactFile;
	private Scanner scan;

	public ContactList() {
		contactMap = new TreeMap<Name, Data>();
		contactFile = new File("contactfile.txt");
		loadContact();
		scan = new Scanner(System.in);
		while (true) {
			String command = getCommand();
			switch (command) {
				case "a":
					addContact();
					break;
				case "d":
					deleteContact();
					break;
				case "p":
					printContact();
					break;
				case "q":
					System.exit(1);
					break;
			}
		}
	}

	private String getCommand() {
		while (true) {
			showCommandMenu();
			String cmd = scan.next().toLowerCase();
			if (cmd.equals("a") || cmd.equals("d") || cmd.equals("p") || cmd.equals("q")) {
				return cmd;
			} else {
				System.out.println("Invalid command!");
			}
		}
	}

	private void addContact() {
		System.out.println("ADD CONTACT");
		System.out.print("First name: ");
		String firstName = scan.next();
		System.out.print("Last name: ");
		String lastName = scan.next();
		Name name = new Name(firstName, lastName);
		if (contactMap.containsKey(name)) {
			System.out.println("This name exists.");
			return;
		}
		System.out.print("Phone number: ");
		String phone = scan.next();
		System.out.print("Email address: ");
		String email = scan.next();
		contactMap.put(name, new Data(phone, email));
		saveContact();
		System.out.println("Save succeed.");
	}

	private void deleteContact() {
		System.out.println("DELETE CONTACT");
		System.out.print("First name: ");
		String firstName = scan.next();
		System.out.print("Last name: ");
		String lastName = scan.next();
		Name name = new Name(firstName, lastName);
		if (!contactMap.containsKey(name)) {
			System.out.println("This name doesn't exist.");
		} else {
			contactMap.remove(name);
			saveContact();
			System.out.println("Delete succeed.");
		}
	}

	private void printContact() {
		if (contactMap.size() == 0) {
			System.out.println("There is no contact.");
			return;
		}
		for (Map.Entry entry : contactMap.entrySet()) {
			System.out.println(entry.getKey().toString() + "  -  " + entry.getValue().toString());
		}
	}

	private void saveContact() {
		try {
			FileWriter writer = new FileWriter(contactFile);
			for (Map.Entry entry : contactMap.entrySet()) {
				writer.write(((Name) entry.getKey()).getFirstName() + " ");
				writer.write(((Name) entry.getKey()).getLastName() + " ");
				writer.write(((Data) entry.getValue()).getPhone() + " ");
				writer.write(((Data) entry.getValue()).getEmail() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File path error.");
		}
	}

	private void loadContact() {
		if (!contactFile.exists()) {
			return;
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(contactFile));
			String s = null;
			while ((s = reader.readLine()) != null) {
				String[] data = s.split(" ");
				contactMap.put(new Name(data[0], data[1]), new Data(data[2], data[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showCommandMenu() {
		System.out.println("-----------------------------------");
		System.out.println("Contact list command table:");
		System.out.println(" a - add a new contact");
		System.out.println(" d - delete a contact");
		System.out.println(" p - print current contact list");
		System.out.println(" q - exit");
		System.out.print("input command: ");
	}

	private class Name implements Comparable {
		private String firstName;
		private String lastName;

		public Name(String firstName, String lastName) {
			firstName = firstName.trim();
			lastName = lastName.trim();
			this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
			this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Name)) {
				return false;
			}
			return ((Name) obj).lastName.equals(this.lastName) && ((Name) obj).firstName.equals(this.firstName);
		}

		@Override
		public int hashCode() {
			return (lastName.hashCode() << 2) + firstName.hashCode();
		}

		@Override
		public int compareTo(Object o) {
			if (!(o instanceof Name)) {
				return -1;
			}
			if (((Name) o).lastName.equals(this.lastName)) {
				return this.firstName.compareTo(((Name) o).firstName);
			} else {
				return this.lastName.compareTo(((Name) o).lastName);
			}
		}

		@Override
		public String toString() {
			return "Last name: " + lastName + ",  First name: " + firstName;
		}
	}

	private class Data {
		private String phone;
		private String email;

		public Data(String phone, String email) {
			this.phone = phone.trim();
			this.email = email.trim();
		}

		public String getPhone() {
			return phone;
		}

		public String getEmail() {
			return email;
		}

		@Override
		public String toString() {
			return "Phone number: " + phone + ",  Email address: " + email;
		}
	}


}
