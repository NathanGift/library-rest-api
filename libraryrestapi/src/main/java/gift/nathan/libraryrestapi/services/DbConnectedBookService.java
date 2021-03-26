package gift.nathan.libraryrestapi.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import gift.nathan.libraryrestapi.entities.Book;
import gift.nathan.libraryrestapi.repositories.BookRepository;
import gift.nathan.libraryrestapi.services.interfaces.BookService;

public class DbConnectedBookService implements BookService {

	private BookRepository bookRepository;

	public DbConnectedBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(long id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void createBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(long id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		bookRepository.deleteById(id);
	}

	@Override
	public void createOrUpdateBook(long id, Book updatedBook) {
		bookRepository.findById(id).map(book -> {
			book.setTitle(updatedBook.getTitle());
			book.setAuthors(updatedBook.getAuthors());
			return bookRepository.save(book);
		}).orElseGet(() -> {
			updatedBook.setId(id);
			return bookRepository.save(updatedBook);
		});
	}

}
