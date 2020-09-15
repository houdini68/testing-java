package core.collection;

import java.util.ArrayList;
import java.util.List;

class School {
    List getCourses() {
        List list = new ArrayList();
        list.add(new Course(1, "mathematics"));
        list.add(new Course(2, "french"));
        return list;
    }
}
