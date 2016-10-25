package day2.myLibrary.comparators;

import day2.myLibrary.model.PeriodicalIssue;

import java.util.Comparator;

public class YearPeriodicalIssueComparator implements Comparator<PeriodicalIssue>{

    @Override
    public int compare(PeriodicalIssue p1, PeriodicalIssue p2) {
        return p1.getYear() - p2.getYear();
    }
}
