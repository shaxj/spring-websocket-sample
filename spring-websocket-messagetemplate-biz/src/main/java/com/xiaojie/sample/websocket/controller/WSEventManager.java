package com.xiaojie.sample.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

/**
 * @author xiaojie.sha
 * @date 2018/9/12
 */
@Component
public class WSEventManager implements ApplicationListener<AbstractSubProtocolEvent> {

    private Logger logger = LoggerFactory.getLogger(WSEventManager.class);

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @Override
    public void onApplicationEvent(AbstractSubProtocolEvent event) {
        try {
            logger.info("received ws event :{} ", event);

            if (event instanceof SessionConnectedEvent) {

            } else if (event instanceof SessionConnectEvent) {

            } else if (event instanceof SessionDisconnectEvent) {
                processDisconnectEvent((SessionDisconnectEvent) event);
            } else if (event instanceof SessionSubscribeEvent) {
                processSubEvent((SessionSubscribeEvent) event);
            } else if (event instanceof SessionUnsubscribeEvent) {
                processUnsub((SessionUnsubscribeEvent) event);
            } else {
                logger.warn("skipped AbstractSubProtocolEvent:{}", event);
            }
        } catch (Exception e) {
            logger.error("Exception occur:", e);
        }
    }

    private void processUnsub(SessionUnsubscribeEvent event) throws Exception {


    }

    private void processSubEvent(SessionSubscribeEvent event) throws Exception {

    }

    private void processDisconnectEvent(SessionDisconnectEvent event) throws Exception {

    }

}