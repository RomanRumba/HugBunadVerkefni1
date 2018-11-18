package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistance.entities.ChatMessage;
import project.persistance.entities.Chatroom;
import project.persistance.repositories.mongo.ChatMessageRepository;

/**
 * A message service.
 * 
 * @author Davíð Helgason (dah38@hi.is)
 */
@Service
public class MessageService {

	@Autowired
	private ChatMessageRepository chatMessageRepository;

	/**
	 * TODO finish implementing
	 * 
	 * Returns `limit` messages from chat room `chatroom` starting from `offset`.
	 * 
	 * @param chatroom
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List<ChatMessage> getChatPage(Chatroom chatroom, int limit, int offset) {
		long id = chatroom.getId();
		List<ChatMessage> chatMessages = chatMessageRepository.findPagedResultByChatroomId(id, limit, offset);
		return chatMessages;
	}

	/**
	 * Returns all the messages from chat room `chatroom`.
	 * 
	 * @param chatroom
	 * @return
	 */
	public List<ChatMessage> getAllMessages(Chatroom chatroom) {
		String chatroomName = chatroom.getChatroomName();
		List<ChatMessage> results = chatMessageRepository.getAllMessages(chatroomName);
		return results;
	}

	/**
	 * Deletes all messages of chat room `chatroom`.
	 * 
	 * @param chatroom
	 */
	public void deleteAllChatMessagesOfChatroom(Chatroom chatroom) {
		chatMessageRepository.deleteAllChatMessagesOfChatroom(chatroom.getChatroomName());
	}

	/**
	 * Returns all the messages from chat room `chatroom` from time `startTime` to
	 * time `endTime`.
	 * 
	 * @param chatroom
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<ChatMessage> getChatroomMessagesBetweenTime(Chatroom chatroom, Long startTime, Long endTime) {
		return chatMessageRepository.getChatroomMessagesBetweenTime(chatroom.getChatroomName(), startTime, endTime);
	}

	/**
	 * Adds chat message to a chat room it points to.
	 * 
	 * @param chatMessage
	 */
	public void addChatMessage(ChatMessage chatMessage) {
		chatMessageRepository.addChatMessage(chatMessage);
	}
}