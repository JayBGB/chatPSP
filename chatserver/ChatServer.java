package chatserver;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

    //List of clients connected to the server
    static ArrayList<Client> clients =new ArrayList();

    public static void main(String[] args) {

        // Here we introduce the desired port
        String port = JOptionPane.showInputDialog("Port");

        try {
            ServerSocket serverSocket=new ServerSocket(Integer.parseInt(port));

            // Server stays up until we close the app
            while (true) {
                Thread.sleep(200);
                if (clients.size() <3) {
                    if(clients.isEmpty())
                        System.out.println("No clients connected.");

                    System.out.println("Accepting new connections.");
                    // We accept new clients
                    Socket newSocket = serverSocket.accept();
                    InputStream is = newSocket.getInputStream();
                    OutputStream os = newSocket.getOutputStream();

                    // We get the client's nickname
                    byte[] messageReceived = new byte[250];
                    is.read(messageReceived);
                    String nickname = new String(messageReceived);

                    // We add the new client to the list and start it
                    Client client =new Client(os,is,nickname);
                    client.start();
                    clients.add(client);

                    // Information about the new user connection
                    System.out.println("New user connected: (nickname:" + nickname + ",IP & Port:" + newSocket.getRemoteSocketAddress() + ").");
                    System.out.println("There is " + clients.size() + " users connected.");

                    clients.forEach((element) -> {
                        element.sendMessage("Server: "+nickname+" has joined the chatroom.");
                    });

                    if(clients.size()==10)
                        System.out.println("Server full until a user disconnects.");
                }
            }
        } catch (IOException ex) {
            System.out.println("New connection reception failed");
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



/**
 * Thread for each client that wants to connect
 *
 * @author JayBGB
 */
class Client extends Thread {

    OutputStream os;
    InputStream is;
    String nickname;

    /**
     * We receive the connection socket from the client and open the input and output connections.
     *
     * @throws IOException
     */
    public Client(OutputStream os, InputStream is, String nickname) {
        this.os = os;
        this.is = is;
        this.nickname = nickname;
    }

    /**
     * Thread execution.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // We get the messages sent by the users.
                byte[] recibido = new byte[250];
                is.read(recibido);
                String mensaje = new String(recibido);
                // If they write /bye, the connection is closed.
                if (mensaje.contains("/bye")) {
                    System.out.println("User " + nickname + " has disconnected.");
                    ChatServer.clients.remove(this);
                    System.out.println("There is " + ChatServer.clients.size() + " connected.");
                    ChatServer.clients.forEach((elemento) -> {
                        elemento.sendMessage("User " + nickname + " has disconnected.");
                    });
                    if (ChatServer.clients.isEmpty())
                        System.out.println("No users connected.");
                    os.close();
                    is.close();
                    stop();
                } else {
                    ChatServer.clients.forEach((elemento) -> {
                        elemento.sendMessage(nickname + ": " + mensaje);
                    });
                    System.out.println(nickname + ": " + mensaje);
                }

            } catch (IOException ex) {
                try {
                    System.out.println("Message reception failed.");
                    os.close();
                    is.close();
                    stop();
                } catch (IOException ex1) {
                    System.out.println("Failed at closing connections.");
                }
            }
        }
    }

    // Here we make the clients get the messages from every user.
    public void sendMessage(String message) {
        try {
            os.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println("Failed at sending the message.");
            try {
                os.close();
            } catch (IOException ex1) {
                System.out.println("Error. Message sending not permitted.");
            }
        }
    }
}
