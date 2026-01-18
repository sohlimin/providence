/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #08: PS1_Ex08_Coins.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * <Type your name here>
 */

import java.util.Scanner;

class Coins {
	public static void main(String[] args) {
		System.out.print("Enter amount in cents: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int noOfCoins = processy(amount);
		System.out.println("Minimum number of coins needed: " + noOfCoins);
  }
	private static int processy(int amt) {
		int coins = 0;
		coins += amt / 100;
		amt = amt % 100;
		coins += amt / 50;
		amt = amt % 50;
		coins += amt / 20;
		amt = amt % 20;
		coins += amt / 10;
		amt = amt % 10;
		coins += amt / 5;
		amt = amt % 5;
		coins += amt;
		return coins;
	}
	  	
}
