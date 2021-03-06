package com.mrliuxia.heiheihei.d0130_code$decode;

/**
 * Programming AE2
 * Processes report on letter frequencies
 */
public class LetterFrequencies
{
	/** Size of the alphabet */
	private final int SIZE = 26;
	
	/** Count for each letter */
	private int [] alphaCounts;
	
	/** The alphabet */
	private char [] alphabet; 
												 	
	/** Average frequency counts */
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
							       0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
								   6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};

	/** Character that occurs most frequently */
	private char maxCh;

	/** Total number of characters encrypted/decrypted */
	private int totChars;
	
	/**
	 * Instantiates a new letterFrequencies object.
	 */
	public LetterFrequencies()
	{
	    // your code TODO
		alphaCounts = new int[SIZE];
		alphabet = new char[SIZE];
		for (int i = 0; i < SIZE; i++) {
			alphabet[i] = (char)(i + 'A');
		}
		maxCh = ' ';
		totChars = 0;
	}
		
	/**
	 * Increases frequency details for given character
	 * @param ch the character just read
	 */
	public void addChar(char ch)
	{
		if (ch < 'A' || ch > 'Z') {
			return;
		}
	    // your code TODO
		totChars++;
		alphaCounts[ch - 'A']++;
		if (maxCh == ' ') {
			maxCh = ch;
		}else {
			if (alphaCounts[ch - 'A'] > alphaCounts[maxCh - 'A']) {
				maxCh = ch;
			}
		}
	}
	
	/**
	 * Gets the maximum frequency
	 * @return the maximum frequency
	 */
	private double getMaxPC()
	{
//	    return 0.0;  // replace with your code TODO
		double max = 0.00;
		for (int i = 0; i < SIZE; i++) {
			double curr =Double.valueOf(alphaCounts[i]) / Double.valueOf(totChars);
			max = curr > max ? curr: max;
		}
		return max;
	}
	
	/**
	 * Returns a String consisting of the full frequency report
	 * @return the report
	 */
	public String getReport()
	{
//	    return "";  // replace with your code TODO
		StringBuilder sb = new StringBuilder();
		sb.append("total chars: ").append(totChars).append('\n');
		sb.append("alpha counts: ").append('\n');
		for (int i = 0; i < SIZE; i++) {
			sb.append(alphabet[i]).append("-").append(alphaCounts[i]).append(", ");
		}
		sb.append("\ndefault percentage: ").append('\n');
		for (int i = 0; i < SIZE; i++) {
			sb.append(alphabet[i]).append('-').append(avgCounts[i]).append('%').append(", ");
		}
		sb.append("\nmax ch: ").append(maxCh);
		sb.append("\nmax pc: ").append(getMaxPC());
		return sb.toString();
	}
}
