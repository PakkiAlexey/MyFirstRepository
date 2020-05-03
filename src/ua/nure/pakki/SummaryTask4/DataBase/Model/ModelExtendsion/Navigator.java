package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class Navigator extends Model {
    private long idNavigator;
    private String firstName;
    private String lastName;
    private int age;

    public Navigator(){

    }

    public Navigator(long idNavigator, String firstName, String lastName, int age) {
        this.idNavigator = idNavigator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void  setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void  setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getidNavigator() {
        return idNavigator;
    }

    public void  setidNavigator(Long idNavigator) {
        this.idNavigator = idNavigator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Navigator navigator = (Navigator) o;
        return age == navigator.age &&
                firstName.equals(navigator.firstName) &&
                lastName.equals(navigator.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNavigator, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Navigator{" +
                "idNavigator=" + idNavigator +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
