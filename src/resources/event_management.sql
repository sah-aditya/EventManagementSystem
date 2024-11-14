-- Create database
CREATE DATABASE event_management;

-- Use the database
USE event_management;

-- Create users table
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       role ENUM('admin', 'user') DEFAULT 'user'
);

-- Create events table
CREATE TABLE events (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        date DATE NOT NULL,
                        location VARCHAR(100) NOT NULL,
                        organizer_id INT,
                        FOREIGN KEY (organizer_id) REFERENCES users(id)
);