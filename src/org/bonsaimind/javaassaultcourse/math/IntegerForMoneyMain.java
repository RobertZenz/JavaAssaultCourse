/*
 * Java Assault Course by Robert 'Bobby' Zenz
 *
 * To the extent possible under law, the person who associated CC0 with
 * Java Assault Course has waived all copyright and related or neighboring
 * rights to Java Assault Course.
 *
 * You should have received a copy of the CC0 legalcode along with this
 * work. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package org.bonsaimind.javaassaultcourse.math;

/**
 * This simple program calculates the result of a simple shopping list.
 * <p>
 * It does have a very nasty and hidden issue, can you figure out which?
 */
public class IntegerForMoneyMain {
	private static final int TAX_RATE_IN_PERCENT = 12;
	
	public static void main(String[] args) {
		int valueInCents = 0_00;
		
		// Let's do some shopping!
		valueInCents += 32_90; // New handbag.
		valueInCents += 1_20; // Chocolate bar.
		valueInCents += (9_99 * 3); // Some DVDs.
		valueInCents += (15_50); // New game.
		valueInCents += (41_90 * 0.75); // New shoes (discount of 25%)
		valueInCents += 14_90; // New "toy".
		
		// Add the tax.
		valueInCents += (valueInCents * TAX_RATE_IN_PERCENT / 100);
		
		// Let's print how much we have to pay.
		System.out.print("Checkout: ");
		System.out.println(valueInCents / 100);
	}
}
