package com.dj.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.dj.domain.Student;

public interface StudentDao {
	// 新建学生
	@Insert("insert into student1_copy (name,qq,type,time,school,online_id,wish,rec_senior,create_at) "
			+ "values (#{name},#{qq},#{type},#{time},#{school},#{onlineId},#{wish},#{recSenior},#{createAt})")
	public long insert(Student student);

	// 按id更新学生数据
	@Update("update student1_copy set id=#{id},name=#{name},qq=#{qq},type=#{type},time=#{time},school=#{school},online_id=#{onlineId},wish=#{wish},rec_senior=#{recSenior} where id=#{id}")
	public boolean update(Student student);

	@Delete("delete from student1_copy where id=#{id}")
	public boolean delete(long id);

	@Select("select count(*) c from student1_copy;")
	public int countAll();

	@Select("select * from student1_copy where id=#{id}")
	public Student findByStudentId(long id);

}
