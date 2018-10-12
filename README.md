## Overview
Spring jira
https://jira.spring.io/browse/SPR-17355?filter=-2


 apache-maven-3.5.4
 jdk1.8
 
*  **run** mvn clean install
*  **copy** spring-websocket-messagetemplate-deploy/target/ws-sample-1.0.0-SNAPSHOT.tar.gz to linux server
* **tar** zxvf ws-sample-1.0.0-SNAPSHOT.tar.gz to /home/admin/

* **execute command:**
java -classpath $(echo /home/admin/ws-messagetemplate-1.0.0-SNAPSHOT/lib/*.jar | tr ' ' ':') com.xiaojie.sample.websocket.WSMarbleMain

**the problem only occur in linux maven package environment. run code direct with mvn spring-boot:run or package tar in windows and use java -cp is ok.**


**run mvn install on linux and windows respectively. and we got spring-websocket-messagetemplate-biz-1.0.0-SNAPSHOT.jar linux version and windows version, use vimdiff compare two jars, the order of classes in two jars is different.
and in linux version environment.I found Controllers were init before WebSocketConfig, and the No handlers Exception was occur.**


2018-10-10 11:31:46,488 ERROR [main] org.springframework.boot.SpringApplication:771 - Application startup failed
org.springframework.context.ApplicationContextException: Failed to start bean 'subProtocolWebSocketHandler'; nested exception is java.lang.IllegalArgumentException: No handlers
	at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:178)
	at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:167)
	at org.springframework.context.support.DefaultLifecycleProcessor.access$200(DefaultLifecycleProcessor.java:50)
	at org.springframework.context.support.DefaultLifecycleProcessor$LifecycleGroup.start(DefaultLifecycleProcessor.java:348)
	at org.springframework.context.support.DefaultLifecycleProcessor.startBeans(DefaultLifecycleProcessor.java:151)
	at org.springframework.context.support.DefaultLifecycleProcessor.onRefresh(DefaultLifecycleProcessor.java:114)
	at org.springframework.context.support.AbstractApplicationContext.finishRefresh(AbstractApplicationContext.java:880)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.finishRefresh(EmbeddedWebApplicationContext.java:144)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:546)
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:693)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:360)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1118)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1107)
	at com.xiaojie.sample.websocket.WSMarbleMain.main(WSMarbleMain.java:24)
Caused by: java.lang.IllegalArgumentException: No handlers
	at org.springframework.util.Assert.isTrue(Assert.java:92)
	at org.springframework.web.socket.messaging.SubProtocolWebSocketHandler.start(SubProtocolWebSocketHandler.java:244)
	at org.springframework.context.support.DefaultLifecycleProcessor.doStart(DefaultLifecycleProcessor.java:175)
	... 15 common frames omitted
