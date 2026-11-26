package citypulse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResourceDAO {
    public void insert(String type, int id, String location, double amount) throws SQLException {
        String sql = "INSERT OR REPLACE INTO resources(id, type, location, amount) VALUES(?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, type);
            ps.setString(3, location);
            ps.setDouble(4, amount);
            ps.executeUpdate();
        }
    }
}
