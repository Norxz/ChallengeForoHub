package com.desafio.foro.domain.topic;

import com.desafio.foro.domain.user.User;

import java.time.LocalDateTime;

public record DatosDetalleTopic(
        Long id,
        LocalDateTime fecha,
        User author,
        String title,
        String status,
        String message
) {
    public DatosDetalleTopic(Topic topic) {
        this(
                topic.getId(),
                topic.getCreationDate(),
                topic.getAuthor(),
                topic.getTitle(),
                topic.getStatus(),
                topic.getMessage()
        );
    }
}

