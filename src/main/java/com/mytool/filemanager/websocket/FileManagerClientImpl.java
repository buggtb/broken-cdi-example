package com.mytool.filemanager.websocket;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;

//import org.apache.oodt.cas.filemgr.system.XmlRpcFileManager;

/**
 * Created by bugg on 23/07/15.
 */
@OsgiServiceProvider
public class FileManagerClientImpl implements FileManagerClient{


  public String sayHello() {
    return "hello";
  }
}