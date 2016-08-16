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

package org.bonsaimind.javaassaultcourse.threading;

/**
 * This program is supposed to print {@code 100000} when it is done.
 * <p>
 * Try to answer these questions without executing the program:
 * <ul>
 * <li>What does this program print?</li>
 * <li>Why is {@code SYNCHRONIZATION_OBJECT} used for?</li>
 * <li>Why is there a random {@code Thread#sleep(long)} call after starting the
 * threads?</li>
 * </ul>
 * <p>
 * After running the program multiple times, try to fix it.
 * <p>
 * Additional questions/tasks when the problem is fixed:
 * <ul>
 * </li>What could you do to simplify this program?</li>
 * </ul>
 */
public class RaceConditionMain {
	private static final Object SYNCHRONIZATION_OBJECT = new Object();
	
	private static int value = 0;
	
	public static void main(String[] pArgs) {
		Thread threadA = new Thread(RaceConditionMain::incrementValue);
		Thread threadB = new Thread(RaceConditionMain::incrementValue);
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// Shouldn't happen.
		}
		
		synchronized (SYNCHRONIZATION_OBJECT) {
			SYNCHRONIZATION_OBJECT.notifyAll();
		}
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			// Shouldn't happen
		}
		
		System.out.println("The value is " + Integer.toString(value) + ".");
	}
	
	private static final void incrementValue() {
		try {
			synchronized (SYNCHRONIZATION_OBJECT) {
				SYNCHRONIZATION_OBJECT.wait();
			}
		} catch (InterruptedException e) {
			// Shouldn't happen.
		}
		
		for (int counter = 0; counter < 50000; counter++) {
			value++;
		}
	}
}
