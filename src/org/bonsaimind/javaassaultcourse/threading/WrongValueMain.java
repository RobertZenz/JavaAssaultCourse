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

import java.io.IOException;

/**
 * This program is supposed to start a thread and then exit when return is
 * pressed.
 * <p>
 * Try to answer these questions without executing the program:
 * <ul>
 * <li>Does this program exit when pressing return?</li>
 * </ul>
 * <p>
 * After running the program, try to fix it.
 * <p>
 * Additional questions/tasks when the problem is fixed:
 * <ul>
 * </li>What could you do to simplify this program?</li>
 * </ul>
 */
public class WrongValueMain {
	private static boolean running = false;
	
	public static void main(String[] args) {
		running = true;
		
		Thread thread = new Thread(WrongValueMain::run);
		thread.start();
		
		System.out.println("A thread is running in the background.");
		
		while (thread.isAlive()) {
			System.out.println("The thread is still alive, press return to stop it.");
			
			try {
				System.in.read();
			} catch (IOException e) {
				// Shouldn't happen.
			}
			
			running = false;
			
			try {
				thread.join(500);
			} catch (InterruptedException e) {
				// We really do not care.
			}
		}
	}
	
	private static final void run() {
		while (running) {
			// Do nothing, just keep going on.
		}
	}
}
