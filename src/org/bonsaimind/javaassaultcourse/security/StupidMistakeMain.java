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

package org.bonsaimind.javaassaultcourse.security;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StupidMistakeMain {
	public static void main(String[] args) {
		try (Database database = new Database()) {
			database.open();
			
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.println();
					System.out.println("------------------------");
					System.out.println("Unknown UNIX System 5.0b");
					System.out.println("------------------------");
					
					System.out.print("Username: ");
					String username = scanner.nextLine();
					
					System.out.print("Password: ");
					String password = scanner.nextLine();
					
					int userId = 0;
					
					try {
						userId = database.login(username, password);
					} catch (SQLException e) {
						// Ignore the exception.
					}
					
					if (userId > 0) {
						System.out.println();
						
						while (userId > 0) {
							if (userId == 1) {
								System.out.print("# ");
							} else {
								System.out.print("$ ");
							}
							
							switch (scanner.nextLine()) {
								case "help":
									System.out.println("help");
									System.out.println("info");
									System.out.println("logout");
									System.out.println("shutdown");
									System.out.println("whoami");
									System.out.println("whois");
									break;
								
								case "info":
									System.out.println("Unknown UNIX System 5.0b");
									break;
								
								case "logout":
									userId = 0;
									break;
								
								case "shutdown":
									if (userId == 1) {
										System.out.println("System is going down for halt NOW!");
										return;
									} else {
										System.out.println("Only root can do that!");
									}
									
								case "whoami":
									System.out.println(database.getUsername(Integer.toString(userId)));
									break;
								
								case "whois":
									System.out.print("Please enter user id: ");
									System.out.println(database.getUsername(scanner.nextLine()));
									break;
								
								default:
									System.out.println("command not found");
							}
						}
					} else {
						System.out.println("Invalid login!");
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final class Database implements Closeable {
		Connection connection = null;
		
		public Database() {
			super();
		}
		
		public void open() throws SQLException, ClassNotFoundException {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:mem:memory");
			
			connection.prepareStatement("create table USERS ("
					+ "ID integer,"
					+ "USERNAME varchar(64),"
					+ "PASSWORD varchar(64)"
					+ ");").execute();
			
			connection.prepareStatement("insert into USERS values (1, 'root', 'super$ecretpa$$word');").execute();
			connection.prepareStatement("insert into USERS values (2, 'john', 'doe');").execute();
			connection.prepareStatement("insert into USERS values (3, 'werner', 'MyVoiceIsMyPassport');").execute();
			connection.prepareStatement("insert into USERS values (4, 'guest', 'guest');").execute();
			connection.commit();
		}
		
		public int login(String username, String password) throws SQLException {
			String sql = "select ID from USERS where USERNAME = '" + username + "' and PASSWORD = '" + password + "';";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				return resultSet.getBigDecimal(1).intValue();
			} else {
				return 0;
			}
		}
		
		public String getUsername(String userid) throws SQLException {
			String sql = "select USERNAME from USERS where ID = " + userid + ";";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				return resultSet.getString(1);
			} else {
				return "???";
			}
		}
		
		@Override
		public void close() {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// Ignore the exception.
				}
			}
		}
	}
}
