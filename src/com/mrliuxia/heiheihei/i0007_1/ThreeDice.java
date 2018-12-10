package com.mrliuxia.heiheihei.i0007_1;// ThreeDice class
//
// Originally written by Clare Dixon, June 2013.
// Adapted by Russell Martin, December 2016.
//
// The class stores the values rolled for three dice and provides
// methods to determine whether the result is three scores the same,
// a run, a pair, or (not a run and) all values different.

public class ThreeDice {
     // ---------------------- ATTRIBUTES ---------------------
     protected int die1;
     protected int die2;
     protected int die3;
     // ------------------ CONSTRUCTOR -------------------
     public ThreeDice(int s1, int s2, int s3) {
          // This puts the three dice values in ascending order.
          int tmp;
          if (s2 < s1) {
              tmp = s2;
              s2 = s1;
              s1 = tmp;
          }
          if (s3 < s2) {
              tmp = s3;
              s3 = s2;
              s2 = tmp;
          }
          if (s2 < s1) {
              tmp = s2;
              s2 = s1;
              s1 = tmp;
          }
          die1 = s1;
          die2 = s2;
          die3 = s3;
     }

     // --------------------- METHODS ---------------------
     // Accessor methods
     public int getDie1() {
          return die1;
     }

     public int getDie2() {
          return die2;
     }

     public int getDie3() {
          return die3;
     }

     // Will return true if all scores are the same.
     // This depends on the scores being ordered.
     public boolean threeSame() {
          return (die1 == die3);
     }

     // Will return true if we have a run e.g. "one, two, three",
     // "two, three, four", "three, four, five" or "four, five, six".
     // Again, this depends upon the values being ordered.
     public boolean runOfThree() {
          return (( (die1 + 1) == die2) && ( (die2 + 1) == die3));
     }

     // Will return true if exactly two of the dice are the same.
     // Note this will *not* return true if all the dice are the same.
     // Uses the fact that the die values have been ordered.
     public boolean pair() {
          return (((die1 == die2) || (die2 == die3)) && (die1 != die3));
     }

     // Will return true if dice are all different and they are not a run.
     // Note we don't need to check that die1 != die3 as we have
     // put the scores in order in the constructor.
     public boolean allDifferent() {
          return (!runOfThree() && (die1 != die2) && (die2 != die3));
     }

     // Tests whether the three scores are three the same, a run of three,
     // a pairi, or three different (and not a run) and prints out which
     // condition holds.
     public void printResult() {
          if (threeSame())
              System.out.println("The roll is all the same.");
          else if (runOfThree())
              System.out.println("The roll is a run.");
          else if (pair())
              System.out.println("The roll is a pair.");
          else if (allDifferent())
              System.out.println("The roll is all different.");
    }

}
