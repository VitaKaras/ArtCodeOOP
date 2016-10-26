package day2.myLibrary.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day2.myLibrary.model.*;

/**
 * Created by Vita on 24.10.2016.
 */
public class LibraryDB {

    private static List<Reader> readers;
    private static Map<PeriodicalIssue, Integer> issues;
    private static LibraryDB libraryDBInstance;

    private LibraryDB(){
        readers = new ArrayList<>();
        issues = new HashMap<>();
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

        return issues.containsKey(issue);
    }

    public boolean addReader(Reader reader){
        if(reader == null) return false;

        readers.add(reader);
        return true;
    }

    public boolean addIssue(PeriodicalIssue issue){
        if(issue == null) return false;

        if(findIssue(issue)){
                int countOfIssues =  issues.get(issue);
                issues.put(issue, ++countOfIssues);
        }else {
            issues.put(issue, 1);
            return true;
        }
        return false;
    }


    public boolean deleteReader(Reader reader){
        if(reader == null || readers.isEmpty()) return false;

        return  readers.remove(reader);
    }

    public List<Reader> getReaders(){
        return readers;
    }

    public Map<PeriodicalIssue, Integer> getIssues(){
        return issues;
    }

}
