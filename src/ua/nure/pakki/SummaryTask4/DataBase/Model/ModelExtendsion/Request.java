package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class Request extends Model {
    private int id;
    private int idTeam;
    private int idVoyage;
    private boolean status;
    private String massage;

    public Request(int id, int idTeam, int idVoyage, boolean status,String massage) {
        this.massage = massage;
        this.id = id;
        this.idTeam = idTeam;
        this.idVoyage = idVoyage;
        this.status = status;
    }

    public Request() {
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
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
