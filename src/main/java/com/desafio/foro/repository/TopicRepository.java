package com.desafio.foro.repository;

import com.desafio.foro.domain.topic.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAll(Pageable pageable); // Método para obtener una lista paginada
    
    boolean existsByTitleAndMessage(String title, String message);
    
    
    @Query ("SELECT t FROM Topic t ORDER BY t.creationDate ASC")
    List<Topic> findTop10ByOrderByCreationDateAsc();
    
    @Query("SELECT t FROM Topic t WHERE t.course.name = :course AND YEAR(t.creationDate) = :year")
    List<Topic> findByCourseAndYear(@Param ("course") String course, @Param("year") int year);
    
}
