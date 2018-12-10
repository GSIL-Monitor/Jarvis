package com.mrliuxia.heiheihei.d0130_code$decode;

import java.util.Arrays;

/**
 * Programming AE2
 * Class contains Vigenere cipher and methods to encode and decode a character
 */
public class VCipher
{
	private char [] alphabet;   //the letters of the alphabet
	private final int SIZE = 26;
        // more instance variables
	private char[][] cipher;
	private int encodeIndex;
	private int decodeIndex;

	/** 
	 * The constructor generates the cipher
	 * @param keyword the cipher keyword
	 */
	public VCipher(String keyword)
	{
	    // your code
		alphabet = new char[SIZE];
		for (int i = 0; i < SIZE; i++) {
			alphabet[i] = (char)(i + 'A');
		}
		cipher = new char[keyword.length()][SIZE];
		for (int i = 0; i < keyword.length(); i++) {
			for (int j = 0; j < SIZE; j++) {
				if (j == 0) {
					cipher[i][j] = keyword.charAt(i);
					continue;
				}
				if (cipher[i][j - 1] == 'Z') {
					cipher[i][j] = 'A';
				} else {
					cipher[i][j] = (char)(cipher[i][j - 1] + 1);
				}
			}
		}
		encodeIndex = -1;
		decodeIndex = -1;
		System.out.println("Vcipher:");
		for (int i = 0; i < cipher.length; i++) {
			System.out.println(Arrays.toString(cipher[i]));
		}
//		String s = "JAVA STYLE GUIDELINES";
//		StringBuffer sb = new StringBuffer();
//		System.out.println(s + "\n encode: ");
//		for (int i = 0; i < s.length(); i++) {
//			char ch = encode(s.charAt(i));
//			sb.append(ch);
//			System.out.print(ch+" ");
//		}
//		s = sb.toString();
//		System.out.println('\n' + s + "\n decode: ");
//		for (int i = 0; i < s.length(); i++) {
//			System.out.print(decode(s.charAt(i))+" ");
//		}
//		encodeIndex = -1;
//		decodeIndex = -1;
	}
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */	
	public char encode(char ch)
	{
		if (ch < 'A' || ch > 'Z') {
			return ch;
		}
		encodeIndex = (encodeIndex + 1) % cipher.length;
	    return cipher[encodeIndex][ch - 'A'];  //TODO replace with your code
	}
	
	/**
	 * Decode a character
	 * @param ch the character to be decoded
	 * @return the decoded character
	 */  
	public char decode(char ch)
	{
		if (ch < 'A' || ch > 'Z') {
			return ch;
		}
		decodeIndex = (decodeIndex + 1) % cipher.length;
		for (int i = 0; i < cipher[decodeIndex].length; i++) {
			if (ch == cipher[decodeIndex][i]) {
				return (char)('A' + i);
			}
		}
		return ch;  //TODO replace with your code
	}
}
