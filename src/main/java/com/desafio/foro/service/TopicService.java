package com.desafio.foro.service;

import com.desafio.foro.domain.Course;
import com.desafio.foro.domain.topic.Topic;
import com.desafio.foro.domain.user.User;
import com.desafio.foro.dto.TopicDTO;
import com.desafio.foro.repository.CourseRepository;
import com.desafio.foro.repository.TopicRepository;
import com.desafio.foro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {
    
    @Autowired
    private TopicRepository topicRepository;
    
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    public Page<Topic> getAllTopics(Pageable pageable) {
        return topicRepository.findAll(pageable); // Usa el repositorio para obtener los datos paginados
    }
    
    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                       .orElseThrow(() -> new RuntimeException("Tópico no encontrado."));
    }
    
    public Topic createTopic(TopicDTO topicDTO) {
        if (topicRepository.existsByTitleAndMessage(topicDTO.getTitle(), topicDTO.getMessage())) {
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje.");
        }
        
        User author = userRepository.findById(topicDTO.getAuthorId())
                              .orElseThrow(() -> new RuntimeException("Autor no encontrado."));
        Course course = courseRepository.findById(topicDTO.getCourseId())
                                .orElseThrow(() -> new RuntimeException("Curso no encontrado."));
        
        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setMessage(topicDTO.getMessage());
        topic.setStatus(topicDTO.getStatus());
        topic.setAuthor(author);
        topic.setCourse(course);
        topic.setCreationDate(LocalDateTime.now());
        
        return topicRepository.save(topic);
    }
    public Topic updateTopic(Long id, Topic updatedTopic) {
        Topic existingTopic = getTopicById(id);
        existingTopic.setTitle(updatedTopic.getTitle());
        existingTopic.setMessage(updatedTopic.getMessage());
        existingTopic.setStatus(updatedTopic.getStatus());
        return topicRepository.save(existingTopic);
    }
    
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
    
    public List<Topic> getTop10Topics() {
        return topicRepository.findTop10ByOrderByCreationDateAsc();
    }
    
    public List<Topic> searchByCourseAndYear(String course, int year) {
        return topicRepository.findByCourseAndYear(course, year);
    }
    
    
}
