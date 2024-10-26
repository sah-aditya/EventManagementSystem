package services;

import models.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public void createEvent(Event event) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO events (name, date, location, organizer_id) VALUES (?, ?, ?, ?)");
            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getOrganizerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM events");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Event event = new Event(rs.getInt("id"), rs.getString("name"), rs.getString("date"), rs.getString("location"), rs.getInt("organizer_id"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}
