package client.core;

import client.model.UserModel;
import client.model.UserModelManager;

public class ModelFactory
{
  private UserModel userModel;

  public UserModel getUserModel(){
    if (userModel == null){
      userModel = new UserModelManager();
    }
    return userModel;
  }
}
