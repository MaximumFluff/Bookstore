package fi.hh.server.Bookstore.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// ID ALWAYS REQUIRED!!! TYPE LONG!!!
	private Long id;
	
	private String title;
	private String firstName;
	private String lastName;
	private int year;
	private String isbn;
	private double price;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Book() {};
	
	public Book(String title, String firstName, String lastName, int year, String isbn, double price, Category category)
	{
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", year="
			+ year + ", isbn=" + isbn + ", price=" + price + ", category=" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", year="
			+ year + ", isbn=" + isbn + ", price=" + price +"]";
			
	}
	
	
}