package client.views.chatAppView;

import client.core.ViewHandler;
import client.network.SocketClient;
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
  private SocketClient client;
  
  //TODO Implement client interface, which send mess to server to get message/user

  @FXML
  void sendMessage(ActionEvent event) {
    ChatMessages message = new ChatMessages(messageSendField.getText(), viewHandler.getUsername());
    messageSendField.setText("");
    client.sendMessages(message);
  }

  public void init(ViewHandler viewHandler, ChatViewModel chatViewModel){
    this.viewHandler = viewHandler;
    this.chatViewModel = chatViewModel;
  }
}
