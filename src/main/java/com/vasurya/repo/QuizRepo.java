package com.vasurya.repo;

import com.vasurya.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface QuizRepo extends CrudRepository<Quiz, Integer> {

}
