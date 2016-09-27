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

import java.util.Random;
import java.util.Scanner;

/**
 * This program outputs a random number every time the Return key is pressed.
 * <p>
 * It has an issue when it comes to generating the random numbers, can you guess
 * which by just looking at the code? Can you produce it when running the
 * program? How would you fix/optimize it?
 */
public class PressButtonForRandomNumberMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press Enter to get a new random number.");
		
		while (true) {
			System.out.println(new Random(System.currentTimeMillis()).nextInt(1000));
			scanner.nextLine();
		}
	}
}
