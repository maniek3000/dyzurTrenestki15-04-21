import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

class UserTest {
    User user= User.create("loginlogin", "haslo","email");

    @org.junit.jupiter.api.Test
    void create() {
        User.create("hgfjgfhj", "Pass", "Email");
    }

    @org.junit.jupiter.api.Test
    public void shouldThrownIllegalArgumentExceptionWhenAnyParameterIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(null, "Pass", "Email"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> User.create("SetLogin", null, "Email"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> User.create("SetLogin", "Pass", null));
            }

    @org.junit.jupiter.api.Test
    public void shouldThrownIllegalArgumentExceptionIfLoginHasLessThen6Letters() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> User.create("Login", "Pass", "Email"));
    }

    @org.junit.jupiter.api.Test
    public void shouldAddBookToBorrows(){
        Book book= new Book("Tytul", "Autor", "Tytul");
        user.addBookToBorrows(book);
        Assertions.assertFalse(user.getBorrowingBooks().isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void shouldSetCreateDate(){
        user.setCreateDate(LocalDate.of(2011,1,1));
        Assertions.assertEquals(user.getCreateDate(),LocalDate.of(2011,1,1));
    }

    @org.junit.jupiter.api.Test
    public void shouldGetLoginPasswordAndEmail(){
        Assertions.assertEquals(user.getLogin(), "loginlogin");
        Assertions.assertEquals(user.getPassword(), "haslo");
        Assertions.assertEquals(user.getEmail(), "email");

    }
}