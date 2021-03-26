package gift.nathan.libraryrestapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gift.nathan.libraryrestapi.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Override
    List<Book> findAll();
}
