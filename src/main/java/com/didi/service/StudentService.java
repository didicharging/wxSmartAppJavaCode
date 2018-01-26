package com.didi.service;

import java.util.List;

import com.didi.model.Student;


public interface StudentService {
	
	public int addStu(Student student);
	public int DelStu(int id);
	//public Student SelStu(String name);
	public  List getAllStu();
	public List getStuByName(String name);
	public int updateStu(Student student);
	public Student selectStudentByID(int id);
}
