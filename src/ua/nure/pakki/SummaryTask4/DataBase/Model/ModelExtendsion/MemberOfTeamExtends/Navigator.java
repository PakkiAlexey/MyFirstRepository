package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends;
import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;

import java.util.Objects;

public class Navigator extends MemberOfTeam {
    private int idNavigator;
    private String firstName;
    private String lastName;
    int age;

    public Navigator(int idNavigator, String firstName, String lastName, int age) {
        this.idNavigator = idNavigator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Navigator() {
    }

    @Override
    public int getId() {
        return idNavigator;
    }

    @Override
    public void setId(int idNavigator) {
        this.idNavigator = idNavigator;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Navigator Navigator = (Navigator) o;
        return age == Navigator.age &&
                firstName.equals(Navigator.firstName) &&
                lastName.equals(Navigator.lastName);
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
