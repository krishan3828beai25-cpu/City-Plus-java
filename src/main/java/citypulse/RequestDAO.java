package citypulse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestDAO {
    public void insert(int id, String location, String type, String status) throws SQLException {
        String sql = "INSERT OR REPLACE INTO requests(id, location, type, status) VALUES(?,?,?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, location);
            ps.setString(3, type);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    }
}
