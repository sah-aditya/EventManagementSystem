# Event Management System

The **Event Management System** is a Java-based application that enables users to manage and view events through an admin panel and allows attendees to register and log in. The system uses MySQL for database management and JDBC for database connectivity.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Contact](#contact)

## Features
1. User Registration and Login
2. Event Creation and Management (Admin)
3. Event Report Generation

## Prerequisites
1. **Java Development Kit (JDK)** - Version 11 or later
2. **Eclipse IDE** - for Java Developers
3. **MySQL Server** - Version 5.7 or later
4. **MySQL Connector/J** - JDBC driver for MySQL

## Setup and Installation

### 1. Install Java JDK
- Download and install the JDK from the [Oracle JDK website](https://www.oracle.com/java/technologies/javase-downloads.html).
- Ensure that the JDK is added to your system PATH.
- Verify installation by running `java -version` and `javac -version` in the command prompt or terminal.

### 2. Install Eclipse IDE
- Download and install Eclipse IDE from [Eclipse Downloads](https://www.eclipse.org/downloads/).
- During installation, ensure you have selected "Eclipse IDE for Java Developers".

### 3. Clone the Repository
- Clone the project repository from GitHub:
  ```bash
  git clone https://github.com/sah-aditya/EventManagementSystem.git
  ```
- Open Eclipse and import the cloned project:
  1. Go to **File > Open Projects from File System...**
  2. Select the root directory where the project was cloned.
  3. Click **Finish**.

### 4. Set Up MySQL Database
- Install MySQL and start the MySQL server.
- Log in to the MySQL console with:
  ```bash
  mysql -u root -p
  ```
- Create the `event_management` database and required tables:
  ```sql
  CREATE DATABASE event_management;
  USE event_management;

  CREATE TABLE users (
      id INT AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(50) UNIQUE NOT NULL,
      password VARCHAR(50) NOT NULL,
      role ENUM('admin', 'user') DEFAULT 'user'
  );

  CREATE TABLE events (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      date DATE NOT NULL,
      location VARCHAR(100) NOT NULL,
      organizer_id INT,
      FOREIGN KEY (organizer_id) REFERENCES users(id)
  );
  ```

### 5. Add MySQL Connector/J to the Project
- Download the MySQL Connector/J from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
- Place the downloaded `.jar` file (e.g., `mysql-connector-java-8.0.26.jar`) in the `lib` folder in your project directory.
- In Eclipse:
  1. Right-click on the project > **Properties**.
  2. Go to **Java Build Path** > **Libraries** > **Add External JARs...**.
  3. Select the MySQL Connector/J `.jar` file and click **Apply and Close**.

### 6. Configure Database Connection in Code
- Open `services/DBConnection.java` and update the `url`, `username`, and `password` fields to match your MySQL setup:
  ```java
  String url = "jdbc:mysql://localhost:3306/event_management";
  String username = "root";
  String password = "your_mysql_password";
  ```

## Project Structure
```
EventManagementSystem/
├── src/
│   ├── models/
│   │   └── Event.java
│   ├── services/
│   │   ├── DBConnection.java
│   │   ├── UserService.java
│   │   └── EventService.java
│   ├── utils/
│   │   └── ReportGenerator.java
│   └── EventManagementSystem.java
├── lib/
│   └── mysql-connector-java-8.0.26.jar
└── README.md
```

## Database Schema

1. **Users Table**: Stores information about users (both admin and normal users).
   - `id`: INT, Primary Key
   - `username`: VARCHAR, Unique
   - `password`: VARCHAR
   - `role`: ENUM ('admin', 'user')

2. **Events Table**: Stores information about events.
   - `id`: INT, Primary Key
   - `name`: VARCHAR
   - `date`: DATE
   - `location`: VARCHAR
   - `organizer_id`: INT, Foreign Key referencing `users(id)`

## Usage

1. **Run the Application**:
   - In Eclipse, open `EventManagementSystem.java`.
   - Right-click on the file and select **Run As > Java Application**.

2. **Interact with the Program**:
   - **Login**: Existing users can log in with their credentials.
   - **Register**: New users can register by providing a username and password.
   - **Admin Panel** (for Admin Users): Allows admins to create, update, and delete events.
   - **Report Generation**: The program generates a simple report of all events.

## Troubleshooting

- **Access Denied for MySQL**: Ensure the correct username and password are set in `DBConnection.java`.
- **Missing MySQL Connector/J**: Ensure the connector `.jar` is correctly added to the project’s build path.
- **Invalid Project Name**: Java projects cannot have spaces in their names. Use an underscore instead, e.g., `Event_Management_System`.

## Contact
For any questions, feel free to contact **Aditya Sah** (Admin from Team Kriya Coders) at **[er.adityasah@gmail.com](mailto:er.adityasah@gmail.com)**.

## Contributing
Feel free to fork this repository and contribute. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the custom License.

