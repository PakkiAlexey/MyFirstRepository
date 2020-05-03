package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;


import java.util.Objects;

public class Airport extends Model {
    private long idAirport;
    private String name;

    public Airport(long idAirport, String name) {
        this.idAirport = idAirport;
        this.name = name;
    }

    public Airport() {
    }

    public void setIdAirport(long idAirport) {
        this.idAirport = idAirport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdAirport() {
        return idAirport;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "idAirport=" + idAirport +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return name.equals(airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAirport, name);
    }
}
