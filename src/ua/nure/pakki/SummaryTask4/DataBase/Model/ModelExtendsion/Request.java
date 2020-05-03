package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class Request extends Model {
    private long id;
    private long idTeam;
    private long idVoyage;
    private boolean status;

    public Request(long id, long idTeam, long idVoyage, boolean status) {
        this.id = id;
        this.idTeam = idTeam;
        this.idVoyage = idVoyage;
        this.status = status;
    }

    public Request() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setIdRequest(long id) {
        this.id = id;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public long getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(long idVoyage) {
        this.idVoyage = idVoyage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return id == request.id &&
                idTeam == request.idTeam &&
                idVoyage == request.idVoyage;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTeam, idVoyage, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", idTeam=" + idTeam +
                ", idVoyage=" + idVoyage +
                ", status=" + status +
                '}';
    }
}
