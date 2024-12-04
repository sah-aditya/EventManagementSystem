---

# Event Management System

The **Event Management System** is a comprehensive Java-based application designed to streamline event management processes. It enables users to register, log in, and manage events through an admin panel. This system features professional front-end integration with HTML, CSS, JavaScript, and Bootstrap for enhanced user experience, alongside a robust MySQL backend for database management.

---

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Front-End Integration](#front-end-integration)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Contact](#contact)
- [Contributing](#contributing)
- [License](#license)

---

## Features
1. **User Registration and Login**
2. **Event Creation and Management (Admin)**
3. **Event Report Generation**
4. **Professional UI/UX with HTML, CSS, Bootstrap**

---

## Prerequisites
1. **Java Development Kit (JDK)** - Version 11 or later
2. **IDE** - Eclipse, IntelliJ IDEA, or VS Code for Java development
3. **MySQL Server** - Version 5.7 or later
4. **MySQL Connector/J** - JDBC driver for MySQL
5. **Modern Browser** - To view the front-end components

---

## Setup and Installation

### 1. Install Java JDK
Follow the instructions in the previous README to install and configure Java JDK.

### 2. Clone the Repository
```bash  
git clone https://github.com/sah-aditya/EventManagementSystem.git  
```  

### 3. Import the Project into Your IDE
Refer to the steps for Eclipse, IntelliJ IDEA, or VS Code provided in the previous README.

### 4. Set Up MySQL Database
Create the `event_management` database and the necessary tables:
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

### 5. Configure Database Connection in Code
Update `src/services/DBConnection.java` with your MySQL credentials.

### 6. Add MySQL Connector/J
Add the MySQL Connector `.jar` to the project's `lib/` folder and link it in your IDE as described in the previous README.

---

## Project Structure

```plaintext  
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
├── frontend/  
│   ├── css/  
│   │   └── styles.css  
│   ├── js/  
│   │   └── scripts.js  
│   ├── login.html  
│   ├── register.html  
│   └── dashboard.html  
├── lib/  
│   └── mysql-connector-java-8.0.26.jar  
└── README.md  
```  

---

## Database Schema

1. **Users Table**: Stores user credentials and roles.
2. **Events Table**: Stores details of events managed in the system.

---

## Front-End Integration

The project includes professional front-end components:
- **HTML**: Structured markup for login, registration, and dashboard pages.
- **CSS**: Styling with Bootstrap and custom styles.
- **JavaScript**: Dynamic interactivity and client-side validations.

Navigate to the `src/resources/static` folder to explore and modify the HTML, CSS, and JS files.

---

## Usage

### 1. Run the Back-End Application
- In Eclipse or IntelliJ IDEA, run `EventManagementSystem.java` as a Java Application.

### 2. View the Front-End
- Open `src/resources/static/login.html` in a browser to access the login page.

### 3. Interact with the System
- Register as a user.
- Login to access the dashboard.
- Admins can manage events.

---

## Troubleshooting
1. **MySQL Errors**: Ensure the database schema matches the `DBConnection.java` configurations.
2. **Missing MySQL Connector**: Ensure the `.jar` file is added to the classpath.
3. **Browser Compatibility**: Use a modern browser for front-end features.

---

## Contact
For questions or suggestions, contact **Aditya Sah** (Team Kriya Coders) at **[er.adityasah@gmail.com](mailto:er.adityasah@gmail.com)**.

---

## Contributing
Contributions are welcome! Fork the repository and create pull requests for enhancements or fixes.

---

## License
This project is licensed under the custom License.

---