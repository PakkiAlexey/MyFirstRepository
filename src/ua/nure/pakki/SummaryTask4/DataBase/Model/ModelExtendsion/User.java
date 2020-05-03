package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;


import java.util.Objects;

public class User extends Model {
    private long idUser;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private long idAirport;
    private String role;

    public static class Builder {
        private long idUser;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private long idAirport;
        private String role;

        public Builder(long idUser) {
            this.idUser = idUser;
        }

        public Builder withFirstName(String firstName){
            this.firstName = firstName;

            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;

            return this;
        }

        public Builder hasLogin(String login){
            this.login = login;

            return this;
        }

        public Builder hasPassword(String password){
            this.password = password;

            return this;
        }

        public Builder workingInAirport(long idAirport){
            this.idAirport = idAirport;

            return this;
        }

        public Builder isRole(String role){
            this.role = role;

            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    private User(Builder builder){
        idUser = builder.idUser;
        idAirport = builder.idAirport;
        firstName = builder.firstName;
        lastName = builder.lastName;
        login = builder.login;
        password = builder.password;
        role = builder.role;
    }

    public User() {
    }

    public long getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getIdAirport() {
        return idAirport;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                idAirport == user.idAirport &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, firstName, lastName, login, password, idAirport, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", airport=" + idAirport +
                ", role=" + role +
                '}';
    }
}
