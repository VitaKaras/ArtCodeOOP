package day2.myLibrary.dao;

import day2.myLibrary.database.LibraryDB;
import day2.myLibrary.model.Reader;

import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public class ReaderDAO {

    private LibraryDB db;

    public ReaderDAO(){
        db = LibraryDB.getInstance();
    }

    public boolean findReader(Reader reader){
        return db.findReader(reader);
    }

    public boolean addReader(Reader reader){
        return db.addReader(reader);
    }

    public List<Reader> getReaders(){
        return db.getReaders();
    }

}
