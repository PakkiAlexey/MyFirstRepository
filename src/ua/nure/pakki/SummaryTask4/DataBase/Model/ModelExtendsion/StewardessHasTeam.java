package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class StewardessHasTeam {
    private long idStewardess;
    private long idTeam;

    public StewardessHasTeam(long idStewardess, long idTeam) {
        this.idStewardess = idStewardess;
        this.idTeam = idTeam;
    }

    public StewardessHasTeam() {
    }

    public long getIdStewardess() {
        return idStewardess;
    }

    public void setIdStewardess(long idStewardess) {
        this.idStewardess = idStewardess;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StewardessHasTeam)) return false;
        StewardessHasTeam that = (StewardessHasTeam) o;
        return idStewardess == that.idStewardess &&
                idTeam == that.idTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStewardess, idTeam);
    }

    @Override
    public String toString() {
        return "StewardessHasTeam{" +
                "idStewardess=" + idStewardess +
                ", idTeam=" + idTeam +
                '}';
    }
}
