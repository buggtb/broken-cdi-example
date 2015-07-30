package com.mytool.filemanager.websocket;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;

/**
 * Created by bugg on 29/07/15.
 */
@OsgiServiceProvider
public interface FileManagerClient {

  String sayHello();
}
