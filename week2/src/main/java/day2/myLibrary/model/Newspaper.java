package day2.myLibrary.model;

/**
 * Created by Vita on 24.10.2016.
 */
public class Newspaper extends PeriodicalIssue {

    public enum Genre {LOCAL_NEWS, INTERNATIONAL_NEWS, NATIONAL_NEWS, FEATURE_ARTICLE }
    private Genre genre;
    private int  countTheSameNewspaper = 1;


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

    public int getCountTheSameNewspaper() {
        return countTheSameNewspaper;
    }

    public void setCountTheSameNewspaper(int countTheSameNewspaper) {
        this.countTheSameNewspaper = countTheSameNewspaper;
    }

    public void increaseCountOfTheSameIssue(){
        int count = getCountTheSameNewspaper();
        setCountTheSameNewspaper(++count);
    }

    public void decreaseCountOfTheSameIssue(){
        int count = getCountTheSameNewspaper();
        setCountTheSameNewspaper(--count);
    }
}
