package sample;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements Runnable {

    private final String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа
    private final int serverPort = 8080; // здесь обязательно нужно указать порт к которому привязывается сервер
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Socket socket = null;

    public void run() {

        try {

            socket = new Socket(InetAddress.getByName(address),serverPort); // создаем сокет используя IP-адрес и порт сервера

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public Socket getSocket() {
        return socket;
    }
}
