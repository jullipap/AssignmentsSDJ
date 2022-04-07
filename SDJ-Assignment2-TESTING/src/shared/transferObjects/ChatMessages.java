package shared.transferObjects;

import java.io.Serializable;

public class ChatMessages implements Serializable
{
  private String msg;
  private String userName;

  public ChatMessages(String msg, String userName)
  {
    this.msg = msg;
    this.userName = userName;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String toString()
  {
    return  userName + ": " + msg;
  }
}
