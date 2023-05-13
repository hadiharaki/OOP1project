package mongo.api.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>, PagingAndSortingRepository<Book, Integer>{
List<Book> findByBookName(String bookName);
List<Book> findByPrice(double price);
}
