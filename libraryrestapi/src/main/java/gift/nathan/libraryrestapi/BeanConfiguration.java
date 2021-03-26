package gift.nathan.libraryrestapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gift.nathan.libraryrestapi.repositories.BookRepository;
import gift.nathan.libraryrestapi.services.DbConnectedBookService;
import gift.nathan.libraryrestapi.services.interfaces.BookService;

@Configuration
public class BeanConfiguration {

	@Bean
	public BookService getBookService(BookRepository bookRepository) {
		return new DbConnectedBookService(bookRepository);
	}
}
