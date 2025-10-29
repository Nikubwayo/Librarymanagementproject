package src.main.java.org.example;


import org.example.DBConnection;

import java.sql.*;

public class BorrowingDAO {

    public void borrowBook(int memberId, int bookId) {
        String sql = "INSERT INTO borrowings (member_id, book_id) VALUES (?, ?)";
        String markBorrowed = "UPDATE books SET is_borrowed = true WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt1 = conn.prepareStatement(sql);
            PreparedStatement stmt2 = conn.prepareStatement(markBorrowed);

            stmt1.setInt(1, memberId);
            stmt1.setInt(2, bookId);
            stmt1.executeUpdate();

            stmt2.setInt(1, bookId);
            stmt2.executeUpdate();

            System.out.println(" Book borrowed successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showBorrowedBooks() {
        String sql = """
                SELECT m.name AS member_name, b.title AS book_title, br.borrow_date
                FROM borrowings br
                JOIN members m ON br.member_id = m.id
                JOIN books b ON br.book_id = b.id;
                """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println(" Borrowed Books:");
            while (rs.next()) {
                System.out.println(rs.getString("member_name") +
                        " borrowed " + rs.getString("book_title") +
                        " on " + rs.getDate("borrow_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


