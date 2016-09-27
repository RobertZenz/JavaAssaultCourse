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

package org.bonsaimind.javaassaultcourse.random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This program generates random numbers and makes sure that none of them
 * repeat.
 * <p>
 * It becomes slower the more numbers it has generated, can you tell why? Can
 * you optimize it? Also there is something fundamentally wrong here, can you
 * tell what?
 */
public class DoWhatIMeantMain {
	public static void main(String[] args) {
		System.out.println("Now generating 100 random numbers:");
		
		Set<Integer> generatedNumbers = new HashSet<>();
		
		Random random = new Random();
		
		for (int counter = 0; counter < 100; counter++) {
			int generatedNumber = random.nextInt(100);
			
			if (generatedNumbers.contains(Integer.valueOf(generatedNumber))) {
				counter--;
				simulateCost();
			} else {
				generatedNumbers.add(Integer.valueOf(generatedNumber));
				System.out.println(Integer.toString(counter) + ": " +
						Integer.toString(generatedNumber));
			}
		}
	}
	
	/**
	 * Simulate step-back cost.
	 * <p>
	 * Because the machines are so damn fast, we have to simulate the cost of
	 * the operation.
	 * <p>
	 * No, removing this and claiming that you "optimized" it does not count!
	 */
	private static final void simulateCost() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
