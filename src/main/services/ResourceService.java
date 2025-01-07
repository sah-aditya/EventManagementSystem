package services;

import models.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
