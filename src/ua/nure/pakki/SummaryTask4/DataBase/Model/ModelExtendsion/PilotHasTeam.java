package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.Objects;

public class PilotHasTeam  {
   private long idPilot;
   private long idTeam;

    public PilotHasTeam(long idPilot, long idTeam) {
        this.idPilot = idPilot;
        this.idTeam = idTeam;
    }

    public PilotHasTeam() {
    }

    public long getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(long idPilot) {
        this.idPilot = idPilot;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public String toString() {
        return "PilotHasTeam{" +
                "idPilot=" + idPilot +
                ", idTeam=" + idTeam +
                '}';
    }
}
