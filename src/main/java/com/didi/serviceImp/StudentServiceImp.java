package com.didi.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.StudentMapper;
import com.didi.model.Student;
import com.didi.service.StudentService;


@Service("studentService")
public class StudentServiceImp implements StudentService {
	@Resource
	private StudentMapper studentMapper;
	
	public int addStu(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.insert(student);
	}

	public int DelStu(int id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

//	public Student SelStu(String name) {
//		// TODO Auto-generated method stub
//		return studentMapper.selectByName(name);
//	}
	public List getStuByName(String name) {
		// TODO Auto-generated method stub
		return studentMapper.selectByName(name);
	}
	public List getAllStu() {
		// TODO Auto-generated method stub
		return studentMapper.getAllStu();
	}

	public int updateStu(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStu(student);
	}

	public Student selectStudentByID(int id) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentByID(id);
	}

	
}
