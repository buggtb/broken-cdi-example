package com.mytool.filemanager.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by bugg on 28/07/15.
 */

@ServerEndpoint(value = "/filemanager")
public class FileManagerEndpoint implements Serializable{


  private final Logger log = LoggerFactory.getLogger(getClass());

  @Inject
  private FileManagerClient fileManagerClient;

  public FileManagerEndpoint() {
  }


  @OnOpen
  public void open(final Session session) {
    log.info("session opened");
    try {
    Context context = new InitialContext();

      fileManagerClient = (FileManagerClient) context.lookup("fmclient");
    } catch (NamingException e) {
      e.printStackTrace();
    }

    try {
      session.getBasicRemote().sendObject(fileManagerClient.sayHello());
    } catch (IOException e){
      log.warn("open failed", e);

    } catch(EncodeException e) {
      log.warn("open failed", e);
    }
    catch(NullPointerException e){
      log.warn("wtf", e);
    }
  }


}
