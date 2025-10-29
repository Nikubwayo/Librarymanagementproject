package src.main.java.org.example;

import org.example.DBConnection;

import java.sql.*;

public class BookDAO {

    // Add a new book
    public void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
            System.out.println("✅ Book added: " + title);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update book title
    public void updateBook(int id, String newTitle) {
        String sql = "UPDATE books SET title=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newTitle);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("✅ Book updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a book
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Book deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Show all books
    public void showBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("List of Books:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Borrowed: " + rs.getBoolean("is_borrowed"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

