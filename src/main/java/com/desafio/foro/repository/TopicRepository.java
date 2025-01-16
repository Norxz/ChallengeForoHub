package com.desafio.foro.repository;

import com.desafio.foro.domain.topic.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAll(Pageable pageable); // Método para obtener una lista paginada
    
}
