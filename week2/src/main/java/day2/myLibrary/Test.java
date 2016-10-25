package day2.myLibrary;

import day2.myLibrary.controller.Library;
import day2.myLibrary.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Library library = new Library("#1");

        Reader reader1= new Reader("Vita", "Karas",19);

        library.addReader(reader1);
        library.addReader(new Reader("Kate", "Smith",23));
        library.addReader(new Reader("Bill", "Parker", 20));

        PeriodicalIssue hg = new Book("The Hunger Games", "Collins", 2008, Book.Genre.FICTION);
        List<String> kwHG = new ArrayList<>();
        kwHG.add("game");
        kwHG.add("female hero");
        kwHG.add("self survival");
        kwHG.add("propaganda");
        kwHG.add("train");
        hg.setKeyWords(kwHG);

        PeriodicalIssue sov = new Book("A Shade of Vampire", "Forrest", 2012, Book.Genre.HORROR);
        sov.addKeyWord("train");

        library.addIssue(hg);
        library.addIssue(hg);
        library.addIssue(hg);
        library.addIssue(new Book("Harry Potter and the Sorcerer's Stone", "Rowling", 1997, Book.Genre.FICTION));
        library.addIssue(new Book("The Hobbit", "Tolkien", 2002, Book.Genre.FICTION));
        library.addIssue(sov);
        library.addIssue(new Book("A Demon Made Me Do It","King", 2011, Book.Genre.HORROR));
        library.addIssue(new Book("Fire with Fire", "King", 2011, Book.Genre.HORROR));
        library.addIssue(new Book("The Hitchhiker's Guide to the Galaxy", "Adams", 1995, Book.Genre.COMEDY));
        library.addIssue(new Book("The Restaurant at the End of the Universe", "Adams", 1997, Book.Genre.COMEDY));

        library.addIssue(new Magazine("American Cheerleader", "Varsity Spirit", 1995, Magazine.Genre.TEEN));
        library.addIssue(new Magazine("Girlfriend", "Pacific Magazines", 1988, Magazine.Genre.TEEN));
        library.addIssue(new Magazine("Vegetarian Times", "Active Interest Media", 1974, Magazine.Genre.HEALTH));
        library.addIssue(new Magazine("Prevention", "Diane Salvatore", 1950, Magazine.Genre.HEALTH));
        library.addIssue(new Magazine("Alive", "Stuart Harries", 1974, Magazine.Genre.HEALTH));
        library.addIssue(new Magazine("American Record Guide", "Donald Vroon", 1935, Magazine.Genre.MUSIC));
        library.addIssue(new Magazine("DJ Times", "Jim Tremayne", 1988, Magazine.Genre.MUSIC));

        library.addIssue(new Newspaper("USA Today","Patty Michalski", 1982, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(new Newspaper("Star Tribune","Rene Sanchez", 1867, Newspaper.Genre.LOCAL_NEWS));
        library.addIssue(new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE));
        library.addIssue(new Newspaper("International Business Times","Peter S. Goodman", 2006, Newspaper.Genre.FEATURE_ARTICLE));
        library.addIssue(new Newspaper("The Wall Street Journal","Gerard Baker", 1889, Newspaper.Genre.FEATURE_ARTICLE));

        List<Reader> readers = library.getReaders();
        for(Reader reader : readers)
            System.out.println(reader);

        System.out.println();
        System.out.println("Sorting by year");
        System.out.println();

        List<PeriodicalIssue> issues = library.getIssues(PeriodicalIssue.SortType.YEAR);
        for (PeriodicalIssue issue: issues){
            System.out.println(issue);
        }

        System.out.println();
        System.out.println("Sorting by name");
        System.out.println();

        List<PeriodicalIssue> availableIssues = library.getAvailableIssues(PeriodicalIssue.IssueType.BOOK, PeriodicalIssue.SortType.NAME);
        for (PeriodicalIssue issue: availableIssues){
            System.out.println(issue);
        }

        library.giveIssue(reader1,new Book("The Hunger Games", "Collins", 2008, Book.Genre.FICTION));
        library.giveIssue(reader1,new Book("The Hunger Games", "Collins", 2008, Book.Genre.FICTION));
        library.giveIssue(reader1, new Newspaper("Financial Times","Lionel Barber", 1888, Newspaper.Genre.FEATURE_ARTICLE));

        System.out.println();
        System.out.println("List of Vita`s issues ");
        System.out.println();

        List<PeriodicalIssue> vitaIssues = reader1.getIssues();
        for(PeriodicalIssue issue : vitaIssues){
            System.out.println(issue);
        }

        System.out.println();
        System.out.println("Sorting by name");
        System.out.println();

        List<PeriodicalIssue> availableIssues2 = library.getAvailableIssues(PeriodicalIssue.IssueType.BOOK, PeriodicalIssue.SortType.NAME);
        for (PeriodicalIssue issue: availableIssues2){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues1 = library.getIssues(PeriodicalIssue.SortType.YEAR);
        for (PeriodicalIssue issue: issues1){
            System.out.println(issue);
        }

        System.out.println();

        List<Book> books = library.getBooks();
        for(Book book : books){
            System.out.println(book);
        }

        System.out.println();


        List<PeriodicalIssue> issues2 = library.getIssuesInAllReaders(PeriodicalIssue.SortType.YEAR);
        for (PeriodicalIssue issue: issues2){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues3 = library.getIssuesInReader(reader1, PeriodicalIssue.SortType.AUTHOR);
        for (PeriodicalIssue issue: issues3){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues4 = library.getIssuesByAuthor("King", PeriodicalIssue.SortType.YEAR);
        for (PeriodicalIssue issue: issues4){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues5 = library.getIssuesByYear(1988, PeriodicalIssue.SortType.YEAR);
        for (PeriodicalIssue issue: issues5){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues6 = library.searchIssueByKeyWords("self survival");
        for (PeriodicalIssue issue: issues6){
            System.out.println(issue);
        }

        System.out.println();

        List<PeriodicalIssue> issues7 = library.searchIssueByKeyWords("train");
        for (PeriodicalIssue issue: issues7){
            System.out.println(issue);
        }


    }
}
