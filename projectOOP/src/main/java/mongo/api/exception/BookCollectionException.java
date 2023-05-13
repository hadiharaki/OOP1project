package mongo.api.exception;

public class BookCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public BookCollectionException(String message) {
	super(message);
}
public static String NotFoundException(String id) {
	return "Book with "+id+" not found";
}
public static String BookAlreadyExists() {
	return "Book with given name already exists";
}

}
