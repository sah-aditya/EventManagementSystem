import models.User;
import models.Event;
import services.UserService;
import services.EventService;
import utils.ReportGenerator;

import java.util.Scanner;

public class EventManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        EventService eventService = new EventService();
        ReportGenerator reportGenerator = new ReportGenerator();

        System.out.println("Welcome to the Event Management System");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User user = userService.login(username, password);
            if (user != null) {
                System.out.println("Login successful! Role: " + user.getRole());
                if ("admin".equals(user.getRole())) {
                    System.out.println("Admin Panel");
                    // Admin functionalities (e.g., generate reports)
                    reportGenerator.generateEventReport();
                } else if ("organizer".equals(user.getRole())) {
                    System.out.println("Organizer Panel");
                    // Organizer functionalities (e.g., create events)
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Enter Event Location: ");
                    String eventLocation = scanner.nextLine();
                    eventService.createEvent(new Event(0, eventName, eventDate, eventLocation, user.getId()));
                    System.out.println("Event created successfully!");
                } else if ("attendee".equals(user.getRole())) {
                    System.out.println("Attendee Panel");
                    // Attendee functionalities
                    // Add options for attendees, like registering for events
                }
            } else {
                System.out.println("Login failed. Please check your username and password.");
            }
        } else if (choice == 2) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Role (admin/organizer/attendee): ");
            String role = scanner.nextLine();
            userService.registerUser(username, password, role);
            System.out.println("User registered successfully!");
        }

        scanner.close();
    }
}
