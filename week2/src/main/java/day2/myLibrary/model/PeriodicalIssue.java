package day2.myLibrary.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public abstract class PeriodicalIssue {

    private String name;
    private String author;
    private int year;
    private List<String> keyWords;
    public enum SortType {NAME, YEAR, AUTHOR}
    public enum IssueType {BOOK, MAGAZINE, NEWSPAPER}

    public PeriodicalIssue(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        keyWords = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PeriodicalIssue) ||obj == null) return false;

        PeriodicalIssue issue = (PeriodicalIssue) obj;
        return this.name.equals(issue.getName()) &&
                this.author.equals(issue.getAuthor())
                && this.year == issue.getYear();
    }

    @Override
    public String toString() {
        return "PeriodicalIssue{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public boolean addKeyWord(String word){
        if(word == null || keyWords.contains(word)) return false;

        return keyWords.add(word);
    }


}
