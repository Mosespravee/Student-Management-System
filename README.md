Student-Management-System
A console-based Student Management System built using Java, JDBC and MySQL.
Student Management System
A console-based Student Management System developed using Java, JDBC, and MySQL.

Technologies Used

- Java
- JDBC
- MySQL
- MySQL Connector/J
- Eclipse IDE

Features

- Add Student
- View Students
- Search Student
- Update Student
- Delete Student

Database

The project uses MySQL with a database named `student_db`.

Table
`students`

| Column | Type |
|---|---|
| id | INT |
| name | VARCHAR |
| email | VARCHAR |
| department | VARCHAR |
| age | INT |

How to Run

1. Install Java JDK.
2. Install MySQL.
3. Create the `student_db` database.
4. Create the `students` table.
5. Add MySQL Connector/J to the project.
6. Update the MySQL username and password in the Java file.
7. Run `StudentManagementSystem.java`.

Project Structure

StudentManagementSystem
├── src
│   └── Student_Management
│       └── StudentManagementSystem.java
├── screenshots
└── README.md
