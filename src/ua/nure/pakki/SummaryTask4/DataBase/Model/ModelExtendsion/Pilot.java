package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class Pilot extends Model {
    private long idPilot;
    private String firstName;
    private String lastName;
    private int age;

    public Pilot(long idPilot, String firstName, String lastName, int age) {
        this.idPilot = idPilot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Pilot() {
    }

    public long getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(long idPilot) {
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
        Pilot pilot = (Pilot) o;
        return age == pilot.age &&
                Objects.equals(firstName, pilot.firstName) &&
                Objects.equals(lastName, pilot.lastName);
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
