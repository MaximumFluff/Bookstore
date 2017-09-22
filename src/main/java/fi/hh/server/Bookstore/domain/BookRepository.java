package fi.hh.server.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>
{
	List<Book> findByLastName(String lastName);
	List<Book> findByFirstNameAndLastName(String firstName, String lastName);
	// Enabling ignoring case
	List<Book> findByLastNameIgnoreCase(String lastName);
	// Enabling ORDER BY for a query
	List<Book> findByLastNameOrderByFirstNameAsc(String lastName);
}
