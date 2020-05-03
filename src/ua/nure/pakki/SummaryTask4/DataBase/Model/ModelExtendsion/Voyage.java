package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;
import java.util.Objects;

public class Voyage extends Model {
    private long idVoyage;
    private String name;
    private String placeOfSending;
    private String placeOfArriving;
    private String timeOfSending;
    private String timeOfArriving;
    private long idTeam;
    private long idAirport;
    private boolean status;

    public long getIdTeam() {
        return idTeam;
    }

    public Voyage() {
    }

    public boolean isStatus() {
        return status;
    }

    public long getIdVoyage() {
        return idVoyage;
    }

    public String getName() {
        return placeOfSending + "-" + placeOfArriving;
    }

    public long getIdAirport() {
        return idAirport;
    }

    public String getPlaceOfSending() {
        return placeOfSending;
    }

    public String getPlaceOfArriving() {
        return placeOfArriving;
    }

    public String getTimeOfSending() {
        return timeOfSending;
    }

    public String getTimeOfArriving() {
        return timeOfArriving;
    }


    public static class Builder{
        private long idVoyage;
        private String name;
        private String placeOfSending;
        private String placeOfArriving;
        private String timeOfSending;
        private String timeOfArriving;
        private long idTeam;
        private long idAirport;
        private boolean status;

        public Builder(long idVoyage){
            this.idVoyage = idVoyage;
        }

        public Builder withName(){
            this.name = placeOfSending + "-" + placeOfArriving;

            return this;
        }

        public Builder withTeam(long idTeam){
            this.idTeam = idTeam;

            return this;
        }

        public Builder fromAirport(long idAirport){
            this.idAirport = idAirport;

            return this;
        }

        public Builder fromPlaceOfSending(String placeOfSending){
            this.placeOfSending = placeOfSending;

            return this;
        }

        public Builder toPlaceOfArriving(String placeOfArriving){
            this.placeOfArriving = placeOfArriving;

            return  this;
        }

        public Builder atTimeOfSending(String timeOfSending){
            this.timeOfSending = timeOfSending;

            return this;
        }

        public  Builder atTimeOfArriving(String timeOfArriving){
            this.timeOfArriving = timeOfArriving;

            return this;
        }

        public  Builder isStatus(int status){
            if (status == 0){
                this.status = false;
            }else {
                this.status = true;
            }

            return this;
        }

        public Voyage build(){
             return new Voyage(this);
        }
    }

    private Voyage(Builder builder){
        idVoyage = builder.idVoyage;
        idAirport = builder.idAirport;
        idTeam = builder.idTeam;
        placeOfSending = builder.placeOfSending;
        placeOfArriving = builder.placeOfArriving;
        timeOfSending = builder.timeOfSending;
        timeOfArriving = builder.timeOfArriving;
        status = builder.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voyage)) return false;
        Voyage voyage = (Voyage) o;
        return name.equals(voyage.name) &&
                timeOfSending.equals(voyage.timeOfSending) &&
                timeOfArriving.equals(voyage.timeOfArriving);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timeOfSending, timeOfArriving, idTeam, idAirport);
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "idVoyage=" + idVoyage +
                ", name='" + placeOfSending + "-" + placeOfArriving + '\'' +
                ", placeOfSending='" + placeOfSending + '\'' +
                ", placeOfArriving='" + placeOfArriving + '\'' +
                ", timeOfSending='" + timeOfSending + '\'' +
                ", timeOfArriving='" + timeOfArriving + '\'' +
                ", team=" + idTeam +
                ", airport=" + idAirport +
                ", status=" + status +
                '}';
    }

}
