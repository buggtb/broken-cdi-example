package com.mytool.filemanager.websocket;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by bugg on 23/07/15.
 */
public class FileManagerClientImpl implements FileManagerClient{

  public FileManagerClientImpl() {
    try {
      Context context = new InitialContext();
      context.bind("fmclient", this);
    } catch (NamingException e) {
      e.printStackTrace();
    }

  }

  public String sayHello() {
    return "hello";
  }
}
