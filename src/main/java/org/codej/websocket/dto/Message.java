package org.codej.websocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    /** 채팅방 입장, 채팅방에 메세지 보내기*/
    public enum MessageType{
        ENTER,COMM
    }
    private MessageType messageType;

    /** 방번호, 보내는사람 ,내용*/

    private String roomId;

    private String sender;

    private String message;
}
