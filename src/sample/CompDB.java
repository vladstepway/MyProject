package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompDB
        implements ElementDao<Computer>
{
    Connector connector;
    private static final String SELECT_COMP = "SELECT * FROM bsuir.computer";
    private static final String INSERT_COMP = "INSERT INTO computer(type_comp, proc_name, proc_freq, proc_memory, video_memory, dvd_privod, cores, type_display, resolution,price) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_COMP = "UPDATE flat SET type_computer = ?, proc_name=?, proc_freq= ?, proc_memory=?,video_memory=?, dvd_privod=?, cores=?, type_display=?, resolution = ?,price =?  WHERE id_comp = ? ";
    private static final String DELETE_COMP = "DELETE FROM bsuir.computer WHERE id_comp = ? ";

    public CompDB()
    {
        this.connector = new Connector();
    }

    public ArrayList<Computer> getAll()
    {
        ArrayList<Computer> compList = new ArrayList();
        try
        {
            Connection conn = this.connector.getDbConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM bsuir.computer");
            while (rs.next())
            {
                Computer computer = new Computer();
                computer.setId_comp(rs.getInt("id_comp"));
                computer.setType_computer(rs.getString("type_comp"));
                computer.setProc_name(rs.getString("proc_name"));
                computer.setProc_freq(rs.getDouble("proc_freq"));
                computer.setProc_memory(rs.getInt("proc_memory"));
                computer.setVideo_memory(rs.getInt("video_memory"));
                computer.setDvd_privod(rs.getString("dvd_privod"));
                computer.setCores(rs.getInt("cores"));
                computer.setType_display(rs.getString("type_display"));
                computer.setResolution(rs.getString("resolution"));
                computer.setPrice(rs.getInt("price"));
                compList.add(computer);
            }
            return compList;
        }
        catch (SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Computer computer)
    {
        return false;
    }

    public boolean delete(int id_comp)
    {
        try
        {
            PreparedStatement prSt = this.connector.getDbConnection().prepareStatement("DELETE FROM bsuir.computer WHERE id_comp = ? ");

            prSt.setInt(1, id_comp);
            prSt.executeUpdate();
            return true;
        }
        catch (ClassNotFoundException|SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(Computer comp)
    {
        try
        {
            PreparedStatement prSt = this.connector.getDbConnection().prepareStatement("INSERT INTO computer(type_comp, proc_name, proc_freq, proc_memory, video_memory, dvd_privod, cores, type_display, resolution,price) VALUES (?,?,?,?,?,?,?,?,?,?)");

            prSt.setString(1, comp.getType_computer());
            prSt.setString(2, comp.getProc_name());
            prSt.setDouble(3, comp.getProc_freq());
            prSt.setInt(4, comp.getProc_memory());
            prSt.setInt(5, comp.getVideo_memory());
            prSt.setString(6, comp.getDvd_privod());
            prSt.setInt(7, comp.getCores());
            prSt.setString(8, comp.getType_display());
            prSt.setString(9, comp.getResolution());
            prSt.setInt(10, comp.getPrice());
            prSt.executeUpdate();
            return true;
        }
        catch (SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
