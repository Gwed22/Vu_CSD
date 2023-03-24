package bookmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author DELL
 */
public class BookManagement {

    private String B_FILE;
    private int numberOfBook;
    private LinkedList<Book> books;

    public BookManagement(String B_FILE) throws BookException {
        if (B_FILE.equals("")) {
            throw new BookException("The URL of books data file can't be empty!");
        } else {
            this.B_FILE = B_FILE;
            this.books = new LinkedList<Book>();
            this.numberOfBook = 0;
        }
    }

    public void loadBooks() throws IOException, BookException {
        File bFile = new File(B_FILE);

        if (!bFile.exists()) {      //checks is file created
            bFile.createNewFile();  //if not, create new file
            System.out.println("The data file Books.txt is not exists. "
                    + "Creating new dta file Books.txt... "
                    + "Done!");
            this.numberOfBook = 0;  //New data file with the number of book is 0
        } else {
            //If file is existed, so loading this data file
            System.out.print("\nThe data file Books.txt is found. "
                    + "Data of books is loading... ");

            BufferedReader br = new BufferedReader(new FileReader(B_FILE));
            try {
                String ID, Title, Price, Author;

                this.numberOfBook = Integer.parseInt(br.readLine());

                for (int i = 0; i < this.numberOfBook; i++) {
                    //Reads answer's information
                    ID = br.readLine();
                    Title = br.readLine();
                    Price = br.readLine();
                    Author = br.readLine();

                    //Creates new instance of Answer and adds to answer bank
                    this.books.add(new Book(Integer.parseInt(ID), Title,
                            Double.parseDouble(Price),
                            Author));
                }
            } finally {
                br.close();
            }
            if (this.numberOfBook < 2) {
                System.out.println("Done! [" + this.numberOfBook + " book]");
            } else {
                System.out.println("Done! [" + this.numberOfBook + " books]");
            }
        }
    }

    public int getSize() {
        return this.numberOfBook;
    }

    public int addBook(int ID, String Title, double Price, String Author) throws BookException {
        this.books.add(new Book(ID, Title, Price, Author));
        return ++this.numberOfBook;
    }

    public int findBookByID(int ID) {
        for (int i = 0; i < this.books.size(); i++) {
            Book b = this.books.get(i);
            if (b.getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public Book getBookByID(int ID) {
        int idx = this.findBookByID(ID);
        if (idx == -1) {
            return null;
        } else {
            return this.books.get(idx);
        }
    }

    public int findBookByTitle(String query) {
        for (int i = 0; i < this.books.size(); i++) {
            Book b = this.books.get(i);
            if ((b.getTitle().toLowerCase()).contains(query.toLowerCase()) == true) {
                return 1;
            }
        }
        return -1;
    }

    public void getBookByTitle(String query) {
        for (int i = 0; i < this.books.size(); i++) {
            Book b = this.books.get(i);
            if ((b.getTitle().toLowerCase()).contains(query.toLowerCase())) {
                b.display();
            }
        }
    }

    public boolean isPriceTheSame(int ID, double newPrice) {
        int idx = this.findBookByID(ID);
        if (this.books.get(idx).getPrice() == newPrice) {
            return true;
        } else {
            return false;
        }
    }

    public void saveBook() throws IOException {
        FileWriter fw = new FileWriter(new File(B_FILE), false);

        try {
            System.out.print("\nBooks are saving into data file Books.txt... ");

            fw.append(String.valueOf(this.numberOfBook) + "\n");

            for (int i = 0; i < this.numberOfBook; i++) {
                int ID = this.books.get(i).getID();
                String Title = this.books.get(i).getTitle();
                double Price = this.books.get(i).getPrice();
                String Author = this.books.get(i).getAuthor();

                fw.append(String.valueOf(ID) + "\n");
                fw.append(Title + "\n");
                fw.append(String.valueOf(Price) + "\n");
                fw.append(Author + "\n");
            }
        } finally {
            fw.close();
            
            if (this.numberOfBook < 2) {
                System.out.println("Done! [" + this.numberOfBook + " book]");
            } else {
                System.out.println("Done! [" + this.numberOfBook + " books]");
            }
        }
    }

    public void showAllBook() {
        for (int i = 0; i < this.numberOfBook; i++) {

            int ID = this.books.get(i).getID();
            String Title = this.books.get(i).getTitle();
            double Price = this.books.get(i).getPrice();
            String Author = this.books.get(i).getAuthor();

            System.out.printf("| %5d| %-20s| $%9.2f| %-21s|\n", ID, Title, Price, Author);
        }
    }

}
