package com.dj.service;

import com.dj.domain.Student;

public interface StudentService {

	 long insert(Student student);

	 boolean update(Student student);

	 boolean delete(long id);

	 int countAll();

	 Student findByStudentId(long id);


}
