package com.example.chat.repositories;

import com.example.chat.dto.MessageDTO;
import com.example.chat.dto.mappers.MessageMapper;
import com.example.chat.dto.mappers.MessageMapperImpl;
import com.example.chat.models.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    private MessageMapper messageMapper = new MessageMapperImpl();

    @Test
    void shouldReturnAlsoNewUsers() {

        //given
        MessageDTO[] messages = {
                new MessageDTO(
                        0,
                        "Ivan",
                        "Come to me",
                        null,
                        "Message"
                ) {
                },
                new MessageDTO(
                        0,
                        "Trisha",
                        "I'll kill you",
                        null,
                        "Message"
                ) {
                }
        };

        List<Message> messageList = new ArrayList<>();
        for (MessageDTO m : messages) {
            messageList.add(messageMapper.fromDTO(m));
        }

        //when
        messageRepository.saveAll(messageList);
        List<Message> messageDBList = messageRepository.findAll();

//      then
        assertThat(messageDBList.containsAll(messageList)).isTrue();
    }
}