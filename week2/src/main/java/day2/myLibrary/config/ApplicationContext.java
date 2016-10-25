package day2.myLibrary.config;

import day2.myLibrary.dao.IssueDAO;
import day2.myLibrary.dao.ReaderDAO;
import day2.myLibrary.database.LibraryDB;

/**
 * Created by Vita on 24.10.2016.
 */
public class ApplicationContext {

    //private LibraryDB libraryDB = LibraryDB.getInstance();
    private ReaderDAO readerDAO;
    private IssueDAO issueDAO;
    private static ApplicationContext applicationContextInstance;

    private ApplicationContext(){
        readerDAO = new ReaderDAO();
        issueDAO = new IssueDAO();
    }

    public static ApplicationContext getInstance(){
        if(applicationContextInstance == null){
            synchronized (ApplicationContext.class){
                if(applicationContextInstance == null){
                    applicationContextInstance = new ApplicationContext();
                }
            }
        }
        return applicationContextInstance;
    }

    public ReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public IssueDAO getIssueDAO() {
        return issueDAO;
    }

    //public LibraryDB getLibraryDB(){return libraryDB;}
}
