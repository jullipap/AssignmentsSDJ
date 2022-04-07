package client.network;

import shared.transferObjects.ChatMessages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public static final String IP = "localhost";
  public static final int PORT = 1234;

  private String username;
  private SocketClientHandler socketClientHandler;

  public SocketClient(){
    support = new PropertyChangeSupport(this);
  }

  public void startClient(){
    try
    {
      Socket socket = new Socket(IP, PORT);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      Thread thread =  new Thread(socketClientHandler);
      thread.setDaemon(true);
      thread.start();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public ChatMessages broadcast(String msg, String username)
  {
    return new ChatMessages(msg, username);
  }

  @Override
  public void setMessages(ChatMessages messages)
  {
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
