package main.java.org.example;

import org.example.BookDAO;
import org.example.BorrowingDAO;
import org.example.MemberDAO;

import java.util.Scanner;

public class MainLb2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();
        BorrowingDAO borrowDAO = new BorrowingDAO();

        while (true) {
            System.out.println("\n=== 📚 Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Show All Members");
            System.out.println("6. Show Borrowed Books");
            System.out.println("7. Update Book Title");
            System.out.println("8. Update Member Name");
            System.out.println("9. Delete Book");
            System.out.println("10. Delete Member");
            System.out.println("0. Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    bookDAO.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter member type (e.g., Student, Adult): ");
                    String type = sc.nextLine();
                    memberDAO.addMember(name, type);
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    int memberId = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    borrowDAO.borrowBook(memberId, bookId);
                    break;

                case 4:
                    bookDAO.showBooks();
                    break;

                case 5:
                    memberDAO.showMembers();
                    break;

                case 6:
                    borrowDAO.showBorrowedBooks();
                    break;

                case 7:
                    System.out.print("Enter book ID to update: ");
                    int updateBookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();
                    bookDAO.updateBook(updateBookId, newTitle);
                    break;

                case 8:
                    System.out.print("Enter member ID to update: ");
                    int updateMemberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    memberDAO.updateMember(updateMemberId, newName);
                    break;

                case 9:
                    System.out.print("Enter book ID to delete: ");
                    int delBookId = sc.nextInt();
                    bookDAO.deleteBook(delBookId);
                    break;

                case 10:
                    System.out.print("Enter member ID to delete: ");
                    int delMemberId = sc.nextInt();
                    memberDAO.deleteMember(delMemberId);
                    break;

                case 0:
                    System.out.println("👋 Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again!");
            }
        }
    }
}
