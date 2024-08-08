package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Subject;
import com.example.repository.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectService {
	@Autowired	
	private SubjectRepository subjectRepository;
	
	public String createSbject(Subject subject)
	{
		 subjectRepository.save(subject);
		 return "Subject is Created...!!";
		 
	}
	public List<Subject> getAllSubjects()
	{
		return subjectRepository.findAll();
	}



}
