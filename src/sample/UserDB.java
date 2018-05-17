package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDB
        implements ElementDao<User>
{
    private static final String SELECT_USER = "SELECT * FROM bsuir.user";
    private static final String INSERT_USER = " insert into user (fio, login, password) values (?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE user SET fio = ?, login = ?, password= ? WHERE id = ? ";
    private static final String DELETE_USER = "DELETE FROM bsuir.user WHERE id= ? ";
    Connector connector;

    public UserDB()
    {
        this.connector = new Connector();
    }

    public ArrayList<User> getAll()
    {
        ArrayList<User> UserLst = new ArrayList();
        try
        {
            Connection conn = this.connector.getDbConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_USER);
            while (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFio(rs.getString("fio"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                UserLst.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return UserLst;
    }

    public boolean update(User users)
    {
        try
        {
            PreparedStatement statement = this.connector.getDbConnection().prepareStatement("UPDATE user SET fio = ?, login = ?, password= ? WHERE id = ? ");
            statement.setString(1, users.getFio());
            statement.setString(2, users.getLogin());
            statement.setString(3, users.getPassword());
            statement.executeUpdate();
            return true;
        }
        catch (SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id)
    {
        try
        {
            PreparedStatement statement = this.connector.getDbConnection().prepareStatement("DELETE FROM bsuir.user WHERE id= ? ");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        }
        catch (SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(User users)
    {
        try
        {
            PreparedStatement statement = this.connector.getDbConnection().prepareStatement(" insert into user (fio, login, password) values (?, ?, ?)");
            statement.setString(1, users.getFio());
            statement.setString(2, users.getLogin());
            statement.setString(3, users.getPassword());
            statement.executeUpdate();
            return true;
        }
        catch (SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
