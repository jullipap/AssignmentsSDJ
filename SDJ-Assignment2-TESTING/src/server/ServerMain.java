package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
  private Pool pool = new Pool();

  public void start()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(1234);

      while (true)
      {
        System.out.println("Waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println(
            "Client connected from " + socket.getInetAddress().getHostAddress()
                + " " + socket.getLocalPort());

        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(
            socket, this);
        pool.addConn(serverSocketHandler);

        Thread thread = new Thread(serverSocketHandler);
        thread.start();

      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public Pool getPool(){
    return pool;
  }

}
