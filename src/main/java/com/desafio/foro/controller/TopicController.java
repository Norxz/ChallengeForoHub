package com.desafio.foro.controller;

import com.desafio.foro.domain.topic.Topic;
import com.desafio.foro.dto.TopicDTO;
import com.desafio.foro.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    @Autowired
    private TopicService topicService;
    
    @GetMapping
    public ResponseEntity<Page<Topic>> getAllTopics(Pageable pageable) {
        Page<Topic> topics = topicService.getAllTopics(pageable);
        return ResponseEntity.ok(topics); // Devuelve una página de tópicos con código HTTP 200 (OK)
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        return ResponseEntity.ok(topic);
    }
    
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid TopicDTO topicDTO) {
        Topic createdTopic = topicService.createTopic(topicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic); // Código HTTP 201 (Created)
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        Topic updatedTopic = topicService.updateTopic(id, topic);
        return ResponseEntity.ok(updatedTopic); // Devuelve código HTTP 200 (OK)
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
