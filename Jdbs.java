package adjava;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class Jdbs {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        try {
            // Register MySQL Connector/J
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Connector/J driver is not found.");
        }

        int ch;
        do {
            System.out.println("1. Create");
            System.out.println("2. Add");
            System.out.println("3. Modify");
            System.out.println("4. Display");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            switch (ch) {
                case 1:
                    createTable(sc);
                    break;
                case 2:
                    addRecord(sc);
                    break;
                case 3:
                    modifyRecord(sc);
                    break;
                case 4:
                    displayRecords();
                    break;
                case 5:
                    deleteRecord(sc);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (ch != 6);

        sc.close();
    }

    private static void createTable(Scanner sc) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");
            if (c != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }

            System.out.print("Enter table name: ");
            String tableName = sc.next();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter number of columns: ");
            int numColumns = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            StringBuilder columnDeclaration = new StringBuilder();
            for (int i = 0; i < numColumns; i++) {
                columnDeclaration.append("column").append(i).append(" ").append("varchar(20)");
                if (i < numColumns - 1) {
                    columnDeclaration.append(", ");
                }
            }

            Statement st = c.createStatement();
            st.executeUpdate("create table " + tableName + " (" + columnDeclaration.toString() + ")");
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    private static void addRecord(Scanner sc) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");

            System.out.print("Enter table name: ");
            String tableName = sc.next();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter number of columns: ");
            int numColumns = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            StringBuilder columnNames = new StringBuilder();
            StringBuilder columnValues = new StringBuilder();

            for (int i = 0; i < numColumns; i++) {
                System.out.print("Enter column name: ");
                String columnName = sc.next();
                sc.nextLine(); // Consume newline left-over

                System.out.print("Enter value: ");
                String columnValue = sc.next();
                sc.nextLine(); // Consume newline left-over

                columnNames.append(columnName).append(",");
                columnValues.append("'").append(columnValue).append("',");
            }

            columnNames.deleteCharAt(columnNames.length() - 1);
            columnValues.deleteCharAt(columnValues.length() - 1);

            PreparedStatement pstmt = c.prepareStatement("insert into " + tableName + " (" + columnNames.toString() + ") values (" + columnValues.toString() + ")");
            pstmt.executeUpdate();

            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }

    private static void modifyRecord(Scanner sc) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");

            System.out.print("Enter table name: ");
            String tableName = sc.next();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter number of columns: ");
            int numColumns = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            StringBuilder condition = new StringBuilder();

            for (int i = 0; i < numColumns; i++) {
                System.out.print("Enter column name: ");
                String columnName = sc.next();
                sc.nextLine(); // Consume newline left-over

                System.out.print("Enter new value: ");
                String newValue = sc.next();
                sc.nextLine(); // Consume newline left-over

                if (i == 0) {
                    condition.append("roll = '").append(newValue).append("'");
                } else {
                    condition.append(" and roll = '").append(newValue).append("'");
                }
            }

            Statement st = c.createStatement();
            st.executeUpdate("update abcd set name = 'new_name', age = 21 where " + condition.toString());
            System.out.println("Record modified successfully.");
        } catch (SQLException e) {
            System.out.println("Error modifying record: " + e.getMessage());
        }
    }

    private static void displayRecords() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from abcd");

            while (rs.next()) {
                System.out.println("Roll: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Age: " + rs.getInt(3));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error displaying records: " + e.getMessage());
        }
    }

    private static void deleteRecord(Scanner sc) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/a", "root", "a");

            System.out.print("Enter table name: ");
            String tableName = sc.next();
            sc.nextLine(); // Consume newline left-over

            System.out.print("Enter condition: ");
            String condition = sc.nextLine();

            Statement st = c.createStatement();
            st.executeUpdate("delete from " + tableName + " where " + condition);
            System.out.println("Record deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        }
    }
}
