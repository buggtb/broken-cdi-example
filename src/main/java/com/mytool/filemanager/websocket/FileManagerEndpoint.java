package com.mytool.filemanager.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.EncodeException;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by bugg on 28/07/15.
 */
@ServerEndpoint(value = "/filemanager")
@WebServlet(urlPatterns = "/message")
public class FileManagerEndpoint extends HttpServlet{


  private final Logger log = LoggerFactory.getLogger(getClass());

  @Inject
  private FileManagerClient fileManagerClient;


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
    catch(NullPointerException e){
      log.warn("wtf", e);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/text");
    response.getWriter().println("It worked!: "+
                                 fileManagerClient.sayHello());
  }

}
