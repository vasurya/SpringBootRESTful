package com.vasurya.controller;


import java.util.*;

import com.vasurya.model.UserAnswer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vasurya.model.CheckAnswer;
import com.vasurya.model.Quiz;

@RestController
public class Controller {
		//List of all quizzes
		List<Quiz> list = new ArrayList<>();
		//1-USER CREATES QUIZ
		int id = 0;
		@PostMapping("/api/quizzes")
		public Quiz createQuiz(@RequestBody Quiz quiz)
		{
			++id;
			quiz.setId(id);

			list.add(quiz);
//			System.out.println(quiz.getId());
			System.out.println(quiz.getAnswer());
			return quiz;
		}
		
		
		//2-GET QUIZ BY ID
		@GetMapping("/api/quizzes/{id}")
		@ResponseBody
		public Quiz getbyId(@PathVariable("id") int id)
		{
			for(Quiz k: list)
			{
				if(k.getId() == id)
					return k;
			}
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "entity not found");
		}
		
		//3-RETURN ALL QUIZZES
		@GetMapping("/api/quizzes")
		public List<Quiz> Allquizzes()
		{
			return list;
		}
		
		//4 - SOLVE A QUIZ
		//NOT WORKING
		@PostMapping("/api/quizzes/{id}/solve")

		public CheckAnswer checkuser(@PathVariable("id") int id,@RequestBody UserAnswer us)
		{
			CheckAnswer k = new CheckAnswer();
			Quiz m = getbyId(id);
			

			System.out.println("Actual answer :"+m.getAnswer());
			System.out.println("User answer :"+us.getAnswer());

			if(m.getAnswer() == us.getAnswer())
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
}
