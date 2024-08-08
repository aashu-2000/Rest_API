package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.exception.StudentException;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class Studentontroller {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<String> CreateStudent(@RequestBody Student student)
	{
		try
		{
	       String msg= studentService.createStudent(student);
	       return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(StudentException s) 
		{
			return new ResponseEntity<String>( s.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		try
		{
			List<Student> stu=studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(stu,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Student>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

}
