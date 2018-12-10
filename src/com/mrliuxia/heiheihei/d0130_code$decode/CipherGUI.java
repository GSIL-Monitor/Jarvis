package com.mrliuxia.heiheihei.d0130_code$decode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Programming AE2
 * Class to display cipher GUI and listen for events
 */
public class CipherGUI extends JFrame implements ActionListener
{
	//instance variables which are the components
	private JPanel top, bottom, middle;
	private JButton monoButton, vigenereButton;
	private JTextField keyField, messageField;
	private JLabel keyLabel, messageLabel;

	//application instance variables
	private String filePath, keyword;
	
	//including the 'core' part of the textfile filename
	//some way of indicating whether encoding or decoding is to be done
	private MonoCipher mcipher;
	private VCipher vcipher;

	/**
	 * The constructor adds all the components to the frame
	 */
	public CipherGUI()
	{
		this.setSize(400,150);
		this.setLocation(100,100);
		this.setTitle("Cipher GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layoutComponents();
	}

	/**
	 * Helper method to add components to the frame
	 */
	public void layoutComponents()
	{
		//top panel is yellow and contains a text field of 10 characters
		top = new JPanel();
		top.setBackground(Color.yellow);
		keyLabel = new JLabel("Keyword : ");
		top.add(keyLabel);
		keyField = new JTextField(10);
		top.add(keyField);
		this.add(top,BorderLayout.NORTH);

		//middle panel is yellow and contains a text field of 10 characters
		middle = new JPanel();
		middle.setBackground(Color.yellow);
		messageLabel = new JLabel("Message file : ");
		middle.add(messageLabel);
		messageField = new JTextField(10);
		middle.add(messageField);
		this.add(middle,BorderLayout.CENTER);

		//bottom panel is green and contains 2 buttons

		bottom = new JPanel();
		bottom.setBackground(Color.green);
		//create mono button and add it to the top panel
		monoButton = new JButton("Process Mono Cipher");
		monoButton.addActionListener(this);
		bottom.add(monoButton);
		//create vigenere button and add it to the top panel
		vigenereButton = new JButton("Process Vigenere Cipher");
		vigenereButton.addActionListener(this);
		bottom.add(vigenereButton);
		//add the top panel
		this.add(bottom,BorderLayout.SOUTH);

//		File file = new File("src/input");
//		System.out.println(file.exists());
//		BufferedWriter writer = null;
//		File outFile = new File("src/out.txt");
//		try {
//			if (!outFile.exists()) {
//				outFile.createNewFile();
//			}
//			writer = new BufferedWriter(new FileWriter(outFile ,false));
//			writer.write("asdfsfda");
//			writer.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Listen for and react to button press events
	 * (use helper methods below)
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e)
	{
	    // your code TODO
		if (e.getSource() == monoButton) {
            mcipher = new MonoCipher(keyField.getText());
			processFileName();
			processFile(false);

			File inputFile = new File(filePath);
			FileReader reader = null;
			try {
				reader = new FileReader(inputFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			FileWriter writer = null;
			try {
				File outFile = new File("src/input-frequencies.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				LetterFrequencies f = new LetterFrequencies();
				int a;
				while ( (a = reader.read()) != -1) {
					f.addChar((char)a);
				}
				writer.write(f.getReport());
				writer.flush();
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

			File monoFile = new File("src/mono.txt");
			try {
				reader = new FileReader(monoFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				File outFile = new File("src/mono-frequencies.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				LetterFrequencies f = new LetterFrequencies();
				int a;
				while ( (a = reader.read()) != -1) {
					f.addChar((char)a);
				}
				writer.write(f.getReport());
				writer.flush();
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		if (e.getSource() == vigenereButton) {
			vcipher = new VCipher(keyField.getText());
			processFileName();
			processFile(true);

			File inputFile = new File(filePath);
			FileReader reader = null;
			try {
				reader = new FileReader(inputFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			FileWriter writer = null;
			try {
				File outFile = new File("src/input-frequencies.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				LetterFrequencies f = new LetterFrequencies();
				int a;
				while ( (a = reader.read()) != -1) {
					f.addChar((char)a);
				}
				writer.write(f.getReport());
				writer.flush();
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

			File monoFile = new File("src/v.txt");
			try {
				reader = new FileReader(monoFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				File outFile = new File("src/v-frequencies.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				LetterFrequencies f = new LetterFrequencies();
				int a;
				while ( (a = reader.read()) != -1) {
					f.addChar((char)a);
				}
				writer.write(f.getReport());
				writer.flush();
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Obtains cipher keyword
	 * If the keyword is invalid, a message is produced
	 * @return whether a valid keyword was entered
	 */
	private boolean getKeyword()
	{
		// replace with your code TODO	
		keyword = keyField.getText();
	    if (keyword == null || keyword == "") {
			return false;	
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < keyword.length(); i++) {
			set.add(keyword.charAt(i));
		}
		if (set.size() == keyword.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Obtains filename from GUI
	 * The details of the filename and the type of coding are extracted
	 * If the filename is invalid, a message is produced
	 * The details obtained from the filename must be remembered
	 * @return whether a valid filename was entered
	 */
	private boolean processFileName()
	{
		filePath = messageField.getText();
		if (filePath == null || filePath == "") {
			return false;
		}
	    return true;  // replace with your code TODO
	}

	/**
	 * Reads the input text file character by character
	 * Each character is encoded or decoded as appropriate
	 * and written to the output text file
	 * @param vigenere whether the encoding is Vigenere (true) or Mono (false)
	 * @return whether the I/O operations were successful
	 */
	private boolean processFile(boolean vigenere)
	{
		File file = new File(filePath);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileWriter writer = null;
		if (vigenere) { // vigenere
			try {
				File outFile = new File("src/v.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				int a;
				while ( (a = reader.read()) != -1) {
					writer.write((vcipher.encode((char) a)));
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else { // mono
			try {
				File outFile = new File("src/mono.txt");
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				writer = new FileWriter(outFile);
				int a;
				while ( (a = reader.read()) != -1) {
					writer.write((mcipher.encode((char) a)));
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	    return true;  // replace with your code TODO
	}
}
