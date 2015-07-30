package com.mytool.filemanager.websocket;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import javax.inject.Named;

/**
 * Created by bugg on 29/07/15.
 */
@OsgiServiceProvider
@Named("fmclient")
public interface FileManagerClient {

  String sayHello();
}
