package day2.myLibrary.controller;

import day2.myLibrary.comparators.*;
import day2.myLibrary.config.ApplicationContext;
import day2.myLibrary.dao.IssueDAO;
import day2.myLibrary.dao.ReaderDAO;
import day2.myLibrary.model.*;

import java.util.*;

/**
 * Created by Vita on 24.10.2016.
 */
public class Library {

    private ApplicationContext context;

    private String name;
    private List<Reader> readers;
    private Map<PeriodicalIssue, Integer> issues;
    private Map<Book, Integer> books = new HashMap<>();
    private Map<Magazine, Integer> magazines = new HashMap<>();
    private Map<Newspaper, Integer> newspapers = new HashMap<>();

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
        List<PeriodicalIssue> periodicalIssues = new ArrayList<>(issues.keySet());
        return sortIssues(periodicalIssues, sortType);
    }

    public List<Book> getBooks() {
        return new ArrayList<Book>(books.keySet());
    }

    public List<Magazine> getMagazines() {
        return new ArrayList<Magazine>(magazines.keySet());
    }

    public List<Newspaper> getNewspapers() {
        return new ArrayList<Newspaper>(newspapers.keySet());
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
                books.put((Book)issue, issues.get(issue));
                return true;
            } else if (issue instanceof Magazine) {
                magazines.put((Magazine) issue, issues.get(issue));
                return true;
            } else if (issue instanceof Newspaper) {
                newspapers.put((Newspaper)issue, issues.get(issue));
                return true;
            }
        }
        return false;
    }

    private Map<Book, Integer> getBookMap(){
        return books;
    }

    public List<PeriodicalIssue> getAvailableIssues(PeriodicalIssue.IssueType issueType, PeriodicalIssue.SortType sortType) throws Exception {
        List<PeriodicalIssue> returnIssues = new ArrayList<>();
        switch (issueType) {
            case BOOK:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(books.keySet()), sortType);
                break;
            case MAGAZINE:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(magazines.keySet()), sortType);
                break;
            case NEWSPAPER:
                returnIssues = sortIssues(new ArrayList<PeriodicalIssue>(newspapers.keySet()), sortType);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return returnIssues;
    }

    public boolean giveIssue(Reader reader, PeriodicalIssue issue) {
        if (reader == null || issue == null || !readerDAO.findReader(reader) || !issueDAO.findIssue(issue))
            return false;

        if(reader.addIssue(issue)){
            int countOfIssues =  issues.get(issue);
            issues.put(issue, --countOfIssues);
            if(countOfIssues == 0) {
                if (issue instanceof Book) {
                    books.remove((Book) issue);
                } else if (issue instanceof Magazine) {
                    magazines.remove((Magazine) issue);
                } else if (issue instanceof Newspaper) {
                    newspapers.remove((Newspaper) issue);
                }
                issues.remove(issue);
                return true;
            }
        }
        return false;
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

    public List<PeriodicalIssue> getIssuesByAuthor(String author, PeriodicalIssue.SortType sortType) throws Exception {
        if(author == null) throw new NullPointerException();

        List<PeriodicalIssue> result = new ArrayList<>();

        List<PeriodicalIssue> periodicalIssues = this.getIssues(sortType);

        for(PeriodicalIssue issue : periodicalIssues) {
            if (issue.getAuthor().equals(author))
                result.add(issue);
        }
        return result;
    }

    public List<PeriodicalIssue> getIssuesByYear(int year, PeriodicalIssue.SortType sortType) throws Exception {
        List<PeriodicalIssue> result = new ArrayList<>();

        List<PeriodicalIssue> periodicalIssues = this.getIssues(sortType);

        for(PeriodicalIssue issue : periodicalIssues){
            if(issue.getYear() == year)
                result.add(issue);
        }
        return result;
    }

    public List<PeriodicalIssue> searchIssueByKeyWords(String word){
        if(word == null) throw new NullPointerException();

        List<PeriodicalIssue> periodicalIssues = new ArrayList<>(issues.keySet());

        List<PeriodicalIssue> result = new ArrayList<>();
        for(PeriodicalIssue issue : periodicalIssues){
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
