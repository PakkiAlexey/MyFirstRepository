package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeamExtends;
import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;
import ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion.MemberOfTeam;

import java.util.Objects;

public class Pilot extends MemberOfTeam {
    private int idPilot;
    private String firstName;
    private String lastName;
    int age;

    public Pilot(int idPilot, String firstName, String lastName, int age) {
        this.idPilot = idPilot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Pilot() {
    }

    @Override
    public int getId() {
        return idPilot;
    }

    @Override
    public void setId(int idPilot) {
        this.idPilot = idPilot;
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
        Pilot Pilot = (Pilot) o;
        return age == Pilot.age &&
                firstName.equals(Pilot.firstName) &&
                lastName.equals(Pilot.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPilot, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "idPilot=" + idPilot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
