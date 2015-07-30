feature:repo-add mvn:org.ops4j.pax.cdi/pax-cdi-features/0.13.0-SNAPSHOT/xml/features
feature:install pax-cdi/0.13.0-SNAPSHOT pax-cdi-web/0.13.0-SNAPSHOT pax-cdi-web-weld/0.13.0-SNAPSHOT
install -s mvn:com.mytool/filemanager-client/1.0-SNAPSHOT

Compile Jar available here: http://filebin.ca/2APGpoJZexNm

Test: ws://0.0.0.0:8181/websocket2/filemanager
