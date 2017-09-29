package fi.hh.server.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import fi.haagahelia.course.domain.Student;
//import fi.haagahelia.course.domain.StudentRepository;
import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BOOKDemo(BookRepository repository) {
		return (args) -> {
			//log.info("save a couple of students");
			repository.save(new Book("Neuromancer", "William", "Gibson", 1984, "123456", 9.99));
			repository.save(new Book("Virtual Light", "William", "Gibson", 1991, "67890", 9.99));
			repository.save(new Book("Something", "Bob", "Dole", 1980, "241567", 9.99));
		};
	}
}
