package client.network;

import shared.transferObjects.ChatMessages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClientHandler implements Runnable
{
  private Socket socket;
  private SocketClient socketClient;
  private ObjectOutputStream out;
  private ObjectInputStream in;


  public SocketClientHandler(Socket socket, SocketClient client)
  {
    this.socket = socket;
    this.socketClient = client;
    try
    {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void run(){
    try
    {
      String username =(String) in.readObject();
      socketClient.setUsername(username);

      while (true)
      {
        ChatMessages mesFromServer = (ChatMessages) in.readObject();
        System.out.println("Message read: " + mesFromServer);
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
    public void sendMessageToServer (ChatMessages msg)
      {
        try
        {
          out.writeObject(msg);
          System.out.println(msg.toString());
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
