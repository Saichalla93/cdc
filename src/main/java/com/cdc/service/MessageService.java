package com.cdc.service;

import com.cdc.entity.Message;
import com.cdc.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.debezium.data.Envelope.Operation;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void replicateData(Map<String, Object> messageData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final Message message = mapper.convertValue(messageData, Message.class);

        if (Operation.DELETE == operation) {
        	messageRepository.deleteById(message.getId());
        } else {
        	messageRepository.save(message);
        }
    }
}
