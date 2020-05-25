package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends;
import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;

import java.util.Objects;

public class Stewardess extends MemberOfTeam {
    private int idStewardess;
    private String firstName;
    private String lastName;
    int age;

    public Stewardess(int idStewardess, String firstName, String lastName, int age) {
        this.idStewardess = idStewardess;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Stewardess() {
    }

    @Override
    public int getId() {
        return idStewardess;
    }

    @Override
    public void setId(int idStewardess) {
        this.idStewardess = idStewardess;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stewardess Stewardess = (Stewardess) o;
        return age == Stewardess.age &&
                firstName.equals(Stewardess.firstName) &&
                lastName.equals(Stewardess.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStewardess, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Stewardess{" +
                "idStewardess=" + idStewardess +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
