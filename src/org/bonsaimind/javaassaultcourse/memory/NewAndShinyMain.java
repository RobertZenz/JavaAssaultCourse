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

package org.bonsaimind.javaassaultcourse.memory;

/**
 * This is a simple program which concatenates all numbers up to 100,000 and
 * then prints the length of the resulting string.
 * <p>
 * However, it is running extremely slow, can you fix it?
 * <p>
 * How can this program be optimized?
 */
public class NewAndShinyMain {
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		String numbers = "";
		
		for (int counter = 0; counter < 100_000; counter++) {
			numbers = numbers + Integer.toString(counter);
		}
		
		System.out.println(numbers.length());
		
		long end = System.nanoTime();
		long duration = end - start;
		
		System.out.print("Time taken: ");
		System.out.print(duration / 1000 / 1000d);
		System.out.println(" ms");
	}
}
