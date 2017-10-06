package fi.hh.server.Bookstore.web;

import java.util.List;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.BookRepository;
import fi.hh.server.Bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
    
    @Autowired
    BookRepository bookstorerepository;
    
    @Autowired
    CategoryRepository categoryrepository;
    
    @RequestMapping(value = {"/", "/index"}, method=RequestMethod.GET)
    public String addBook(Model model){
    	model.addAttribute("bookList", bookstorerepository.findAll());
        return "book";
    }
    
    @RequestMapping(value="/add")
    public String addBook(Book book, Model model)
    {
    	model.addAttribute("book", new Book());
    	// New thing
    	model.addAttribute("categories", categoryrepository.findAll());
    	return "addbook";
    }
    
    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String save(Book book){
    	System.out.println(book.getTitle());
        bookstorerepository.save(book);
        return "redirect:index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	bookstorerepository.delete(id);
    	// ../ means it goes one URL directory back, so it will always go to index
        return "redirect:../index";
    }
    
    // TODO!!!
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Book book, Model model)
    {
    	model.addAttribute("book", bookstorerepository.findOne(id));
    	// New thing
    	model.addAttribute("categories", categoryrepository.findAll());
    	return "editbook";
    }
    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	}
    
    // RESTFUL services
    // RESTful service to get all students
    @RequestMapping(value="/book", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) bookstorerepository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long id) {	
    	return bookstorerepository.findOne(id);
    }       
    
    
}

