package fi.hh.server.Bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.BookRepository;
import fi.hh.server.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository repository;
    private CategoryRepository crepository;

    @Test
    public void findByLastnameShouldReturnBook() {
        List<Book> books = repository.findByLastName("Gibson");
        
        assertThat(books).hasSize(2);
        assertThat(books.get(0).getLastName()).isEqualTo("Gibson");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("1984", "George", "Orwell", 1948, "67190", 9.99, crepository.findByName("Science-Fiction").get(0));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteNewBook()
    {
    	Book book = new Book("Microserfs", "Douglas", "Copeland", 1995, "61119", 5.55, crepository.findByName("Politics").get(0));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    	repository.delete(book);
    	assertThat(repository.findByLastName("Copeland")).isNull();
    }

}
