package com.dj.service.impl;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.dj.dao.StudentDao;
import com.dj.domain.Student;
import com.dj.service.StudentService;
import Exception.NoNumberException;

@Qualifier("StudentService")

@Service public class StudentServiceImpl implements StudentService {

		private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(StudentServiceImpl.class.getName());
	// 注入Service依赖
	@Autowired
	private StudentDao studentDao;

	public long insert(Student student) {
		studentDao.insert(student);
		logger.info("StudentServiceImpl insert");
		return student.getId();
	}

	public boolean update(Student student) {
		student.setUpdateAt(System.currentTimeMillis());
		boolean bl = studentDao.update(student);
		logger.info("studentDao.update(student)");
		return bl;

	}

	public boolean delete(long id) {
		boolean bl = studentDao.delete(id);
		logger.info("StudentServiceImpl delete");
		return bl;
	}

	public int countAll() {
		studentDao.countAll();
		logger.info("StudentServiceImpl countAll");
		return studentDao.countAll();
	}

	public Student findByStudentId(long id) throws NoNumberException {
		Student student = studentDao.findByStudentId(id);
		logger.info("StudentServiceImpl findByStudentId");
		if (student != null) {
			return student;
		} else {
			throw new NoNumberException("不存在此id");
		}
	}

}
