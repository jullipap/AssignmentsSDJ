package client.views.logInView;

import client.core.ViewHandler;
import client.views.chatAppView.ChatViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginViewController
{

  @FXML
  private TextField usernameField;

  private ViewHandler viewHandler;
  private LogInViewModel logInViewModel;

  public void init(ViewHandler viewHandler, LogInViewModel logInViewModel){
    this.viewHandler = viewHandler;
    this.logInViewModel = logInViewModel;

    usernameField.textProperty().bindBidirectional(logInViewModel.usernameProperty());
  }

  @FXML
  public void loginAction(ActionEvent event){
    viewHandler.setUsername(usernameField.getText());
    viewHandler.openChatView();
  }


}
