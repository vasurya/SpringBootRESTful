package com.vasurya.controller;


import java.util.*;

import com.vasurya.model.UserAnswer;
import com.vasurya.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.vasurya.model.CheckAnswer;
import com.vasurya.model.Quiz;

import javax.validation.Valid;

@RestController
public class Controller {
		@Autowired
	   QuizRepo repo;
		
		
		//1-USER CREATES QUIZ
		int id = 0;
		@PostMapping("/api/quizzes")
		public Quiz createQuiz(@Valid @RequestBody Quiz quiz)
		{
			++id;
			quiz.setId(id);
			repo.save(quiz);
			return quiz;
		}
		
		
		//2-GET QUIZ BY ID
		@GetMapping("/api/quizzes/{id}")
		@ResponseBody
		public Quiz getbyId(@PathVariable("id") int id)
		{
			return repo.findById(id).orElse(null);
//
		}
		
		//3-RETURN ALL QUIZZES
		@GetMapping("/api/quizzes")
		public Iterable<Quiz> Allquizzes()
		{
			return repo.findAll();
		}
		
		//4 - SOLVE A QUIZ

		@PostMapping("/api/quizzes/{id}/solve")
		public CheckAnswer checkuser(@PathVariable("id") int id,@RequestBody UserAnswer us)
		{
			CheckAnswer k = new CheckAnswer();
			Quiz m = repo.findById(id).orElse(null);
			

			System.out.println("Actual answer :"+m.getAnswer().toString());
			System.out.println("User answer :"+us.getAnswer().toString());

			if(Arrays.equals(m.getAnswer(),us.getAnswer()))
			{
				k.setSuccess(true);
				k.setFeedback("Congratulations, you're right!");
			}
			else {
				k.setSuccess(false);
				k.setFeedback("Wrong answer! Please, try again.");
			}
			return k;
		}
		
		//Test
				@GetMapping("/test")
				public String hello(Model model)
				{
					return "home";
				}

		
}
