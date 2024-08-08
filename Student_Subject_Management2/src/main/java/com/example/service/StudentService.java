package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.exception.StudentException;
import com.example.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public String createStudent(Student student)
	{
		if(studentRepository.isStudentPresent(student.getStudent_name())==1)
		{
			throw new StudentException("Student is alredy present!!");
			
		}
		else
		{
		    List<Subject> subjects = student.getSubjects();
		    for(Subject subject : subjects)
		    {
		    	subject.setStudent(student);
		    }
		    student.setSubjects(subjects);
			studentRepository.save(student);
			return "Student successfully inserted";
		}
	}
	
	
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}

}
