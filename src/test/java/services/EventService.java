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

    public Event getEventById(int id) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM events WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Event(rs.getInt("id"), rs.getString("name"), rs.getString("date"), rs.getString("location"), rs.getInt("organizer_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> getAllEvents() {
        Connection conn = DBConnection.getConnection();
        List<Event> events = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM events");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                events.add(new Event(rs.getInt("id"), rs.getString("name"), rs.getString("date"), rs.getString("location"), rs.getInt("organizer_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public void updateEvent(Event event) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE events SET name = ?, date = ?, location = ?, organizer_id = ? WHERE id = ?");
            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getOrganizerId());
            stmt.setInt(5, event.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int id) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM events WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}