# Employee Management System

A desktop-based **Employee Management System** developed using Java. The project is designed to provide a simple graphical application for managing employee information and performing basic employee-related operations.

This project is being developed step-by-step as a practical Java project, with the development progress maintained through Git and GitHub.

## 💡 Project Idea

The goal of this project is to build a desktop application that can be used to manage employee records in an organization.

The application will provide a graphical interface through which employee information can be entered, viewed, and managed. Employee data will be stored in a MariaDB database, allowing the application to work with persistent data rather than temporary information.

The project also serves as practical experience in developing a complete Java application involving a graphical user interface, database connectivity, and different components working together.

## 🛠️ Tools & Technologies

* **Java** — Main programming language
* **Java Swing** — Graphical User Interface
* **Java AWT** — GUI components and event handling
* **MariaDB** — Database for storing employee information
* **MariaDB JDBC Driver** — JDBC driver used to connect the Java application with MariaDB
* **Apache Ant** — Build system
* **NetBeans IDE** — Development environment
* **Git & GitHub** — Version control and project tracking


## ⚙️ Database Setup

The application currently uses **MariaDB** through JDBC.

Before running the application, make sure:

1. MariaDB is installed and the server is running.
2. A database named `employeeManagementSystemJava` exists.
3. Your MariaDB username and password are configured in `Conn.java`.

### 1. Create the database

Open the MariaDB/MySQL client and run:

```sql
CREATE DATABASE employeeManagementSystemJava;
```

You can verify that it was created with:

```sql
SHOW DATABASES;
```

### 2. Configure your database username and password

Open:

```text
src/employee/management/system/Conn.java
```

Inside the constructor, find the database connection:

```java
c = DriverManager.getConnection(
    "jdbc:mariadb://localhost:3306/employeeManagementSystemJava",
    "YOUR_USERNAME",
    "YOUR_PASSWORD"
);
```

Replace:

- `YOUR_USERNAME` with your MariaDB username
- `YOUR_PASSWORD` with your MariaDB password

For example:

```java
c = DriverManager.getConnection(
    "jdbc:mariadb://localhost:3306/employeeManagementSystemJava",
    "root",
    "your_password"
);
```

**Do not use the example password above as your actual password.**

> **Important:** Do not commit your real database password to GitHub. The credentials in `Conn.java` are currently hardcoded for the local development setup. This will be improved later by moving credentials into a safer configuration method.

### 3. MariaDB JDBC Driver

The project uses:

```java
Class.forName("org.mariadb.jdbc.Driver");
```

Therefore, the **MariaDB JDBC driver JAR** must be available to the project when compiling and running it.

If you clone this repository and get an error such as:

```text
ClassNotFoundException: org.mariadb.jdbc.Driver
```

check that the MariaDB JDBC driver has been added to the project's libraries/classpath.

### 4. Database name and connection details

The current connection expects:

| Setting | Value |
|---|---|
| Database | `employeeManagementSystemJava` |
| Host | `localhost` |
| Port | `3306` |
| Driver | MariaDB JDBC |
| Username | Your MariaDB username |
| Password | Your MariaDB password |

The database name, host and port can also be changed in `Conn.java` if your MariaDB setup is different.

---

## ▶️ Running the Project

After configuring MariaDB and the JDBC driver:

1. Clone the repository.
2. Open the project in your Java IDE.
3. Configure the database credentials in `Conn.java`.
4. Make sure MariaDB is running.
5. Build the project using Apache Ant.
6. Run the application.

The project is still **in development**, so database tables and additional setup requirements will be documented here as new functionality is added.

## 🎯 Purpose

The project is being built to gain practical experience with:

* Core Java and Object-Oriented Programming
* Java Swing/AWT
* Desktop application development
* Event handling
* MariaDB database integration
* JDBC
* Connecting a Java application with a database
* Git and GitHub

## 🚧 Project Status

**In Development**

The application is being developed progressively, and new components and functionality will be added as the project progresses.

---

**Author:** Atul Singh
