package citypulse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrafficDAO {
    public void insert(TrafficRecord record) throws SQLException {
        String sql = "INSERT OR REPLACE INTO traffic(id, location, vehicles, congestion) VALUES(?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, record.getId());
            ps.setString(2, record.getLocation());
            ps.setInt(3, record.getVehicleCount());
            ps.setString(4, record.getCongestionLevel());
            ps.executeUpdate();
        }
    }
}
