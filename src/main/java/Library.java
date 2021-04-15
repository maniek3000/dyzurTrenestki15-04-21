import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private Address address;
    private final List<User> users;
    private List<Book> books;

    public Library(Address address, List<User> users, List<Book> books) {
        this.address = address;
        this.users = users;
        this.books = books;
    }


    public void addUser(User user) throws UserAlreadyExistException {
        if (users.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()))) {
            throw new UserAlreadyExistException();
        } else if (users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new UserAlreadyExistException();
        } else {
            users.add(user);
        }
    }

    public List<User> retrieveCreatedUsersBefore(LocalDate date) {
        return users.stream().filter(u -> u.getCreateDate().isBefore(date)).collect(Collectors.toList());
    }

    public boolean borrowingBook(String login, String titleOfBook) {
        if (users.stream().noneMatch(u -> u.getLogin().equals(login))) {
            throw new IllegalArgumentException("Nie ma takiego użytkownika");
        }
        if (books.stream().noneMatch(b -> b.getTitle().equals(titleOfBook))) {
            throw new IllegalArgumentException("Nie ma takiej książki");
        }
        users.stream().findFirst()
                .filter(u -> u.getLogin().equals(login)).get()
                .addBookToBorrows(books.stream().findFirst()
                        .filter(b -> b.getTitle().equals(titleOfBook)).get());
        System.out.println("Książkę wypożyczono " + LocalDate.now());
        return true;
    }


}
