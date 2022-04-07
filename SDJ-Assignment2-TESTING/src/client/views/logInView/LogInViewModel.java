package client.views.logInView;

import client.model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogInViewModel
{
  private StringProperty username;
  private UserModel userModel;

  public LogInViewModel(UserModel userModel){
    this.userModel = userModel;
    username = new SimpleStringProperty();
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public void say()
  {
    System.out.println("Username: " + usernameProperty().get()); //TEST
  }
}
