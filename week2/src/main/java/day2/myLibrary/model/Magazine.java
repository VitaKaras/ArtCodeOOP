package day2.myLibrary.model;

/**
 * Created by Vita on 24.10.2016.
 */
public class Magazine extends PeriodicalIssue {

    public enum Genre {TEEN, GOSSIP, GARDENING, VIDEO_GAMES, FASHION, FOOTBALL, HEALTH, MUSIC}
    private Genre genre;
    private int countTheSameMagazine = 1;

    public Magazine(String name, String author, int year,Genre genre) {
        super(name, author, year);
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + "Genre: "+genre+"; (Magazine)";
    }

    public int getCountTheSameMagazine() {
        return countTheSameMagazine;
    }

    public void setCountTheSameMagazine(int countTheSameMagazine) {
        this.countTheSameMagazine = countTheSameMagazine;
    }

    public void increaseCountOfTheSameIssue(){
        int count = getCountTheSameMagazine();
        setCountTheSameMagazine(++count);
    }

    public void decreaseCountOfTheSameIssue(){
        int count = getCountTheSameMagazine();
        setCountTheSameMagazine(--count);
    }


}
