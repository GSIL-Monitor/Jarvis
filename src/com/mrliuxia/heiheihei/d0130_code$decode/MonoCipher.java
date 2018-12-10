package com.mrliuxia.heiheihei.d0130_code$decode;

import java.util.Arrays;

/**
 * Programming AE2
 * Contains monoalphabetic cipher and methods to encode and decode a character.
 */
public class MonoCipher
{
	/** The size of the alphabet. */
	private final int SIZE = 26;

	/** The alphabet. */
	private char [] alphabet;
	
	/** The cipher array. */
	private char [] cipher;

	/**
	 * Instantiates a new mono cipher.
	 * @param keyword the cipher keyword
	 */
	public MonoCipher(String keyword)
	{
		//create alphabet
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('A' + i);
		
		// create first part of cipher from keyword
		int index = 0;
		cipher = new char[SIZE];
		for (; index < keyword.length(); index++) {
			cipher[index] = keyword.charAt(index);
		}

		// create remainder of cipher from the remaining characters of the alphabet
		for (int i = 0; i < SIZE; i++) {
			char ch = (char)('Z' - i);
			if (!keyword.contains(ch + "")) {
				cipher[index++] = ch;
			}
		}

		// print cipher array for testing and tutors
		System.out.println("MonoCipher:" + '\n' + Arrays.toString(cipher));
//		System.out.print("encode    : ");
//		for (int i = 0; i < SIZE; i++) {
//			System.out.print(encode(alphabet[i])+" ");
//		}
//		System.out.println();
//		System.out.print("decode    : ");
//		for (int i = 0; i < SIZE; i++) {
//			System.out.print(decode(cipher[i])+" ");
//		}
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
	    return cipher[ch - 'A'];  //TODO replace with your code
	}

	/**
	 * Decode a character
	 * @param ch the character to be encoded
	 * @return the decoded character
	 */
	public char decode(char ch)
	{
		if (ch < 'A' || ch > 'Z') {
			return ch;
		}
		for (int i = 0; i < cipher.length; i++) {
			if (ch == cipher[i]) {
				return (char)(i + 'A');
			}
		}  //TODO replace with your code
		return ch;
	}
}
