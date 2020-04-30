package model;

import java.util.Objects;

public class PersonV1 {
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private String nrn;

    public PersonV1(String firstName, String lastName, int age, String sex, String nrn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.nrn = nrn;
    }

    public PersonV1() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNrn() {
        return nrn;
    }

    public void setNrn(String nrn) {
        this.nrn = nrn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonV1 personV1 = (PersonV1) o;
        return nrn.equals(personV1.nrn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex, nrn);
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", nrn='" + nrn + '\'' + '}';
    }
}
