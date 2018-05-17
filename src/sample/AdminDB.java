package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDB
        implements ElementDao<Admin>
{
    private static final String SELECT_USER = "SELECT * FROM bsuir.admin";
    private static final String INSERT_USER = " insert into admin (login, password) values (?, ?)";
    private static final String UPDATE_USER = "UPDATE admin SET login = ?, password= ? WHERE id_admin = ? ";
    private static final String DELETE_USER = "DELETE FROM bsuir.admin WHERE id_admin= ? ";
    Connector connector;

    public AdminDB()
    {
        this.connector = new Connector();
    }

    public ArrayList<Admin> getAll()
    {
        ArrayList<Admin> AdminLst = new ArrayList();
        try
        {
            Connection conn = this.connector.getDbConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_USER);
            while (rs.next())
            {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id_admin"));
                admin.setLogin(rs.getString("login"));
                admin.setPassword(rs.getString("password"));
                AdminLst.add(admin);
            }
            return AdminLst;
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
        return AdminLst;
    }

    public boolean update(Admin admin)
    {
        return false;
    }

    public boolean delete(int id)
    {
        return false;
    }

    public boolean add(Admin admin)
    {
        return false;
    }
}
