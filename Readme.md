# Event Management System

The **Event Management System** is a Java-based application that allows users to manage and view events through an admin panel, enabling attendees to register and log in. The system uses MySQL for database management and JDBC for database connectivity.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Contact](#contact)
- [Contributing](#contributing)
- [License](#license)

## Features
1. User Registration and Login
2. Event Creation and Management (Admin)
3. Event Report Generation

## Prerequisites
1. **Java Development Kit (JDK)** - Version 11 or later
2. **IDE (Eclipse, IntelliJ IDEA, or VS Code)** - For Java Development
3. **MySQL Server** - Version 5.7 or later
4. **MySQL Connector/J** - JDBC driver for MySQL

## Setup and Installation

### 1. Install Java JDK
- Download and install the JDK from the [Oracle JDK website](https://www.oracle.com/java/technologies/javase-downloads.html).
- Ensure the JDK is added to your system's PATH.
- Verify the installation by running:
  ```bash
  java -version
  javac -version
  ```

### 2. Install an IDE
- **Eclipse IDE**: Download and install from [Eclipse Downloads](https://www.eclipse.org/downloads/).
    - During installation, select "Eclipse IDE for Java Developers."
- **IntelliJ IDEA**: Download and install from [JetBrains](https://www.jetbrains.com/idea/download/).
- **VS Code**: Download and install from [VS Code Downloads](https://code.visualstudio.com/Download).
    - Ensure you have the Java Extension Pack installed.

### 3. Clone the Repository
- Clone the project repository from GitHub:
  ```bash
  git clone https://github.com/sah-aditya/EventManagementSystem.git
  ```

### 4. Import the Project into Your IDE
#### Eclipse:
1. Open Eclipse.
2. Go to **File > Open Projects from File System...**
3. Select the root directory where the project was cloned.
4. Click **Finish**.

#### IntelliJ IDEA:
1. Open IntelliJ IDEA.
2. Select **Open** and navigate to the folder where you cloned the project.
3. Click **OK**.

#### VS Code:
1. Open VS Code.
2. Go to **File > Open Folder...** and select the project directory.
3. Install Java extensions if prompted.

### 5. Set Up MySQL Database
- Install MySQL and start the MySQL server.
- Log in to MySQL console:
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

### 6. Add MySQL Connector/J to the Project
- Download MySQL Connector/J from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
- **In Eclipse**:
    1. Place the `.jar` file (e.g., `mysql-connector-java-8.0.26.jar`) in the `lib` folder of your project.
    2. Right-click on the project > **Properties**.
    3. Go to **Java Build Path** > **Libraries** > **Add External JARs...**.
    4. Select the MySQL Connector/J `.jar` file and click **Apply and Close**.
- **In IntelliJ IDEA**:
    1. Go to **File > Project Structure > Libraries**.
    2. Click the **+** icon and select **Java**.
    3. Navigate to the `.jar` file and add it to the project.
- **In VS Code**:
    1. Add the `.jar` to your project's `lib` folder.
    2. Ensure it's referenced in the `settings.json` or via classpath configuration in your `launch.json`.

### 7. Configure Database Connection in Code
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
    - In **Eclipse**, open `EventManagementSystem.java`, right-click on the file, and select **Run As > Java Application**.
    - In **IntelliJ IDEA**, right-click on `EventManagementSystem.java` and select **Run**.
    - In **VS Code**, open the integrated terminal and run:
      ```bash
      javac -cp lib/mysql-connector-java-8.0.26.jar src/*.java
      java -cp lib/mysql-connector-java-8.0.26.jar:src EventManagementSystem
      ```

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
