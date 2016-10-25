package day2.myLibrary.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vita on 24.10.2016.
 */
public class Reader {

    final static int MAX_BOOKS_IN_ONE_HANDS = 3;
    private List<PeriodicalIssue> issues;
    private String name;
    private String surname;
    private int age;
    private boolean isBlackList = false;

    public Reader(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        issues = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isBlackList() {
        return isBlackList;
    }

    public boolean addIssue(PeriodicalIssue issue){
        if(isBlackList() || issues.size() == MAX_BOOKS_IN_ONE_HANDS) return false;

        return issues.add(issue);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Reader) || obj == null) return false;

        Reader reader = (Reader) obj;
        return this.name.equals(reader.getName()) &&
                this.surname.equals(reader.getSurname())
                && this.age == reader.getAge();
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isBlackList=" + isBlackList +
                '}';
    }

    public List<PeriodicalIssue> getIssues(){
        return issues;
    }

    public void setBlackList(boolean blackList) {
        isBlackList = blackList;
    }
}
