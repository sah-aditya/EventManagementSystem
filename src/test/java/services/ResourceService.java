package services;

import models.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceService {

    public void bookResource(Resource resource) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO resources (name, event_id) VALUES (?, ?)");
            stmt.setString(1, resource.getName());
            stmt.setInt(2, resource.getEventId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Resource getResourceById(int id) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM resources WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Resource(rs.getInt("id"), rs.getString("name"), rs.getInt("event_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Resource> getAllResources() {
        Connection conn = DBConnection.getConnection();
        List<Resource> resources = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM resources");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resources.add(new Resource(rs.getInt("id"), rs.getString("name"), rs.getInt("event_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

    public void updateResource(Resource resource) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE resources SET name = ?, event_id = ? WHERE id = ?");
            stmt.setString(1, resource.getName());
            stmt.setInt(2, resource.getEventId());
            stmt.setInt(3, resource.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteResource(int id) {
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM resources WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}