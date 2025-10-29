package src.main.java.org.example;

import java.sql.*;

public class MemberDAO {

    // Add a new member
    public void addMember(String name, String type) {
        String sql = "INSERT INTO members (name, member_type) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.executeUpdate();
            System.out.println("Member added: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update member name
    public void updateMember(int id, String newName) {
        String sql = "UPDATE members SET name=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println(" Member updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a member
    public void deleteMember(int id) {
        String sql = "DELETE FROM members WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Member deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Show all members
    public void showMembers() {
        String sql = "SELECT * FROM members";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println(" List of Members:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Type: " + rs.getString("member_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
