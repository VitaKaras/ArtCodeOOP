package day2.myLibrary.model;

/**
 * Created by Vita on 24.10.2016.
 */
public class Book extends PeriodicalIssue {

    public enum Genre {FICTION, HORROR, COMEDY, DRAMA, TRAGEDY, TRAGICOMEDY, SATIRE}
    private Genre genre;
    private int countTheSameBook;

    public Book(String name, String author, int year, Genre genre) {
        super(name, author, year);
        this.genre = genre;
        countTheSameBook = 1;
    }

    public void setCountTheSameBook(int countTheSameBook) {
        this.countTheSameBook = countTheSameBook;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + "Genre: "+genre+"; (Book)";
    }

    public int getCountTheSameBook() {
        return countTheSameBook;
    }

    public void increaseCountOfTheSameIssue(){
        int count = getCountTheSameBook();
        setCountTheSameBook(++count);
    }

    public void decreaseCountOfTheSameIssue(){
        int count = getCountTheSameBook();
        setCountTheSameBook(--count);
    }


}
