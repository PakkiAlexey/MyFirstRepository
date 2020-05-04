package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends;
import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;

import java.util.Objects;

public class Operator extends MemberOfTeam {
    private int idOperator;
    private String firstName;
    private String lastName;
    int age;

    public Operator(int idOperator, String firstName, String lastName, int age) {
        this.idOperator = idOperator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Operator() {
    }

    @Override
    public int getId() {
        return idOperator;
    }

    @Override
    public void setId(int idOperator) {
        this.idOperator = idOperator;
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
        Operator operator = (Operator) o;
        return age == operator.age &&
                firstName.equals(operator.firstName) &&
                lastName.equals(operator.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperator, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "idOperator=" + idOperator +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
