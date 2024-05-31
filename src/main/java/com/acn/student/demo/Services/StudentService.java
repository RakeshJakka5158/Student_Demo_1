package com.acn.student.demo.Services;

import com.acn.student.demo.Models.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public Student getStudentById(Integer studID) throws Exception;
    public List<Student> getAllStudents();
    public Student deleteStudentById(Integer studId) throws Exception;
}
