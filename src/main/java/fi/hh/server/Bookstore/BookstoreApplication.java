package fi.hh.server.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.BookRepository;
import fi.hh.server.Bookstore.domain.Category;
import fi.hh.server.Bookstore.domain.CategoryRepository;
import fi.hh.server.Bookstore.domain.User;
import fi.hh.server.Bookstore.domain.UserRepository;
@SpringBootApplication
public class BookstoreApplication {
	final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BOOKDemo(BookRepository repository, CategoryRepository categoryrepository, UserRepository urepository) {
		return (args) -> {
			
			// Create new users
			User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin","$2a$06$eOmrAyZssl/tG20WWTRhOOpE2UfVq8fp7KMBZgel47qdtf/u.ipt.", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			// save to category repository
			categoryrepository.save(new Category("Science-Fiction"));
			categoryrepository.save(new Category("Horror"));
			categoryrepository.save(new Category("Politics"));
			//log.info("save a couple of students");
			repository.save(new Book("Neuromancer", "William", "Gibson", 1984, "123456", 9.99, categoryrepository.findByName("Science-Fiction").get(0)));
			repository.save(new Book("Virtual Light", "William", "Gibson", 1991, "67890", 9.99, categoryrepository.findByName("Science-Fiction").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
