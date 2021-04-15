import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.List;


class LibraryTest {
    User user1 = User.create("FirstUser", "Password", "email1@wp.pl");
    User user2 = User.create("SecondUser", "Password", "email2@wp.pl");
    User user3 = User.create("ThirdUser", "Password", "email3@wp.pl");
    User user4 = User.create("FourthUser", "Password", "email4@wp.pl");

    Book book1 = new Book("FirstTitle", "FirstAuthor", "Horror");
    Book book2 = new Book("SecondTitle", "SecondAuthor", "Thriller");
    Book book3 = new Book("ThirdTitle", "FirstAuthor", "Romance");
    Book book4 = new Book("FourthTitle", "ThirdAuthor", "Romance");

    List<User> users = List.of(user1, user2, user3, user4);
    List<Book> books = List.of(book1, book2, book3, book4);
    Library library = new Library(new Address(), users, books);

    @org.junit.jupiter.api.Test
    void shouldThrowUserAlreadyExistException() {
        Assertions.assertThrows(UserAlreadyExistException.class, () -> library.addUser(User.create("ThirdUser", "Password", "email@o2.pl")));
        Assertions.assertThrows(UserAlreadyExistException.class, () -> library.addUser(User.create("AnotherUser", "Pass", "email2@wp.pl")));

    }

    @org.junit.jupiter.api.Test
    void retrieveCreatedUsersBefore() {
        users.get(0).setCreateDate(LocalDate.of(2011, 1, 1));
        users.get(1).setCreateDate(LocalDate.of(2015, 12, 30));
        users.get(2).setCreateDate(LocalDate.of(2000, 5, 22));
        Assertions.assertEquals(List.of(user1, user3), library.retrieveCreatedUsersBefore(LocalDate.of(2013, 1, 1)));
        Assertions.assertEquals(List.of(user1, user3), library.retrieveCreatedUsersBefore(LocalDate.of(2011, 12, 29)));
        Assertions.assertEquals(List.of(user1, user3), library.retrieveCreatedUsersBefore(LocalDate.of(2011, 1, 2)));
    }

    @org.junit.jupiter.api.Test
    void checkBorrowingBook() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.borrowingBook("UnknownUser", "FirstTitle"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.borrowingBook("FirstUser", "UnknownBook"));
        library.borrowingBook("FirstUser", "FirstTitle");
    }
}