package client.network;

import shared.transferObjects.ChatMessages;
import shared.util.Subject;

import java.beans.PropertyChangeListener;

public interface Client extends Subject
{
  ChatMessages broadcast(String msg, String username);
  void setMessages(ChatMessages messages);

  void addListener(String name, PropertyChangeListener listener);
}
