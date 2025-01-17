package com.desafio.foro.controller;

import com.desafio.foro.domain.topic.DatosDetalleTopic;
import com.desafio.foro.domain.topic.Topic;
import com.desafio.foro.dto.TopicDTO;
import com.desafio.foro.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    
    @Autowired
    private TopicService topicService;
    
    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopic>> getAllTopics(
            @PageableDefault(size = 10, sort = "creationDate", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Topic> topics = topicService.getAllTopics(pageable);
        // Convertimos cada objeto Topic en DatosDetalleTopic
        Page<DatosDetalleTopic> topicDTOs = topics.map(DatosDetalleTopic::new);
        return ResponseEntity.ok(topicDTOs);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopic> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id); // Busca el tópico en la base de datos.
        DatosDetalleTopic topicDetails = new DatosDetalleTopic(topic); // Transforma los datos.
        return ResponseEntity.ok(topicDetails); // Devuelve el detalle del tópico.
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
    
    @GetMapping("/top10")
    public ResponseEntity<List<Topic>> getTop10Topics() {
        List<Topic> topics = topicService.getTop10Topics();
        return ResponseEntity.ok(topics);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Topic>> searchByCourseAndYear(@RequestParam String course, @RequestParam int year) {
        List<Topic> topics = topicService.searchByCourseAndYear(course, year);
        return ResponseEntity.ok(topics);
    }
    
}
