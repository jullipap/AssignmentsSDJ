package client.network;

import shared.transferObjects.ChatMessages;
import shared.util.Subject;

import java.beans.PropertyChangeListener;

public interface Client extends Subject
{
  void sendMessages(ChatMessages messages);

  void addListener(String name, PropertyChangeListener listener);

  void startClient();
}
