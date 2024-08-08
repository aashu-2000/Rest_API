package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Subject;
import com.example.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/create")
	public ResponseEntity<String> CreateSubject(@RequestBody Subject subject)
	{
		try
		{
	        String createSubject = subjectService.createSbject(subject);
	        return new ResponseEntity<String>(createSubject,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getdata")
	public List<Subject> getAllSubjects()
	{
		return subjectService.getAllSubjects();
	}
}
