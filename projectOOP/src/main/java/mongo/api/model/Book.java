package mongo.api.model;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {
	private int id;
	@NotNull(message= "bookName cannot be null")
	private String bookName;
	@NotNull(message= "authorName cannot be null")
	private String authorName;
	@NotNull(message= "price cannot be null")
	private double price;
	public int getID() {
	// TODO Auto-generated method stub
	return id;
	}
	public String getBookName() {
	return bookName;
	}
	public String getAuthorName() {
	return authorName;
	}
	public void setId(int id) {
	this.id = id;
	}
	public void setBookName(String bookName) {
	this.bookName = bookName;
	}
	public void setAuthorName(String authorName) {
	this.authorName = authorName;
	}
	public double getPrice() {
	return price;
	}
	public void setPrice(double price) {
	this.price = price;
	}

}
