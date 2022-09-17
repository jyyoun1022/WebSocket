package org.codej.websocket.domain;

import lombok.Data;
import java.util.HashMap;
import java.util.UUID;

@Data
public class ChatRoom {

    private String roomId;  // 채팅방 아이디
    private String roomName;// 채팅방 이름
    private long userCount; // 채팅방 인원수


    private HashMap<String,String> userList = new HashMap<>();

    public ChatRoom create(String roomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;

        return chatRoom;
    }
//    public void handleAction(WebSocketSession session, ChatDto message, ChatService service){
//        //message 에 담긴 타입을 확인한다.
//        //이때 message 에서 getType 으로 가져온 내용이
//        //chatDto 의 열거형인 MessageType 안에 있는 ENTER 과 동일한 값이라면
//        if(message.getType().equals(ChatDto.MessageType.ENTER)){
//            //sessions 에 넘어온 session 을 담고,
//            sessions.add(session);
//
//            //message 에는 입장하였다는 메시지를 띄워줍니다.
//            message.setMessage(message.getSender() + " 님이 입장하였습니다.");
//            sendMessage(message,service);
//        } else if (message.getType().equals(ChatDto.MessageType.TALK)) {
//            message.setMessage(message.getMessage());
//            sendMessage(message,service);
//        }
//    }
//    public <T> void sendMessage(T message, ChatService service){
//        sessions.parallelStream().forEach(sessions -> service.sendMessage(sessions,message));
//    }
}
