package mongo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintViolationException;
import mongo.api.exception.BookCollectionException;
import mongo.api.model.Book;
import mongo.api.repository.BookRepository;

public interface BookService {

List<Book> getBook(int pageNumber, int pageSize);
List<Book> getBooksByBookName(String name);
List<Book> getBooksByPrice(double price);
}
