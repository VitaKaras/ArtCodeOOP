package day2.myLibrary.controller;

import day2.myLibrary.comparators.*;
import day2.myLibrary.config.ApplicationContext;
import day2.myLibrary.dao.IssueDAO;
import day2.myLibrary.dao.ReaderDAO;
import day2.myLibrary.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public class Library {

    private ApplicationContext context;

    private String name;
    private List<Reader> readers;
    private List<PeriodicalIssue> issues;
    private List<Book> books = new ArrayList<>();
    private List<Magazine> magazines = new ArrayList<>();
    private List<Newspaper> newspapers = new ArrayList<>();

    private ReaderDAO readerDAO;
    private IssueDAO issueDAO;

    public Library(String name) {
        context = ApplicationContext.getInstance();
        this.name = name;
        readerDAO = context.getReaderDAO();
        issueDAO = context.getIssueDAO();
        readers = readerDAO.getReaders();
        issues = issueDAO.getIssues();
    }

    public List<Reader> getReaders() {
        readers.sort(new NameReaderComparator());
        return readers;
    }

    public List<PeriodicalIssue> getIssues(PeriodicalIssue.SortType sortType) throws Exception {
        return sortIssues(issues, sortType);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public List<Newspaper> getNewspapers() {
        return newspapers;
    }

    private List<PeriodicalIssue> sortIssues(List<PeriodicalIssue> issues, PeriodicalIssue.SortType sortType) throws Exception {
        switch (sortType) {
            case NAME:
                sort(issues, new NamePeriodicalIssueComparator());
                break;
            case YEAR:
                sort(issues, new YearPeriodicalIssueComparator());
                break;
            case AUTHOR:
                sort(issues, new AuthorPeriodicalIssueComparator());
                break;
            default:
                throw new IllegalArgumentException();
        }
        return issues;
    }

    private void sort(List<PeriodicalIssue> issues, Comparator comparator) {
        issues.sort(comparator);
    }

    public boolean addReader(Reader reader) {
        return readers.add(reader);
    }


    public boolean addIssue(PeriodicalIssue issue) {
        if (issueDAO.addIssue(issue)) {
            if (issue instanceof Book) {
                return books.add((Book) issue);
            } else if (issue instanceof Magazine) {
                return magazines.add((Magazine) issue);
            } else if (issue instanceof Newspaper) {
                return newspapers.add((Newspaper) issue);
            }
        }
        return false;
    }

    public List<PeriodicalIssue> getAvailableIssues(PeriodicalIssue.IssueType issueType, PeriodicalIssue.SortType sortType) throws Exception {
        List<PeriodicalIssue> returnIssues = new ArrayList<>();
        switch (issueType) {
            case BOOK:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(books), sortType);
                break;
            case MAGAZINE:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(magazines), sortType);
                break;
            case NEWSPAPER:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(newspapers), sortType);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return returnIssues;
    }

    private boolean decreaseCountOfTheSameIssue(PeriodicalIssue issue) {
        int index = issues.indexOf(issue);
        if (issue instanceof Book) {
            Book book = (Book)issues.get(index);
            ((Book) issue).setCountTheSameBook(book.getCountTheSameBook());
            ((Book) issue).decreaseCountOfTheSameIssue();
            if (((Book) issue).getCountTheSameBook() == 0) {
                issues.remove(issue);
                books.remove(issue);
            }
        } else if (issue instanceof Magazine) {
            Magazine magazine = (Magazine) issues.get(index);
            ((Magazine) issue).setCountTheSameMagazine(magazine.getCountTheSameMagazine());
            ((Magazine) issue).decreaseCountOfTheSameIssue();
            if (((Magazine) issue).getCountTheSameMagazine() == 0) {
                issues.remove(issue);
                magazines.remove(issue);
            }
        } else if (issue instanceof Newspaper) {
            Newspaper newspaper = (Newspaper) issues.get(index);
            ((Newspaper) issue).setCountTheSameNewspaper(newspaper.getCountTheSameNewspaper());
            ((Newspaper) issue).decreaseCountOfTheSameIssue();
            if (((Newspaper) issue).getCountTheSameNewspaper() == 0) {
                issues.remove(issue);
                newspapers.remove(issue);
            }
        }
        return true;
    }


    public boolean giveIssue(Reader reader, PeriodicalIssue issue) {
        if (reader == null || issue == null || !readerDAO.findReader(reader) || !issueDAO.findIssue(issue))
            return false;

        return reader.addIssue(issue) ? decreaseCountOfTheSameIssue(issue) : false;
    }

    public List<PeriodicalIssue> getIssuesInAllReaders(PeriodicalIssue.SortType sortType) throws Exception {
        List<PeriodicalIssue> result = new ArrayList<>();

        for(Reader reader : readers){
            result.addAll(reader.getIssues());
        }
        return sortIssues(result, sortType);
    }

    public List<PeriodicalIssue> getIssuesInReader(Reader reader, PeriodicalIssue.SortType sortType) throws Exception {
        List<PeriodicalIssue> issues = new ArrayList<>();
        if(readerDAO.findReader(reader)){
            issues = reader.getIssues();
        }
        return sortIssues(issues, sortType);
    }

    public boolean addToBlackList(Reader reader){
        if(reader == null || !readers.contains(reader)) return false;

        reader.setBlackList(true);
        return true;
    }

    public List<PeriodicalIssue> getIssuesByAuthor(String author, PeriodicalIssue.SortType sortType){
        if(author == null) throw new NullPointerException();

        List<PeriodicalIssue> result = new ArrayList<>();

        for(PeriodicalIssue issue : issues){
            if(issue.getAuthor().equals(author))
                result.add(issue);
        }
        return result;
    }

    public List<PeriodicalIssue> getIssuesByYear(int year, PeriodicalIssue.SortType sortType){
        List<PeriodicalIssue> result = new ArrayList<>();

        for(PeriodicalIssue issue : issues){
            if(issue.getYear() == year)
                result.add(issue);
        }
        return result;
    }

    public List<PeriodicalIssue> searchIssueByKeyWords(String word){
        if(word == null) throw new NullPointerException();

        List<PeriodicalIssue> result = new ArrayList<>();
        for(PeriodicalIssue issue : issues){
            List<String> keyWords = issue.getKeyWords();
            if(keyWords != null) {
                for (String keyword : keyWords) {
                    if (keyword.equals(word)) {
                        result.add(issue);
                    }
                }
            }
        }
        return result;
    }
}
