package ua.nure.pakki.SummaryTask4.DataBase.Model;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private static final long serialVersionUID = 8466257860808346236L;

    private long id;

    public abstract int getId();

    public abstract void setId(int id);
}
