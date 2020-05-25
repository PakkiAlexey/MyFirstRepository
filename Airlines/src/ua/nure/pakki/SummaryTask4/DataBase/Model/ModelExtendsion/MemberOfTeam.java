package ua.nure.pakki.SummaryTask4.DataBase.Model.ModelExtendsion;

import ua.nure.pakki.SummaryTask4.DataBase.Model.Model;

public abstract class MemberOfTeam extends Model {
    public abstract int getId();
    public abstract void setId(int id);

    public abstract void setFirstName(String firstName);
    public abstract String getFirstName();

    public abstract String getLastName();
    public abstract void setLastName(String lastName);

    public abstract void setAge(int age);
    public abstract int getAge();
    }

