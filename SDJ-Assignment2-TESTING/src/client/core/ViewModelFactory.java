package client.core;

import client.views.chatAppView.ChatViewController;
import client.views.chatAppView.ChatViewModel;
import client.views.logInView.LogInViewModel;
import client.views.logInView.LoginViewController;

public class ViewModelFactory
{
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public LogInViewModel getLogInViewModel(){
    return new LogInViewModel(mf.getUserModel());
  }
  public ChatViewModel getChatViewModel(){
    return new ChatViewModel();
  }



}
