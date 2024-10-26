package utils;

import models.Event;
import services.EventService;

import java.util.List;

public class ReportGenerator {

    public void generateEventReport() {
        EventService eventService = new EventService();
        List<Event> events = eventService.getAllEvents();

        System.out.println("Event Report:");
        for (Event event : events) {
            System.out.println("ID: " + event.getId() + ", Name: " + event.getName() + ", Date: " + event.getDate() + ", Location: " + event.getLocation() + ", Organizer ID: " + event.getOrganizerId());
        }
    }
}
