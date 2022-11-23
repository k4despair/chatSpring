package com.example.chat.dto.mappers;

import com.example.chat.dto.MessageDTO;
import com.example.chat.enums.TypeEnum;
import com.example.chat.models.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    List<MessageDTO> toListDTO(List<Message> messageList);

    Message fromDTO(MessageDTO messageDTO);

    MessageDTO toDTO(Message message);

    default String fromEnum(int type) throws Exception {
        return TypeEnum.getTypeById(type);
    }

    default int toEnum(String type) throws Exception {
        return TypeEnum.getIdByType(type);
    }
}
