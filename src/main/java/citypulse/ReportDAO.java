package citypulse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportDAO {
    public void insert(CityReport report) throws SQLException {
        String sql = "INSERT INTO reports(summary, created_at) VALUES(?,?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, report.getSummary());
            ps.setString(2, report.getGeneratedAt().toString());
            ps.executeUpdate();
        }
    }
}
