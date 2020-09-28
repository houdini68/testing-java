package core.generic;

import model.v1.Course;
import model.v1.School;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericTest {

    @Test
    public void givenMethodReturningListNotGeneric_whenAssigningToGenericList_thenOK() {
        List<Course> courses = new School().getCourses();
        assertThat(courses.size()).isEqualTo(2);
        assertThat(courses.get(0).getId()).isEqualTo(1);
        assertThat(courses.get(0).getName()).isEqualTo("mathematics");
    }
}

