package sample;

import java.io.Serializable;

public class Admin
        implements Serializable
{
    int id;
    String login;
    String password;
    static final long serialVersionUID = 3432063776451490808L;

    public Admin()
    {
        this.id = 0;
        this.login = null;
        this.password = null;
    }

    public Admin(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public int getId(int id)
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return this.login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
