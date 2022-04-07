package client.core;

import client.views.chatAppView.ChatViewController;
import client.views.logInView.LoginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene logInScene;
  private Scene chatScene;

  private Stage stage;
  private ViewModelFactory vmf;

  private String username;

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public ViewHandler(ViewModelFactory vmf){
    this.vmf = vmf;
    stage = new Stage();
  }

  public void start(){
    openLogInView();
  }

  public void openLogInView(){
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/logInView/login.fxml"));
      Parent root = loader.load();

      LoginViewController controller = loader.getController();
      controller.init(this, vmf.getLogInViewModel());

      logInScene = new Scene(root);
      stage.setScene(logInScene);
      stage.setTitle("Log In");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openChatView(){
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/chatAppView/chat.fxml"));
      Parent root = loader.load();

      ChatViewController controller = loader.getController();
      controller.init(this, vmf.getChatViewModel());

      chatScene = new Scene(root);
      stage.setScene(chatScene);
      stage.setTitle("Telegram");
      stage.centerOnScreen();
      stage.show();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
