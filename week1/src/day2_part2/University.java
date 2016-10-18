package day2_part2;

import java.util.Arrays;

/**
 * Created by Vita on 09.10.2016.
 */
public class University {

    private String name;
    private Group[] groups;
    private int groupCount;

    public University(String name, int groupSize) {
        this.name = name;
        this.groups = new Group[groupSize];
    }

    public void showGroups() {
        for (int i = 0; i < groupCount; i++) {
            if (groups[i] != null)
                System.out.printf("%d). - %s \n", i + 1, groups[i].getName());
        }
    }

    public void showStudents() {
        for (int i = 0; i < groupCount; i++) {
            groups[i].showStudents();
        }
    }

    public boolean contains(Group group) {
        if (group != null) {
            for (int i = 0; i < groupCount; i++) {
                if (groups[i].equals(group))
                    return true;
            }
        }
        return false;
    }

    public boolean addGroup(Group group) {
        if (groupCount == groups.length || group == null || contains(group)) return false;

        groups[groupCount++] = group;
        return true;
    }

    public boolean deleteGroup(Group group) {
        if (groups == null) return false;

        for (int i = 0; i < groupCount; i++) {
            if (group.equals(groups[i])) {
                System.arraycopy(groups, i + 1, groups, i, groupCount - i - 1);
                groups[--groupCount] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public Group[] getGroups() {
        return groups;
    }

    public int getGroupCount() {
        return groupCount;
    }
}
