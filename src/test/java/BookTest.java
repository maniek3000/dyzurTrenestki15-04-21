import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book("Title", "Author", "type");

    @org.junit.jupiter.api.Test
    void gettingAuthorAndType(){
        assertEquals(book.getAuthor(), "Author");
        assertEquals(book.getType(), "type");

    }

}