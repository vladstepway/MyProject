package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ClientThread
        extends Thread
{
    private Socket socket;
    private Message message;
    public ObjectOutputStream outputStream;
    public ObjectInputStream inputStream;

    public ClientThread(Socket socket)
    {
        this.socket = socket;
        start();
    }

    public void run()
    {
        try
        {
            this.inputStream = new ObjectInputStream(this.socket.getInputStream());
            this.outputStream = new ObjectOutputStream(this.socket.getOutputStream());
            for (;;)
            {
                this.message = ((Message)this.inputStream.readObject());
                String sw = this.message.getMessage();
                switch (sw)
                {
                    case "Авторизация":
                        System.out.println("Сервер получил команду к авторизации");
                        Admin admin = (Admin)this.message.getStructure();
                        AdminDB db_adm = new AdminDB();
                        ArrayList<Admin> adm_list = db_adm.getAll();
                        Admin adminn = adm_list.get(0);
                        if ((adminn.getLogin().equals(admin.getLogin())) && (adminn.getPassword().equals(admin.getPassword()))) {
                            this.outputStream.writeObject(new Message("Success"));
                        } else {
                            this.outputStream.writeObject(new Message("Fail"));
                        }
                        break;
                }
            }
        }
        catch (SocketException localSocketException) {}catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
