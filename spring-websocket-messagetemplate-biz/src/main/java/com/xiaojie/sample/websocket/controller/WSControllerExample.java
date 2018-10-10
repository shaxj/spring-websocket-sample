package com.xiaojie.sample.websocket.controller;

import com.xiaojie.sample.websocket.dto.DifferentialResult;
import com.xiaojie.sample.websocket.dto.WSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xiaojie.sha
 * @date 2018/9/11
 */
@Controller
public class WSControllerExample {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/test")
    public WSResponse deviceruntimeInfo(@DestinationVariable String dsk, StompHeaderAccessor headerAccessor) throws Exception {

        simpMessageSendingOperations.convertAndSendToUser(dsk, "", "testMessage");
        return new WSResponse();
    }

    /**
     * for test
     *
     * @return
     */
    @RequestMapping(path = "/send", method = RequestMethod.GET)
    public WSResponse send() {
        simpMessageSendingOperations.convertAndSendToUser("1", "/message", new DifferentialResult());
        return new WSResponse();
    }

}
