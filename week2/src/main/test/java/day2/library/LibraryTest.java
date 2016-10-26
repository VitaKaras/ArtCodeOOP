package day2.library;

import day2.myLibrary.config.ApplicationContext;
import day2.myLibrary.controller.Library;
import day2.myLibrary.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Vita on 25.10.2016.
 */
public class LibraryTest {

    private static ApplicationContext appContext;
    private static Library library;
    private static List<Reader> readers;
    private static Map<PeriodicalIssue, Integer> issues;

    @Before
    public void init() {
        appContext = ApplicationContext.getInstance();
        library = new Library("#1");
        readers = appContext.getReaderDAO().getReaders();
        issues = appContext.getIssueDAO().getIssues();
    }

    @After
    public void tearDown() {
        appContext = null;
        library = null;
        for(Reader reader : readers){
            reader.getIssues().clear();
        }
        readers.clear();
        issues.clear();
    }

    @Test
    public void TestGetReaders(){
        Reader reader = new Reader("Vita", "Karas", 19);
        Reader reader1 = new Reader("Andrey", "Ivanov", 23);

        appContext.getReaderDAO().addReader(reader);
        appContext.getReaderDAO().addReader(reader1);

        Reader actual =  appContext.getReaderDAO().getReaders().get(0);
        Reader actual1 =  appContext.getReaderDAO().getReaders().get(1);

        Assert.assertEquals(reader, actual);
        Assert.assertEquals(reader1, actual1);

    }

    @Test
    public void TestSortIssuesByName() throws Exception {
        appContext.getIssueDAO().addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        appContext.getIssueDAO().addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN));
        appContext.getIssueDAO().addIssue(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN));

        List<PeriodicalIssue> issues =  library.getIssues(PeriodicalIssue.SortType.NAME);

        Assert.assertEquals(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN), issues.get(0));
        Assert.assertEquals(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR), issues.get(1));
    }

    @Test
    public void TestSortIssuesByYear() throws Exception {
        appContext.getIssueDAO().addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        appContext.getIssueDAO().addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN));
        appContext.getIssueDAO().addIssue(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN));

        List<PeriodicalIssue> issues =  library.getIssues(PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY), issues.get(3));
        Assert.assertEquals(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN), issues.get(0));
    }

    @Test
    public void TestSortIssuesByAuthor() throws Exception {
        appContext.getIssueDAO().addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        appContext.getIssueDAO().addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN));
        appContext.getIssueDAO().addIssue(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN));

        List<PeriodicalIssue> issues =  library.getIssues(PeriodicalIssue.SortType.AUTHOR);

        Assert.assertEquals(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY), issues.get(1));
        Assert.assertEquals(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN), issues.get(4));
    }


    @Test
    public void TestGetIssues() throws Exception {
        appContext.getIssueDAO().addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        appContext.getIssueDAO().addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));
        appContext.getIssueDAO().addIssue(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN));
        appContext.getIssueDAO().addIssue(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN));

        List<PeriodicalIssue> issues = library.getIssues(PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(true, issues.contains(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY)));
        Assert.assertEquals(true, issues.contains(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN)));
    }

    @Test
    public void TestGetBooks(){
        library.addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        library.addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        library.addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));

        List<Book> books = library.getBooks();
        Assert.assertEquals(true, books.contains(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR)));
        Assert.assertEquals(true, books.contains(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY)));

    }

    @Test
    public void TestGetMagazines(){
        library.addIssue(new Magazine("Vegetarian Times", "Active Interest Media", 1974, Magazine.Genre.HEALTH));
        library.addIssue(new Magazine("Prevention", "Diane Salvatore", 1950, Magazine.Genre.HEALTH));
        library.addIssue(new Magazine("Alive", "Stuart Harries", 1974, Magazine.Genre.HEALTH));

        List<Magazine> magazines = library.getMagazines();
        Assert.assertEquals(true, magazines.contains(new Magazine("Vegetarian Times", "Active Interest Media", 1974, Magazine.Genre.HEALTH)));
        Assert.assertEquals(true, magazines.contains(new Magazine("Prevention", "Diane Salvatore", 1950, Magazine.Genre.HEALTH)));

    }

    @Test
    public void TestGetNewspapers(){
        library.addIssue(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE));
        library.addIssue(new Newspaper("International Business Times","Peter S. Goodman", 2006, Newspaper.Genre.FEATURE_ARTICLE));

        List<Newspaper> newspapers = library.getNewspapers();
        Assert.assertEquals(true, newspapers.contains(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS)));
        Assert.assertEquals(true, newspapers.contains(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS)));

    }

    @Test
    public void TestAddReader(){
        library.addReader(new Reader("Vita", "Karas", 19));
        library.addReader(new Reader("Andrey", "Ivanov", 23));

        Assert.assertEquals(2,library.getReaders().size());

    }

    @Test
    public void TestAddIssue() throws Exception {
        library.addIssue(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS));

        Assert.assertEquals(2,library.getIssues(PeriodicalIssue.SortType.YEAR).size());

    }

    @Test
    public void TestGetAvailableIssuesByBook() throws Exception {

        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);

        PeriodicalIssue issue = new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION);
        PeriodicalIssue issue1 = new Book("The Hobbit", "Tolkien", 2002, Book.Genre.FICTION);
        PeriodicalIssue issue2 = new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY);

        library.addIssue(issue);
        library.addIssue(new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION));
        library.addIssue(issue1);
        library.addIssue(new Book("A Demon Made Me Do It","King", 2011, Book.Genre.HORROR));
        library.addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        library.addIssue(issue2);
        library.addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));

        library.giveIssue(reader, issue);
        library.giveIssue(reader, issue1);
        library.giveIssue(reader, issue2);

        List<PeriodicalIssue> books = library.getAvailableIssues(PeriodicalIssue.IssueType.BOOK, PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(true, books.contains(new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION)));
        Assert.assertEquals(true, books.contains(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY)));

    }

    @Test
    public void TestGetAvailableIssuesByMagazine() throws Exception {

        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);

        PeriodicalIssue issue = new  Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN);
        PeriodicalIssue issue1 = new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN);
        PeriodicalIssue issue2 = new Magazine("Vegetarian Times", "Active Interest Media", 1974, Magazine.Genre.HEALTH);

        library.addIssue(new Magazine("Prevention", "Diane Salvatore", 1950, Magazine.Genre.HEALTH));
        library.addIssue(issue);
        library.addIssue(new Magazine("Alive", "Stuart Harries", 1974, Magazine.Genre.HEALTH));
        library.addIssue(issue1);
        library.addIssue(issue2);
        library.addIssue(new Magazine("American Record Guide", "Donald Vroon", 1935, Magazine.Genre.MUSIC));

        library.giveIssue(reader, issue);
        library.giveIssue(reader, issue1);
        library.giveIssue(reader, issue2);

        List<PeriodicalIssue> magazines = library.getAvailableIssues(PeriodicalIssue.IssueType.MAGAZINE, PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(new Magazine("American Record Guide", "Donald Vroon", 1935, Magazine.Genre.MUSIC), magazines.get(0));
        Assert.assertEquals(new Magazine("Prevention", "Diane Salvatore", 1950, Magazine.Genre.HEALTH), magazines.get(1));

    }

    @Test
    public void TestGetAvailableIssuesByNewspaper() throws Exception {

        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);

        PeriodicalIssue issue = new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue issue1 = new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue issue2 = new Newspaper("International Business Times","Peter S. Goodman", 2006, Newspaper.Genre.FEATURE_ARTICLE);

        library.addIssue(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(issue);
        library.addIssue(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(issue1);
        library.addIssue(issue2);
        library.addIssue(new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE));

        library.giveIssue(reader, issue);
        library.giveIssue(reader, issue1);
        library.giveIssue(reader, issue2);

        List<PeriodicalIssue> newspapers = library.getAvailableIssues(PeriodicalIssue.IssueType.NEWSPAPER, PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS), newspapers.get(0));
        Assert.assertEquals(new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE), newspapers.get(1));

    }

    @Test
    public void TestGiveIssue(){
        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);

        PeriodicalIssue issue = new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue issue1 = new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue issue2 = new Newspaper("International Business Times","Peter S. Goodman", 2006, Newspaper.Genre.FEATURE_ARTICLE);
        PeriodicalIssue issue3 = new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE);

        library.addIssue(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(issue);
        library.addIssue(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(issue1);
        library.addIssue(issue2);
        library.addIssue(issue3);

        library.giveIssue(reader, issue);
        library.giveIssue(reader, issue1);
        library.giveIssue(reader, issue2);
        library.giveIssue(reader, issue3);

        List<PeriodicalIssue> issues = reader.getIssues();
        Assert.assertEquals(issue, issues.get(0));
        Assert.assertEquals(issue2, issues.get(2));
        Assert.assertEquals(false, issues.contains(issue3));
    }

    @Test
    public void TestGetIssuesInAllReaders() throws Exception {
        Reader reader = new Reader("Vita", "Karas", 19);
        Reader reader1 = new Reader("Andrey", "Ivanov", 23);

        library.addReader(reader);
        library.addReader(reader1);

        PeriodicalIssue newspaper = new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue newspaper1 = new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue newspaper2 = new Newspaper("International Business Times","Peter S. Goodman", 2006, Newspaper.Genre.FEATURE_ARTICLE);
        PeriodicalIssue magazine = new  Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN);
        PeriodicalIssue magazine1 = new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN);
        PeriodicalIssue magazine2 = new Magazine("Vegetarian Times", "Active Interest Media", 1974, Magazine.Genre.HEALTH);
        PeriodicalIssue book = new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION);
        PeriodicalIssue book1 = new Book("The Hobbit", "Tolkien", 2002, Book.Genre.FICTION);

        library.addIssue(newspaper);
        library.addIssue(newspaper1);
        library.addIssue(book);
        library.addIssue(magazine);
        library.addIssue( newspaper2);
        library.addIssue( magazine1);
        library.addIssue( magazine2);
        library.addIssue( book1);


        library.giveIssue(reader, newspaper);
        library.giveIssue(reader, newspaper1);
        library.giveIssue(reader, book);
        library.giveIssue(reader, magazine);
        library.giveIssue(reader1, newspaper2);
        library.giveIssue(reader1, magazine1);
        library.giveIssue(reader1, magazine2);
        library.giveIssue(reader1, book1);

        List<PeriodicalIssue> issues = library.getIssuesInAllReaders(PeriodicalIssue.SortType.YEAR);
        Assert.assertEquals(newspaper, issues.get(2));
        Assert.assertEquals(magazine1, issues.get(3));
    }

    @Test
    public void TestGetIssuesInReader() throws Exception {
        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);

        PeriodicalIssue newspaper = new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue newspaper1 = new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS);
        PeriodicalIssue magazine = new  Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN);
        PeriodicalIssue book = new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION);

        library.addIssue(newspaper);
        library.addIssue(newspaper1);
        library.addIssue(book);
        library.addIssue(magazine);

        library.giveIssue(reader, newspaper);
        library.giveIssue(reader, newspaper1);
        library.giveIssue(reader, book);
        library.giveIssue(reader, magazine);

        List<PeriodicalIssue> issues = library.getIssuesInReader(reader, PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(newspaper1, issues.get(0));
        Assert.assertEquals(book, issues.get(2));
    }

    @Test
    public void TestAddToBlackList(){
        Reader reader = new Reader("Vita", "Karas", 19);

        library.addReader(reader);
        library.addToBlackList(reader);

        Assert.assertEquals(true, reader.isBlackList());

    }

    @Test
    public void TestGetIssuesByAuthor() throws Exception {
        PeriodicalIssue book = new Book("A Demon Made Me Do It","King", 2011, Book.Genre.HORROR);
        PeriodicalIssue book1 = new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR);
        PeriodicalIssue book2 = new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY);
        PeriodicalIssue book3 = new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY);
        library.addIssue(book);
        library.addIssue(book1);
        library.addIssue(book2);
        library.addIssue(book3);

        List<PeriodicalIssue> issues = library.getIssuesByAuthor("Adams", PeriodicalIssue.SortType.YEAR);

        Assert.assertEquals(book2, issues.get(0));
        Assert.assertEquals(book3, issues.get(1));

    }

    @Test
    public void TestGetIssuesByYear() throws Exception {
        PeriodicalIssue book = new Book("A Demon Made Me Do It","King", 2011, Book.Genre.HORROR);
        PeriodicalIssue book1 = new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR);
        PeriodicalIssue book2 = new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY);
        PeriodicalIssue book3 = new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY);
        library.addIssue(book);
        library.addIssue(book1);
        library.addIssue(book2);
        library.addIssue(book3);

        List<PeriodicalIssue> issues = library.getIssuesByYear(2011, PeriodicalIssue.SortType.AUTHOR);

        Assert.assertEquals(book, issues.get(0));
        Assert.assertEquals(book1, issues.get(1));

    }

    @Test
    public void TestSearchIssueByKeyWord(){
        PeriodicalIssue book = new Book("A Demon Made Me Do It","King", 2011, Book.Genre.HORROR);
        book.addKeyWord("demon");
        book.addKeyWord("fire");
        PeriodicalIssue book1 = new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR);
        book1.addKeyWord("fire");
        PeriodicalIssue book2 = new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY);

        library.addIssue(book);
        library.addIssue(book1);
        library.addIssue(book2);

        List<PeriodicalIssue> issues = library.searchIssueByKeyWords("fire");

        Assert.assertEquals(true, issues.contains(book));
        Assert.assertEquals(true, issues.contains(book1));
        Assert.assertEquals(false, issues.contains(book2));

        List<PeriodicalIssue> issues1 = library.searchIssueByKeyWords("demon");

        Assert.assertEquals(true, issues1.contains(book));
        Assert.assertEquals(false, issues1.contains(book2));

    }
}
