package mongo.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int id;
    private User user;
    private List<Book> books;
    private Date date;
    
    public Order(int id, User user, List<Book> books) {
        this.id = id;
        this.user = user;
        this.books = new ArrayList<>(books);
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Date getDate() {
        return date;
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
    
}
