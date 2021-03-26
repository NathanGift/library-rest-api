package gift.nathan.libraryrestapi.services.interfaces;

import java.util.List;

import gift.nathan.libraryrestapi.entities.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public Book getBook(long id);

	public void createBook(Book book);

	public void deleteBook(long id);

	public void createOrUpdateBook(long id, Book book);

}
