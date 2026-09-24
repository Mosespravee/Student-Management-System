package Student;
import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/student_db";
    static String username = "root";
    static String password = "PASS";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.print("Enter name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            String sql = "INSERT INTO students(name, email, department, age) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, department);
            ps.setInt(4, age);

            ps.executeUpdate();

            System.out.println("Student added successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // View Students
    static void viewStudents() {

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID\tName\tEmail\t\tDepartment\tAge");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getString("department") + "\t\t" +
                        rs.getInt("age")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Search Student
    static void searchStudent() {

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nStudent Found!");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Age: " + rs.getInt("age"));

            } else {

                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Student
    static void updateStudent() {

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new email: ");
            String email = sc.nextLine();

            System.out.print("Enter new department: ");
            String department = sc.nextLine();

            System.out.print("Enter new age: ");
            int age = sc.nextInt();

            String sql = "UPDATE students SET name=?, email=?, department=?, age=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, department);
            ps.setInt(4, age);
            ps.setInt(5, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Student
    static void deleteStudent() {

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}