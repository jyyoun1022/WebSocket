package org.codej.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payload = (String) message.getPayload();
        log.info("payload : "+payload);

        for (WebSocketSession sess : list) {
            sess.sendMessage(message);
        }
    }
    /** Client가 접속 시 호출되는 메서드*/
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session + " 클라이언트 접속");
    }
    /** client가 접속 시 호출되는 메서드*/
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해제");
        list.remove(session);
    }
}
