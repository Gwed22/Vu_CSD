package bookmanagement;

/**
 *
 * @author DELL
 */
public class Book {

    private int ID;
    private String Title;
    private double price;
    private String Author;

    public void setID(int ID) throws BookException {
        if (ID < 0) {
            throw new BookException("Book ID must be a positive integer!");
        } else {
            this.ID = ID;
        }
    }

    public void setTitle(String Title) throws BookException {
        if (Title.equals("")) {
            throw new BookException("Book title can't be empty!");
        } else {
            this.Title = Title;
        }
    }

    public void setPrice(double price) throws BookException {
        if (price <= 0) {
            throw new BookException("Book price must be greater than 0!");
        } else {
            this.price = price;
        }
    }

    public void setAuthor(String Author) throws BookException {
        if (Author.equals("")) {
            throw new BookException("Book author can't be empty!");
        } else {
            this.Author = Author;
        }
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return Author;
    }

    public Book(int ID, String Title, double price, String Author) {
        this.ID = ID;
        this.Title = Title;
        this.price = price;
        this.Author = Author;
    }

    @Override
    public String toString() {
        return this.Title + "\n";
    }

    public void display() {
        System.out.printf("| %5d| %-20s| $%9.2f| %-21s|\n", ID, Title, price, Author);
    }
}
