package com.mytool.filemanager.websocket;

import org.ops4j.pax.cdi.api.OsgiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by bugg on 28/07/15.
 */
@ServerEndpoint(value = "/filemanager")
public class FileManagerEndpoint {


  private final Logger log = LoggerFactory.getLogger(getClass());
  @Inject
  @OsgiService
  private FileManagerClientImpl fileManagerClient;

  @OnOpen
  public void open(final Session session) {
    log.info("session opened");

    try {
      session.getBasicRemote().sendObject(fileManagerClient.sayHello());
    } catch (IOException e){
      log.warn("open failed", e);

    } catch(EncodeException e) {
      log.warn("open failed", e);
    }
  }


  public void setFileManagerClient(FileManagerClientImpl fileManagerClient) {
    this.fileManagerClient = fileManagerClient;
  }
}
