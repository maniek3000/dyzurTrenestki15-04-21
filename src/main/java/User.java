import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private String email;
    private LocalDate createDate;
    private List<Book> borrowingBooks;

    private User(String login, String password, String email, LocalDate createDate, List<Book> borrowingBooks) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.borrowingBooks = borrowingBooks;
    }

    public static User create(String login, String password, String email) {
        if (login == null) throw new IllegalArgumentException("Login is null");
        if (password == null) throw new IllegalArgumentException("Password is null");
        if (email == null) throw new IllegalArgumentException("Email is null");
        if (login.length() < 6) throw new IllegalArgumentException();
        List<Book> borrowingBooks= new ArrayList<>();
        return new User(login, password, email, LocalDate.now(), borrowingBooks);
    }

    public void addBookToBorrows(Book book) {
        borrowingBooks.add(book);
    }

    public List<Book> getBorrowingBooks() {
        return borrowingBooks;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
