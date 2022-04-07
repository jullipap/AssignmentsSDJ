package server;

import shared.transferObjects.ChatMessages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private ServerMain serverMain;
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private String username;

  public ServerSocketHandler(Socket socket, ServerMain serverMain)
  {
    this.socket = socket;

    this.serverMain = serverMain;
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

  public void sendMessage(ChatMessages chatMessages)
  {
    try
    {
      out.writeObject(chatMessages);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {

    try
    {
      out.writeObject(username);

      while(true){
        ChatMessages message = (ChatMessages) in.readObject();
        System.out.println(message.getMsg() + " from " + message.getUserName());
        serverMain.getPool().broadcast(message.getMsg(), message.getUserName());
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
