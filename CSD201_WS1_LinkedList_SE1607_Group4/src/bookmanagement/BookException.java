/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanagement;

/**
 *
 * @author DELL
 */
public class BookException extends Exception {

    /**
     * Creates new ComicException
     *
     * @param message
     */
    public BookException(String message) {
        super(message);
    }

    /**
     * Gets the exception message
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "BookException: " + super.getMessage();
    }
}
