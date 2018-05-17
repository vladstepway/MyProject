package sample;

public class User
{
    private int id;
    private String Fio;
    private String Login;
    private String Password;

    public User()
    {
        this.id = 0;
        this.Fio = null;
        this.Login = null;
        this.Password = null;
    }

    public User(int id, String Fio, String Login, String Password)
    {
        this.id = id;
        this.Fio = Fio;
        this.Login = Login;
        this.Password = Password;
    }

    public String toString()
    {
        return "Information : " + this.id + this.Fio + this.Login + this.Password;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setFio(String fio)
    {
        this.Fio = fio;
    }

    public String getFio()
    {
        return this.Fio;
    }

    public void setLogin(String login)
    {
        this.Login = login;
    }

    public String getLogin()
    {
        return this.Login;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }

    public String getPassword()
    {
        return this.Password;
    }
}
