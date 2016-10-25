package day2.myLibrary.database;

import java.util.ArrayList;
import java.util.List;

import day2.myLibrary.model.*;

/**
 * Created by Vita on 24.10.2016.
 */
public class LibraryDB {

    private static List<Reader> readers;
    private static List<PeriodicalIssue> issues;
    private static LibraryDB libraryDBInstance;

    private LibraryDB(){
        readers = new ArrayList<>();
        issues = new ArrayList<>();
    }

    public static LibraryDB getInstance(){
        if(libraryDBInstance == null){
            synchronized (LibraryDB.class){
                if(libraryDBInstance == null)
                    libraryDBInstance = new LibraryDB();
            }
        }
        return libraryDBInstance;
    }

    public boolean findReader(Reader reader){
        if(reader == null || readers.isEmpty()) return false;

        return readers.contains(reader);
    }

    public boolean findIssue(PeriodicalIssue issue){
        if(issue == null || issues.isEmpty()) return false;

        return issues.contains(issue);
    }

    public boolean addReader(Reader reader){
        if(reader == null) return false;

        readers.add(reader);
        return true;
    }

    public boolean addIssue(PeriodicalIssue issue){
        if(issue == null) return false;

        if(findIssue(issue)){
            if(issue instanceof Book) {
                ((Book) issue).increaseCountOfTheSameIssue();
                issues.remove(issue);
                issues.add(issue);
            }
            else if(issue instanceof Magazine) {
                ((Magazine) issue).increaseCountOfTheSameIssue();
                issues.remove(issue);
                issues.add(issue);
            }
            else if(issue instanceof Newspaper) {
                ((Newspaper) issue).increaseCountOfTheSameIssue();
                issues.remove(issue);
                issues.add(issue);
            }
        }else return issues.add(issue);
        return false;
    }

    public boolean deleteReader(Reader reader){
        if(reader == null || readers.isEmpty()) return false;

        return  readers.remove(reader);
    }

    public List<Reader> getReaders(){
        return readers;
    }

    public List<PeriodicalIssue> getIssues(){
        return issues;
    }

}
