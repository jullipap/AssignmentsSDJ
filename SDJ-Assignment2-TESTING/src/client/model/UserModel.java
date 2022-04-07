package client.model;

import shared.transferObjects.ChatMessages;
import shared.util.Subject;

import java.beans.PropertyChangeListener;

public interface UserModel extends Subject
{
  ChatMessages broadcast(String msg, String username);

  void addListener(String name, PropertyChangeListener listener);



}
