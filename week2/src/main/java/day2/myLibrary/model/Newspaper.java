package day2.myLibrary.model;

/**
 * Created by Vita on 24.10.2016.
 */
public class Newspaper extends PeriodicalIssue {

    public enum Genre {LOCAL_NEWS, INTERNATIONAL_NEWS, NATIONAL_NEWS, FEATURE_ARTICLE }
    private Genre genre;

    public Newspaper(String name, String author, int year, Genre genre) {
        super(name, author, year);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + "Genre: "+genre+"; (Newspaper)";
    }

}
