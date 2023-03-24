package bookmanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class BookDemo {
    
    private static BookManagement bm;
    
    public static void main(String[] args) {
        try {
            bm = new BookManagement("Books.txt");
            bm.loadBooks();
            
            Scanner cin = new Scanner(System.in);  //Creates a scanner
            String func;                              //The function that selected by user

            do {
                System.out.println("+------+---------------------+-----------+----------------------+");
                System.out.println("|  ID  |        Title        |   Price   |      AuthorName      |");
                System.out.println("+------+---------------------+-----------+----------------------+");
                bm.showAllBook();
                System.out.println("+------+---------------------+-----------+----------------------+");

                //Shows menu
                System.out.println("\n---------- BOOK MANAGEMENT PROGRAM ----------");
                System.out.println("1. Add new book.");
                System.out.println("2. Search book by title.");
                System.out.println("3. Update book price.");
                System.out.println("4. Quit.\n");

                //Gets function that selected by user
                System.out.print("  Please select a function: ");
                func = cin.nextLine();
                func = func.replaceAll("\\s\\s+", " ").trim();
                
                String strUserEntered = "";
                int flag = 1;
                
                switch (func) {
                    
                    case "1":
                        
                        System.out.println("\n----- BOOK MANAGEMENT PROGRAM [ADD NEW BOOK] -----");
                        
                        int ID = 0;
                        String Title = "";
                        double Price = 0.0;
                        String Author = "";
                        do {
                            try {
                                flag = 1;
                                System.out.print("Please enter ID of the book: ");
                                ID = Integer.parseInt(cin.nextLine());
                                if (ID <= 0 || ID > 99999) {
                                    System.out.println("Error: Transaction ID must be an integer from 1 to 99999!");
                                    continue;
                                }
                                
                                if (bm.findBookByID(ID) != -1) {
                                    System.out.println("Error: This book ID has been existed!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: The ID must be a number with no space between the digits!");
                                flag = 0;
                            }
                        } while (ID <= 0 || ID > 99999 || bm.findBookByID(ID) != -1 || flag == 0);

                        //Gets the title of book
                        do {
                            System.out.print("Please enter title of the book: ");
                            Title = cin.nextLine();
                            Title = Title.replaceAll("\\s\\s+", " ").trim();
                            if (Title.equals("")) {
                                System.out.println("Error: Book title can't be empty!");
                                continue;
                            }
                            if (Title.length() > 20) {
                                System.out.println("Error: Book title can't have more than 20 characters!");
                            }
                        } while (Title.equals("") || Title.length() > 20);

                        //Gets the rental price of books
                        do {
                            try {
                                flag = 1;
                                System.out.print("Please enter price of the book: ");
                                Price = Double.parseDouble(cin.nextLine());
                                
                                if (Price <= 0) {
                                    System.out.println("Error: Book price must be greater than 0!");
                                    continue;
                                }
                                if (Price >= 1000000) {
                                    System.out.println("Error: Book price must be smaller than 1000000!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: The price must be a number with no space between the digits!");
                                flag = 0;
                            }
                        } while (Price <= 0 || Price >= 1000000 || flag == 0);
                        
                        do {
                            flag = 1;
                            System.out.print("Please enter author of the book: ");
                            Author = cin.nextLine();
                            Author = Author.replaceAll("\\s\\s+", " ").trim();
                            if (Author.equals("")) {
                                System.out.println("Error: Book author name can't be empty!");
                                continue;
                            }
                            if (Author.length() > 20) {
                                System.out.println("Error: Book author name can't have more than 20 characters!");
                                continue;
                            }
                            
                            String regex = "[A-Za-z0-9_.]+";
                            Pattern p = Pattern.compile(regex);
                            Matcher m = p.matcher(Author);
                            
                            if (m.matches() == false) {
                                System.out.println("Error: The author name can't have special character!");
                                flag = 1;
                            }
                            
                        } while (Author.equals("") || Author.length() > 20 || flag == 1);
                        
                        bm.addBook(ID, Title, Price, Author);
                        
                        System.out.println("Your book is created!");
                        
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        System.out.println("|  ID  |        Title        |   Price   |      AuthorName      |");
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        bm.showAllBook();
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        
                        cin.nextLine();
                        break;
                    
                    case "2":
                        
                        System.out.println("\n----- BOOK MANAGEMENT PROGRAM [SEARCH BOOK BY TITLE] -----");
                        do {
                            System.out.print("Please enter  the title you want to search: ");
                            strUserEntered = cin.nextLine();
                            strUserEntered = strUserEntered.replaceAll("\\s\\s+", " ").trim();
                            if (strUserEntered.equals("")) {
                                System.out.println("Error: The query to search can't be empty!");
                            }
                        } while (strUserEntered.equals(""));
                        
                        if (bm.findBookByTitle(strUserEntered) == -1) {
                            System.out.println("\nCan't find the book!");
                        } else {
                            System.out.println("+------+---------------------+-----------+----------------------+");
                            System.out.println("|  ID  |        Title        |   Price   |      AuthorName      |");
                            System.out.println("+------+---------------------+-----------+----------------------+");
                            
                            bm.getBookByTitle(strUserEntered);
                            
                            System.out.println("+------+---------------------+-----------+----------------------+");
                        }
                        cin.nextLine();
                        break;
                    
                    case "3":
                        
                        System.out.println("\n----- BOOK MANAGEMENT PROGRAM [UPDATE BOOK PRICE] -----");
                        
                        ID = 0;
                        Price = 0.0;
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        System.out.println("|  ID  |        Title        |   Price   |      AuthorName      |");
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        bm.showAllBook();
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        
                        do {
                            try {
                                flag = 1;
                                System.out.print("Please enter ID of book you want to change the price: ");
                                ID = Integer.parseInt(cin.nextLine());
                                if (bm.findBookByID(ID) == -1) {
                                    System.out.println("Error: This book ID doesn't exist!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: The ID must be a number with no space between the digits!");
                                flag = 0;
                            }
                        } while (bm.findBookByID(ID) == -1 || flag == 0);
                        
                        do {
                            try {
                                flag = 1;
                                System.out.print("Please enter the new price: ");
                                Price = Double.parseDouble(cin.nextLine());
                                
                                if (Price <= 0) {
                                    System.out.println("Error: Book price must be greater than 0!");
                                    continue;
                                }
                                if (Price >= 1000000) {
                                    System.out.println("Error: Book price must be smaller than 1000000!");
                                    continue;
                                }
                                
                                if (bm.isPriceTheSame(ID, Price)) {
                                    System.out.println("You've entered the old price!");
                                    do {                                        
                                        System.out.print("Do you want to enter another new price? (Yes/No) ");
                                        strUserEntered = cin.nextLine();
                                        strUserEntered = strUserEntered.replaceAll("\\s\\s+", " ").trim();
                                        if (!(strUserEntered.equals("Yes") || strUserEntered.equals("No"))) {
                                            System.out.println("Error: You must type 'Yes' or 'No'!");
                                        }
                                    } while (!(strUserEntered.equals("Yes") || strUserEntered.equals("No")));
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: The price must be a number with no space between the digits!");
                                flag = 0;
                            }
                        } while (Price <= 0 || Price >= 1000000 || flag == 0 || (bm.isPriceTheSame(ID, Price) && strUserEntered.equals("Yes")));
                        
                        bm.getBookByID(ID).setPrice(Price);
                        
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        System.out.println("|  ID  |        Title        |   Price   |      AuthorName      |");
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        bm.showAllBook();
                        System.out.println("+------+---------------------+-----------+----------------------+");
                        
                        cin.nextLine();
                        break;
                    
                    case "4":
                        System.out.println("\n----------------------------");
                        System.out.println("Thank you for using our software!\n" + "See you again!");
                        break;
                    default:
                        System.out.println("Error: The function must be an integer from 1 to 4!");
                }
            } while (!func.equals("4"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bm.saveBook();
            } catch (Exception e) {
                System.out.println("Exception: can't save the books");
            }
            
        }
    }
}
