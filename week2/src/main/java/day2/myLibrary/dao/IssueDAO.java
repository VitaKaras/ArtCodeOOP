package day2.myLibrary.dao;

import day2.myLibrary.database.LibraryDB;
import day2.myLibrary.model.PeriodicalIssue;

import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public class IssueDAO {

    private LibraryDB db;

    public IssueDAO(){
        db = LibraryDB.getInstance();
    }

    public boolean addIssue(PeriodicalIssue issue){
        return db.addIssue(issue);
    }

    public List<PeriodicalIssue> getIssues(){
        return db.getIssues();
    }

    public boolean findIssue(PeriodicalIssue issue){
        return db.findIssue(issue);
    }
}
