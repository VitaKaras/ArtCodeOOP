package hw.abstractClass;

import java.util.Arrays;

/**
 * Created by Vita on 11.10.2016.
 */
public class Edition {
    private int year;
    private Book[] books;
    private int bookCount;

    public Edition(int year, int editionSize) {
        this.year = year;
        this.books = new Book[editionSize];
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "year=" + year +
                ", books=" + Arrays.toString(books)+
                '}';
    }
}
