package mongo.api.resource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolationException;
import mongo.api.exception.BookCollectionException;
import mongo.api.model.Book;
import mongo.api.repository.BookRepository;
import mongo.api.service.BookService;
@RestController
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private BookService bookService;
	@PostMapping("/addBook")
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		
	Optional<Book> optionalBook = repository.findById(book.getID());
	if (optionalBook.isPresent()) {
	return ResponseEntity.badRequest().body("Book with ID " + book.getID() + " already exists.");
	} else {
	repository.save(book);
	return ResponseEntity.ok().body("Added book with ID: " + book.getID());
	}
	}
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
	return repository.findAll();
	}
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id){
	return repository.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
	Optional<Book> book = repository.findById(id);
	if (book.isPresent()) {
	repository.deleteById(id);
	return "Book deleted with ID: " + id;
	} else {
	return "No book found with ID: " + id;
	}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody Book book) {
	boolean exists = repository.existsById(id);
	if (!exists) {
	return ResponseEntity.badRequest().body("The book does not exist with id: " + id);
	}
	Optional<Book> optionalBook = repository.findById(id);
	Book book1 = optionalBook.orElse(null);
	book1.setBookName(book.getBookName());
	book1.setAuthorName(book.getAuthorName());
	book1.setPrice(book.getPrice());
	repository.save(book1);
	return ResponseEntity.ok("Book updated with id: " + id);
	}
	@GetMapping("/findBooks")
	public List<Book> getbooks(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
	return bookService.getBook(pageNumber, pageSize);
	}
	@GetMapping("/filterBooks/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByBookName(name);
    }
	@GetMapping("/filterBooksByPrice/{price}")
	public List<Book> getBooksByPrice(@PathVariable double price){
		return bookService.getBooksByPrice(price);
	}
}
