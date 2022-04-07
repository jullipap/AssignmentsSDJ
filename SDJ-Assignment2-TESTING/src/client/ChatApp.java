package client;

import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.network.SocketClient;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application
{
  @Override
  public void start(Stage stage) throws Exception
  {
    SocketClient socketClient = new SocketClient();
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(vmf, socketClient);


    socketClient.startClient();
    viewHandler.start();
  }
}
