package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class Stewardess extends Model {
    private long idStewardess;
    private String firstName;
    private String lastName;
    private int age;

    public Stewardess(long idStewardess, String firstName, String lastName, int age) {
        this.idStewardess = idStewardess;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Stewardess() {
    }

    public long getIdStewardess() {
        return idStewardess;
    }

    public void setIdStewardess(Long idStewardess) {
        this.idStewardess = idStewardess;
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
        Stewardess that = (Stewardess) o;
        return age == that.age &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
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
