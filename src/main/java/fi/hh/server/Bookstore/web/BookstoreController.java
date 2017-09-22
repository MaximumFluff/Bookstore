package fi.hh.server.Bookstore.web;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fi.hh.server.Bookstore.domain.Book;
import fi.hh.server.Bookstore.domain.BookRepository;

@Controller
public class BookstoreController {
    
    @Autowired
    BookRepository bookstorerepository;
    
    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String addBook(Model model){
    	model.addAttribute("bookList", bookstorerepository.findAll());
        return "book";
    }
    
    @RequestMapping(value="/add")
    public String addBook(Book book, Model model)
    {
    	model.addAttribute("book", new Book());
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
        return "redirect:../index";
    }
    
}

