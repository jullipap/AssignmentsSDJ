package client.model;

import shared.transferObjects.ChatMessages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserModelManager implements UserModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private ChatMessages messages; //TODO May cause problems later. Change if so

  public UserModelManager()
  {

  }

  //Probably not even needed
  @Override
  public ChatMessages broadcast(String msg, String username)
  {
    return new ChatMessages(msg, username);
  }



  @Override
  public void addListener(String eventName,PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
