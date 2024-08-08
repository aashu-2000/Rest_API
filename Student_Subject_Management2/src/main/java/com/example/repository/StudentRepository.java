package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>   {
	@Query("select count(s) from Student s where s.student_name=?1")
	public int isStudentPresent(String student_name);

}
