package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

import java.util.*;

public class Team extends Model {
    private int idTeam;
    private int idNavigator;
    private int idOperator;
    private ArrayList<Integer> stewardesses;
    private ArrayList<Integer> pilots;

    public Team(int idTeam, int idNavigator, int idOperator,int[] stewardesses, int[] pilots) {
        this.idTeam = idTeam;
        this.idNavigator = idNavigator;
        this.idOperator = idOperator;
    }

    public Team() {
    }

    public ArrayList<Integer> getStewardesses() {
        return stewardesses;
    }

    public void setStewardesses(ArrayList<Integer> stewardesses) {
        this.stewardesses = stewardesses;
    }

    public ArrayList<Integer> getPilots() {
        return pilots;
    }

    public void setPilots(ArrayList<Integer> pilots) {
        this.pilots = pilots;
    }

    public int getId() {
        return idTeam;
    }

    public void setId(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getIdNavigator() {
        return idNavigator;
    }

    public void setIdNavigator(int idNavigator) {
        this.idNavigator = idNavigator;
    }

    public int getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(int idOperator) {
        this.idOperator = idOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        Collections.sort(stewardesses);
        Collections.sort(team.stewardesses);
        Collections.sort(pilots);
        Collections.sort(team.pilots);
        return idNavigator == team.idNavigator &&
                idOperator == team.idOperator &&
                stewardesses.equals(team.stewardesses) &&
                pilots.equals(team.pilots);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idTeam, idNavigator, idOperator);

        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", idNavigator=" + idNavigator +
                ", idOperator=" + idOperator +
                ", stewardesses=" + Arrays.toString(stewardesses.toArray()) +
                ", pilots=" + Arrays.toString(pilots.toArray()) +
                '}';
    }
}
