package model.v1;

import java.util.ArrayList;
import java.util.List;

public class School {
    public List getCourses() {
        List list = new ArrayList();
        list.add(new Course(1, "mathematics"));
        list.add(new Course(2, "french"));
        return list;
    }
}
