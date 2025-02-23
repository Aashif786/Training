package JDBC;

import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class Sqljava {
	public static Scanner sc;
	static int ch;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Sqljava a = new Sqljava();
		do {
			System.out.println("1. Create");
			System.out.println("2. Add");
			System.out.println("3. Modify");
			System.out.println("4. Display");
			System.out.println("5. Delete");
			System.out.println("6. Write Query");
			System.out.println("7. Exit");
			System.out.print("Enter your choice : ");
			sc = new Scanner(System.in);
			ch = sc.nextInt();
			switch (ch) {
				case 1:
					a.create(sc);
					break;
				case 2:
					a.insert(sc);
					break;
				case 3:
					a.update(sc);
					break;
				case 4:
					a.display();
					break;
				case 5:
					a.delete(sc);
					break;
				case 6:
					a.queries(sc);
				case 7:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please choose a valid option.");
					break;
			}
		} while (true);
	}

	static Connection connect() throws SQLException {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");
			if (c != null) {
				System.out.println("DB Connected");
			} else {
				System.out.println("DB Not Connected");
			}
			return c;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	void create(Scanner sc) throws SQLException {
		System.out.println();
		try {
			Connection c = connect();
			String t = sc.nextLine();
			String q = "create table ? (id int not null primary key , name varchar(20), age int )";
			PreparedStatement p = c.prepareStatement(q);
			p.setString(1, t);
			// System.out.println(p);
			p.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("Creation error");
		} finally {
			sc.close();
		}
	}

	void insert(Scanner sc) throws SQLException {
		System.out.println();
		Connection c = connect();
		try {
			System.out.println("Enter the values:\n");
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("Age :");
			int age = sc.nextInt();
			System.out.println("ID  :");
			int id = sc.nextInt();
			String q = "insert into list (id, name, age) values (?,?,?) ;";

			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			p.setString(2, name);
			p.setInt(3, age);
			// System.out.println(p);
			int i = p.executeUpdate();
			System.out.println(i + " row(s) inserted.");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			sc.close();
			sc.close();
		}
	}

	void display() throws SQLException {
		System.out.println();
		Connection c = connect();
		try {
			PreparedStatement p = c.prepareStatement("select * from list");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				System.out.println("ID  :" + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Age : " + rs.getInt(3));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.close();
		}
	}

	void update(Scanner sc) throws SQLException {
		System.out.println();
		Connection c = connect();
		System.out.println("Enter ID:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new name:");
		String name = sc.nextLine();
		PreparedStatement p = c.prepareStatement("update list set  name =? where id = ? ");
		p.setString(1, name);
		p.setInt(2, id);
	}

	void delete(Scanner sc) throws SQLException {
		System.out.println();
	}

	void queries(Scanner sc) throws SQLException {
		sc.nextLine();
		Connection c = connect();
		System.out.println("Welcome to MySQL shell ");
		System.out.println("Note: Only execute select queries...");
		while (true) {
			System.out.print("mysql> ");
			sc.nextLine();
			String query = sc.nextLine();
			if (query.equalsIgnoreCase("exit"))
				System.out.println();
			Statement p = c.createStatement();
			ResultSet rs = p.executeQuery(query);
			while (rs.next()) {
				ResultSetMetaData md = rs.getMetaData();
				int column = md.getColumnCount();
				for (int i = 1; i <= column; i++) {
					System.out.print(md.getColumnName(i) + "\t");
				}
				System.out.println();
				while (rs.next()) {
					for (int i = 1; i <= column; i++) {
						System.out.print(rs.getString(i) + "\t");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}

}
