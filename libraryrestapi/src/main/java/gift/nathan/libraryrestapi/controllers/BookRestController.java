package gift.nathan.libraryrestapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gift.nathan.libraryrestapi.entities.Book;
import gift.nathan.libraryrestapi.services.interfaces.BookService;

@RestController()
@RequestMapping("books")
public class BookRestController {

	private BookService bookService;

	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBook(id);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBook(@RequestBody Book book) {
		bookService.createBook(book);
	}
	
	@PutMapping("/{id}")
	public void createOrUpdateBook(@PathVariable long id, @RequestBody Book book) {
		bookService.createOrUpdateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id) {
		bookService.deleteBook(id);
	}
}
