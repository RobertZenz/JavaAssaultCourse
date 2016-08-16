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

package org.bonsaimind.javaassaultcourse.refactoring;

import java.util.Random;

/**
 * This is worker management program, or at least a prototype there of.
 * <p>
 * Try to read and understand the code first before running it. When you
 * understand what it does, explain where you see problems with this code. Try
 * to execute the following tasks without breaking something:
 * <ul>
 * <li>Add an additional worker before "Matthew", called "Martin".</li>
 * <li>Add an additional job, "Checking".</li>
 * <li>Replace "Soren" with a worker called "Picard".</li>
 * </ul>
 * <p>
 * Afterwards, try to refactor the program into an easier readable and
 * manageable form, execute the above tasks on your refactored program. Assume
 * that worker names are unique and will never repeat.
 * <p>
 * Additional, there is subtle bug which does not manifest itself in this
 * implementation, can you figure out what it is and why it does not cause
 * problems here?
 */
public class WorkerManagementMain {
	private String[] workerNames = new String[22];
	
	private String[] workerJobs = new String[22];
	
	private String[] workerHasTools = new String[22];
	
	private byte workerCount = 0;
	
	public static void main(String[] args) {
		new WorkerManagementMain();
	}
	
	public WorkerManagementMain() {
		// Setup our workers.
		workerNames[0] = "Thomas";
		workerJobs[0] = "Idle";
		workerHasTools[0] = "yes";
		
		workerNames[1] = "Matthew";
		workerJobs[1] = "Idle";
		workerHasTools[1] = "yes";
		
		workerNames[2] = "Marianna";
		workerJobs[2] = "Idle";
		workerHasTools[2] = "no";
		
		workerNames[3] = "Andrea";
		workerJobs[3] = "Idle";
		workerHasTools[3] = "yes";
		
		workerNames[4] = "Soren";
		workerJobs[4] = "Idle";
		workerHasTools[4] = "no";
		
		workerNames[5] = "Lucia";
		workerJobs[5] = "Idle";
		workerHasTools[5] = "yes";
		
		workerCount = 6;
		
		// Assign random tasks.
		workerJobs[new Random().nextInt(workerCount)] = "Assembling";
		workerJobs[new Random().nextInt(workerCount)] = "Assembling";
		workerJobs[new Random().nextInt(workerCount)] = "Assembling";
		
		workerJobs[new Random().nextInt(workerCount)] = "Polishing";
		workerJobs[new Random().nextInt(workerCount)] = "Polishing";
		workerJobs[new Random().nextInt(workerCount)] = "Polishing";
		
		workerJobs[new Random().nextInt(workerCount)] = "Cleaning";
		workerJobs[new Random().nextInt(workerCount)] = "Cleaning";
		workerJobs[new Random().nextInt(workerCount)] = "Cleaning";
		
		// Whoops, reassignment, let's swap out Marianna.
		workerNames[2] = "Susan";
		
		// Print what everyone is doing.
		for (int i = 0; i < workerCount; i++) {
			System.out.println(workerNames[i] + ": " + workerJobs[i] + " | Has tools: " + workerHasTools[i]);
		}
		
		// Let's check if Soren is working at all!
		if (workerJobs[4] != "Assembling" && workerJobs[4] != "Polishing" && workerJobs[4] != "Cleaning") {
			System.out.println();
			System.out.println("Soren isn't working!");
		}
	}
}
