package server;

import shared.transferObjects.ChatMessages;

import java.util.ArrayList;

public class Pool
{
  private ArrayList<ServerSocketHandler> connections;
  public Pool(){
    connections = new ArrayList<>();
  }

  public synchronized void broadcast(String msg, String username){
  ChatMessages chatMessages = new ChatMessages(msg, username);
    for (ServerSocketHandler ss:connections)
    {
      ss.sendMessage(chatMessages);
    }
  }

  public synchronized void addConn(ServerSocketHandler ssh){
    connections.add(ssh);
  }
  public synchronized void removeConn(ServerSocketHandler ssh){
    connections.remove(ssh);
  }
}
