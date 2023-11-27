package com.ep.backend.service;

import java.util.List;

import com.ep.backend.dto.Credential;
import com.ep.backend.dto.LoginMesage;
import com.ep.backend.dto.StudentDto;

public interface StudentService {
	//create
	 StudentDto saveStudent(StudentDto studentDto);
	 
	//update
	    StudentDto updateStudent(StudentDto studentDto, String studentId);

	  //delete    
	    void deleteStudent(String studentId);
	    
//		get single user by email
	    StudentDto findStudentByEmail(String email);
	    
	  //get all user;
	    List<StudentDto> getAllStudents();
	    
// get student by id
	    StudentDto getStudentById(String studentId);
	    
	    
// reset password
//	    void resetPassword(Credential credentials);
	    
//	    LoginMesage loginEmployee(StudentDto studentDto);
	    
	  //search user
		
		List<StudentDto> searchStudent(String keyword); 
}
