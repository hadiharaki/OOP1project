package mongo.api.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolationException;
import mongo.api.exception.BookCollectionException;
import mongo.api.model.Book;
import mongo.api.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
@Autowired
	private BookRepository bookRepo;
	


	@Override
	public List<Book> getBook(int pageNumber, int pageSize) {
		Sort sort=Sort.by(Sort.Direction.DESC, "id");
		Pageable pages= PageRequest.of(pageNumber, pageSize, sort);
		return bookRepo.findAll(pages).getContent();
	}



	@Override
	public List<Book> getBooksByBookName(String name) {
	return bookRepo.findByBookName(name);
	}



	@Override
	public List<Book> getBooksByPrice(double price) {
	return bookRepo.findByPrice(price);
	}



	
}
