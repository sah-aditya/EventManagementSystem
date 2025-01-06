# Event Management System

The **Event Management System** is a full-stack Java-based application designed to streamline and simplify event management tasks. It empowers users to register, log in, and manage events via a user-friendly interface. Admins have the ability to create, update, and delete events, generate reports, and oversee the system’s operations. The system features a responsive front-end built using HTML, CSS, and JavaScript, alongside a robust MySQL backend for data management. This project is perfect for event planners, organizations, and educational purposes.

---

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
    - [Clone the Repository](#1-clone-the-repository)
    - [Import the Project into Your IDE](#2-import-the-project-into-your-ide)
    - [Set Up MySQL Database](#3-set-up-mysql-database)
    - [Configure Database Connection](#4-configure-database-connection)
    - [Add MySQL Connector/J](#5-add-mysql-connectorj)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Front-End Integration](#front-end-integration)
- [Detailed Features](#detailed-features)
- [Future Enhancements](#future-enhancements)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Contact](#contact)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **User Management:**
    - Registration and Login system with role-based access (User/Admin).
    - Password storage with basic security measures.
- **Event Management:**
    - Admins can create, update, delete, and manage events.
    - View a list of events with relevant details such as date, location, and organizer.
- **Reporting:**
    - Admins can generate event reports in real-time.
- **Professional Front-End:**
    - Fully responsive and interactive UI using HTML, CSS, and JavaScript.
- **Database Management:**
    - MySQL database integration to store and retrieve user and event data securely.
- **Scalable Design:**
    - Easily extendable to include additional features like ticket management or notifications.

---

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK):** Version 11 or later
- **Integrated Development Environment (IDE):** IntelliJ IDEA, Eclipse, or VS Code
- **MySQL Server:** Version 5.7 or later
- **MySQL Connector/J:** JDBC driver for MySQL
- **Maven:** For dependency management and project build
- **Modern Browser:** For accessing and testing the front-end

---

## Setup and Installation

### 1. Clone the Repository
```bash
git clone https://github.com/sah-aditya/EventManagementSystem.git
```

### 2. Import the Project into Your IDE
- Open your IDE (IntelliJ IDEA, Eclipse, or VS Code).
- Import the project as a **Maven Project**.
- Ensure the `pom.xml` file is loaded to download necessary dependencies.

### 3. Set Up MySQL Database
- Start your MySQL server.
- Create the database and tables using the following script:

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

### 4. Configure Database Connection
Edit the `src/services/DBConnection.java` file with your MySQL credentials:
```java
public static final String URL = "jdbc:mysql://localhost:3306/event_management";
public static final String USER = "your_mysql_username";
public static final String PASSWORD = "your_mysql_password";
```

### 5. Add MySQL Connector/J
- Download `mysql-connector-java-x.x.x.jar` from [MySQL Official Website](https://dev.mysql.com/downloads/connector/j/).
- Add the `.jar` file to the `lib/` directory.
- Link the library in your IDE’s project settings.

---

## Project Structure

```plaintext
EventManagementSystem/
├── src/
│   ├── models/
│   │   ├── Event.java
│   │   ├── Resource.java
│   │   └── User.java
│   ├── services/
│   │   ├── DBConnection.java
│   │   ├── EventService.java
│   │   ├── ResourceService.java
│   │   └── UserService.java
│   ├── servlets/
│   │   ├── LoginServlet.java
│   │   ├── ProfileServlet.java
│   │   └── RegisterServlet.java
│   └── utils/
│       └── EventManagementSystem.java
├── resources/
│   ├── static/
│   │   ├── css/
│   │   │   └── styles.css
│   │   ├── js/
│   │   │   └── scripts.js
│   ├── templates/
│   │   ├── dashboard.html
│   │   ├── login.html
│   │   └── register.html
│   └── webapp.WEB-INF/
│       └── jsp/
│           ├── dashboard.jsp
│           ├── events.jsp
│           ├── login.jsp
│           ├── profile.jsp
│           └── register.jsp
├── lib/
│   └── mysql-connector-java-x.x.x.jar
├── event_management.sql
└── pom.xml
```

---

## Database Schema

- **Users Table:**
    - Stores user credentials and roles.
    - Columns: `id`, `username`, `password`, `role`.
- **Events Table:**
    - Stores event details.
    - Columns: `id`, `name`, `date`, `location`, `organizer_id`.

---

## Front-End Integration

- **HTML:** Used for creating structured and semantic pages.
- **CSS:** Provides styling and layout for the application.
- **JavaScript:** Implements interactivity and client-side validation.

---

## Detailed Features

### User Management
- **Registration:** Users can sign up using unique usernames and passwords.
- **Login:** Users can securely log in to the system.
- **Roles:** Role-based access for Admin and regular users.

### Event Management
- **Admin Controls:**
    - Create, update, and delete events.
    - View all events in a table format.
- **User Interaction:**
    - View upcoming events.

### Reporting
- Admins can generate and download event reports (future enhancement).

---

## Future Enhancements

- Integration with email notifications.
- Add attendee management for events.
- Implement secure password hashing.
- Add RESTful APIs for mobile application support.

---

## Usage

1. Run `EventManagementSystem.java` in your IDE.
2. Open `resources/static/login.html` in a browser.
3. Register, log in, and start managing events.

---

## Troubleshooting

- **Database Connection Errors:**
    - Verify the MySQL server is running.
    - Check the credentials in `DBConnection.java`.
- **Missing Dependencies:**
    - Ensure Maven dependencies are resolved.
- **Front-End Display Issues:**
    - Use a modern browser (e.g., Chrome, Edge).

---

## Contact

For any questions or feedback, contact:

**Aditya Sah**  
Email: [er.adityasah@gmail.com](mailto:er.adityasah@gmail.com)

---

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

---

## License

This project is licensed under a [Custom License](./LICENSE).