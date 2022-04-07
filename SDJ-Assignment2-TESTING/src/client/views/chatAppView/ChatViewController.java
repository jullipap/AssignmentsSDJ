package client.views.chatAppView;

import client.core.ViewHandler;
import client.views.logInView.LogInViewModel;
import client.views.logInView.LoginViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import shared.transferObjects.ChatMessages;

public class ChatViewController
{
  @FXML
  private TextArea messageBox;
  @FXML
  private TextArea messageSendField;


  private ViewHandler viewHandler;
  private ChatViewModel chatViewModel;



  @FXML
  void sendMessage(ActionEvent event) {
    ChatMessages message = new ChatMessages(messageSendField.getText(), viewHandler.getUsername());
    System.out.println(message.toString());
    messageBox.appendText(message.toString() + "\n");
  }

  public void init(ViewHandler viewHandler, ChatViewModel chatViewModel){
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;
  }
}
